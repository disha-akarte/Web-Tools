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
import com.myproject.myapp.pojo.Job;

@Repository
public class ApplicationDAO extends DAO{

	public ApplicationDAO(){

	}

	public Boolean sendApplication(long company, long canID, long jobID ) throws AdException{
		boolean alreadyApplied = true; 
		try {
			begin();       
			Application application =new Application();
			application.setEmployeeID(company);
			application.setCandidateID(canID);
			application.setJobID(jobID);
			application.setStatus("Applied");
			getSession().save(application);
			commit();
			System.out.println("Done!");
			return false;
		} catch (HibernateException e) {
			rollback();
			alreadyApplied = true;
			return true;
			
			
		}
	}


	public ArrayList<Job> FetchList(long id) throws AdException {
		// TODO Auto-generated method stub

		try {
			begin();
			ArrayList l1 = new ArrayList();
			Query q = getSession().createQuery("from Application where candidateID = :id");
			q.setLong("id", id);
			List list = q.list();
			Iterator jobIterator = list.iterator();

			while (jobIterator.hasNext())
			{

				Application app = (Application) jobIterator.next();

				Query q1 = getSession().createQuery("from Job where jobID = :jobID");
				q1.setLong("jobID",app.getJobID());
				Job job = (Job) q1.uniqueResult();
				l1.add(job);


			}
			commit();
			return l1;
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
	public void acceptCandidate(int appid)throws AdException{

		try {

			begin();       

			Query q = getSession().createQuery("from Application where appID =:appid");	    	
			q.setLong("appid",appid);
			Application c = (Application)q.uniqueResult();
			c.setStatus("Hired");
			getSession().update(c);
			commit();

		}
		catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while accepting candidate " + e.getMessage());
		}
	}

	public void rejectCandidate(int appid)throws AdException{

		try {

			begin();       

			Query q = getSession().createQuery("from Application where appID =:appid");	    	
			q.setLong("appid",appid);
			Application c = (Application)q.uniqueResult();
			c.setStatus("Rejected");
			getSession().update(c);
			commit();

		}
		catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while accepting candidate " + e.getMessage());
		}
	}

}
