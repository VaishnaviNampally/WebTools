package com.neu.edu;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.data.CandidateDAO;
import com.neu.edu.data.CompanyDAO;
import com.neu.edu.data.DAO;
import com.neu.edu.data.PersonDAO;
import com.neu.edu.data.WorkRequestDAO;
import com.neu.edu.pojo.WorkRequest.ApplyToJobWorkRequest;
import com.neu.edu.pojo.candidate.Candidate;
import com.neu.edu.pojo.candidate.Education;
import com.neu.edu.pojo.candidate.Experience;
import com.neu.edu.pojo.candidate.Person;
import com.neu.edu.pojo.candidate.Skill;
import com.neu.edu.pojo.candidate.UserAccount;
import com.neu.edu.pojo.employer.Job;
import com.neu.edu.resume.FileUploadForm;
import com.neu.edu.validator.CandidateValidator;
import com.neu.edu.validator.CompanyValidator;

@Controller
public class CandidateController {
	@Autowired
	PersonDAO userDao;

//	@Autowired
//	@Qualifier("candidateValidator")
//	CandidateValidator validator;

//	@InitBinder("Candidate")
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}
	@Autowired
	CandidateDAO candidate;

	@Autowired
	WorkRequestDAO jobs;
	
	@Autowired
	CompanyDAO compa;

	@RequestMapping(value="index.html")
	public ModelAndView submitForm(@PathVariable("first_name") String fname,HttpServletRequest request){

		ModelAndView model = new ModelAndView("home");
		model.addObject("msg","hello"+fname);
		return model;

	}
	@RequestMapping(value="/redirectCandiDash")
	public ModelAndView submitForm1(@ModelAttribute("job")Job j,HttpServletRequest request){

		ModelAndView model = new ModelAndView("AddJob");
		return model;

	}
	
	@RequestMapping(value="/redirectCandidateDash")
	public String submitForm2(@ModelAttribute("job")Job j,HttpServletRequest request,Model model){

		List jobList = new ArrayList();

		try {
			jobList = compa.list();


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		model.addAttribute( "jobs", jobList);
		return "candidateDashboard";

	}



	@RequestMapping(value = "/registerCandidate", method = RequestMethod.GET)
	public ModelAndView registerCandidate(@ModelAttribute("Candidate") Person p,Locale locale) {
		ModelAndView model = new ModelAndView("AddPerson");
		return model;
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView adminLogin(@ModelAttribute("user") UserAccount u,Locale locale,@CookieValue(value="userName",required=false)String userName,@CookieValue(value="password",required=false)String password) {

		ModelAndView model = new ModelAndView("Login");
		return model;
	}


	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doSubmitAction(@Valid @ModelAttribute("Candidate") Person p,BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			return "AddPerson";
		}

		try {
			userDao.addPerson(p.getFirstName(),p.getLastName(),p.getAddress(),p.getEmail(),p.getPhone(),p.getSsn(),p.getUsername(),p.getPassword());

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "Login";
	}

	@RequestMapping(value = "/manageEducation",method = RequestMethod.GET)
	public ModelAndView doSubmitAction1(@ModelAttribute("education") Education edu ,BindingResult result) throws Exception {

		ModelAndView model = new ModelAndView("manageEducation");
		return model;

	}
	@RequestMapping(value = "/manageSkill",method = RequestMethod.GET)
	public ModelAndView doSubmitAction1(@ModelAttribute("skills") Skill skill ,BindingResult result) throws Exception {

		ModelAndView model = new ModelAndView("manageSkills");
		return model;

	}
	@RequestMapping(value = "/manageExperience",method = RequestMethod.GET)
	public ModelAndView doSubmitAction2(@ModelAttribute("experience") Experience exp ,BindingResult result) throws Exception {

		ModelAndView model = new ModelAndView("manageExperience");
		return model;

	}

	@RequestMapping(value = "/viewProfile")
	public ModelAndView doSubmitAction31(@ModelAttribute("skil")Skill skill,BindingResult result1,@ModelAttribute("educa")Education educa,@ModelAttribute("expe")Experience expe,HttpServletRequest request) throws Exception {

//		if(result.hasErrors()){
//			ModelAndView mv = new ModelAndView("CandidateViewProfile");
//			return mv;
//		}
		ArrayList<Skill> skillList = new ArrayList<Skill>();
		ArrayList<Education> eduList= new ArrayList<Education>();
		ArrayList<Experience> expList= new ArrayList<Experience>();
		try {
			HttpSession session=request.getSession();
			UserAccount user = (UserAccount) session.getAttribute("userAccount");
			
			skillList=candidate.getPersonSkills(user);
			System.out.println("skillList size is"+skillList.size());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			HttpSession session=request.getSession();
			UserAccount user = (UserAccount) session.getAttribute("userAccount");

			eduList=candidate.getPersonEdu(user);

//			Iterator jobIterator = eduList.iterator();
//
//			while (jobIterator.hasNext())
//			{
//
//				Education job = (Education) jobIterator.next();
//				eduList.add(job);
//
//			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			HttpSession session=request.getSession();
			UserAccount user = (UserAccount) session.getAttribute("userAccount");

			expList= candidate.getPersonExp(user);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		ModelAndView mv = new ModelAndView("CandidateViewProfile", "skills", skillList);
		mv.addObject("edus", eduList);
		mv.addObject("exps", expList);
		return mv;

	}

	@RequestMapping(value = "/addSkill", method = RequestMethod.POST)
	public String doSubmitAction3(@Valid @ModelAttribute("skills") Skill skill,BindingResult result,HttpServletRequest request) throws Exception {
	
		if (result.hasErrors()) {
			return "manageSkills";
		}

		try {
			HttpSession session=request.getSession();
			UserAccount person = (UserAccount) session.getAttribute("userAccount");

			candidate.addSkills(skill.getSkillName(), skill.getSkillType(), person);


		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "AddedSuccessfully";
	}

	@RequestMapping(value = "/addSkill", method = RequestMethod.GET)
	public String doSubmitAction11(@Valid @ModelAttribute("skills") Skill skill,BindingResult result,HttpServletRequest request) throws Exception {
		
		return "home";
	}
	@RequestMapping(value = "/addEducation", method = RequestMethod.POST)
	public String doSubmitAction4(@Valid @ModelAttribute("education") Education edu,BindingResult result,HttpServletRequest request) throws Exception {
		
		if (result.hasErrors()) {
			return "manageEducation";
		}

		try {
			HttpSession session=request.getSession();
			UserAccount person = (UserAccount) session.getAttribute("userAccount");

			candidate.addEducation(edu.getSchoolName(),edu.getLevel(),edu.getMajor(),edu.getGPA(),edu.getAttendedFrom(),edu.getAttendedTo(), person);


		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "AddedSuccessfully";
	}
	
	@RequestMapping(value = "/addEducation", method = RequestMethod.GET)
	public String doSubmitAction12(@Valid @ModelAttribute("education") Education edu,BindingResult result,HttpServletRequest request) throws Exception {
		
		
		return "home";
	}

	@RequestMapping(value = "/addExperience", method = RequestMethod.POST)
	public String doSubmitAction5(@Valid @ModelAttribute("experience") Experience exp,BindingResult result,HttpServletRequest request) throws Exception {
	
		if (result.hasErrors()) {
			return "manageExperience";
		}

		try {
			HttpSession session=request.getSession();
			UserAccount person = (UserAccount) session.getAttribute("userAccount");

			candidate.addExperience(exp.getCompanyName(), exp.getRole(), exp.getDescription(), exp.getStartDate(), exp.getEndDate(), person);

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "AddedSuccessfully";
	} 
	
	@RequestMapping(value = "/addExperience", method = RequestMethod.GET)
	public String doSubmitAction11(@Valid @ModelAttribute("experience") Experience exp,BindingResult result,HttpServletRequest request) throws Exception {
		return "home";
	} 



	@RequestMapping(value = "/viewQualifiedJobs", method = RequestMethod.GET)
	public ModelAndView registerCandidate(@ModelAttribute("applicants") ApplyToJobWorkRequest c,Locale locale, Model model,HttpServletRequest request) {
	
		List jobList = new ArrayList();

		try {
			HttpSession session=request.getSession();
			UserAccount employer = (UserAccount) session.getAttribute("userAccount");


			jobList = jobs.getSelectCandidate(employer);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ModelAndView mv = new ModelAndView("viewQualifiedJobs", "applicants", jobList);
		return mv;
	}

	@RequestMapping(value ="/updateSkill", method = RequestMethod.POST)
	public String doSubmitAction6(HttpServletRequest request) throws Exception {

//		if (result.hasErrors()) {
//			return "CandidateViewProfile";
//		}
		try{
		HttpSession session=request.getSession();
		UserAccount person = (UserAccount) session.getAttribute("userAccount");
		String abc=request.getParameter("update");
		System.out.print(abc);
		int skillID=Integer.parseInt(request.getParameter("skillID"));
		String skillname=request.getParameter("name");
		String skillType=request.getParameter("type");


		candidate.updateSkill(skillID,skillname,skillType,person);
		}catch(Exception e){
			System.out.println("exception while updating skill");
			return "CandidateViewProfile";
		}

		return "AddedSuccessfully";
	}

	@RequestMapping(value ="/updateEdu", method = RequestMethod.POST)
	public String doSubmitAction7(HttpServletRequest request) throws Exception {

		try{
		HttpSession session=request.getSession();
		UserAccount person = (UserAccount) session.getAttribute("userAccount");
		String abc=request.getParameter("update");
		System.out.print(abc);
		int eduID=Integer.parseInt(request.getParameter("eduID"));
		String schoolName=request.getParameter("schoolName");
		String level=request.getParameter("level");
		String major=request.getParameter("major");
		String attendedFrom=request.getParameter("attendedFrom");
		String attendedTo=request.getParameter("attendedTo");
		String gpa=request.getParameter("gpa");


		candidate.updateEducation(eduID,schoolName,level,major,attendedFrom,attendedTo,gpa,person);
		}catch(Exception e){
			System.out.println("exception while updating Edu");
			return "CandidateViewProfile";
		}

		return "AddedSuccessfully";
	}

	@RequestMapping(value ="/updateExp", method = RequestMethod.POST)
	public String doSubmitAction8(HttpServletRequest request) throws Exception {

		try{
		HttpSession session=request.getSession();
		UserAccount person = (UserAccount) session.getAttribute("userAccount");
		String abc=request.getParameter("update");
		System.out.print(abc);
		int expID=Integer.parseInt(request.getParameter("expID"));
		String companyName=request.getParameter("companyName");
		String role=request.getParameter("role");
		String description=request.getParameter("description");
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");	
		candidate.updateExperience(expID,companyName,role,description,startDate,endDate,person);

		}catch(Exception e){
			System.out.println("exception while updating Exp");
			return "CandidateViewProfile";
		}

		return "AddedSuccessfully";
	}


	@RequestMapping(value = "/updateSkill", method = RequestMethod.GET)
	public String doSubmitAction6(@Valid @ModelAttribute("experience") Experience exp,BindingResult result,HttpServletRequest request) throws Exception {
		return "home";
	} 

	@RequestMapping(value = "/updateEdu", method = RequestMethod.GET)
	public String doSubmitAction7(@Valid @ModelAttribute("experience") Experience exp,BindingResult result,HttpServletRequest request) throws Exception {
		return "home";
	} 

	@RequestMapping(value = "/updateExp", method = RequestMethod.GET)
	public String doSubmitAction8(@Valid @ModelAttribute("experience") Experience exp,BindingResult result,HttpServletRequest request) throws Exception {
		return "home";
	} 

}
