package com.neu.edu.pojo.employer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.NotEmpty;



@Entity
@NamedQuery(name="job.all" ,query="from Job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobID;
	@NotEmpty(message="Job Title could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Job Title should be between 2 - 15 characters.")
	@Pattern(regexp="^[A-Za-z_ ]++$", message=" only words accepted")
	private String jobTitle;
	@NotEmpty(message="Description could not be left blank/ Invalid Characters")
	@Size(min=2, max=30, message="Description should be between 2 - 30 characters.")
	@Pattern(regexp="^[A-Za-z_ ]++$", message=" only words accepted")
	private String description;
	@NotEmpty(message="Job Type could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="job Type should be between 2 - 15 characters.")
	@Pattern(regexp="^[A-Za-z_ ]++$", message=" only words accepted")
	private String jobType;
	@Max(10000)	
	@Min(0)
	private float salary;
	@NotEmpty(message="Experience could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Experience should be between 2 - 15 characters.")
	@Pattern(regexp="^[A-Za-z_ ]++$", message=" only words accepted")
	private String experienceRequired;
	@NotEmpty(message="Skills could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Skills should be between 2 - 15 characters.")
	@Pattern(regexp="^[_,A-Za-z_ ]++$", message=" only words separated with ',' accepted")
	private String skillsRequired;
	@NotEmpty(message="Location could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Location should be between 2 - 15 characters.")
	@Pattern(regexp="^[A-Za-z0-9_ ]++$", message=" only words and digits accepted")
	private String location;
	
	private String datePosted;
	@NotEmpty(message="Qualifications Required could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Qualifications Required should be between 2 - 15 characters.")
	@Pattern(regexp="^[A-Za-z_ ]++$", message=" only words accepted")
	private String qualificationsRequired;
	@NotEmpty(message="Industry Required could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Industry Required should be between 2 - 15 characters.")
	@Pattern(regexp="^[A-Za-z_ ]++$", message=" only words accepted")
	private String industry;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="companyName")
    private Company company;
	
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	private String postedBy;
	
	
	
	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String category) {
		this.industry = category;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getExperienceRequired() {
		return experienceRequired;
	}
	public void setExperienceRequired(String experienceRequired) {
		this.experienceRequired = experienceRequired;
	}
	public String getSkillsRequired() {
		return skillsRequired;
	}
	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(String datePosted) {
		this.datePosted = datePosted;
	}
	public String getQualificationsRequired() {
		return qualificationsRequired;
	}
	public void setQualificationsRequired(String qualificationsRequired) {
		this.qualificationsRequired = qualificationsRequired;
	}
	
	
	
}
