package kz.kerey.validators;

import javax.inject.Singleton;

import kz.kerey.business.wrappers.LocationWrapper;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;

@Singleton
public class LocationValidator extends Validator<LocationWrapper> {

	public void validate(LocationWrapper t) throws ValidatorException {
		if (t==null)
			throw new ValidatorException(Constants.objectIsNull, "Location is NULL");
		if (t.getName()==null || t.getName().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Location name is NULL or EMPTY");
	}

}
