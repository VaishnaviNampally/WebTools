package com.neu.edu.data;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.neu.edu.pojo.candidate.Candidate;
import com.neu.edu.pojo.candidate.Person;
import com.neu.edu.pojo.candidate.UserAccount;

@Repository
public class PersonDAO extends DAO{
	public Person addPerson(String fname, String lname, String address, String email, String phone, String ssn, String uname, String pwd){
		
			
		
		Session session = getSession();
		
		Transaction transaction = session.beginTransaction();
		Person p= new Person();
		p.setFirstName(fname);
		p.setLastName(lname);
		p.setAddress(address);
		p.setEmail(email);
		p.setPhone(phone);
		p.setSsn(ssn);
		p.setUsername(uname);
		p.setPassword(pwd);
		p.setType("Candidate");
		session.save(p);
		transaction.commit();
		session.close();
		return p;
	}
}
