package com.neu.edu.validator;



import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.neu.edu.data.CompanyDAO;
import com.neu.edu.pojo.employer.Company;

import org.springframework.validation.ValidationUtils;

public class CompanyValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Company.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Company company = (Company) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "error.invalid.company", "Company Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.company", "Password Required");;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.company", "Username Required");;
        
        String user = company.getUsername();
        
        
        CompanyDAO cd = new CompanyDAO();
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
