package kz.kerey.business.point;

import javax.inject.Inject;
import javax.inject.Singleton;

import kz.kerey.business.wrappers.WarehouseWrapper;
import kz.kerey.exceptions.ValidatorException;
import kz.kerey.validators.Validator;

@Singleton
public class WarehouseValidator extends Validator<WarehouseWrapper> {

	@Inject
	PointValidator pointValidator;
	
	@Override
	public void validate(WarehouseWrapper t) throws ValidatorException {
		pointValidator.validate(t);
	}

}