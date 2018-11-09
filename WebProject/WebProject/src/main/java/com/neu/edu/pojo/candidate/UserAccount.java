package com.neu.edu.pojo.candidate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class UserAccount{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	@NotEmpty(message="User Name could not be left blank/ Invalid Characters")
	@Size(min=5, max=10, message="Your User name should be between 5 - 10 characters.")
    private String username;
	@NotEmpty(message="Password could not be left blank/ Invalid Characters")
	@Size(min=5, max=10, message="Your Password should be between 5 - 10 characters.")
    private String password;
    
    private String type;
    
	

    public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public UserAccount(String Username, String password) {
        this.username = Username;
        this.password = password;
    }

    public UserAccount() {
    }
    
    

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
