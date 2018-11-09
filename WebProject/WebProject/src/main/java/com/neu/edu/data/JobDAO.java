package com.neu.edu.data;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.neu.edu.pojo.candidate.UserAccount;
import com.neu.edu.pojo.employer.Company;
import com.neu.edu.pojo.employer.Job;

@Repository
public class JobDAO extends DAO {

	public Job addJob(String title,String description, String type,float salary,String experience,String skills,String location, String datePosted,String qualifications, String category,String postedBy,UserAccount company){

		Session session = getSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query q= session.createQuery("from UserAccount where userID=:id");
		q.setInteger("id", company.getUserID());
		Company c=(Company)q.uniqueResult();
		
		
		Job j=new Job();
		j.setJobTitle(title);
		j.setDescription(description);
		j.setJobType(type);
		j.setSalary(salary);
		j.setExperienceRequired(experience);
		j.setSkillsRequired(skills);
		j.setLocation(location);
		j.setDatePosted(datePosted);
		j.setQualificationsRequired(qualifications);
		j.setIndustry(category);
		j.setCompany(c);
		j.setPostedBy(postedBy);
		session.save(j);
		transaction.commit();
		session.close();
		return j;
		
	}
	
	public void delete(int jobID) {
      
        	Session session = getSession();
        	Transaction transaction = session.beginTransaction();
        	Query q= session.createQuery("from Job where jobID=:id");
        	q.setInteger("id", jobID);
        	Job c=(Job)q.uniqueResult();
            session.delete(c);
    		transaction.commit();
    		session.close();
       
    }
	
	public Job updateJob(int jobID,String jobTitle,String jobType,String description,Float salary,String experienceRequired,String skillsRequired,String location,String datePosted,String qualificationsRequired,String industry)
	{
    
		Session session = getSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query q= session.createQuery("from Job where jobID=:id");
		q.setInteger("id", jobID);
		Job j=(Job)q.uniqueResult();
		
		j.setJobTitle(jobTitle);
		j.setDescription(description);
		j.setJobType(jobType);
		j.setSalary(salary);
		j.setExperienceRequired(experienceRequired);
		j.setSkillsRequired(skillsRequired);
		j.setLocation(location);
		j.setDatePosted(datePosted);
		j.setQualificationsRequired(qualificationsRequired);
		j.setIndustry(industry);
		
		session.update(j);
		transaction.commit();
		session.close();
		return j;
		
	}
}
