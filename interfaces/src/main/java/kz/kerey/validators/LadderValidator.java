package kz.kerey.validators;

import kz.kerey.business.wrappers.LadderWrapper;
import kz.kerey.constants.Constants;

public class LadderValidator extends Validator<LadderWrapper> {

	private static LadderValidator validator = new LadderValidator();
	private LadderValidator() {
	}
	public static LadderValidator getValidator() {
		return validator;
	}
	
	@Override
	public void validate(LadderWrapper t) throws ValidatorException {
		if (t==null)
			throw new ValidatorException(Constants.objectIsNull, "Ladder is NULL");
		if (t.getName()==null || t.getName().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "Ladder name is empty");
	}

}