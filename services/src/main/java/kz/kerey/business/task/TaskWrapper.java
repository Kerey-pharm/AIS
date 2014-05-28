package kz.kerey.business.task;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import kz.kerey.business.types.enums.TaskType;

@XmlRootElement
public class TaskWrapper {

	private Long id;
	private Date initialDate;
	private Date finishDate;
	private Date deadlineDate;
	private TaskType type;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public Date getDeadlineDate() {
		return deadlineDate;
	}
	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}
	public TaskType getType() {
		return type;
	}
	public void setType(TaskType type) {
		this.type = type;
	}
	
	
}
