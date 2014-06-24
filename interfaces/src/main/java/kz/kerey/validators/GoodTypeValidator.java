package kz.kerey.validators;

import kz.kerey.business.wrappers.GoodTypeWrapper;
import kz.kerey.constants.Constants;

public class GoodTypeValidator extends Validator<GoodTypeWrapper> {

	private static GoodTypeValidator validator = new GoodTypeValidator();
	private GoodTypeValidator() {
	}
	public static GoodTypeValidator getValidator() {
		return validator;
	}
	
	@Override
	public void validate(GoodTypeWrapper t) throws ValidatorException {
		if (t==null) 
			throw new ValidatorException(Constants.objectIsNull, "objectIsNull");
		if (t.getName()==null || t.getName().trim().length()==0) 
			throw new ValidatorException(Constants.fieldNotFilledProperly, "goodTypeNameEmpty");
	}
	
}
