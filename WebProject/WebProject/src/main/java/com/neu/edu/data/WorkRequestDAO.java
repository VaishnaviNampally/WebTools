package com.neu.edu.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.neu.edu.pojo.WorkRequest.ApplyToJobWorkRequest;
import com.neu.edu.pojo.candidate.Person;
import com.neu.edu.pojo.candidate.UserAccount;
import com.neu.edu.pojo.employer.Company;
import com.neu.edu.pojo.employer.Job;

@Repository
public class WorkRequestDAO extends DAO{

	
	public void sendToEmployee(int jobID,UserAccount candidate){
		
		Session session = getSession();
		try{
		Transaction tx = session.beginTransaction();
		Query q= session.createQuery("from UserAccount where userID=:id");
		q.setInteger("id", candidate.getUserID());
		Person person=(Person)q.uniqueResult();
		Query q1= session.createQuery("from Job where jobID=:id");
		q1.setInteger("id", jobID);
		Job job=(Job)q1.uniqueResult();
		
		ApplyToJobWorkRequest request=new ApplyToJobWorkRequest();
		request.setMessage("sent to employee");
		request.setReceiver(job.getPostedBy());
		request.setSender(person.getFirstName());
		request.setUserAccount(candidate);
		request.setRole(String.valueOf(job.getJobID()));
		request.setPerson(person);
		request.setCompany(job.getCompany());
		request.setStatus("Sent to employer");
		System.out.println("sent to employer");
		
		session.saveOrUpdate(request);
		tx.commit();
		session.close();}
		catch(Exception e){
			System.out.println("Exception :"+ e);
		}
		//request.set
		
	}
	

	public void sendToCandidate(int jobID){
		Session session = getSession();
		try{
		Transaction tx = session.beginTransaction();
		
		Query q1= session.createQuery("from WorkRequest where requestId=:id");
		q1.setInteger("id", jobID);
		
		ApplyToJobWorkRequest request=(ApplyToJobWorkRequest)q1.uniqueResult();
		request.setMessage("qualified");
		request.setReceiver(request.getPerson().getUsername());
		request.setSender(request.getCompany().getCompanyName());
		
		request.setRole("Person");
		request.setPerson(request.getPerson());
		request.setCompany(request.getCompany());
		request.setStatus("Qualified");
		
		session.update(request);
		tx.commit();
		session.close();
		}
		catch(Exception e){
			System.out.println("Exception :"+ e);
		}
		
	}
	
	public List<ApplyToJobWorkRequest> getApplyToJobWorkRequests(UserAccount employer){
		Criteria criteria = getSession().createCriteria(ApplyToJobWorkRequest.class);	
		criteria.add(Restrictions.eq("status", "Sent to employer"));
		criteria.add(Restrictions.eq("receiver",employer.getUsername()));
		List<ApplyToJobWorkRequest> workReq = criteria.list();
		return workReq;
	}
	
	public List<ApplyToJobWorkRequest> getAllApplyToJobWorkRequests(){
		Criteria criteria = getSession().createCriteria(ApplyToJobWorkRequest.class);	
		criteria.add(Restrictions.eq("status", "Sent to employer"));
		//criteria.add(Restrictions.eq("receiver",person.getUsername()));
		List<ApplyToJobWorkRequest> workReq = criteria.list();
		return workReq;
	}
	
	public List<ApplyToJobWorkRequest> getSelectCandidate(UserAccount candidate){
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		
		Query q1= session.createQuery("from UserAccount where userID=:id");
		q1.setInteger("id", candidate.getUserID());
		Person p=(Person)q1.uniqueResult();
		Criteria criteria = getSession().createCriteria(ApplyToJobWorkRequest.class);	
		//criteria.add(Restrictions.eq("status", "Qualified"));
		//criteria.add(Restrictions.eq("receiver",candidate.getUsername()));
		criteria.add(Restrictions.eq("person",p));
		List<ApplyToJobWorkRequest> workReq = criteria.list();
		tx.commit();
		session.close();
		return workReq;
	}
	
	public Person getCandidate(int jobID){
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		
		Query q1= session.createQuery("from WorkRequest where requestId=:id");
		q1.setInteger("id", jobID);
		ApplyToJobWorkRequest request=(ApplyToJobWorkRequest)q1.uniqueResult();
		Person p= request.getPerson();
		System.out.println("Person is: "+p.getFirstName());
		tx.commit();
		session.close();
		//request.set
		return p;
		
	}
}
