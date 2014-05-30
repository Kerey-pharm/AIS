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
		
		for (int i=0; i<1000; i++) {
			String jndiName = "ejb:/services//GoodTypeEJB!kz.kerey.api.GoodTypeInterface";
			GoodTypeInterface service = Main.lookupRemoteStatelessCalculator(jndiName);
			GoodTypeWrapper wrapper = new GoodTypeWrapper();
			wrapper.setName("FFF"+i);
			service.createGoodType(wrapper);
		}
	}

	private static GoodTypeInterface lookupRemoteStatelessCalculator(String url) throws NamingException {
        Properties jndiProps = new Properties();
        jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context ctx = new InitialContext(jndiProps);
        GoodTypeInterface ser = (GoodTypeInterface) ctx.lookup(url);
        return ser;
    }
	
}
