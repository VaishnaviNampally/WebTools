package com.neu.edu.pojo.candidate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@NamedQuery(name="skill.all" ,query="from Skill")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillID;
	@NotEmpty(message="Skill Name could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Your Skill Name should be between 2 - 15 characters.")
	@Pattern(regexp="[A-Za-z_ ]++$", message=" only words accepted")
	private String skillName;
	@NotEmpty(message="Skill Type could not be left blank/ Invalid Characters")
	@Size(min=2, max=15, message="Your Skill Name should be between 2 - 15 characters.")
	@Pattern(regexp="[A-Za-z_ ]++$", message=" only words accepted")
	private String skillType;
	
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getSkillType() {
		return skillType;
	}
	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}
	public int getSkillID() {
		return skillID;
	}
	public void setSkillID(int skillID) {
		this.skillID = skillID;
	}
	
	
	
	
}
