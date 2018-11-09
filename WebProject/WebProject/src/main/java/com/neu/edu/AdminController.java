package com.neu.edu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.data.AdminDAO;
import com.neu.edu.pojo.candidate.Person;
import com.neu.edu.pojo.candidate.UserAccount;
import com.neu.edu.pojo.employer.Company;
import com.neu.edu.pojo.employer.Job;

@Controller
public class AdminController {

	@Autowired
	AdminDAO admin;
	
	@RequestMapping(value = "/viewCandidates",method = RequestMethod.GET)
	public String doSubmitAction1(@ModelAttribute("education") Person p ,Model model,BindingResult result) throws Exception {

		 List candidateList = new ArrayList();

	        try {
	            candidateList = admin.getCandidateList();

//	            Iterator candidateIterator = candidateList.iterator();
//
//	            while (candidateIterator.hasNext())
//	            {
//	               
//	                    Person j = (Person) candidateIterator.next();
//	                    candidateList.add(j);
//	                
//	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }

	        model.addAttribute( "cand", candidateList);
		
		

		return "adminViewCandidates";
	}
	
	@RequestMapping(value = "/viewCompanies",method = RequestMethod.GET)
	public String doSubmitAction2(Model model) throws Exception {

		 List companyList = new ArrayList();

	        try {
	            companyList = admin.getCompanyList();

//	            Iterator companyIterator = companyList.iterator();
//
//	            while (companyIterator.hasNext())
//	            {
//	               
//	                    Company j = (Company) companyIterator.next();
//	                    companyList.add(j);
//	                
//	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }

	        model.addAttribute( "comp", companyList);
		
		

		return "adminViewCompanies";
	}
	
	
	@RequestMapping(value = "/deleteCandidate", method = RequestMethod.POST)
	public String doSubmitAction1(HttpServletRequest request) throws Exception {

		try {
			HttpSession session=request.getSession();
			
			int userID=Integer.parseInt(request.getParameter("userID"));
		
			admin.deleteCandidate(userID);
			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return null;
	}
	
	@RequestMapping(value = "/deleteCompany", method = RequestMethod.POST)
	public String doSubmitAction2(HttpServletRequest request) throws Exception {

		try {
			HttpSession session=request.getSession();
			
			int userID=Integer.parseInt(request.getParameter("userID"));
		
			admin.deleteCompany(userID);
			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return null;
	}
	
}
