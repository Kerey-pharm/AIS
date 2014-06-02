package kz.kerey.idp;

import java.security.Principal;
import java.security.acl.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.sql.DataSource;

import org.jboss.security.SimpleGroup;

public class UsernamePasswordLoginModule extends org.jboss.security.auth.spi.UsernamePasswordLoginModule {

	/** The JNDI name of the DataSource to use */
	protected String dsJndiName;
	/** The SQL query to obtain the user password */
	protected String principalsQuery = "select u.passwordHash, u.login from K_USER u where u.login = ?";
	/** The SQL query to obtain the user roles */
	protected String rolesQuery = "select 'authenticated', 'Roles' from wx_user where enabled_ = true and name_=?";
	/** Default DataSet JNDI Name */
	protected final String defaultDataSetJndiName = "java:jboss/datasources/drugstoreDatasource";

	private Logger log = Logger.getLogger(getClass().getName());
	private String usernameCase = "lower";
	
	Principal userIdPrincipal;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map sharedState, Map options) {
        // We could read options passed via <module-option> in standalone.xml if there were any here
        // For an example see http://docs.redhat.com/docs/en-US/JBoss_Enterprise_Application_Platform/5/html/Security_Guide/sect-Custom_LoginModule_Example.html

        // We could also f.ex. lookup a data source in JNDI
        // For an example see http://www.docjar.com/html/api/org/jboss/security/auth/spi/DatabaseServerLoginModule.java.html
        super.initialize(subject, callbackHandler, sharedState, options);
        
		dsJndiName = (String) options.get("dsJndiName");
		usernameCase  = (String) options.get("usernameCase");

		if (usernameCase == null)
			usernameCase = "lower";

		if (dsJndiName == null)
			dsJndiName = defaultDataSetJndiName;
		Object tmp = options.get("principalsQuery");
		if (tmp != null)
			principalsQuery = tmp.toString();
		tmp = options.get("rolesQuery");
		if (tmp != null)
			rolesQuery = tmp.toString();
		
		log.info("dsJndiName=" + dsJndiName);
		log.info("principalsQuery=" + principalsQuery);
		log.info("rolesQuery=" + rolesQuery);
		log.info("usernameCase=" + usernameCase);
    }

	/**
	 * Overridden to return an empty password string as typically one cannot
	 * obtain a user's password. We also override the validatePassword so this
	 * is ok.
	 * 
	 * @return and empty password String
	 */
	protected String getUsersPassword() throws LoginException {
		return "";
	}

	/**
	 * Validate the inputPassword by creating a ldap InitialContext with the
	 * SECURITY_CREDENTIALS set to the password.
	 * @param inputPassword the password to validate.
	 * @param expectedPassword ignored
	 */
	protected boolean validatePassword(String inputPassword, String expectedPassword) {
		log.info(String.format("validatePassword %s %s", inputPassword, getUsername()));

		boolean isValid = false;

		try {
			if (passwordMatches(getUsername(), inputPassword)) {
				isValid = true;
			}

		} 
		catch (Throwable e) {
			super.setValidateError(e);
		}

		return isValid;
	}

	private boolean passwordMatches(String username, String inputPassword) throws LoginException {
		String password = null;
		String usertype = null;
		String user_id = "0";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(dsJndiName);
			conn = ds.getConnection();
			// Get the password
			log.info("Excuting query: " + principalsQuery + ", with username: " + username);

			ps = conn.prepareStatement(principalsQuery);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next() == false) {
				log.info( "Query returned no matches from db" );
				throw new FailedLoginException( "No matching username found in Principals" );
			}

			password = rs.getString(1);
			user_id = rs.getString(2);

			userIdPrincipal = createIdentity(user_id);
			// userPassPrincipal = createIdentity(password);

			log.info("Obtained user password and type= " + usertype);
		} catch (NamingException ex) {
			IllegalStateException le = new IllegalStateException( "Error looking up DataSource from: " + dsJndiName );
			le.initCause(ex);
			throw le;
		} catch (SQLException ex) {
			IllegalStateException le = new IllegalStateException( "Query failed" );
			le.initCause(ex);
			throw le;
		} catch (Exception ex) {
			IllegalStateException le = new IllegalStateException( "User_id assign error" );
			le.initCause(ex);
			throw le;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			}
		}

		// if (!passwordMatchesHash(inputPassword, password)) {
		// throw new FailedLoginException("Username/Password mismatch");
		// }

		if (!inputPassword.equals(password)) {
			throw new FailedLoginException("Username/Password mismatch");
		}

		return true;
	}
	
    /**
     * (required) The groups of the user, there must be at least one group called
     * "Roles" (though it likely can be empty) containing the roles the user has.
     */
    @Override
    protected Group[] getRoleSets() throws LoginException {
		Connection conn = null;
		HashMap<String, Group> setsMap = new HashMap<String, Group>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(dsJndiName);
			conn = ds.getConnection();
			// Get the user role names
			log.info("Excuting query: " + rolesQuery + ", with username: " + getUsername());
			
			ps = conn.prepareStatement(rolesQuery);
			try {
				ps.setString(1, getUsername());
			} catch (ArrayIndexOutOfBoundsException ignore) {
				// The query may not have any parameters so just try it
			}
			rs = ps.executeQuery();
			
			if (rs.next() == false) {
				log.info("No roles found");
				if (getUnauthenticatedIdentity() == null)
					throw new FailedLoginException(
							"No matching username found in Roles");
				/*
				 * We are running with an unauthenticatedIdentity so create an
				 * empty Roles set and return.
				 */
				Group[] roleSets = { new SimpleGroup("Roles") };
				return roleSets;
			}

			do {
				String name = rs.getString(1);
				String groupName = rs.getString(2);
				if (groupName == null || groupName.length() == 0)
					groupName = "Roles";
				Group group = (Group) setsMap.get(groupName);
				if (group == null) {
					group = new SimpleGroup(groupName);
					setsMap.put(groupName, group);
				}

				try {
					Principal p = createIdentity(name);
					log.info("Assign user to role " + name);
					group.addMember(p);
				} catch (Exception e) {
					log.info("Failed to create principal: " + name);
				}
			} while (rs.next());
		} catch (NamingException ex) {
			LoginException le = new LoginException(
					"Error looking up DataSource from: " + dsJndiName);
			le.initCause(ex);
			throw le;
		} catch (SQLException ex) {
			LoginException le = new LoginException("Query failed");
			le.initCause(ex);
			throw le;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ex) {
				}
			}
		}

		Group[] roleSets = new Group[setsMap.size()];
		setsMap.values().toArray(roleSets);
		return roleSets;
    }

}
