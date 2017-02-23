package com.myproject.myapp.dao;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.myproject.myapp.exception.AdException;
import com.myproject.myapp.pojo.Candidate;
import com.myproject.myapp.pojo.Career;
import com.myproject.myapp.pojo.Education;
import com.myproject.myapp.pojo.Skills;
import com.myproject.myapp.pojo.UserAccount;

@Repository
public class EducationDAO extends DAO {

    public EducationDAO() {
    }

    public Education create(String school,String level,String from,String to,String major,Candidate c)
            throws AdException {
        try {
        	
        	begin();
        	
        	
           Education edu = new Education();
           edu.setSchoolName(school);
           edu.setLevel(level);
           edu.setYearAttendedFrom(from);
           edu.setYearAttendedTo(to);
           edu.setMajor(major);
           edu.setCandidate(c);
           getSession().save(edu);          
           commit();
           return edu;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while adding Skill: " + e.getMessage());
        }
    }

	 
	 public ArrayList<Education> FetchEduList(UserAccount ua) throws AdException {
			// TODO Auto-generated method stub
			
			try {
	            begin();   
	            ArrayList<Education> eduList = new ArrayList<Education>();
		    	Query q = getSession().createQuery("from Education where userid = :id ");
		    	q.setLong("id",ua.getId());
		    	List list = q.list();
		    	
		    	System.out.println("Retrieved Education:"+list.size());
		    	
		    	Iterator<Education> eduIterator = list.iterator();
		
		    	while (eduIterator.hasNext())
	            {            		
		    			Education s = (Education) eduIterator.next();
		    			eduList.add(s);                        
	            }
	            commit();
	            return eduList;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not retirieve Education list :" +e.getMessage());
	        }
			
		}
	 	
	 	
	 public ArrayList<Education> FetchEduListfromCandidate(Candidate ua) throws AdException {
			// TODO Auto-generated method stub
			
			try {
	            begin();   
	            ArrayList<Education> eduList = new ArrayList<Education>();
		    	Query q = getSession().createQuery("from Education where userid = :id ");
		    	q.setLong("id",ua.getId());
		    	List list = q.list();
		    	
		    	System.out.println("Retrieved Education:"+list.size());
		    	
		    	Iterator<Education> eduIterator = list.iterator();
		
		    	while (eduIterator.hasNext())
	            {            		
		    			Education s = (Education) eduIterator.next();
		    			eduList.add(s);                        
	            }
	            commit();
	            return eduList;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not retirieve Education list :" +e.getMessage());
	        }
			
		}
	 

	 	public void delete(long eduId)
	            throws AdException {
	        try {
	            begin();
	            Query q =getSession().createQuery("delete from Education where eduID = :eduID");
	            q.setLong("eduID", eduId);
	            q.executeUpdate();
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not delete Education with ID :"+eduId, e);
	        }
	    }
}





