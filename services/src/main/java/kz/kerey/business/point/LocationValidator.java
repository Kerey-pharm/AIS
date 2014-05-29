package kz.kerey.business.point;

import javax.inject.Singleton;

import kz.kerey.business.wrappers.LocationWrapper;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;
import kz.kerey.validators.Validator;

@Singleton
public class LocationValidator extends Validator<LocationWrapper> {

	@Override
	public void validate(LocationWrapper t) throws ValidatorException {
		if (t==null)
			throw new ValidatorException(Constants.objectIsNull, "objectIsNull");
		if (t.getName()==null || t.getName().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "locationNameIsEmpty");
	}

}