package kz.kerey.business.point;

import javax.inject.Singleton;

import kz.kerey.business.wrappers.PointWrapper;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;
import kz.kerey.validators.Validator;

@Singleton
public class PointValidator extends Validator<PointWrapper> {
	
	@Override
	public void validate(PointWrapper t) throws ValidatorException {
		if (t==null)
			throw new ValidatorException(Constants.objectIsNull, "objectIsNull");
		if (t.getDescription()==null || t.getDescription().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "pointDescriptionEmpty");
		if (t.getLocation()==null || t.getLocation().getId()==null || t.getLocation().getId()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "pointLocationEmpty");
		if (t.getName()==null || t.getName().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "pointNameEmpty");		
	}

}