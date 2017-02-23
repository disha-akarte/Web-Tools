package com.myproject.myapp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.myapp.dao.CareerDAO;
import com.myproject.myapp.dao.JobDAO;
import com.myproject.myapp.exception.AdException;
import com.myproject.myapp.pojo.Job;
import com.myproject.myapp.pojo.UserAccount;
import com.myproject.myapp.validator.JobValidator;

@Controller
@RequestMapping("/addjob.htm")
public class AddJobController {

	@Autowired
	@Qualifier("jobDAO")
	JobDAO jobDAO;
	
	@Autowired
	@Qualifier("jobValidator")
	JobValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("job") Job job, BindingResult result, HttpServletRequest request) throws Exception {
		validator.validate(job, result);
		if (result.hasErrors()) {
			return "addJob";
		}

		try {
		
			
			UserAccount ua = (UserAccount)request.getSession().getAttribute("user");
			String postedby = ua.getEmailId();
			
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date();
            String datePosted = dateFormat.format(date);
			
			Job j = jobDAO.create(job.getJobTitle(), job.getJobDescription(), job.getJobType(), 
					 job.getSalary(), job.getExperienceRequired(),job.getSkillsRequired(),job.getQualifications(),
					 job.getLocation(),datePosted, job.getCategory(), postedby,ua);
			
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return "successCompany";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("job") Job job, BindingResult result) {

		return "addJob";
	}
	
	
	
}
