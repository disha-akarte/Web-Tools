package com.myproject.myapp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.myproject.myapp.exception.AdException;
import com.myproject.myapp.pojo.Application;
import com.myproject.myapp.pojo.Candidate;
import com.myproject.myapp.pojo.EmployerAppView;
import com.myproject.myapp.pojo.Job;

@Repository
public class EmployerAppViewDAO extends DAO{

	public EmployerAppViewDAO(){
		
	}
		
	public ArrayList<EmployerAppView> FetchList(long id) throws AdException {
		// TODO Auto-generated method stub
		
		try {
            begin();
            ArrayList<EmployerAppView> emp = new ArrayList<EmployerAppView>();
            //ArrayList l1 = new ArrayList();
            Query q = getSession().createQuery("from Application where employeeID = :id");
            q.setLong("id", id);
	    	List list = q.list();
	    	Iterator jobIterator = list.iterator();

	            while (jobIterator.hasNext())
	            {
	            		EmployerAppView eav = new EmployerAppView();
	                    Application app = (Application) jobIterator.next();
	                    eav.setApp(app);
	                    eav.setAppID(eav.getApp().getAppID());
	                    eav.setStatus(eav.getApp().getStatus());
	                    
	                    Query q1 = getSession().createQuery("from Job where jobID = :jobID");
	                    q1.setLong("jobID",app.getJobID());
	                	Job job = (Job) q1.uniqueResult();
	                	eav.setJob(job);
	                	eav.setJobTitle(eav.getJob().getJobTitle());
	                	
	                	Query q2 = getSession().createQuery("from UserAccount where id = :id");
	                    q2.setLong("id",app.getCandidateID());
	                	Candidate cand = (Candidate) q2.uniqueResult();
	                	eav.setCandidate(cand);
	                	String name = eav.getCandidate().getFirst().concat(" ").concat(eav.getCandidate().getLast());
	                	System.out.println("The name is :"+name);
	                	eav.setName(name);
	                	System.out.println(cand.getId());
	                	eav.setCandidateID(cand.getId());
	                	
	                    emp.add(eav);                    
	                
	            }
	    	commit();
            return emp;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not retirieve list :" +e.getMessage());
        }
		
	}
	
	public ArrayList<Application> getJobsApplicantList(long id) throws AdException {
		// TODO Auto-generated method stub
		
		try {
            begin();
            ArrayList<Application> applicationsList = new ArrayList<Application>();
            Query q = getSession().createQuery("from Application where employeeID = :id");
            q.setLong("id", id);
	    	List list = q.list();
	    	
	    	Iterator<Application> appIterator = list.iterator();
	
	    	while (appIterator.hasNext())
            {            		
            	    Application a = (Application) appIterator.next();
                    applicationsList.add(a);                        
            }
           
	    	
	    	commit();
            return applicationsList;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not retirieve list :" +e.getMessage());
        }
		
	}
}
