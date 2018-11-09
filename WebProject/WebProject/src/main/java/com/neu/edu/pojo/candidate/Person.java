
package com.neu.edu.pojo.candidate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.neu.edu.resume.FileUploadForm;

@Entity
@PrimaryKeyJoinColumn(name="userID")
public class Person extends UserAccount{

	@NotEmpty(message="First Name could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="First name should be between 2 - 15 characters.")
	@Pattern(regexp="^[A-Za-z_ ]++$", message=" only words  accepted")
	private String firstName;
	@NotEmpty(message="Last Name could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Last name should be between 2 - 15 characters.")
	@Pattern(regexp="^[A-Za-z_ ]++$", message=" only words  accepted")
	private String lastName;
	@NotEmpty(message="SSN could not be left blank/ Invalid Characters")
	@Size(min=2, max=10, message="SSN should be between 2 - 10 characters.")
	@Pattern(regexp="^[0-9]++$", message=" only digits  accepted")
	private String ssn;
	@NotEmpty(message="Address could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Address should be between 2 - 15 characters.")
	@Pattern(regexp="^[A-Za-z0-9_ ]++$", message=" only words and digits  accepted")
	private String address;
	@NotEmpty(message="Phone could not be left blank/ Invalid Characters")
	@Size(min=0, max=10, message="Phone should be between 10 characters.")
	@Pattern(regexp="^[0-9]++$", message=" only digits accepted")
	private String phone;
	@NotEmpty(message="Email could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Email should be between 2 - 15 characters.")
	@Pattern(regexp="^(.+)@(.+)$", message=" enter in format characters@chars")
	private String email;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private FileUploadForm file;


	public Person(){}

	private String resume;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Skill> skills = new HashSet<Skill>();
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Education> educationList = new HashSet<Education>();
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Experience> experienceList = new HashSet<Experience>();
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	private Set<Applications> applicationList = new HashSet<Applications>();

	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}


	public Set<Skill> getSkills() {
		return skills;
	}
	public void addSkills(Skill skill) {
		skills.add(skill);
	}
	public void deleteSkill(Skill skill){
		skills.remove(skill);
	}

	public void addEducation(Education edu) {
		educationList.add(edu);
	}
	public void deleteEducation(Education edu){
		educationList.remove(edu);
	}

	public void addExperience(Experience exp) {
		experienceList.add(exp);
	}
	public void deleteExperience(Experience edu){
		experienceList.remove(edu);
	}
	public Set<Education> getEducationList() {
		return educationList;
	}
	public void setEducationList(Set<Education> education) {
		this.educationList = education;
	}
	public Set<Experience> getExperienceList() {
		return experienceList;
	}
	public void setExperienceList(Set<Experience> experience) {
		this.experienceList = experience;
	}
//	public Set<Applications> getApplicationList() {
//		return applicationList;
//	}
//	public void setApplicationList(Set<Applications> applications) {
//		this.applicationList = applications;
//	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public FileUploadForm getFile() {
		return file;
	}
	public void setFile(FileUploadForm file) {
		this.file = file;
	}


}
