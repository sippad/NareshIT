package com.formbacking.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class FormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
	
		//ValidationUtils.rejectIfEmpty(errors, field, errorCode, defaultMessage);
		
	}

}
