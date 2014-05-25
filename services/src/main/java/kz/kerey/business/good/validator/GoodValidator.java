package kz.kerey.business.good.validator;

import javax.inject.Singleton;

import kz.kerey.business.good.wrapper.Good;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;
import kz.kerey.validators.Validator;

@Singleton
public class GoodValidator extends Validator<Good> {
	
	@Override
	public void validate(Good t) throws ValidatorException {

		if (t==null)
			throw new ValidatorException(Constants.objectIsNull, "objectIsNull");
		
		if (t.getName()==null || t.getName().trim().length()==0)
			throw new ValidatorException(Constants.goodNameEmpty, "goodNameEmpty");
		
		if (t.getPrimaryBarcode()==null || t.getPrimaryBarcode().trim().length()==0)
			throw new ValidatorException(Constants.barcodeEmpty, "barcodeEmpty");
		
	}
	
}
