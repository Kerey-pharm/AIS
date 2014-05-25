package kz.kerey.exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class ValidatorException extends ServiceException {

	private static final long serialVersionUID = -8860769610075820959L;
	
	public ValidatorException(Long error, String comment) {
		super(error, comment);
	}
	
}
