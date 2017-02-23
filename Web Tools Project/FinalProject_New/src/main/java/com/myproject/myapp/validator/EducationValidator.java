package com.myproject.myapp.validator;

import com.myproject.myapp.pojo.Education;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

public class EducationValidator implements Validator {
	
	private String textPattern = "^[A-Za-z]++$";


    public boolean supports(Class aClass)
    {
        return aClass.equals(Education.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Education education = (Education) obj;
        
        String schoolName = education.getSchoolName();
        String level = education.getLevel();
        String major = education.getMajor();
               
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "schoolName", "error.invalid.education", "School name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "level", "error.invalid.education", "Level of education Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "yearAttendedFrom", "error.invalid.education", "Year attended from Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "yearAttendedTo", "error.invalid.education", "Year attended to Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "major", "error.invalid.education", "Major Required");
        
        if(!schoolName.matches(textPattern)){
			errors.rejectValue("schoolName", "error.invalid.user", "Enter valid ext for School Name");
		}
		if(!level.matches(textPattern)){
			errors.rejectValue("level","error.invalid.userpwd","Enter valid Text for level");
		}
		if(!major.matches(textPattern)){
			errors.rejectValue("major","error.invalid.userpwd","Enter valid Text for Major");
		}
        
        
    }
    
    
}
