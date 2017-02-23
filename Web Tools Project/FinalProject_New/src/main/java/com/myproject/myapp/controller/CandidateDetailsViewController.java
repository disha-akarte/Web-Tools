package com.myproject.myapp.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.myapp.dao.CandidateDAO;
import com.myproject.myapp.dao.CareerDAO;
import com.myproject.myapp.dao.EducationDAO;
import com.myproject.myapp.dao.EmployerAppViewDAO;
import com.myproject.myapp.dao.JobDAO;
import com.myproject.myapp.dao.SkillDAO;
import com.myproject.myapp.exception.AdException;
import com.myproject.myapp.pojo.Candidate;
import com.myproject.myapp.pojo.Career;
import com.myproject.myapp.pojo.Education;
import com.myproject.myapp.pojo.EmployerAppView;
import com.myproject.myapp.pojo.Skills;
import com.myproject.myapp.pojo.UserAccount;

@Controller
public class CandidateDetailsViewController {

	@Autowired
	@Qualifier("candidateDAO")
	CandidateDAO cDAO;
	
	@Autowired
	@Qualifier("skillDAO")
	SkillDAO skillDAO;
	
	@Autowired
	@Qualifier("careerDAO")
	CareerDAO careerDAO;

	@Autowired
	@Qualifier("educationDAO")
	EducationDAO eduDAO;
	
	EmployerAppViewDAO empDAO = new EmployerAppViewDAO();
	
	@RequestMapping("/abcd.htm")
	public ModelAndView viewAppliedJobs(HttpServletRequest hsr, HttpServletResponse hsr1,
			@ModelAttribute("eav") EmployerAppView eav) throws Exception {
          	 
	      List applicationsList = new ArrayList();

	      try {
	      	UserAccount ua = (UserAccount)hsr.getSession().getAttribute("user");	      	 
	      	applicationsList = empDAO.FetchList(ua.getId());            
       
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
	      
	      ModelAndView mv = new ModelAndView("abc","eav",applicationsList);
          return mv; 
          
	}
	
	@RequestMapping("/candProfile1.htm")
	public ModelAndView ViewCandidateDetails(HttpServletRequest hsr, HttpServletResponse hsr1,
			@ModelAttribute("candidate") Candidate candidate,@ModelAttribute("eav") EmployerAppView eav) throws Exception {
        System.out.println("Inside Controller");
		
        String cId = hsr.getParameter("candID");
        System.out.println("cId:"+cId);
        Candidate ca = cDAO.findCandidatebyID(cId);
		
		ModelAndView mv = new ModelAndView("CandidateProfileView","candidate",ca);
		//ModelAndView mv = new ModelAndView();
		//mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/viewResume1.htm")
	public ModelAndView ViewResume(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("candidate") Candidate candidate) throws Exception {
       
		String a = hsr.getParameter("candid");
		
		Candidate c = new Candidate();
				
		try {
		
			c = cDAO.findCandidatebyID(a);		
			OutputStream outputStream = hsr1.getOutputStream();
			outputStream.write(c.getImg());
			outputStream.close();
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		ModelAndView mv = new ModelAndView("ViewResume","candidate",candidate);
		return mv;
	}

	
	@RequestMapping("/viewCareer1.htm")
	public ModelAndView ViewProfessionalExp(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("candidate") Candidate candidate,
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
	
	
	@RequestMapping("/viewEdu1.htm")
	public ModelAndView ViewEducation(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("candidate") Candidate candidate,
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

	
	@RequestMapping("/goToDashboard.htm")
	public ModelAndView redirectToDashboard(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        
		ModelAndView mv = new ModelAndView("loginCand");
        return mv;
        
	}
	
	
	@RequestMapping("/candidatePersonalDetails.htm")
	public ModelAndView CandidateDetails(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("candidate") Candidate candidate) throws Exception {
        
		UserAccount ua = (UserAccount)hsr.getSession().getAttribute("user");
		System.out.println("User is:"+ua.getEmailId());
		Candidate can=null;
//		if (result.hasErrors()) {
//			return "loginCand";
//		}
		
		try {
		
			can = cDAO.findCandidate(ua);								
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		System.out.println("beforre cN"+can.getFirst());
		ModelAndView mv = new ModelAndView("CandidatePersonalDetails","candidate",can);
        return mv;
	}
	
	
	
}
	