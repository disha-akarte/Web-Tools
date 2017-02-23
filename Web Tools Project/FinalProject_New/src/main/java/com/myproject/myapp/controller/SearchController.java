package com.myproject.myapp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import com.myproject.myapp.dao.JobDAO;
import com.myproject.myapp.pojo.Job;

@Controller
public class SearchController {

	@Autowired
	@Qualifier("jobDAO")
	JobDAO jobDAO;
	
	
	@RequestMapping("/searchJobs.htm")
    protected ModelAndView handleRequestInternal1(HttpServletRequest request, HttpServletResponse response,
    		@ModelAttribute("job")Job job) throws Exception {
        
		
        String searchBy = request.getParameter("searchBy");
        String searchText = request.getParameter("searchText");
        
        ArrayList jobList = new ArrayList<Job>();
        if(searchBy.equals("company")){
        	jobList = jobDAO.searchByCompany(searchText);
        }
        else if(searchBy.equals("location")){
        	jobList = jobDAO.searchByLocation(searchText);
        }
        else if(searchBy.equals("category")){
        	jobList = jobDAO.searchByCategory(searchText);
        }
        else if(searchBy.equals("type")){
        	jobList = jobDAO.searchByType(searchText);
        }
        ModelAndView mv = new ModelAndView("AllJobs","jobs",jobList);
        return mv;
        
    }
}
