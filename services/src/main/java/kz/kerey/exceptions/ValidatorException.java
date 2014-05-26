package kz.kerey.exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class ValidatorException extends Exception {

	private static final long serialVersionUID = 1820276239592982870L;

	private Long errorCode;
	private String comment;
	
	public ValidatorException(Long error, String comment) {
		this.errorCode = error;
		this.comment = comment;
	}
	
	public Long getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Long errorCode) {
		this.errorCode = errorCode;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
