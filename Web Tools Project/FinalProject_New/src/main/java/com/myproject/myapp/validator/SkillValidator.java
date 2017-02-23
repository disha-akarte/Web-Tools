package com.myproject.myapp.validator;

import com.myproject.myapp.pojo.Skills;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

public class SkillValidator implements Validator {

	private String textPattern = "^[A-Za-z]++$";
	
    public boolean supports(Class aClass)
    {
        return aClass.equals(Skills.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Skills skills = (Skills) obj;
        
        String skillName = skills.getSkillName();
        
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "skillName", "error.invalid.skills", "Skill Name Required");
        
        if(!skillName.matches(textPattern)){
			errors.rejectValue("skillName","error.invalid.userpwd","Enter Skill Name in proper format");
		} 
    }
}
