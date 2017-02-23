package com.myproject.myapp.validator;

import com.myproject.myapp.pojo.Company;
import com.myproject.myapp.pojo.Job;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

public class JobValidator implements Validator {

	private String textPattern = "^[A-Za-z]++$";
	private String numberPattern = "^[0-9]{1,6}$";
	private String floatPattern = "^[0-9]*_.?[0-9]*$";
	
    public boolean supports(Class aClass)
    {
        return aClass.equals(Job.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Job job = (Job) obj;
        
        String jobTitle = job.getJobTitle();
        String jobDesc = job.getJobDescription();
        String jobType = job.getJobType();
        String skillsReq = job.getSkillsRequired();
        String qualifications = job.getQualifications();
        String location = job.getLocation();
        String category = job.getCategory();
        
        		
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobTitle", "error.invalid.job", "Job Title Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobDescription", "error.invalid.job", "Job Description Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobType", "error.invalid.job", "Job Type Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "error.invalid.job", "Salary Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "experienceRequired", "error.invalid.job", "Experience Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "skillsRequired", "error.invalid.job", "Skills Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "qualifications", "error.invalid.job", "Qualifications Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "error.invalid.job", "Location Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "error.invalid.job", "Category Required");
     
        if(!jobTitle.matches(textPattern)){
			errors.rejectValue("jobTitle", "error.invalid.user", "Enter proper Job Title");
		}
		if(!jobDesc.matches(textPattern)){
			errors.rejectValue("jobDescription","error.invalid.userpwd","Enter proper description");
		}
		if(!jobType.matches(textPattern)){
			errors.rejectValue("jobType","error.invalid.userpwd","Enter proper type of job");
		}
		
		if(!skillsReq.matches(textPattern)){
			errors.rejectValue("skillsRequired","error.invalid.userpwd","Enter Skills required in proper format");
		}
		if(!location.matches(textPattern)){
			errors.rejectValue("location","error.invalid.userpwd","Enter location in proper format");
		}
		if(!category.matches(textPattern)){
			errors.rejectValue("category","error.invalid.userpwd","Enter category in proper format");
		}
		if(!qualifications.matches(textPattern)){
			errors.rejectValue("qualifications","error.invalid.userpwd","Enter Qualifications in proper format");
		}
    }
}
