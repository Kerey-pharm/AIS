package kz.kerey.ui;

import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;

import net.miginfocom.swing.MigLayout;
import kz.kerey.business.types.enums.UserProperty;
import kz.kerey.business.wrappers.UserWrapper;
import kz.kerey.services.api.UserInterface;

public class Main {

	private static String jndiName = "ejb:/services//UserEJB!kz.kerey.services.api.UserInterface";
	private static UserInterface service = null;
	
	public static void main(String[] args) throws NamingException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		service = Main.lookupRemoteStatelessCalculator(jndiName);
		createUser();
	}

	private static void createUser() {
		for (int i=0; i<10; i++) {
			UserWrapper user = new UserWrapper();
			user.setLogin(UUID.randomUUID().toString());
			service.createUser(user);
		}
		List<UserWrapper> users = service.getUserList(false, null, null);
		for (UserWrapper user : users) {
			service.changeUserProperty(user.getId(), UserProperty.name, UUID.randomUUID().toString());
		}
		users = service.getUserList(false, null, null);
		for (UserWrapper user : users) {
			System.out.println(user.getLogin() + " : " + user.getName());
		}
	}
	
	private static UserInterface lookupRemoteStatelessCalculator(String url) throws NamingException {
        Properties jndiProps = new Properties();
        jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context ctx = new InitialContext(jndiProps);
        UserInterface ser = (UserInterface) ctx.lookup(url);
        return ser;
    }
	
}
