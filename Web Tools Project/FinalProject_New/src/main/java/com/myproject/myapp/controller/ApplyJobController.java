package com.myproject.myapp.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.myapp.dao.ApplicationDAO;
import com.myproject.myapp.dao.CandidateDAO;
import com.myproject.myapp.dao.CareerDAO;
import com.myproject.myapp.dao.JobDAO;
import com.myproject.myapp.pojo.Candidate;
import com.myproject.myapp.pojo.Career;
import com.myproject.myapp.pojo.Education;
import com.myproject.myapp.pojo.Job;
import com.myproject.myapp.pojo.Skills;
import com.myproject.myapp.pojo.UserAccount;

@Controller
public class ApplyJobController {

	@Autowired
	@Qualifier("jobDAO")
	JobDAO jDAO;
	
	@Autowired
	@Qualifier("candidateDAO")
	CandidateDAO cDAO;
	
	@Autowired
	@Qualifier("applicationDAO")
	ApplicationDAO application;
	
	@RequestMapping("/applyJob")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		long jobID = Long.parseLong(request.getParameter("jobID"));
		UserAccount ua = (UserAccount)request.getSession().getAttribute("user");
		
		Job j = jDAO.findJob(jobID);
		long companyID = j.getCompany().getId();
		
		Candidate c = cDAO.findCandidate(ua);
//		if(c.getEdu().isEmpty()||c.getExp().isEmpty()||c.getSkills().isEmpty()){
//			return new ModelAndView("incompleteProfile");
//		}
//		else{
//		
		Boolean alreadyApplied = application.sendApplication(companyID, c.getId(), jobID);
		if(alreadyApplied==true){
			return new ModelAndView("alreadyApplied");
		}
		else{
        return new ModelAndView("successCandidate");
		}
//		}
    }
}
