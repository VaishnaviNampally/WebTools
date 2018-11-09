package com.neu.edu.pojo.candidate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

@Entity

public class Candidate{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String resume;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Skill> skills = new HashSet<Skill>();
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Education> educationList = new HashSet<Education>();
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Experience> experienceList = new HashSet<Experience>();
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Applications> applicationList = new HashSet<Applications>();
	
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	
	
	public Set<Skill> getSkills() {
		return skills;
	}
	public void addSkills(String name,String type) {
		Skill skill=new Skill();
		skill.setSkillName(name);
		skill.setSkillType(type);
		skills.add(skill);
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
	public Set<Applications> getApplicationList() {
		return applicationList;
	}
	public void setApplicationList(Set<Applications> applications) {
		this.applicationList = applications;
	}
	
	
}
