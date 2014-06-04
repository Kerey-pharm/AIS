package kz.kerey.exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class WebServiceException extends RuntimeException {

	private static final long serialVersionUID = -7776211548782675247L;
	
	private Long errorCode;
	private String comment;
	
	public WebServiceException(Long error, String comment) {
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
