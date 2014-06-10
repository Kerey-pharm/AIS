package kz.kerey.validators;

import javax.inject.Singleton;

import kz.kerey.business.wrappers.DocumentWrapper;
import kz.kerey.constants.Constants;
import kz.kerey.exceptions.ValidatorException;

@Singleton
public class DocumentValidator extends Validator<DocumentWrapper> {

	@Override
	public void validate(DocumentWrapper t) throws ValidatorException {
		if (t==null)
			throw new ValidatorException(Constants.objectIsNull, "Doc is NULL");
		if (t.getData()==null || t.getData().length==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "DocData is Empty");
		if (t.getDocType()==null || t.getDocType().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "DocType is Empty");
		if (t.getDocExtension()==null || t.getDocExtension().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "DocExtension is Empty");
		if (t.getDocName()==null || t.getDocName().trim().length()==0)
			throw new ValidatorException(Constants.fieldNotFilledProperly, "DocName is Empty");
	}

}
