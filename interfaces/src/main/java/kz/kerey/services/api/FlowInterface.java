package kz.kerey.services.api;

import java.util.List;

import kz.kerey.business.types.PageParam;
import kz.kerey.business.types.enums.TaskProperty;
import kz.kerey.business.types.enums.TaskStatus;
import kz.kerey.business.wrappers.TaskWrapper;

public interface FlowInterface {

	public void createTask(TaskWrapper task);
	public void deleteTask(Long id);
	public void changeTaskProperty(Long id, TaskProperty property, String value);
	public List<TaskWrapper> getTaskList(PageParam param);
	public List<TaskWrapper> getTaskFiltered(PageParam param, Long userId, TaskStatus status);
	
	public void nextStep(Long taskId);
	public void previousStep(Long taskId);
	public void assignTask(Long taskId, Long userId);
	
	
}
