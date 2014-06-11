package kz.kerey.validators;

import kz.kerey.exceptions.ValidatorException;

public abstract class Validator<T> {

	public abstract void validate(T t) throws ValidatorException;
	
}