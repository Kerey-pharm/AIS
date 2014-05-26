package kz.kerey.business.good;

import javax.inject.Singleton;

import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;
import kz.kerey.validators.Validator;

@Singleton
public class GoodValidator extends Validator<GoodWrapper> {
	
	@Override
	public void validate(GoodWrapper t) throws ValidatorException {

		if (t==null)
			throw new ValidatorException(Constants.objectIsNull, "objectIsNull");
		
		if (t.getName()==null || t.getName().trim().length()==0)
			throw new ValidatorException(Constants.goodNameEmpty, "goodNameEmpty");
		
		if (t.getPrimaryBarcode()==null || t.getPrimaryBarcode().trim().length()==0)
			throw new ValidatorException(Constants.barcodeEmpty, "barcodeEmpty");
		
	}
	
}
