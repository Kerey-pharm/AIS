package kz.kerey.business.goodtype;

import javax.inject.Singleton;

import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;
import kz.kerey.validators.Validator;

@Singleton
public class GoodTypeValidator extends Validator<GoodTypeWrapper> {

	@Override
	public void validate(GoodTypeWrapper t) throws ValidatorException {
		
		if (t==null) 
			throw new ValidatorException(Constants.objectIsNull, "objectIsNull");
		if (t.getName()==null || t.getName().trim().length()==0) 
			throw new ValidatorException(Constants.goodTypeNameEmpty, "goodTypeNameEmpty");
		
	}
	
}
