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

		
		String jndiName = "java:jboss/exported/services/GoodTypeEJB!kz.kerey.api.GoodTypeInterface";
		
		GoodTypeInterface service = Main.lookupRemoteStatelessCalculator(jndiName);
		
		GoodTypeWrapper wrapper = new GoodTypeWrapper();
		wrapper.setName("FFFF!");
		service.createGoodType(wrapper);
		
		
	}

	private static GoodTypeInterface lookupRemoteStatelessCalculator(String url) throws NamingException {
        final Properties jndiProperties = new Properties();
        
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
                
        final Context context = new InitialContext(jndiProperties);
        
        return (GoodTypeInterface) context.lookup(url);
    }
	
}
