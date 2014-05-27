package kz.kerey.business.point;

import javax.inject.Singleton;

import kz.kerey.exceptions.ValidatorException;
import kz.kerey.validators.Validator;

@Singleton
public class DistributorValidator extends Validator<DistributorWrapper> {

	@Override
	public void validate(DistributorWrapper t) throws ValidatorException {

	}

}
