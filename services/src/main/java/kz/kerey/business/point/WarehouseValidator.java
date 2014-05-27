package kz.kerey.business.point;

import javax.inject.Singleton;

import kz.kerey.exceptions.ValidatorException;
import kz.kerey.validators.Validator;

@Singleton
public class WarehouseValidator extends Validator<WarehouseWrapper> {

	@Override
	public void validate(WarehouseWrapper t) throws ValidatorException {
		
	}

}
