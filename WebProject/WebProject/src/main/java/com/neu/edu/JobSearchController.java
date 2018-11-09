package com.neu.edu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.data.CompanyDAO;
import com.neu.edu.data.JobDAO;
import com.neu.edu.pojo.candidate.UserAccount;
import com.neu.edu.pojo.employer.Company;
import com.neu.edu.pojo.employer.Job;

@Controller
public class JobSearchController {

	@Autowired
	CompanyDAO jobs;

	@Autowired
	JobDAO jobDao;


	@RequestMapping("/listjobs")
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List jobList = new ArrayList();

		try {
			
			jobList = jobs.list();


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ModelAndView mv = new ModelAndView("viewJobs", "jobs", jobList);
		return mv;
	}


	@RequestMapping("/searchJobs")
	protected ModelAndView handleRequestInternal1(@ModelAttribute("searchText")String company,@ModelAttribute("searchByOption")String option,HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mv=null;
		
		List jobList = new ArrayList();
		System.out.println("option is"+ option);

		if(option.equals("company")){
			try {

				jobList = jobs.searchByCompany(company);


			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			mv = new ModelAndView("candidateDashboard", "jobs", jobList);

		}
		if(option.equals("location")){
			try {

				jobList = jobs.searchByLocation(company);


			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			mv = new ModelAndView("candidateDashboard", "jobs", jobList);

		}
		if(option.equals("role")){
			try {

				jobList = jobs.searchByRole(company);


			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			mv = new ModelAndView("candidateDashboard", "jobs", jobList);

		}

		if(option.equals("salary")){
			try {

				jobList = jobs.searchBySalary(company);


			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			mv = new ModelAndView("candidateDashboard", "jobs", jobList);

		}

		return mv;
	}


	@RequestMapping("/viewCompanyJobs")
	protected ModelAndView handleRequestInternal1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		HttpSession session=request.getSession();
		UserAccount company = (UserAccount) session.getAttribute("userAccount");

		List jobList = new ArrayList();

		try {
			
			jobList = jobs.searchByCompany(company.getUsername());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ModelAndView mv = new ModelAndView("viewCompanyJobs", "jobs", jobList);
		return mv;
	}

	@RequestMapping(value ="/updateJob" , method = RequestMethod.POST)
	protected String handleRequestInternal2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		try{
		HttpSession session=request.getSession();
		UserAccount company = (UserAccount) session.getAttribute("userAccount");
		int jobID=Integer.parseInt(request.getParameter("jobID"));
		//String jobTitle=request.getParameter("postedBy");
		String jobTitle=request.getParameter("jobTitle");
		String jobType=request.getParameter("jobType");
		String description=request.getParameter("description");
		Float salary=Float.parseFloat(request.getParameter("salary"));
		String experienceRequired=request.getParameter("experienceRequired");
		String skillsRequired=request.getParameter("skillsRequired");
		String location=request.getParameter("location");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String datePosted = dateFormat.format(date);
		String qualificationsRequired=request.getParameter("qualificationsRequired");
		String industry=request.getParameter("industry");
		jobDao.updateJob(jobID,jobTitle,jobType,description,salary,experienceRequired,skillsRequired,location,datePosted,qualificationsRequired,industry);

		}catch(Exception e){
			System.out.println("cannot update job"+e.getMessage());
		}
		return "AddedSuccessfullyCompany";
	}
	
	@RequestMapping(value ="/updateJob" , method = RequestMethod.GET)
	protected String handleRequestInternal5(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "home";
	}
}
