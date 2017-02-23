package com.myproject.myapp.validator;

import com.myproject.myapp.pojo.Career;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

public class CareerValidator implements Validator {
	
	private String textPattern = "^[A-Za-z]++$";


    public boolean supports(Class aClass)
    {
        return aClass.equals(Career.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Career career = (Career) obj;
        
        String companyName = career.getCompanyName();
        String role = career.getRole();
        String description = career.getDescription();
        String designation = career.getDesignation();
               
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "error.invalid.career", "School name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "error.invalid.career", "Level of career Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate", "error.invalid.career", "Year attended from Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "error.invalid.career", "Year attended to Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designation", "error.invalid.career", "Major Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.invalid.career", "Major Required");
        
        
        
        if(!companyName.matches(textPattern)){
			errors.rejectValue("role", "error.invalid.role", "Enter valid text for School Name");
		}
		if(!role.matches(textPattern)){
			errors.rejectValue("role","error.invalid.userpwd","Enter valid Text for role");
		}
		if(!description.matches(textPattern)){
			errors.rejectValue("designation","error.invalid.userpwd","Enter valid Text for description");
		}
		if(!designation.matches(textPattern)){
			errors.rejectValue("designation","error.invalid.userpwd","Enter valid Text for designation");
		}
        
        
    }
    
    
}
