package com.myproject.myapp.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.myapp.dao.ApplicationDAO;
import com.myproject.myapp.dao.CandidateDAO;
import com.myproject.myapp.dao.CareerDAO;
import com.myproject.myapp.dao.CompanyDAO;
import com.myproject.myapp.dao.EducationDAO;
import com.myproject.myapp.dao.JobDAO;
import com.myproject.myapp.dao.SkillDAO;
import com.myproject.myapp.exception.AdException;
import com.myproject.myapp.pojo.Application;
import com.myproject.myapp.pojo.Candidate;
import com.myproject.myapp.pojo.Career;
import com.myproject.myapp.pojo.Education;
import com.myproject.myapp.pojo.Job;
import com.myproject.myapp.pojo.Skills;
import com.myproject.myapp.pojo.UserAccount;

@Controller
public class ApplicationsViewController {

	@Autowired
	@Qualifier("applicationDAO")
	ApplicationDAO applicationDAO;
	
	@Autowired
	@Qualifier("candidateDAO")
	CandidateDAO cDAO;
	
	@Autowired
	@Qualifier("jobDAO")
	JobDAO jobDAO;
	

	@RequestMapping("/viewapps.htm")
	public ModelAndView viewAppliedJobs(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("apps") Application apps) throws Exception {
        
		 
	      List applicationsList = new ArrayList();

	      try {
	      	UserAccount ua = (UserAccount)hsr.getSession().getAttribute("user");	      	 
	      	applicationsList = applicationDAO.getJobsApplicantList(ua.getId());  
          
       
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	      
	      ModelAndView mv = new ModelAndView("RecievedApplications","apps",applicationsList);
          return mv; 
          
	}
	
	@RequestMapping("/successCandidate.htm")
	public ModelAndView SuccessDisplay(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("apps") Application apps) throws Exception {
        
	      ModelAndView mv = new ModelAndView("successCandidate");
          return mv; 
          
	}
	
	
	
}
	