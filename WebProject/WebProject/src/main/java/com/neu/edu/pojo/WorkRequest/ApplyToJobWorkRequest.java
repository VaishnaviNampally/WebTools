package com.neu.edu.pojo.WorkRequest;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import com.neu.edu.pojo.candidate.Person;
import com.neu.edu.pojo.employer.Company;


@Entity
@PrimaryKeyJoinColumn(name="REQUEST_ID")
public class ApplyToJobWorkRequest extends WorkRequest {

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Person person;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Company company;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
