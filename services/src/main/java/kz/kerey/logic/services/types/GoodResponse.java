package kz.kerey.logic.services.types;

public class GoodResponse {

	private Boolean completed;
	private String comment;
	private Integer errorCode;
	
	public GoodResponse(Boolean status, String comment, Integer errorCode) {
		this.comment = comment;
		this.completed = status;
		this.errorCode = errorCode;
	}
	
	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	
}
