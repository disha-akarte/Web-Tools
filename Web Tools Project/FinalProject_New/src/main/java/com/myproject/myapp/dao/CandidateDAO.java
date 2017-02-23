package com.myproject.myapp.dao;

import java.util.List;
import java.sql.ResultSet;

import javax.mail.Multipart;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.myapp.exception.AdException;
import com.myproject.myapp.pojo.Candidate;
import com.myproject.myapp.pojo.UserAccount;

@Repository
public class CandidateDAO extends DAO{
	

		public CandidateDAO(){
			
		}
			
		public Candidate create(String emailId, String password, String confirmPassword, 
								String firstName, String lastName,String fileName,String address, 
								String phone, byte[] img)
		throws AdException {
		try {
		     begin();       
		     Candidate candidate=new Candidate(emailId, password, confirmPassword, firstName, lastName, fileName,address,phone,img);
		    
		     getSession().save(candidate);
		     commit();
		     return candidate;
		 } catch (HibernateException e) {
		            rollback();
		            //throw new AdException("Could not create user " + emailId, e);
		            throw new AdException("Exception while creating user: " + e.getMessage());
		 }
		 }

		    public void delete(Candidate candidate)
		            throws AdException {
		        try {
		            begin();
		            getSession().delete(candidate);
		            commit();
		        } catch (HibernateException e) {
		            rollback();
		            throw new AdException("Could not delete user " + candidate.getFirst(), e);
		        }
		    }
		    
		    public Candidate findCandidate(UserAccount ua)throws AdException{

		    	try {
				
		    	begin();       
				long id = ua.getId();
		    	
		    	Query q = getSession().createQuery("from UserAccount where id = :id");
		    	q.setLong("id",id);
		    	Candidate candidate = (Candidate) q.uniqueResult();
	            commit();
		    	
		    	return candidate;
		    	}
		    	catch (HibernateException e) {
		            rollback();
		            throw new AdException("Exception while creating user: " + e.getMessage());
		        }
		    }
		    
		    public Candidate findCandidatebyID(String id)throws AdException{

		    	try {
				
		    	begin();       
				long canid = Long.parseLong(id);
		    	
		    	Query q = getSession().createQuery("from UserAccount where id = :id");
		    	q.setLong("id",canid);
		    	Candidate candidate = (Candidate) q.uniqueResult();
	            commit();
		    	
		    	return candidate;
		    	}
		    	catch (HibernateException e) {
		            rollback();
		            throw new AdException("Exception while creating user: " + e.getMessage());
		        }
		    }
		    
		    public void updateCandidatebyDetails(long canid, String phone, String address)throws AdException{

		    	try {
				
		    	begin();       
				System.out.println("Candidate ID:"+canid+"Phone:"+phone+"Address:"+address);
		    	
		    	Query q = getSession().createQuery("from UserAccount where id =:id");	    	
		    	q.setLong("id",canid);
		    	Candidate c = (Candidate)q.uniqueResult();
		    	c.setPhone(phone);
		    	c.setAddress(address);
		    	getSession().update(c);
	            commit();
		    	
		    	}
		    	catch (HibernateException e) {
		            rollback();
		            throw new AdException("Exception while updating user: " + e.getMessage());
		        }
		    }
		    
		    
		    
		    @RequestMapping(method = RequestMethod.POST)
		    public boolean isUserExists(String email) throws AdException{
		      
		    	boolean result = false;
		        try{
		        	begin();
		        
		        	Query q = getSession().createQuery("from UserAccount where emailId = :emailId");
		        	q.setString("emailId",email);
		        	List list = q.list();
		        	
		        	commit();
		            if(!list.isEmpty()) {
		            	result = true;
		            	
		            }
		           
		        }catch(HibernateException e) {
		            rollback();
		            throw new AdException("Exception while creating user: " + e.getMessage());
		        }
		        return result;
		   }
		   
		    
		   
		    
		    
		    
	}
	

