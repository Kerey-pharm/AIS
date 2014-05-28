package kz.kerey.business.gooditem;

import java.util.Date;

import javax.inject.Singleton;

import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;
import kz.kerey.validators.Validator;

@Singleton
public class GoodItemValidator extends Validator<GoodItemWrapper> {

	@Override
	public void validate(GoodItemWrapper t) throws ValidatorException {
		if (t==null)
			throw new ValidatorException(Constants.objectIsNull, "GoodItem is NULL");
		if (t.getBarcode()==null || t.getBarcode().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Field : Barcode");
		if (t.getSerial()==null || t.getSerial().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Field : Serial");
		if (t.getCurrentCount()==null || t.getCurrentCount()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Field : CurrentCount");
		if (t.getExpireDate()==null || t.getExpireDate().before(new Date()))
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Field : ExpireDate");
		if (t.getInitialBoxCount()==null || t.getInitialBoxCount()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Field : InitialBoxCount");
		if (t.getInitialCount()==null || t.getInitialCount()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Field : InitialCount");
		if (t.getInitialDate()==null)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Field : InitialDate");
		if (t.getGood()==null || t.getGood().getId()==null || t.getGood().getId()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Field : Good");
		if (t.getOwner()==null || t.getOwner().getId()==null || t.getOwner().getId()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Field : Owner");
	}

}