package com.neu.edu.pojo.candidate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BackgroundCheck {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int backgroundID;
	private String Gender;
	private Boolean VeteranStatus;
	private Boolean Disability;
	private String ethnicity;
	
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Boolean getVeteranStatus() {
		return VeteranStatus;
	}
	public void setVeteranStatus(Boolean veteranStatus) {
		VeteranStatus = veteranStatus;
	}
	public Boolean getDisability() {
		return Disability;
	}
	public void setDisability(Boolean disability) {
		Disability = disability;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	
	
	
}
