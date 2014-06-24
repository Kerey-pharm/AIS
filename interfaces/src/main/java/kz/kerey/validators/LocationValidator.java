package kz.kerey.validators;

import kz.kerey.business.wrappers.LocationWrapper;
import kz.kerey.constants.Constants;

public class LocationValidator extends Validator<LocationWrapper> {

	private static LocationValidator validator = new LocationValidator();
	private LocationValidator() {
	}
	public static LocationValidator getValidator() {
		return validator;
	}
	
	public void validate(LocationWrapper t) throws ValidatorException {
		if (t==null)
			throw new ValidatorException(Constants.objectIsNull, "Location is NULL");
		if (t.getName()==null || t.getName().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Location name is NULL or EMPTY");
	}

}
