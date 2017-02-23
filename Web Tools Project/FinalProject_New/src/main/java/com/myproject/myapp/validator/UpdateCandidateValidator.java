package com.myproject.myapp.validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.myapp.dao.CandidateDAO;
import com.myproject.myapp.exception.AdException;
import com.myproject.myapp.pojo.Candidate;
import com.myproject.myapp.pojo.PatternMatcher;


public class UpdateCandidateValidator implements Validator {
		
	private String textPattern = "^[A-Za-z]++$";
	private String phonePattern = "^(\\([0-9]{3}\\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$";
		
		public boolean supports(Class aClass)
	    {
	        return aClass.equals(Candidate.class);
	    }
    
	    public void validate(Object obj, Errors errors){
	    	Candidate candidate = (Candidate) obj;
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "first", "error.invalid.user", "First Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last", "error.invalid.user", "Last Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "error.invalid.user", "Phone Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.invalid.user", "Location Required");
	      	        	        
	       			
//			String first = candidate.getFirst();
//	        String last = candidate.getLast();
//	        String phone = candidate.getPhone();
//	        String address = candidate.getAddress();
//	        
//	     	if(!first.matches(textPattern)){
//				errors.rejectValue("first","error.invalid.userpwd","Enter First name in proper format");
//			}
//			if(!last.matches(textPattern)){
//				errors.rejectValue("last","error.invalid.userpwd","Enter Last Name in proper format");
//			}       
//			if(!phone.matches(phonePattern)){
//				errors.rejectValue("phone","error.invalid.userpwd","Enter Phone Number in proper format");
//			} 
//			if(!address.matches(textPattern)){
//				errors.rejectValue("address","error.invalid.userpwd","Enter Address in proper format");
//			} 
	        
	        
	}
}


