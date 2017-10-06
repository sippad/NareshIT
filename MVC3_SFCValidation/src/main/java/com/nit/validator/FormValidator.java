package com.nit.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nit.command.StCommand;

public class FormValidator implements Validator{

	@Override
	public boolean supports(Class<?> cmdClass) {		
		return cmdClass.isAssignableFrom(StCommand.class);
	}

	@Override
	public void validate(Object command, Errors err) {	
		StCommand cmd = (StCommand)command;
		if(cmd.getSno()>=99999)
			err.rejectValue("sno", "sno.max");
		if(String.valueOf(cmd.getSno()).length()<=0)
			err.rejectValue("sno","sno.invalid");
		if(cmd.getSname()==null||cmd.getSname().equals("") || cmd.getSname().equals("enter your name")) 
			err.rejectValue("sname","sname.required");
		if(String.valueOf(cmd.getSmob()).length()<10 || String.valueOf(cmd.getSmob()).length()>10)
			err.rejectValue("smob","smob.invalid");
		if(cmd.getEmail()==null || cmd.getEmail().equals("")||cmd.getEmail().equals("enter your email address"))
			err.rejectValue("email","email.required");
	}
}