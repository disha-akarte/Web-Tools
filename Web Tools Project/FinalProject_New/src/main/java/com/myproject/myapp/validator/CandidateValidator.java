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


public class CandidateValidator implements Validator {
		
	private String emailPattern =  "^[\\w-\\.+]*[\\w-\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	private String passwordPattern =  "(?=.*\\d)(?=.*[A-Z])[0-9a-zA-Z]{4,}$";
	private String textPattern = "^[A-Za-z]++$";
	private String phonePattern = "^(\\([0-9]{3}\\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$";
		
//		private static final String RESUME_PATTERN = "([^\\s]+(\\.(?i)(pdf|doc))$)";
	
		public boolean supports(Class aClass)
	    {
	        return aClass.equals(Candidate.class);
	    }
//		Pattern pattern = Pattern.compile(RESUME_PATTERN);
//	    Matcher matcher;
	  //  MultipartFile resume;
	    
	    public void validate(Object obj, Errors errors){
	    	Candidate candidate = (Candidate) obj;
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "error.invalid.user", "EmailID Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.user", "Password Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "error.invalid.user", "Confirm Password Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "first", "error.invalid.user", "First Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last", "error.invalid.user", "Last Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "error.invalid.user", "Phone Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.invalid.user", "Location Required");
	       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "img", "error.invalid.user", "Please attach a Resume copy");
	        
	        	        	        
	        String email = candidate.getEmailId();
	        		        
	        CandidateDAO cd = new CandidateDAO();
	        Boolean exists;
			try {
				exists = cd.isUserExists(email);
				//System.out.println("Exists : "+email);
				if(exists == true){
		        	 errors.rejectValue("emailId", "error.invalid.user", "Username already in use");
		        }
			} catch (AdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			
			String pwd = candidate.getPassword();
	        String confirmpwd = candidate.getConfirmPassword();
	        String first = candidate.getFirst();
	        String last = candidate.getLast();
	        String phone = candidate.getPhone();
	        String address = candidate.getAddress();
	        
	        if(!email.matches(emailPattern)){
				errors.rejectValue("emailId", "error.invalid.user", "Enter valid email ID");
			}
			if(!pwd.matches(passwordPattern)){
				errors.rejectValue("password","error.invalid.userpwd","Enter password in proper format i.e. "
						+ "One uppercase, one lowercase letter and one special symbol");
			}
			if(!confirmpwd.matches(passwordPattern)){
				errors.rejectValue("confirmPassword","error.invalid.userpwd","Enter password in proper format i.e. "
						+ "One uppercase, one lowercase letter and one special symbol");
			}
			if(!first.matches(textPattern)){
				errors.rejectValue("first","error.invalid.userpwd","Enter First name in proper format");
			}
			if(!last.matches(textPattern)){
				errors.rejectValue("last","error.invalid.userpwd","Enter Last Name in proper format");
			}       
			if(!phone.matches(phonePattern)){
				errors.rejectValue("phone","error.invalid.userpwd","Enter Phone Number in proper format");
			} 
			if(!address.matches(textPattern)){
				errors.rejectValue("address","error.invalid.userpwd","Enter Address in proper format");
			} 
	        
	        
//	        resume = candidate.getResume();
//	        
//	       // matcher = pattern.matcher(resume.getOriginalFilename());
//	        
//	        if(0 == resume.getSize()) {
//	           errors.rejectValue("resume","Test","File is empty");
//	        }
////	              if(!matcher.matches()) {
////	             errors.rejectValue("resume","Test","Invalid File Format");
////	        }
//	        
//	        if(5000000 < resume.getSize()) {
//	             errors.rejectValue("resume","Test","File size is over 5mb !");
//	        } 
	    }
	}


