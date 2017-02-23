package com.myproject.myapp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.myapp.exception.AdException;
import com.myproject.myapp.pojo.Application;
import com.myproject.myapp.pojo.Candidate;
import com.myproject.myapp.pojo.Company;
import com.myproject.myapp.pojo.Job;
import com.myproject.myapp.pojo.UserAccount;

@Repository
public class CompanyDAO extends DAO {

    public CompanyDAO() {
    }

    public Company create(String emailId,String password,String confirmPwd, String companyName, String location)
            throws AdException {
        try {
        	
        	begin();

            Company company = new Company(emailId, password, confirmPwd, companyName, location);       
            company.setEmailId(emailId);
            company.setPassword(password);
            company.setConfirmPassword(confirmPwd);
            company.setCompanyName(companyName);
            company.setLocation(location);
            
            
            getSession().save(company);
           
            commit();
            return company;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create UserAccount " + UserAccountname, e);
            throw new AdException("Exception while creating UserAccount: " + e.getMessage());
        }
    }

    public void delete(Company company)
            throws AdException {
        try {
            begin();
            getSession().delete(company);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete UserAccount :"+company.getEmailId(),e);
        }
    }

	public ArrayList<Job> FetchList() throws AdException {
		// TODO Auto-generated method stub
		
		try {
            begin();   
            ArrayList<Job> jobList = new ArrayList<Job>();
	    	Query q = getSession().createQuery("from Job");
	    	List list = q.list();
	    		    	
	    	Iterator<Job> jobIterator = list.iterator();
	
	    	while (jobIterator.hasNext())
            {            		
	    			Job a = (Job) jobIterator.next();
	    			jobList.add(a);                        
            }
            commit();
            return jobList;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not retirieve list :" +e.getMessage());
        }
		
	}
	
	
	public ArrayList<Job> FetchListbyCompany(Company c) throws AdException {
		// TODO Auto-generated method stub
		
		try {
            begin();   
            ArrayList<Job> jobList = new ArrayList<Job>();
	    	Query q = getSession().createQuery("from Job where postedBy =:name");
	    	q.setString("name",c.getEmailId());
	    	List list = q.list();
	    		    	
	    	Iterator<Job> jobIterator = list.iterator();
	
	    	while (jobIterator.hasNext())
            {            		
	    			Job a = (Job) jobIterator.next();
	    			jobList.add(a);                        
            }
            commit();
            return jobList;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not retirieve list :" +e.getMessage());
        }
		
	}
	
	public Company findCompany(UserAccount ua)throws AdException{

    	try {
		
    	begin();       
		long id = ua.getId();
    	
    	Query q = getSession().createQuery("from UserAccount where id = :id");
    	q.setLong("id",id);
    	Company company = (Company) q.uniqueResult();
        commit();
    	
    	return company;
    	}
    	catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating user: " + e.getMessage());
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





