package kz.kerey.ui;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.tika.Tika;

public class Main {

	public static void main(String[] args) throws IOException {
		
		File file = new File("D:/jboss-eap-6.2.0/jboss-eap-6.2/bin/jboss-cli.xml");
		
		Tika tika = new Tika();
		String mimeType = tika.detect(file);
		
		System.out.println(Files.probeContentType(file.toPath()));
		System.out.println(mimeType);
		
	}
	
	/*private static String jndiName = "ejb:/services//UserEJB!kz.kerey.services.api.UserInterface";
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
    }*/
	
}
