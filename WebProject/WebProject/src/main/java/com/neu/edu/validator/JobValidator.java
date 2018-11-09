package com.neu.edu.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.pojo.employer.Company;
import com.neu.edu.pojo.employer.Job;

public class JobValidator implements Validator{

    public boolean supports(Class aClass)
    {
        return aClass.equals(Job.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Job job = (Job) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobTitle", "error.invalid.job", "Title Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.invalid.job", "Description Required");;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobType", "error.invalid.job", "JobType Required");;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "error.invalid.job", "Salary Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "experienceRequired", "error.invalid.job", "Experience Required");;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "skillsRequired", "error.invalid.job", "Skills Required");;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "error.invalid.job", "Location Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "qualificationsRequired", "error.invalid.job", "Qualifications Required");;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "industry", "error.invalid.job", "Industry Required");;
        
//        String user = company.getUsername();
        
//        CompanyDAO cd = new CompanyDAO();
//        Boolean exists;
//		try {
//			exists = cd.isUserExists(email);
//			if(exists == true){
//	        	 errors.rejectValue("emailId", "error.invalid.user", "Username already in use");
//	        }
//		} catch (AdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    
    }
}
