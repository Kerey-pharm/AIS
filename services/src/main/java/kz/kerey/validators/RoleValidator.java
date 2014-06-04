package kz.kerey.validators;

import javax.inject.Singleton;

import kz.kerey.business.wrappers.RoleWrapper;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;

@Singleton
public class RoleValidator extends Validator<RoleWrapper> {

	@Override
	public void validate(RoleWrapper t) throws ValidatorException {
		if (t==null)
			throw new ValidatorException(Constants.objectIsNull, "Role object is null");
		if (t.getName()==null || t.getName().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Role name is null");
	}

}
