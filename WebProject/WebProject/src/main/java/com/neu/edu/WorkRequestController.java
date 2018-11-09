package com.neu.edu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.data.CandidateDAO;
import com.neu.edu.data.CompanyDAO;
import com.neu.edu.data.WorkRequestDAO;
import com.neu.edu.pojo.WorkRequest.ApplyToJobWorkRequest;
import com.neu.edu.pojo.WorkRequest.WorkRequest;
import com.neu.edu.pojo.candidate.Education;
import com.neu.edu.pojo.candidate.Experience;
import com.neu.edu.pojo.candidate.Person;
import com.neu.edu.pojo.candidate.Skill;
import com.neu.edu.pojo.candidate.UserAccount;
import com.neu.edu.pojo.employer.Job;
import com.neu.edu.resume.FileUploadForm;

@Controller
public class WorkRequestController {

	@Autowired
	WorkRequestDAO workReq;

	@Autowired
	CandidateDAO candidate;

	@RequestMapping("/sendToEmployer")
	protected String handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int jobID=Integer.parseInt(request.getParameter("jobID"));

		HttpSession session=request.getSession();
		UserAccount can = (UserAccount) session.getAttribute("userAccount");
		
		
		Person p= candidate.getPerson(can);
		List<ApplyToJobWorkRequest> workreq= workReq.getAllApplyToJobWorkRequests();
		FileUploadForm resume=new FileUploadForm();
		
		Set<Skill> skillList=p.getSkills();
		Set<Education> eduList=p.getEducationList();
		Set<Experience> expList=p.getExperienceList();
		//resume=p.getFile();
		resume=p.getFile();
		System.out.println("resume is"+resume);
		if(skillList.size()==0||eduList.size()==0||expList.size()==0||resume==null){
			System.out.println("cannot apply for the job");
			
			return "CannotApplyToJob";
		}
	
		else{
			for(ApplyToJobWorkRequest a:workreq){
				System.out.println("Job ID:"+a.getRole()+"Person is:"+a.getPerson().getUsername());
				if(a.getRole().equals(String.valueOf(jobID))&&a.getPerson().getUserID()==p.getUserID()){
					System.out.println("going here");
					return "CannotApplyToJob2";
					
				}
			
			}
		}
		
		workReq.sendToEmployee(jobID,can);
		return "AddedSuccessfully";
	}

	@RequestMapping("/notifyCandidate")
	protected String handleRequestInternal1(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int jobID=Integer.parseInt(request.getParameter("jobID"));

		workReq.sendToCandidate(jobID);
		return "AddedSuccessfullyCompany";
	}

	@RequestMapping("/viewCandidateProfile")
	protected ModelAndView handleRequestInternal2(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List skillList = new ArrayList();
		List eduList= new ArrayList();
		List expList= new ArrayList();
		int jobID=Integer.parseInt(request.getParameter("jobID"));

		Person p=workReq.getCandidate(jobID);
		System.out.println("person slected is"+p.getFirstName());
		try {

			skillList=candidate.getSkills(p);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		try {
			eduList=candidate.getEdu(p);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {

			expList=candidate.getExp(p);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		ModelAndView mv = new ModelAndView("ViewProfile", "skills", skillList);
		mv.addObject("edus", eduList);
		mv.addObject("exps", expList);
		mv.addObject("personid",p.getUserID());
		return mv;
	}
}
