package com.myproject.myapp.controller;
		
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.myproject.myapp.dao.CandidateDAO;
import com.myproject.myapp.dao.CareerDAO;
import com.myproject.myapp.exception.AdException;
import com.myproject.myapp.pojo.Candidate;
import com.myproject.myapp.pojo.Skills;
import com.myproject.myapp.validator.CandidateValidator;

@Controller
@RequestMapping("/addcandidate.htm")
public class AddCandidateFormController {
	
		@Autowired
		@Qualifier("candidateValidator")
		CandidateValidator validator;

		@Autowired
		@Qualifier("candidateDAO")
		CandidateDAO candidateDAO;
		
		@InitBinder
		private void initBinder(WebDataBinder binder) {
			binder.setValidator(validator);
		}

		@RequestMapping(method = RequestMethod.POST)
		protected String doSubmitAction(@ModelAttribute("candidate") Candidate candidate, BindingResult result,@RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
			validator.validate(candidate, result);
			if (result.hasErrors()) {
				return "addCandidateForm";
			}
		
			try {
			
				String fileName = null;
				byte[] img = null;
				 if (fileUpload != null && fileUpload.length > 0) {
		    	        for (CommonsMultipartFile aFile : fileUpload){
		    	              
		    	            System.out.println("Saving file: " + aFile.getOriginalFilename());
		    	           
		    	            fileName = aFile.getOriginalFilename();
		    	            img = aFile.getBytes();
		    	                           
		    	        }
		    	 }
				
				
				candidateDAO.create(candidate.getEmailId(), candidate.getPassword(), candidate.getConfirmPassword(), 
						candidate.getFirst(), candidate.getLast(),fileName, candidate.getAddress(), candidate.getPhone(),img);
				
				
				
			} catch (AdException e) {
				System.out.println("Exception: " + e.getMessage());
			}
			return "home";
		}

		@RequestMapping(method = RequestMethod.GET)
		public String initializeForm(@ModelAttribute("candidate") Candidate candidate, BindingResult result) {

			return "addCandidateForm";
		}
		
		
		
		
	}
	


