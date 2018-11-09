package com.neu.edu.pojo.candidate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.neu.edu.pojo.employer.Job;

@Entity
public class Applications {

	@Id
	@GeneratedValue
	private int applicationID;
	
	private String status;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
