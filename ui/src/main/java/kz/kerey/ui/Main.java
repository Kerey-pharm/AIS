package kz.kerey.ui;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;

import net.miginfocom.swing.MigLayout;
import kz.kerey.business.wrappers.UserWrapper;
import kz.kerey.services.api.UserInterface;

public class Main {

	public static void main(String[] args) throws NamingException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		JFrame form = new JFrame();
		form.setTitle("Users window");
		
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout());
		
		
		
		
		
		String jndiName = "ejb:/services//UserEJB!kz.kerey.services.api.UserInterface";
		UserInterface service = Main.lookupRemoteStatelessCalculator(jndiName);
		UserWrapper wrapper = new UserWrapper();
		wrapper.setLogin("FFF");
		service.createUser(wrapper);
		
	}

	private static UserInterface lookupRemoteStatelessCalculator(String url) throws NamingException {
        Properties jndiProps = new Properties();
        jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context ctx = new InitialContext(jndiProps);
        UserInterface ser = (UserInterface) ctx.lookup(url);
        return ser;
    }
	
}
