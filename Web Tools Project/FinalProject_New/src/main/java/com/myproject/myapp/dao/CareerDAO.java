package com.myproject.myapp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.myproject.myapp.exception.AdException;
import com.myproject.myapp.pojo.Candidate;
import com.myproject.myapp.pojo.Career;
import com.myproject.myapp.pojo.Skills;
import com.myproject.myapp.pojo.UserAccount;

@Repository
public class CareerDAO extends DAO{

	
	 public Career create(String companyName,String start,String end ,String role,String designation,String description,Candidate c)
	            throws AdException {
	        try {
	        	
	           begin();        	
	           Career career = new Career();
	           career.setCompanyName(companyName);
	           career.setStartDate(start);
	           career.setEndDate(end);
	           career.setRole(role);
	           career.setDesignation(designation);
	           career.setDescription(description);
	           career.setCandidate(c);
	           getSession().save(career);          
	           commit();
	           return career;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Exception while adding Skill: " + e.getMessage());
	        }
	    }
	 
	 
	 public ArrayList<Career> FetchCareerList(UserAccount ua) throws AdException {
			// TODO Auto-generated method stub
			
			try {
	            begin();   
	            ArrayList<Career> careerList = new ArrayList<Career>();
		    	Query q = getSession().createQuery("from Career where userid = :id ");
		    	q.setLong("id",ua.getId());
		    	List list = q.list();
		    	
		    	System.out.println("Retrieved Career:"+list.size());
		    	
		    	Iterator<Career> careerIterator = list.iterator();
		
		    	while (careerIterator.hasNext())
	            {            		
		    			Career s = (Career) careerIterator.next();
		    			careerList.add(s);                        
	            }
	            commit();
	            return careerList;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not retirieve career list :" +e.getMessage());
	        }
			
		}
	 
	 
	 public ArrayList<Career> FetchCareerListByCandidate(Candidate ca) throws AdException {
			// TODO Auto-generated method stub
			
			try {
	            begin();   
	            ArrayList<Career> careerList = new ArrayList<Career>();
		    	Query q = getSession().createQuery("from Career where userid = :id ");
		    	q.setLong("id",ca.getId());
		    	List list = q.list();
		    	
		    	System.out.println("Retrieved Career:"+list.size());
		    	
		    	Iterator<Career> careerIterator = list.iterator();
		
		    	while (careerIterator.hasNext())
	            {            		
		    			Career s = (Career) careerIterator.next();
		    			careerList.add(s);                        
	            }
	            commit();
	            return careerList;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not retirieve career list :" +e.getMessage());
	        }
			
		}

	 	public void delete(int careerId)
	            throws AdException {
	        try {
	            begin();
	            Query q =getSession().createQuery("delete from Career where careerID = :careerID");
	            q.setInteger("careerID", careerId);
	            q.executeUpdate();
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not delete career with ID :"+careerId, e);
	        }
	    }
	 
}
