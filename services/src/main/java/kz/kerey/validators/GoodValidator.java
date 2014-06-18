package kz.kerey.validators;

import javax.inject.Singleton;

import kz.kerey.business.wrappers.GoodWrapper;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;

@Singleton
public class GoodValidator extends Validator<GoodWrapper> {
	
	@Override
	public void validate(GoodWrapper t) throws ValidatorException {
		if (t==null)
			throw new ValidatorException(Constants.objectIsNull, "objectIsNull");
		if (t.getName()==null || t.getName().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Field : Name");
		if (t.getPrimaryBarcode()==null || t.getPrimaryBarcode().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Field : Barcode");
		if (t.getPartialSelling()==null)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Field : PartialSelling");
		if (t.getCountPerBox()==null || t.getCountPerBox()==0L)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Field : CountPerBox");
		if (t.getCountSellable()==null || t.getCountSellable()==0L)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Field : CountSellable");
		if (t.getGoodTypeId()==null || t.getGoodTypeId()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Field : GoodTypeId");
	}
	
}