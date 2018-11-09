package com.neu.edu.pojo.candidate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int experienceId;
	@NotEmpty(message="Company Name could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Your Company Name should be between 2 - 15 characters.")
	@Pattern(regexp="^[A-Za-z0-9_ ]++$", message=" only words and digits accepted")
	private String companyName;
	@NotEmpty(message="Role could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Your Role should be between 2 - 15 characters.")
	@Pattern(regexp="^[A-Za-z_ ]++$", message=" only words accepted")
	private String role;
	@NotEmpty(message="Description could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Your Description should be between 2 - 15 characters.")
	@Pattern(regexp="^[A-Za-z0-9_ ]++$", message=" only words and digits accepted")
	private String description;
	@NotEmpty(message="Start Date could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Your Start Date should be between 2 - 15 characters.")
	private String startDate;
	@NotEmpty(message="End Date could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Your End Date should be between 2 - 15 characters.")
	private String endDate;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getExperienceId() {
		return experienceId;
	}
	public void setExperienceId(int experienceId) {
		this.experienceId = experienceId;
	}
	
	
}
