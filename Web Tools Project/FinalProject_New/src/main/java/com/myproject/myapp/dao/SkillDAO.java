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
import com.myproject.myapp.pojo.Job;
import com.myproject.myapp.pojo.Skills;
import com.myproject.myapp.pojo.UserAccount;

@Repository
public class SkillDAO extends DAO {

    public SkillDAO() {
    }

    public Skills create(String skillName,Candidate c)
            throws AdException {
        try {
        	
        	begin();
        	
        	
           Skills skill = new Skills();
           skill.setSkillName(skillName);
           skill.setCandidate(c);
           getSession().save(skill);          
           commit();
           return skill;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while adding Skill: " + e.getMessage());
        }
    }
    
    public ArrayList<Skills> FetchSkillList(UserAccount ua) throws AdException {
		// TODO Auto-generated method stub
		
		try {
            begin();   
            
            
            ArrayList<Skills> skillList = new ArrayList<Skills>();
	    	Query q = getSession().createQuery("from Skills where userid = :id ");
	    	q.setLong("id",ua.getId());
	    	List list = q.list();
	    	
	    	System.out.println("Retrieved Skills:"+list.size());
	    	
	    	Iterator<Skills> skillIterator = list.iterator();
	
	    	while (skillIterator.hasNext())
            {            		
	    			Skills s = (Skills) skillIterator.next();
	    			skillList.add(s);                        
            }
            commit();
            return skillList;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not retirieve skill list :" +e.getMessage());
        }
		
	}

    public ArrayList<Skills> FetchCandidateSkillList(Candidate c) throws AdException {
		// TODO Auto-generated method stub
		
		try {
            begin();   
            
            
            ArrayList<Skills> skillList = new ArrayList<Skills>();
	    	Query q = getSession().createQuery("from Skills where userid = :id ");
	    	q.setLong("id",c.getId());
	    	List list = q.list();
	    	
	    	System.out.println("Retrieved Skills:"+list.size());
	    	
	    	Iterator<Skills> skillIterator = list.iterator();
	
	    	while (skillIterator.hasNext())
            {            		
	    			Skills s = (Skills) skillIterator.next();
	    			skillList.add(s);                        
            }
            commit();
            return skillList;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not retirieve skill list :" +e.getMessage());
        }
		
	}

    
    
    public void delete(int skillId)
            throws AdException {
        try {
            begin();
            Query q =getSession().createQuery("delete from Skills where skillId = :skillId");
            q.setInteger("skillId", skillId);
            q.executeUpdate();
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete skill with ID :"+skillId, e);
        }
    }
}





