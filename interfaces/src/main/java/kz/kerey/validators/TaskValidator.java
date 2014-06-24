package kz.kerey.validators;

import kz.kerey.business.wrappers.TaskWrapper;
import kz.kerey.constants.Constants;

public class TaskValidator extends Validator<TaskWrapper> {

	private static TaskValidator validator = new TaskValidator();
	private TaskValidator() {
	}
	public static TaskValidator getValidator() {
		return validator;
	}
	
	@Override
	public void validate(TaskWrapper t) throws ValidatorException {
		
		if (t==null)
			throw new ValidatorException(Constants.objectIsNull, "Task is NULL");
		if (t.getLadder()==null || t.getLadder()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Task Ladder is NULL or EMPTY");
		
	}

}
