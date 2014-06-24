package kz.kerey.validators;

import java.io.Serializable;

public abstract class Validator<T extends Serializable> {
	
	public abstract void validate(T t) throws ValidatorException;
	
}