package com.myproject.myapp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.myproject.myapp.exception.AdException;
import com.myproject.myapp.pojo.Application;
import com.myproject.myapp.pojo.Candidate;
import com.myproject.myapp.pojo.Company;
import com.myproject.myapp.pojo.Job;
import com.myproject.myapp.pojo.Skills;
import com.myproject.myapp.pojo.UserAccount;

import java.util.List;

@Repository
public class JobDAO extends DAO {

    public JobDAO() {
    }

    public Job create(String jobTitle,String jobDescription,String jobType,float salary, int experienceRequired,
    		String skillsRequired, String qualifications, String location, String datePosted, String category, String postedby,UserAccount ua)
            throws AdException {
        try {
        	
        	begin();

        	Query q = getSession().createQuery("from UserAccount where id = :id");
        	q.setLong("id",ua.getId());
        	Company c = (Company)q.uniqueResult();
        	
        	
           Job job = new Job();
           job.setJobTitle(jobTitle);
           job.setJobDescription(jobDescription);
            job.setJobType(jobType);
           job.setSalary(salary);
           job.setExperienceRequired(experienceRequired);
           job.setSkillsRequired(skillsRequired);
           job.setQualifications(qualifications);
           job.setLocation(location);
           job.setDatePosted(datePosted);
           job.setCategory(category);
           job.setPostedBy(postedby);
           job.setCompany(c);
           
            
            getSession().save(job);
           
            commit();
            return job;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating Job: " + e.getMessage());
        }
    }

    public void delete( long jobID)
            throws AdException {
        try {
            begin();
            ArrayList<Application> appList = new ArrayList<Application>();
            Query g1 = getSession().createQuery("from Application where jobID =:jobID");
            g1.setLong("jobID", jobID);
            List list= g1.list();
            
            Iterator<Application> appIt = list.iterator();
            while (appIt.hasNext())
            {            		
	    			Application s = (Application) appIt.next();
	    			s.setStatus("Position no longer exists");                        
            }
            
            
            Query q =getSession().createQuery("delete from Job where jobID = :jobID");
            q.setLong("jobID", jobID);
            q.executeUpdate();
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete Job :"+ jobID, e);
        }
    }
    
    public Job findJob(long jobID)throws AdException{

    	try {
		
    	begin();       
		
    	Query q = getSession().createQuery("from Job where jobID = :jobID");
    	q.setLong("jobID",jobID);
    	Job job = (Job) q.uniqueResult();
        commit();
    	
    	return job;
    	}
    	catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

	public ArrayList<Job> searchByCompany(String searchText) throws AdException {
		try {
			
	    	begin();       
	    	ArrayList<Job> jobList = new ArrayList<Job>();
	    	Query q = getSession().createQuery("from Job where company.companyName  = :cName");
	    	q.setString("cName", searchText);
	    	List list = q.list();
	    	Iterator<Job> jobIterator = list.iterator();
	    	
	    	while (jobIterator.hasNext())
            {            		
	    			Job a = (Job) jobIterator.next();
                    jobList.add(a);                        
            }
	    	
	        commit();
	    	return jobList;
	    	}
	    	catch (HibernateException e) {
	            rollback();
	            throw new AdException("Exception while finding job by company: " + e.getMessage());
	        
	    	}
	}
	
	public ArrayList<Job> searchByLocation(String searchText) throws AdException {
		try {
			
	    	begin();       
	    	ArrayList<Job> jobList = new ArrayList<Job>();
	    	Query q = getSession().createQuery("from Job where location  = :loc");
	    	q.setString("loc", searchText);
	    	List list = q.list();
	    	Iterator<Job> jobIterator = list.iterator();
	    	
	    	while (jobIterator.hasNext())
            {            		
	    			Job a = (Job) jobIterator.next();
                    jobList.add(a);                        
            }
	    	
	        commit();
	    	return jobList;
	    	}
	    	catch (HibernateException e) {
	            rollback();
	            throw new AdException("Exception while searching job by location: " + e.getMessage());
	        
	    	}
	}
	
	public ArrayList<Job> searchByCategory(String searchText) throws AdException {
		try {
			
	    	begin();       
	    	ArrayList<Job> jobList = new ArrayList<Job>();
	    	Query q = getSession().createQuery("from Job where category  = :category");
	    	q.setString("category", searchText);
	    	List list = q.list();
	    	Iterator<Job> jobIterator = list.iterator();
	    	
	    	while (jobIterator.hasNext())
            {            		
	    			Job a = (Job) jobIterator.next();
                    jobList.add(a);                        
            }
	    	
	        commit();
	    	return jobList;
	    	}
	    	catch (HibernateException e) {
	            rollback();
	            throw new AdException("Exception while searching job by location: " + e.getMessage());
	        
	    	}
	}
	
	public ArrayList<Job> searchByType(String searchText) throws AdException {
		try {
			
	    	begin();       
	    	ArrayList<Job> jobList = new ArrayList<Job>();
	    	Query q = getSession().createQuery("from Job where jobType  = :type");
	    	q.setString("type", searchText);
	    	List list = q.list();
	    	Iterator<Job> jobIterator = list.iterator();
	    	
	    	while (jobIterator.hasNext())
            {            		
	    			Job a = (Job) jobIterator.next();
                    jobList.add(a);                        
            }
	    	
	        commit();
	    	return jobList;
	    	}
	    	catch (HibernateException e) {
	            rollback();
	            throw new AdException("Exception while searching job by type: " + e.getMessage());
	        
	    	}
	}
}





