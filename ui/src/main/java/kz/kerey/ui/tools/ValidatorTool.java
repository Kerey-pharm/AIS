package kz.kerey.ui.tools;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class ValidatorTool {

	private static InternetAddress emailAddr = new InternetAddress();
	
	public static boolean isValidEmailAddress(String email) {
		try {
			emailAddr.setAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			return false;
		}
		return true;
	}

}
