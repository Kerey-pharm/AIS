package kz.kerey.ui;

import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import kz.kerey.api.GoodTypeInterface;
import kz.kerey.business.wrappers.GoodTypeWrapper;

public class Main {

	public static void main(String[] args) throws NamingException {

		
		String jndiName = "ejb:/services//GoodTypeEJB!kz.kerey.api.GoodTypeInterface";
		
		//"java:global/services/GoodTypeEJB!kz.kerey.api.GoodTypeInterface";
		//"java:app/services/GoodTypeEJB!kz.kerey.api.GoodTypeInterface";
		//"java:module/GoodTypeEJB!kz.kerey.api.GoodTypeInterface";
		//"java:jboss/exported/services/GoodTypeEJB!kz.kerey.api.GoodTypeInterface";
		
		GoodTypeInterface service = Main.lookupRemoteStatelessCalculator(jndiName);
		
		GoodTypeWrapper wrapper = new GoodTypeWrapper();
		wrapper.setName("FFFF");
		service.createGoodType(wrapper);
		
	}

	private static GoodTypeInterface lookupRemoteStatelessCalculator(String url) throws NamingException {
        
        Properties jndiProps = new Properties();
        
        jndiProps.put("java.naming.factory.initial","org.jboss.naming.remote.client.InitialContextFactory");
        jndiProps.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
        jndiProps.put("java.naming.provider.url","remote://127.0.0.1:4447");
        jndiProps.put("jboss.naming.client.ejb.context",true);
        //jndiProps.put("java.naming.security.principal","admin");
        //jndiProps.put("java.naming.security.credentials","1q2w3e4r(O*I&U^Y");
        
        //jndiProps.put("java.naming.provider.url","jnp://127.0.0.1:4447");
        //jndiProps.put("java.naming.factory.initial","org.jboss.as.naming.InitialContextFactory");
        //jndiProps.put("java.naming.factory.url.pkgs","org.jboss.as.naming.interfaces.java");
        //jndiProps.put("java.naming.security.principal", "Admin");
        //jndiProps.put(Context.SECURITY_CREDENTIALS, "1q2w3e4r(O*I&U^Y");
        
        //jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        //jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        
        //jndiProps.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED",false);
        //jndiProps.put("remote.connections", "default");
        //jndiProps.put("remote.connection.default.host", "127.0.0.1");
        //jndiProps.put("remote.connection.default.port", "4447");
        //jndiProps.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", false);
        //jndiProps.put("jboss.naming.client.ejb.context", true);
        
		//jndiProps.put(Context.PROVIDER_URL,"remote://127.0.0.1:4447");
        //jndiProps.put(Context.SECURITY_PRINCIPAL, "admin");
        //jndiProps.put(Context.SECURITY_CREDENTIALS, "1q2w3e4r(O*I&U^Y");
        
        Context ctx = new InitialContext(jndiProps);
        
        GoodTypeInterface ser = (GoodTypeInterface) ctx.lookup(url);
        
        ctx.close();
        
        return ser;
    }
	
}
