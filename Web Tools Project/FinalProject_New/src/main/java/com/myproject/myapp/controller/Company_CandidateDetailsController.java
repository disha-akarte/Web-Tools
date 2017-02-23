package com.myproject.myapp.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.myproject.myapp.pojo.Company;
import com.myproject.myapp.pojo.Education;
import com.myproject.myapp.pojo.Job;
import com.myproject.myapp.pojo.Skills;
import com.myproject.myapp.pojo.UserAccount;
import com.myproject.myapp.validator.CareerValidator;
import com.myproject.myapp.validator.EducationValidator;

@Controller
public class Company_CandidateDetailsController {

	@Autowired
	@Qualifier("companyDAO")
	CompanyDAO jobs;
	
	@Autowired
	@Qualifier("careerValidator")
	CareerValidator careerValidator;
	
	@Autowired
	@Qualifier("educationValidator")
	EducationValidator educationValidator;
	
	
	@Autowired
	@Qualifier("applicationDAO")
	ApplicationDAO apps;
	
	@Autowired
	@Qualifier("candidateDAO")
	CandidateDAO cDAO;
	
	@Autowired
	@Qualifier("careerDAO")
	CareerDAO careerDAO;
	
	@Autowired
	@Qualifier("educationDAO")
	EducationDAO eduDAO;
	
	@Autowired
	@Qualifier("jobDAO")
    JobDAO jobDAO;
	

	@Autowired
	@Qualifier("skillDAO")
	SkillDAO skillDAO;
	
