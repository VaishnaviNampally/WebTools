package com.neu.edu.data;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.neu.edu.pojo.WorkRequest.ApplyToJobWorkRequest;
import com.neu.edu.pojo.candidate.Education;
import com.neu.edu.pojo.candidate.Experience;
import com.neu.edu.pojo.candidate.Person;
import com.neu.edu.pojo.candidate.Skill;
import com.neu.edu.pojo.candidate.UserAccount;
import com.neu.edu.resume.FileUploadForm;


@Repository
public class CandidateDAO extends DAO {


	public void addSkills(String skillName,String skillType,UserAccount p){


		try{

			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			Query q= session.createQuery("from UserAccount where userID=:id");

			q.setInteger("id", p.getUserID());
			Person person=(Person)q.uniqueResult();
			Skill skill= new Skill();
			skill.setSkillName(skillName);
			skill.setSkillType(skillType);
			person.addSkills(skill);
			session.save(person);
			transaction.commit();
			session.close();
		}catch(Exception e ){
			System.out.println("cannot add skills:"+ e.getMessage());
		}
	}
	public void addResume(FileUploadForm file,UserAccount user){	

		try{

			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			Query q= session.createQuery("from UserAccount where userID=:id");
			q.setInteger("id", user.getUserID());
			Person person=(Person)q.uniqueResult();
			person.setFile(file);
			session.update(person);

			transaction.commit();
			session.close();
		}catch(Exception e ){
			System.out.println("cannot add skills:"+ e.getMessage());
		}
	}

	public void addEducation(String schoolName,String level,String major,String gpa,String attendedFrom,String attendedTo,UserAccount p){


		try{

			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			Query q= session.createQuery("from UserAccount where userID=:id");

			q.setInteger("id", p.getUserID());
			Person person=(Person)q.uniqueResult();
			Education education= new Education();
			education.setSchoolName(schoolName);
			education.setLevel(level);
			education.setMajor(major);
			education.setGPA(gpa);
			education.setAttendedFrom(attendedFrom);
			education.setAttendedTo(attendedTo);
			person.addEducation(education);
			session.save(person);
			transaction.commit();
			session.close();
		}catch(Exception e ){
			System.out.println("cannot add education:"+ e.getMessage());
		}
	}

	public void addExperience(String companyName,String role,String description,String startDate,String endDate,UserAccount p){


		try{

			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			Query q= session.createQuery("from UserAccount where userID=:id");

			q.setInteger("id", p.getUserID());
			Person person=(Person)q.uniqueResult();
			Experience experience= new Experience();
			experience.setCompanyName(companyName);
			experience.setRole(role);
			experience.setDescription(description);
			experience.setStartDate(startDate);
			experience.setEndDate(endDate);

			person.addExperience(experience);
			session.save(person);
			transaction.commit();
			session.close();
		}catch(Exception e ){
			System.out.println("cannot add experience:"+ e.getMessage());
		}
	}

	public Person getPerson(UserAccount p){

		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Query q= session.createQuery("from UserAccount where userID=:id");

		q.setInteger("id", p.getUserID());
		Person person=(Person)q.uniqueResult();

		transaction.commit();
		session.close();
		return person;


	}

	public ArrayList<Skill> getPersonSkills(UserAccount p){

		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		ArrayList<Skill> list= new ArrayList<Skill>();
		
		Query q= session.createQuery("from UserAccount where userID=:id");

		q.setInteger("id", p.getUserID());
		Person person=(Person)q.uniqueResult();
		System.out.println("Person inside skill:"+person.getFirstName());
		Set<Skill> expList =person.getSkills();
		System.out.println("Exp List size:"+expList.size());
//		list.addAll(expList);
		for(Skill s:expList){
			//Query q1= session.createQuery("from Skill where skillID=:id");
			System.out.println("Skill s:"+s.getSkillName());
			//q1.setInteger("id", s.getSkillID());
		//Skill skill=(Skill)q1.uniqueResult();
			list.add(s);	
		}
		System.out.println("Returning List size:"+list.size());
		transaction.commit();
		session.close();
		return list;


	}

	public ArrayList<Education> getPersonEdu(UserAccount p){

		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		ArrayList<Education> list= new ArrayList<Education>();
		//List list=null;
		Query q= session.createQuery("from UserAccount where userID=:id");

		q.setInteger("id", p.getUserID());
		Person person=(Person)q.uniqueResult();

		Set<Education> expList =person.getEducationList();
		for(Education s:expList){
//			Query q1= session.createQuery("from Education where educationId=:id");
//
//			q1.setInteger("id", s.getEducationID());
		list.add(s);	
		}

		transaction.commit();
		session.close();
		return list;


	}

