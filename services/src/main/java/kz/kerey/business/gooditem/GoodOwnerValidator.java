package kz.kerey.business.gooditem;

import javax.inject.Singleton;

import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;
import kz.kerey.validators.Validator;

@Singleton
public class GoodOwnerValidator extends Validator<GoodOwnerWrapper> {

	@Override
	public void validate(GoodOwnerWrapper t) throws ValidatorException {
		if (t==null)
			throw new ValidatorException(Constants.objectIsNull, "Object is NULL");
		if (t.getPoint()==null || t.getTask()==null)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Point or Task are empty");
	}

}