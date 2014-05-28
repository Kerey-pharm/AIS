package kz.kerey.business.gooditem;

import javax.xml.bind.annotation.XmlRootElement;

import kz.kerey.business.point.PointWrapper;
import kz.kerey.business.task.TaskWrapper;

@XmlRootElement
public class GoodOwnerWrapper {

	private Long id;
	private PointWrapper point;
	private TaskWrapper task;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PointWrapper getPoint() {
		return point;
	}
	public void setPoint(PointWrapper point) {
		this.point = point;
	}
	public TaskWrapper getTask() {
		return task;
	}
	public void setTask(TaskWrapper task) {
		this.task = task;
	}
	
}