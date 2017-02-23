package com.myproject.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.myapp.dao.CandidateDAO;
import com.myproject.myapp.dao.CareerDAO;
import com.myproject.myapp.dao.JobDAO;
import com.myproject.myapp.dao.LoginDAO;
import com.myproject.myapp.dao.SkillDAO;
import com.myproject.myapp.exception.AdException;
import com.myproject.myapp.pojo.Candidate;
import com.myproject.myapp.pojo.Company;
import com.myproject.myapp.pojo.Job;
import com.myproject.myapp.pojo.Skills;
import com.myproject.myapp.pojo.UserAccount;
import com.myproject.myapp.validator.SkillValidator;

@Controller
@RequestMapping("/addskills.htm")
public class AddSkillController {
	
	@Autowired
	@Qualifier("skillDAO")
	SkillDAO skillDAO;
	
	@Autowired
	@Qualifier("candidateDAO")
	CandidateDAO cDAO;
	
	@Autowired
	@Qualifier("skillValidator")
	SkillValidator skillvalidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(skillvalidator);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("skills") Skills skills, BindingResult result, HttpServletRequest request) throws Exception {
		skillvalidator.validate(skills, result);
		
		UserAccount ua = (UserAccount)request.getSession().getAttribute("user");
		if (result.hasErrors()) {
			return "addSkill";
		}
		
		try {
		
			
			Candidate c = cDAO.findCandidate(ua);				
			Skills s = skillDAO.create(skills.getSkillName(),c);
			c.getSkills().add(s);
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return "successCandidate";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("skills") Skills skills, BindingResult result) {

		return "addSkill";
	}
        
}