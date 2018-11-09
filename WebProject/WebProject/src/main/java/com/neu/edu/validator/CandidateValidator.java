package com.neu.edu.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.data.CandidateDAO;
import com.neu.edu.data.CompanyDAO;
import com.neu.edu.pojo.candidate.Candidate;
import com.neu.edu.pojo.candidate.Person;
import com.neu.edu.pojo.employer.Company;

public class CandidateValidator implements Validator {

	 public boolean supports(Class aClass)
	    {
	        return aClass.equals(Person.class);
	    }

	    public void validate(Object obj, Errors errors)
	    {
	    	Person candidate = (Person) obj;
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.company", "First Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.company", "Last Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ssn", "error.invalid.company", "SSN Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.company", "Last Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ssn", "error.invalid.company", "SSN Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.invalid.company", "Address Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "error.invalid.company", "Phone Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.company", "Email Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.company", "Password Required");;
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.company", "Username Required");;
	        
	        String user = candidate.getUsername();
	        
	        
	        CandidateDAO cd = new CandidateDAO();
	        Boolean exists;
			try {
				exists = cd.isUserExists(user);
				if(exists == true){
		        	 errors.rejectValue("username", "error.invalid.user", "Username already in use");
		        }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	    }
}
