package com.neu.edu.data;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.neu.edu.pojo.WorkRequest.ApplyToJobWorkRequest;
import com.neu.edu.pojo.candidate.Education;
import com.neu.edu.pojo.candidate.Experience;
import com.neu.edu.pojo.candidate.Person;
import com.neu.edu.pojo.candidate.Skill;
import com.neu.edu.pojo.candidate.UserAccount;
import com.neu.edu.pojo.employer.Company;
import com.neu.edu.resume.FileUploadForm;

@Repository
public class AdminDAO extends DAO{


	public List getCandidateList(){

		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Query q= session.createQuery("from Person");


		List list=(List) q.list();

		transaction.commit();
		session.close();
		return list;


	}

	public List getCompanyList(){

		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Query q= session.createQuery("from Company");


		List list=(List) q.list();

		transaction.commit();
		session.close();
		return list;


	}

	public void deleteCandidate(int userID){

		Session session = getSession();
		try{
		Transaction transaction = session.beginTransaction();
		Query q= session.createQuery("from UserAccount where userID=:id");
		q.setInteger("id", userID);
		Person p=(Person)q.uniqueResult();
		Set<Skill> skillList=p.getSkills();
		Set<Education> eduList=p.getEducationList();
		Set<Experience> expList=p.getExperienceList();
		FileUploadForm file=p.getFile();
//		//session.delete(p);
//		session.delete(file);

		for(Skill s:skillList){
			Query q1= session.createQuery("from Skill where skillID=:id");
			q1.setInteger("id", s.getSkillID());
			Skill ski= (Skill)q1.uniqueResult();
			
			p.deleteSkill(ski);
			session.delete(ski);
		}
		
		for(Education s:eduList){
			Query q2= session.createQuery("from Education where educationID=:id");
			q2.setInteger("id", s.getEducationID());
			Education ski= (Education)q2.uniqueResult();
			
			p.deleteEducation(ski);
			session.delete(ski);
		}
		
		for(Experience s:expList){
			Query q3= session.createQuery("from Experience where experienceId=:id");
			q3.setInteger("id", s.getExperienceId());
			Experience ski= (Experience)q3.uniqueResult();
			p.deleteExperience(ski);
			session.delete(ski);
			//p.deleteExperience(s);
		}
		
	
		
		
		Query q4 = session.createQuery("from ApplyToJobWorkRequest where userID = :userid");
		 q4.setInteger("userid", userID);
		 ApplyToJobWorkRequest req=(ApplyToJobWorkRequest)q4.uniqueResult();
		 session.delete(req);
		// int result5 = q4.executeUpdate();
		 
			//FileUploadForm resume=p.getFile();
			Query q6= session.createQuery("from FileUploadForm where id=:id");
			q6.setLong("id", file.getId());
//			System.out.println("fileupload id is:"+file.getId());
//			 int result4 = q6.executeUpdate();
			FileUploadForm resume=(FileUploadForm)q6.uniqueResult();
			session.delete(resume);
		session.delete(p);

		transaction.commit();
		session.close();
		}catch(Exception e){
			System.out.println("delete not happening"+e.getMessage());
		}



	}
	public void deleteCompany(int userID){

		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Query q= session.createQuery("from UserAccount where userID=:id");
		q.setInteger("id", userID);
		Company p=(Company)q.uniqueResult();


		session.delete(p);

		transaction.commit();
		session.close();



	}
	
	
	public void deleteCandidate1(int userID)
            {
    	 try {
    		 Session session = getSession();
    		 Transaction transaction = session.beginTransaction();
             Query q1 = session.createQuery("delete from Education where userID = :userid");
             Query q2 = session.createQuery("delete from Experience where userID = :userid");
             Query q3 = session.createQuery("delete from Skill where userID = :userid");
             Query q4 = session.createQuery("delete from ApplyToJobWorkRequest where userID = :userid");
             Query q5 = session.createQuery("delete from FileUploadForm where userID = :userid");
             Query q = session.createQuery("delete from Person where userID = :userid");
             q1.setInteger("userid", userID);
             q2.setInteger("userid", userID); 
             q3.setInteger("userid", userID);
             q4.setInteger("userid", userID);
             q5.setInteger("userid", userID);
             q.setInteger("userid", userID); 
            // q4.setString("email", email);
            
             int result2 = q1.executeUpdate();
             int result3 = q2.executeUpdate();
             int result4 = q3.executeUpdate();
             int result5 = q4.executeUpdate();
             int result6 = q5.executeUpdate();
             int result1 = q.executeUpdate();
             
            
        
            // List list = q.list();
            // System.out.println("+1++++++++++++++++" +list.size());
             transaction.commit();
     		session.close();
             //return result1;
         } catch (Exception e) {
             //rollback();
             System.out.println(e.getMessage());
            
     
         }
        
    }
}
