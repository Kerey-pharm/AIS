package kz.kerey.validators;

import javax.inject.Singleton;

import kz.kerey.business.wrappers.UserWrapper;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;

@Singleton
public class UserValidator extends Validator<UserWrapper> {

	@Override
	public void validate(UserWrapper t) throws ValidatorException {
		if (t==null)
			throw new ValidatorException(Constants.objectIsNull, "User object is NULL");
		if (t.getLogin()==null || t.getLogin().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "User login is NULL");
	}

}
