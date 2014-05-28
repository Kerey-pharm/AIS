package kz.kerey.business.task;

import javax.inject.Singleton;

import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;
import kz.kerey.validators.Validator;

@Singleton
public class TaskValidator extends Validator<TaskWrapper> {

	@Override
	public void validate(TaskWrapper t) throws ValidatorException {
		if (t==null)
			throw new ValidatorException(Constants.objectIsNull, "Object is NULL");
		if (t.getDeadlineDate()==null)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "DeadLine is Empty");
		if (t.getInitialDate()==null)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "InitialDate is Empty");
	}

}