package com.neu.edu.pojo.employer;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


public class Category {
	
	private int categoryID;
	private String title;
	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Job> jobList = new HashSet<Job>();
	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Set<Job> getJobList() {
		return jobList;
	}
	public void setJobList(Set<Job> jobList) {
		this.jobList = jobList;
	}
	
	

}
