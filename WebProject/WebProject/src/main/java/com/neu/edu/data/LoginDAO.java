package com.neu.edu.data;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.neu.edu.pojo.candidate.UserAccount;


@Repository
public class LoginDAO extends DAO {
	
    public UserAccount getUserAccount(String username, String password) {
  
    	     
    	        	Session session = getSession();
    	    		
    	    		Transaction transaction = session.beginTransaction();
    	            Query q = getSession().createQuery("from UserAccount where username = :username AND password = :password");
    	            
    	            q.setString("username", username);
    	            q.setString("password", password);
    	            UserAccount useraccount = (UserAccount) q.uniqueResult();
    	            System.out.println("username:"+useraccount.getUsername());
    	            transaction.commit();
    	    		session.close();
    	            return useraccount;
    	       
    }
	
}