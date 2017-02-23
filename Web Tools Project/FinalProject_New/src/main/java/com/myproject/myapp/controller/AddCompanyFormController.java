package com.myproject.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.myapp.dao.CareerDAO;
import com.myproject.myapp.dao.CompanyDAO;
import com.myproject.myapp.exception.AdException;
import com.myproject.myapp.pojo.Company;
import com.myproject.myapp.pojo.UserAccount;
import com.myproject.myapp.validator.CompanyValidator;

@Controller
@RequestMapping("/addcompany.htm")
public class AddCompanyFormController {
	
	@Autowired
	@Qualifier("companyValidator")
	CompanyValidator validator;
	
	@Autowired
	@Qualifier("companyDAO")
	CompanyDAO companyDAO;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("company") Company company, BindingResult result) throws Exception {
		System.out.println("*** IN CONTROLLER");
		validator.validate(company, result);
		System.out.println("*** IN CONTROLLER - AFTER VALIDATOR CALLED");
		if (result.hasErrors()) {
			return "addCompanyForm";
		}
		try {		
			companyDAO.create(company.getEmailId(), company.getPassword(), company.getConfirmPassword(), company.getCompanyName(), company.getLocation());
			
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "home";
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("company") Company company, BindingResult result) {

		return "addCompanyForm";
	}
}
