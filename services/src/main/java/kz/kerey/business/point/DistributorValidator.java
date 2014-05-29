package kz.kerey.business.point;

import javax.inject.Inject;
import javax.inject.Singleton;

import kz.kerey.business.wrappers.DistributorWrapper;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;
import kz.kerey.validators.Validator;

@Singleton
public class DistributorValidator extends Validator<DistributorWrapper> {

	@Inject
	PointValidator pointValidator;
	
	@Override
	public void validate(DistributorWrapper t) throws ValidatorException {
		pointValidator.validate(t);
		if (t.getBin()==null || t.getBin().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "BIN is Empty");
		if (t.getBankAccount()==null || t.getBankAccount().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "BankAccount is Empty");
	}

}