	public ArrayList<Experience> getPersonExp(UserAccount p){

		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		ArrayList<Experience> list= new ArrayList<Experience>();
		//List list=null;
		Query q= session.createQuery("from UserAccount where userID=:id");

		q.setInteger("id", p.getUserID());
		Person person=(Person)q.uniqueResult();

		Set<Experience> expList =person.getExperienceList();
		for(Experience s:expList){
			System.out.println("Experience ID is: "+s.getExperienceId());
//			Query q1= session.createQuery("from Experience where experienceId=:id");
//
//			q1.setInteger("id", s.getExperienceId());
//			list=q1.list();
			list.add(s);


		}

		transaction.commit();
		session.close();
		return list;


	}

	public void updateSkill(int skillID,String name,String type,UserAccount user){

		Session session = getSession();
		Transaction transaction = session.beginTransaction();

		Query q= session.createQuery("from UserAccount where userID=:id");

		q.setInteger("id", user.getUserID());
		Person person=(Person)q.uniqueResult();
		Set<Skill> skillList=  person.getSkills();

		for(Skill s:skillList){
			if(skillID==s.getSkillID()){
				Query q1= session.createQuery("from Skill where skillID=:id");

				q1.setInteger("id", skillID);
				Skill skill=(Skill)q1.uniqueResult();

				skill.setSkillName(name);
				skill.setSkillType(type);

				session.update(person);
			}
		}
		transaction.commit();
		session.close();


	}

	public List getSkills(Person p){

		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		List list = null;
		Set<Skill> skiList=  p.getSkills();
		for(Skill s:skiList){
			Query q1= session.createQuery("from Skill where skillID=:id");

			q1.setInteger("id", s.getSkillID());
			list=(List) q1.list();
		}
		transaction.commit();
		session.close();
		return list;


	}

	public List getEdu(Person p){

		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		List list = null;
		Set<Education> eduList=  p.getEducationList();
		for(Education s:eduList){
			Query q1= session.createQuery("from Education where educationId=:id");

			q1.setInteger("id", s.getEducationID());
			list=(List) q1.list();
		}
		transaction.commit();
		session.close();
		return list;


	}

	public List getExp(Person p){

		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		List list = null;
		Set<Experience> expList=  p.getExperienceList();

		for(Experience s:expList){
			Query q1= session.createQuery("from Experience where experienceId=:id");

			q1.setInteger("id", s.getExperienceId());
			list=(List) q1.list();
		}
		transaction.commit();
		session.close();
		return list;


	}

	public void updateEducation(int eduID,String schoolName,String level,String major,String attendedFrom,String attendedTo,String gpa,UserAccount user){

		Session session = getSession();
		Transaction transaction = session.beginTransaction();

		Query q= session.createQuery("from UserAccount where userID=:id");

		q.setInteger("id", user.getUserID());
		Person person=(Person)q.uniqueResult();
		Set<Education> eduList=  person.getEducationList();

		for(Education s:eduList){
			if(eduID==s.getEducationID()){
				Query q1= session.createQuery("from Education where educationID=:id");

				q1.setInteger("id", eduID);
				Education edu=(Education)q1.uniqueResult();

				edu.setSchoolName(schoolName);
				edu.setLevel(level);
				edu.setMajor(major);
				edu.setAttendedFrom(attendedFrom);
				edu.setAttendedTo(attendedTo);
				edu.setGPA(gpa);

				session.update(person);
			}
		}
		transaction.commit();
		session.close();
	}


	public void updateExperience(int expID,String companyName,String role,String description,String startDate,String endDate,UserAccount user){

		Session session = getSession();
		Transaction transaction = session.beginTransaction();

		Query q= session.createQuery("from UserAccount where userID=:id");

		q.setInteger("id", user.getUserID());
		Person person=(Person)q.uniqueResult();
		Set<Experience> expList=  person.getExperienceList();

		for(Experience s:expList){
			if(expID==s.getExperienceId()){
				Query q1= session.createQuery("from Experience where experienceId=:id");

				q1.setInteger("id", expID);
				Experience exp=(Experience)q1.uniqueResult();

				exp.setCompanyName(companyName);
				exp.setRole(role);
				exp.setDescription(description);
				exp.setStartDate(startDate);
				exp.setEndDate(endDate);

				//int i=q.executeUpdate();
				session.update(person);
			}
		}
		transaction.commit();
		session.close();
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

	public FileUploadForm getResume(int id){
		
		Session session= getSession();
		Transaction transaction = session.beginTransaction();
		Query q=session.createQuery("from UserAccount where userID=:id");
		q.setInteger("id", id);
		Person p=(Person)q.uniqueResult();
		FileUploadForm form= p.getFile();
		System.out.println("form id is"+form.getId());
		transaction.commit();
		session.close();

		return form;

	}

}

