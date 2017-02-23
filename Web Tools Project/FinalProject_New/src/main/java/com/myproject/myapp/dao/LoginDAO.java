package com.myproject.myapp.dao;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.myproject.myapp.exception.AdException;
import com.myproject.myapp.pojo.UserAccount;

@Repository
public class LoginDAO extends DAO {
	
    public UserAccount getUserAccount(String emailId, String password) throws AdException{
  
    	        try {
    	            begin();
    	            Query q = getSession().createQuery("from UserAccount where emailId = :emailId AND password = :password");
    	            q.setString("emailId", emailId);
    	            q.setString("password", password);
    	            UserAccount useraccount = (UserAccount) q.uniqueResult();
    	            commit();
    	            return useraccount;
    	        } catch (HibernateException e) {
    	            rollback();
    	            throw new AdException("Could not get user " + emailId + password, e);
    	        }
    }
	
}