package kz.kerey.validators;

import kz.kerey.business.wrappers.UserWrapper;
import kz.kerey.constants.Constants;

public class UserValidator extends Validator<UserWrapper> {

	private static UserValidator validator = new UserValidator();
	private UserValidator() {
	}
	public static UserValidator getValidator() {
		return validator;
	}
	
	@Override
	public void validate(UserWrapper t) throws ValidatorException {
		if (t==null)
			throw new ValidatorException(Constants.objectIsNull, "User object is NULL");
		if (t.getLogin()==null || t.getLogin().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "User login is NULL");
	}

}
