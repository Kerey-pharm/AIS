package kz.kerey.business.gooditem;

import javax.inject.Singleton;

import kz.kerey.exceptions.ValidatorException;
import kz.kerey.validators.Validator;

@Singleton
public class GoodItemValidator extends Validator<GoodItemWrapper> {

	@Override
	public void validate(GoodItemWrapper t) throws ValidatorException {
		
	}

}
