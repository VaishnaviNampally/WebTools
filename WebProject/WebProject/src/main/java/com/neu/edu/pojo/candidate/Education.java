package com.neu.edu.pojo.candidate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int educationID;
	@NotEmpty(message="School Name could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Your School Name should be between 2 - 15 characters.")
	@Pattern(regexp="^[A-Za-z0-9_ ]++$", message=" only words and digits accepted")
	private String schoolName;
	@NotEmpty(message="Level could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Your Level should be between 2 - 15 characters.")	
	@Pattern(regexp="^[A-Za-z0-9_ ]++$", message=" only words and digits accepted")
	private String level;
	@NotEmpty(message="Major could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Your Major should be between 2 - 15 characters.")
	@Pattern(regexp="^[A-Za-z_ ]++$", message=" only and digits accepted")
	private String major;
	@NotEmpty(message="Attended From could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Your Attended From should be between 2 - 4 characters.")	
	private String attendedFrom;
	@NotEmpty(message="Attended To could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Your Attended To should be between 2 - 4 characters.")	
	private String attendedTo;
	@NotEmpty(message="GPA could not be left blank/ Invalid Characters")
	@Size(min=2, max=3, message="Your GPA should be between 2 - 3 characters.")
	@Pattern(regexp="^[0-9]++$", message=" only words and digits accepted")
	private String GPA;
	
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getAttendedFrom() {
		return attendedFrom;
	}
	public void setAttendedFrom(String attendedFrom) {
		this.attendedFrom = attendedFrom;
	}
	public String getAttendedTo() {
		return attendedTo;
	}
	public void setAttendedTo(String attendedTo) {
		this.attendedTo = attendedTo;
	}
	public String getGPA() {
		return GPA;
	}
	public void setGPA(String gPA) {
		GPA = gPA;
	}
	public int getEducationID() {
		return educationID;
	}
	public void setEducationID(int educationID) {
		this.educationID = educationID;
	}
	
	
}
