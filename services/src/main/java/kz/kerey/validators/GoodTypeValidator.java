package kz.kerey.validators;

import javax.inject.Singleton;

import kz.kerey.business.wrappers.GoodTypeWrapper;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;

@Singleton
public class GoodTypeValidator extends Validator<GoodTypeWrapper> {

	@Override
	public void validate(GoodTypeWrapper t) throws ValidatorException {
		if (t==null) 
			throw new ValidatorException(Constants.objectIsNull, "objectIsNull");
		if (t.getName()==null || t.getName().trim().length()==0) 
			throw new ValidatorException(Constants.fieldNotFilledProperly, "goodTypeNameEmpty");
	}
	
}
