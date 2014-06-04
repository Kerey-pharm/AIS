package kz.kerey.exceptions;

import javax.ejb.EJBException;

public class ServicesException extends EJBException {

	private static final long serialVersionUID = 5888590522434808725L;
	
	private Long errorCode;
	private String comment;
	
	public ServicesException(Long error, String comment) {
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