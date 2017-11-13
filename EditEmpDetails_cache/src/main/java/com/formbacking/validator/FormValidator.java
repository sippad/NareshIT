package com.formbacking.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.formbacking.command.EmpCommand;

public class FormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {		
		return EmpCommand.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	
		ValidationUtils.rejectIfEmpty(errors,"eno", "eno is empty");
		
	}

}
