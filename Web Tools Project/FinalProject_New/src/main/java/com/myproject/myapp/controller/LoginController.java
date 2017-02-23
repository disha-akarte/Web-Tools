package com.myproject.myapp.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.myapp.dao.LoginDAO;
import com.myproject.myapp.pojo.Company;
import com.myproject.myapp.pojo.Job;
import com.myproject.myapp.pojo.Skills;
import com.myproject.myapp.pojo.UserAccount;

@Controller
@RequestMapping("/login.htm")
public class LoginController {
	
	@Autowired
	@Qualifier("loginDAO")
	LoginDAO loginDAO;
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1,@ModelAttribute("job") Job job,@ModelAttribute("skills") Skills skill) throws Exception {
        
        HttpSession session = hsr.getSession();
        String action = hsr.getParameter("action");
        ModelAndView mv = new ModelAndView();
        
       
        if(action.equals("login")){
        	 
        	 String emailId = hsr.getParameter("emailId");
             String password = hsr.getParameter("password");         
                     
             
             UserAccount ua = loginDAO.getUserAccount(emailId, password);
             if(ua == null){
            	 mv.addObject("invalidDetails","true");
            	 mv.setViewName("home");
             }
             else{
            
            	 String option = hsr.getParameter("rem");
            	 System.out.println("Remember me? : "+option);
            	 if(option!=null){
            		 Cookie userCookie = new Cookie("userName", hsr.getParameter("emailId"));
            		 Cookie passwordCookie = new Cookie("password", hsr.getParameter("password"));

            		 hsr1.addCookie(userCookie);
            		 hsr1.addCookie(passwordCookie);	 
            	 }
            
             session.setAttribute("emailId", ua.getEmailId());
             session.setAttribute("user",ua);
             
             if(ua.getType().equals("Employer")){
            	 mv.setViewName("login");
             }
             else if(ua.getType().equals("Candidate")){
            	 mv.setViewName("loginCand");
             }
             }
        	
        } 
		return mv;
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView handleRequest1(HttpServletRequest hsr,HttpServletResponse hsr1) throws Exception {
        
        HttpSession session = hsr.getSession();
        String action = hsr.getParameter("action");
        System.out.println("Action : "+action);
        ModelAndView mv = new ModelAndView();
        if (action.equals("logout")){
        	session.invalidate();
            mv.setViewName("home");
        	
        }
        return mv;
	}
}