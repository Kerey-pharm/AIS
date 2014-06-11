package kz.kerey.validators;

import javax.inject.Singleton;

import kz.kerey.business.wrappers.LadderWrapper;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;

@Singleton
public class LadderValidator extends Validator<LadderWrapper> {

	@Override
	public void validate(LadderWrapper t) throws ValidatorException {
		if (t==null)
			throw new ValidatorException(Constants.objectIsNull, "Ladder is NULL");
		if (t.getName()==null || t.getName().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Ladder name is empty");
	}

}