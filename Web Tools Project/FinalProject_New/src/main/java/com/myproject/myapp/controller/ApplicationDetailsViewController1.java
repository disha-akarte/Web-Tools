package com.myproject.myapp.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
import com.myproject.myapp.validator.CandidateValidator;
import com.myproject.myapp.validator.UpdateCandidateValidator;

@Controller
public class ApplicationDetailsViewController1 {

	@Autowired
	@Qualifier("updateCandidateValidator")
	UpdateCandidateValidator validator;

	
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
	
	@RequestMapping("/abc.htm")
	public ModelAndView viewAppliedJobs(HttpServletRequest hsr, HttpServletResponse hsr1,
			@ModelAttribute("eav") EmployerAppView eav) throws Exception {
          	
		  System.out.println("Inside abc.htm");
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
	
	@RequestMapping("/candProfile.htm")
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
	
	@RequestMapping("/viewResume.htm")
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
	
	@RequestMapping("/viewSkills.htm")
	public ModelAndView ViewSkills(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("candidate") Candidate candidate,
			@ModelAttribute Skills skills) throws Exception {
        
		UserAccount ua = (UserAccount)hsr.getSession().getAttribute("user");
				
		ArrayList<Skills> skillList = new ArrayList<Skills>();
		try {
		
			skillList = skillDAO.FetchSkillList(ua);
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		System.out.println("SkillLIst size"+skillList.size());
		ModelAndView mv = new ModelAndView("CandidateViewSkills","skills",skillList);
        return mv;
	}
	
	@RequestMapping("/deleteCandidateSkill")
	public ModelAndView deleteSkill(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("skills")Skills skills) throws Exception {
		UserAccount ua = (UserAccount)hsr.getSession().getAttribute("user");	
		int skillId = Integer.parseInt(hsr.getParameter("skillId"));	
		ArrayList<Skills> skillList = new ArrayList<Skills>();
	
		try {
		
			skillDAO.delete(skillId);						
			skillList = skillDAO.FetchSkillList(ua);
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		//ModelAndView mv = new ModelAndView("CandidateViewSkills","skills",skillList);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("successCandidate");
		return mv;
	}
	
	
	@RequestMapping("/viewCareer.htm")
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
	
	@RequestMapping("/deleteCandidateCareer")
	public ModelAndView deleteCareer(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("career")Career career) throws Exception {
		UserAccount ua = (UserAccount)hsr.getSession().getAttribute("user");	
		int careerID = Integer.parseInt(hsr.getParameter("careerID"));	
		
		try {
			careerDAO.delete(careerID);						
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		//ModelAndView mv = new ModelAndView("CandidateViewSkills","skills",skillList);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("successCandidate");
		return mv;
	}
	
	@RequestMapping("/viewEdu.htm")
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
	
	@RequestMapping("/deleteCandidateEdu")
	public ModelAndView deleteEdu(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("education")Education education) throws Exception {
		UserAccount ua = (UserAccount)hsr.getSession().getAttribute("user");	
		long eduID = Long.parseLong(hsr.getParameter("eduId"));	
		
		try {
			eduDAO.delete(eduID);						
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		//ModelAndView mv = new ModelAndView("CandidateViewSkills","skills",skillList);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("successCandidate");
		return mv;
	}
	
	
	@RequestMapping("/updatecandidate.htm")
	public ModelAndView UpdateCandidate(HttpServletRequest hsr, HttpServletResponse hsr1,
			@ModelAttribute("candidate")Candidate candidate, BindingResult result) throws AdException {
		
		 ModelAndView mv = new ModelAndView();
		
		validator.validate(candidate, result);
		
		if (result.hasErrors()) {
			mv.setViewName("CandidatePersonalDetails");
		}
		
		UserAccount ua = (UserAccount)hsr.getSession().getAttribute("user");	
		
		Candidate can= new Candidate();
		try {
			can = cDAO.findCandidate(ua);
			System.out.println("IN controller :Candidate ID:"+can.getId()
			+"Phone:"+candidate.getPhone()+"Address:"+candidate.getAddress());
	    	
			cDAO.updateCandidatebyDetails(can.getId(),candidate.getPhone(),candidate.getAddress());
		
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		//ModelAndView mv = new ModelAndView("CandidateViewSkills","skills",skillList);
       
        mv.setViewName("successCandidate");
		
        
		return mv;
	}
	
	@RequestMapping("/welcome.htm")
	public ModelAndView viewAppliedJobs(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
          	return new ModelAndView("welcome");
		
	}
	
	
}
	