package com.neu.edu.pojo.employer;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.neu.edu.pojo.candidate.UserAccount;



@Entity
@PrimaryKeyJoinColumn(name="userID")
public class Company extends UserAccount{

	@NotEmpty(message="Company Name could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Your Comapny Name should be between 2 - 15 characters.")
	private String companyName;

	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Job> jobList = new HashSet<Job>();
	
	public Company(){}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Set<Job> getJobList() {
		return jobList;
	}
	public void setJobList(Set<Job> categoryList) {
		this.jobList = categoryList;
	}
	
	 public void addJob(Job job) {
		 jobList.add(job);
	    }
	
}
