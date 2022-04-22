package org.exam.www.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AdminLoginCommandValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> arg0) {
		return AdminLoginCommand.class.isAssignableFrom(arg0);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adm_id", "required");
		ValidationUtils.rejectIfEmpty(errors, "adm_pass", "required");
	}

}
