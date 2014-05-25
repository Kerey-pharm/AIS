package kz.kerey.business.goodtype.validator;

import javax.inject.Singleton;

import kz.kerey.business.goodtype.wrapper.GoodType;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;
import kz.kerey.validators.Validator;

@Singleton
public class GoodTypeValidator extends Validator<GoodType> {

	@Override
	public void validate(GoodType t) throws ValidatorException {
		
		if (t==null) 
			throw new ValidatorException(Constants.objectIsNull, "objectIsNull");
		if (t.getName()==null || t.getName().trim().length()==0) 
			throw new ValidatorException(Constants.goodTypeNameEmpty, "goodTypeNameEmpty");
		
	}
	
}
