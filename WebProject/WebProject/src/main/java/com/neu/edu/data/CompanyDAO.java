package com.neu.edu.data;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.neu.edu.pojo.employer.Company;

@Repository
public class CompanyDAO extends DAO {

	
	public Company addCompany(String companyName,String uname, String pwd){

		Session session = getSession();
		
		Transaction transaction = session.beginTransaction();
		Company c= new Company();
		c.setCompanyName(companyName);
		c.setUsername(uname);
		c.setPassword(pwd);
		c.setType("company");
		session.save(c);
		transaction.commit();
		session.close();
		return c;
		
	}
	
	
	
	   public List list() {
	      
	        	Session session = getSession();
	        	Transaction transaction = session.beginTransaction();
	            Query q = getSession().getNamedQuery("job.all");
	            List list = q.list();
	            transaction.commit();
	            session.close();
	            return list;
	        
	    }
	   
	   public List searchByCompany(String company){
		   Session session = getSession();
       	Transaction transaction = session.beginTransaction();
           Query q = getSession().createQuery("from Job where postedBy=:company");
           q.setString("company", company);
           List list = q.list();
           transaction.commit();
           session.close();
           return list;
		   
	   }
	   public List searchBySalary(String salary){
		   Session session = getSession();
		   float s=Float.parseFloat(salary);
       	Transaction transaction = session.beginTransaction();
           Query q = getSession().createQuery("from Job where salary>=:s");
           q.setFloat("s", s);
           List list = q.list();
           transaction.commit();
           session.close();
           return list;
		   
	   }
	   
	   public List searchByRole(String role){
		   Session session = getSession();
		  // float s=Float.parseFloat(salary);
       	Transaction transaction = session.beginTransaction();
           Query q = getSession().createQuery("from Job where jobTitle=:role");
           q.setString("role", role);
           List list = q.list();
           transaction.commit();
           session.close();
           return list;
		   
	   }
	   
	   public List searchByLocation(String salary){
		   Session session = getSession();
       	Transaction transaction = session.beginTransaction();
           Query q = getSession().createQuery("from Job where location=:location");
           q.setString("location", salary);
           List list = q.list();
           transaction.commit();
           session.close();
           return list;
		   
	   }
	   public Company get(String companyName)  {
	     
	        	Session session = getSession();
	        	Transaction transaction = session.beginTransaction();
	            Query q=getSession().createQuery("from Company where companyName= :companyName");
	            q.setString("companyName",companyName);
	            Company company=(Company)q.uniqueResult();
	            transaction.commit();
	            session.close();
	            return company;
	      
	    }
	   
	   public boolean isUserExists(String user){
		   boolean bool=false;
		   Session session= getSession();
		   Transaction transaction = session.beginTransaction();
		   Query q=session.createQuery("from UserAccount where username=:id");
		   q.setString("id", user);
		   List list=q.list();
		   transaction.commit();
           session.close();
           
           if(!list.isEmpty()){
        	   bool=true;
           }
		   return bool;
		   
	   }
}