	@RequestMapping("/viewownjobs.htm")
	public ModelAndView ViewOwnJobs(HttpServletRequest hsr, HttpServletResponse hsr1,
			@ModelAttribute("job") Job job) throws Exception {
      
		Company ua = (Company)hsr.getSession().getAttribute("user");
		System.out.println(ua.getCompanyName());
		
       ArrayList<Job> jobList = new ArrayList<Job>();
        try {
           
            jobList = jobs.FetchListbyCompany(ua);
  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("AllJobsforCompany","jobs",jobList);
        return mv;
	}
	
		
	@RequestMapping("/viewCandidateEdu.htm")
	public ModelAndView ViewCandidateEducation(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("candidate") Candidate candidate,
			@ModelAttribute("education") Education education) throws Exception {
        
		UserAccount ua = (UserAccount)hsr.getSession().getAttribute("user");
				
		ArrayList<Education> eduList = new ArrayList<Education>();
		try {
		
			eduList = eduDAO.FetchEduList(ua);
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		ModelAndView mv = new ModelAndView("CandidateViewEducation","education",eduList);
        return mv;
	}
	
	@RequestMapping("/viewCandidateCareer.htm")
	public ModelAndView ViewCandidateProfessionalExp(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("candidate") Candidate candidate,
			@ModelAttribute("career") Career career) throws Exception {
        
		UserAccount ua = (UserAccount)hsr.getSession().getAttribute("user");
				
		ArrayList<Career> careerList = new ArrayList<Career>();
		try {
		
			careerList = careerDAO.FetchCareerList(ua);
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		ModelAndView mv = new ModelAndView("CandidateViewCareer","career",careerList);
        return mv;
	}
	
	@RequestMapping("/CandidateCareerViewCompany")
	public ModelAndView ViewApplicantProfessionalExp(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("candidate") Candidate candidate,
			@ModelAttribute("career") Career career) throws Exception {
		
		String cId = hsr.getParameter("candID");
		Candidate ca = cDAO.findCandidatebyID(cId);
		
		
						
		ArrayList<Career> careerList = new ArrayList<Career>();
		try {
		
			careerList = careerDAO.FetchCareerListByCandidate(ca);
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		ModelAndView mv = new ModelAndView("CandidateCareerViewCompany","career",careerList);
        return mv;
	}
	
	
	@RequestMapping("/CandidateEducationViewCompany")
	public ModelAndView ViewCandidateEducationCompany(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("candidate") Candidate candidate,
			@ModelAttribute("education") Education education) throws Exception {
		
		String cId = hsr.getParameter("candID");
		Candidate ca = cDAO.findCandidatebyID(cId);
								
		ArrayList<Education> eduList = new ArrayList<Education>();
		try {
		
			eduList = eduDAO.FetchEduListfromCandidate(ca);
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		ModelAndView mv = new ModelAndView("CandidateEducationViewCompany","education",eduList);
        return mv;
	}
	
	
	
	
	@RequestMapping("/CandidateSkillView")
	public ModelAndView ViewCandidateSkills(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("candidate") Candidate candidate,
			@ModelAttribute Skills skills) throws Exception {
        
		String cId = hsr.getParameter("candID");
		Candidate ca = cDAO.findCandidatebyID(cId);
		
		ArrayList<Skills> skillList = new ArrayList<Skills>();
		try {
		
			skillList = skillDAO.FetchCandidateSkillList(ca);
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		ModelAndView mv = new ModelAndView("CandidateSkillView","skills",skillList);
        return mv;
	}
	
	@RequestMapping("/viewjob.htm")
	public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("job") Job job) throws Exception {
      
       ArrayList jobList = new ArrayList();
        try {
           
            jobList = jobs.FetchList();
  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("AllJobs","jobs",jobList);
        return mv;
	}
	
	@RequestMapping("/viewapplications.htm")
	public ModelAndView viewAppliedJobs(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("application") Application application,@ModelAttribute("job") Job job) throws Exception {
        
		 
	      ArrayList appliedJobList = new ArrayList();

	      try {
	      	UserAccount ua = (UserAccount)hsr.getSession().getAttribute("user");	      	 
	      	appliedJobList = apps.FetchList(ua.getId());                   
       
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("appliedJobs","jobs",appliedJobList);
        return mv;
	}
	
	@RequestMapping("/addcareer.htm")
	public ModelAndView handleRequest2(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("career") Career career) throws Exception {
         ModelAndView mv = new ModelAndView("addCareer");
        return mv;
	}  
	
	
	@RequestMapping("/addCareer.htm")
	public ModelAndView handleRequest3(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("career")Career career,
			BindingResult result) throws Exception {
		ModelAndView mv = new ModelAndView();
		UserAccount ua = (UserAccount)hsr.getSession().getAttribute("user");
		careerValidator.validate(career,result);
		
		
		if (result.hasErrors()) {
			mv.setViewName("addCareer");
			return mv;
		}
		try {
			Candidate c = cDAO.findCandidate(ua);
			Career career1 = careerDAO.create(career.getCompanyName(),career.getStartDate(),career.getEndDate(),career.getRole(),career.getDesignation(),career.getDescription(),c);
			c.getExp().add(career1);
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		mv.setViewName("successCandidate");
        return mv;
	}
	
	@RequestMapping("/addeducation.htm")
	public ModelAndView handleRequest4(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("education") Education education) throws Exception {
        ModelAndView mv = new ModelAndView("addEducation");
        return mv;
	}

	
	@RequestMapping("/addEducation.htm")
	public ModelAndView handleRequest5(HttpServletRequest hsr, HttpServletResponse hsr1,
			@ModelAttribute("education") Education education, BindingResult result) throws Exception {
		ModelAndView mv = new ModelAndView();
		UserAccount ua = (UserAccount)hsr.getSession().getAttribute("user");
		educationValidator.validate(education,result);
		 
		if (result.hasErrors()) {
			mv.setViewName("addEducation");
			return mv;
		}
		
		try {
		
			Candidate c = cDAO.findCandidate(ua);								
			Education edu = eduDAO.create(education.getSchoolName(),education.getLevel(),education.getYearAttendedFrom(),education.getYearAttendedTo(),education.getMajor(),c);
			c.getEdu().add(edu);
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		mv.setViewName("successCandidate");
        return mv;
	}
	
	@RequestMapping("/successCompany.htm")
	public String success() {

		return "successCompany";
	}
	
	@RequestMapping("/alreadyApplied")
	public String AppliedAlready() {

		return "alreadyApplied";
	}
	
	@RequestMapping("/incompleteProfile")
	public String IncompleteProf() {

		return "incompleteProfile";
	}
	
	@RequestMapping("/deleteJob")
	public ModelAndView deleteJob(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("skills")Skills skills) throws Exception {
		UserAccount ua = (UserAccount)hsr.getSession().getAttribute("user");	
		
		int jobID = Integer.parseInt(hsr.getParameter("jobID"));	
		ArrayList<Job> jobList = new ArrayList<Job>();
	
		try {	
			jobDAO.delete(jobID);					
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
	    ModelAndView mv = new ModelAndView();
        mv.setViewName("successCompany");
		return mv;
	}
	
	
	@RequestMapping("/acceptCandidate.htm")
	public ModelAndView AcceptCandidate(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
		
		int appID = Integer.parseInt(hsr.getParameter("appID"));	
		
		try {
		
			
			apps.acceptCandidate(appID);						
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
	    ModelAndView mv = new ModelAndView();
        mv.setViewName("successCompany");
		return mv;
	}
	
	@RequestMapping("/rejectCandidate")
	public ModelAndView RejectCandidate(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
		
		int appID = Integer.parseInt(hsr.getParameter("appID"));	
		
		try {
		
			
			apps.rejectCandidate(appID);						
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
	    ModelAndView mv = new ModelAndView();
        mv.setViewName("successCompany");
		return mv;
	}
	
	
	
	
	
	

	
	
}
