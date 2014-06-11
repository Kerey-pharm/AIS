package kz.kerey.business.wrappers;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import kz.kerey.business.types.enums.TaskStatus;

@XmlRootElement
public class TaskWrapper implements Serializable {

	private static final long serialVersionUID = -1560064299717535289L;

	private Long id;
	private Date initialDate;
	private Date finishDate;
	private Date deadlineDate;
	private TaskStatus status;
	private String barcode;
	private Long ladder;
	private Long step;
	private Long executor;
	
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
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public Long getLadder() {
		return ladder;
	}
	public void setLadder(Long ladder) {
		this.ladder = ladder;
	}
	public Long getStep() {
		return step;
	}
	public void setStep(Long step) {
		this.step = step;
	}
	public Long getExecutor() {
		return executor;
	}
	public void setExecutor(Long executor) {
		this.executor = executor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
