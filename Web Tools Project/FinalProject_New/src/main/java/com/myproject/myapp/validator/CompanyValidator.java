package com.myproject.myapp.validator;

import com.myproject.myapp.dao.CompanyDAO;
import com.myproject.myapp.exception.AdException;
import com.myproject.myapp.pojo.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

public class CompanyValidator implements Validator {

	private String emailPattern =  "^[\\w-\\.+]*[\\w-\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	private String passwordPattern =  "(?=.*\\d)(?=.*[A-Z])[0-9a-zA-Z]{4,}$";
	private String textPattern = "^[A-Za-z]++$";

	public boolean supports(Class aClass)
	{
		return aClass.equals(Company.class);
	}

	public void validate(Object obj, Errors errors)
	{
		
		Company company = (Company) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "error.invalid.company", "emailId Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "error.invalid.confirmPassword", "Confirm Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "error.invalid.companyName", "Company Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "error.invalid.location", "Location Required");       
        
		String email = company.getEmailId();
		String pwd = company.getPassword();
        String confirmpwd = company.getConfirmPassword();
        String cName = company.getCompanyName();
        String loc = company.getLocation();
		
		CompanyDAO cd = new CompanyDAO();
		Boolean exists;
		try {
			exists = cd.isUserExists(email);
			if(exists == true){
				errors.rejectValue("emailId", "error.invalid.user", "Username already in use");
			}
		} catch (AdException e) {
			e.printStackTrace();
		}
		
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
		if(!cName.matches(textPattern)){
			errors.rejectValue("companyName","error.invalid.userpwd","Enter company name in proper format");
		}
		if(!loc.matches(textPattern)){
			errors.rejectValue("location","error.invalid.userpwd","Enter location in proper format");
		}
		
		
		

	}
}
