package kz.kerey.exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class ServiceException extends Exception {

	private static final long serialVersionUID = -7764898904461660297L;

	private Long errorCode;
	private String comment;
	
	public ServiceException(Long error, String comment) {
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
