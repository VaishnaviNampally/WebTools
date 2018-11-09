package com.neu.edu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.data.CompanyDAO;
import com.neu.edu.data.JobDAO;
import com.neu.edu.data.PersonDAO;
import com.neu.edu.data.WorkRequestDAO;
import com.neu.edu.pojo.WorkRequest.ApplyToJobWorkRequest;
import com.neu.edu.pojo.candidate.Person;
import com.neu.edu.pojo.candidate.UserAccount;
import com.neu.edu.pojo.employer.Company;
import com.neu.edu.pojo.employer.Job;
import com.neu.edu.validator.CompanyValidator;
import com.neu.edu.validator.JobValidator;

@Controller
public class CompanyController {

	@Autowired
	CompanyDAO companyDao ;

	@Autowired
	@Qualifier("companyValidator")
	CompanyValidator validator;


//	@Autowired
//	@Qualifier("jobValidator")
//	JobValidator jobvalidator;

	@InitBinder("company")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
		//binder.setValidator(jobvalidator);
	}

//	@InitBinder("job")
//	private void initBinder2(WebDataBinder binder) {
//		binder.setValidator(jobvalidator);
//		//binder.setValidator(jobvalidator);
//	}


	@Autowired
	JobDAO jobDao;

	@Autowired
	WorkRequestDAO jobs; 

	@RequestMapping(value = "/registerCompany", method = RequestMethod.GET)
	public String registerCandidate(@ModelAttribute("company") Company c,Locale locale, Model model) {

		return "AddCompany";
	}

	@RequestMapping(value = "/companySignup", method = RequestMethod.POST)
	public String doSubmitAction(@Valid @ModelAttribute("company") Company p,BindingResult result) throws Exception {
		validator.validate(p, result);
		if (result.hasErrors()) {
			return "AddCompany";
		}

		try {
			companyDao.addCompany(p.getCompanyName(),p.getUsername(),p.getPassword());
			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "Login";
	}
	
	@RequestMapping(value = "/companySignup", method = RequestMethod.GET)
	public String doSubmitAction5(@Valid @ModelAttribute("company") Company p,BindingResult result) throws Exception {
		return "home";
	}


	@RequestMapping(value = "/addJob", method = RequestMethod.POST)
	public String doSubmitAction(@Valid @ModelAttribute("job") Job p,BindingResult result,HttpServletRequest request) throws Exception {
		
		if (result.hasErrors()) {
			return "AddJob";
		}

		try {
			HttpSession session=request.getSession();
			UserAccount company = (UserAccount) session.getAttribute("userAccount");
			String postedBy=company.getUsername();
			p.setPostedBy(postedBy);


			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            String datePosted = dateFormat.format(date);

			Job job=jobDao.addJob(p.getJobTitle(), p.getDescription(), p.getJobType(), p.getSalary(), p.getExperienceRequired(), p.getSkillsRequired(), p.getLocation(), datePosted, p.getQualificationsRequired(), p.getIndustry(),p.getPostedBy(),company);

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "AddedSuccessfullyCompany";
	}
	
	@RequestMapping(value = "/addJob", method = RequestMethod.GET)
	public String doSubmitAction8(@Valid @ModelAttribute("job") Job p,BindingResult result,HttpServletRequest request) throws Exception {
		return "home";
	}

	@RequestMapping(value = "/viewApplicants", method = RequestMethod.GET)
	public ModelAndView registerCandidate(@ModelAttribute("applicants") ApplyToJobWorkRequest c,Locale locale, Model model,HttpServletRequest request) {
		
		List jobList = new ArrayList();

		try {
			HttpSession session=request.getSession();
			UserAccount employer = (UserAccount) session.getAttribute("userAccount");

			jobList = jobs.getApplyToJobWorkRequests(employer);


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ModelAndView mv = new ModelAndView("viewApplicants", "applicants", jobList);
		return mv;
	}


	@RequestMapping(value = "/deleteJob", method = RequestMethod.POST)
	public String doSubmitAction1(@ModelAttribute("job") Job p,HttpServletRequest request) throws Exception {
	

		try {
			HttpSession session=request.getSession();
			int jobID=Integer.parseInt(request.getParameter("jobID"));
			UserAccount company = (UserAccount) session.getAttribute("userAccount");
			String postedBy=company.getUsername();
			p.setPostedBy(postedBy);



			jobDao.delete(jobID);

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "AddedSuccessfullyCompany";
	}

	@RequestMapping(value = "/deleteJob", method = RequestMethod.GET)
	public String doSubmitAction11(@ModelAttribute("job") Job p,HttpServletRequest request) throws Exception {
		return "home";
	}


}

