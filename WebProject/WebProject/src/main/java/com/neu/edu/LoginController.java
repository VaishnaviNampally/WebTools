package com.neu.edu;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.data.CompanyDAO;
import com.neu.edu.data.LoginDAO;
import com.neu.edu.pojo.candidate.UserAccount;
import com.neu.edu.pojo.employer.Job;


@Controller

public class LoginController {

	@Autowired
	LoginDAO loginDAO;

	@Autowired
	CompanyDAO jobs;

	@RequestMapping("/userlogin.htm")
	public String home(Locale locale, Model model, HttpServletRequest request,HttpServletResponse response,@ModelAttribute(value="job")Job job, @ModelAttribute(value="username")String username,@ModelAttribute(value="password")String password,@RequestParam(required=false) String rememberMe) {



		try{
			HttpSession session = request.getSession();
			UserAccount u = loginDAO.getUserAccount(username, password);
			model.addAttribute("user", u);
			if(rememberMe!=null){
				Cookie uname = new Cookie("userName",username);
				Cookie pwd = new Cookie("password", password);
				response.addCookie(uname);
				response.addCookie(pwd);
				System.out.println("cookie added");
			}


			if(u.getType().equals("Candidate")){
				model.addAttribute("user", u);
				session.setAttribute("userAccount", u);

				List jobList = new ArrayList();

				try {
					jobList = jobs.list();

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				model.addAttribute( "jobs", jobList);

				return "candidateDashboard";
			}
			else if(u.getType().equals("company")){
				model.addAttribute("user", u);
				session.setAttribute("userAccount", u);
				return "AddJob";
			}
			else if(u.getType().equals("admin")){
				model.addAttribute("user", u);
				session.setAttribute("userAccount", u);
				return "AdminDashboard";
			}


		}

		catch(Exception e){
			System.out.println("No user");
		}

		return "home";
	}

	@RequestMapping("/logout.htm")
	public ModelAndView home1(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session= request.getSession();
		String action=request.getParameter("action");
		ModelAndView mv=new ModelAndView();
		if(action.equals("logout")){
			session.invalidate();
			mv.setViewName("home");
		}

		return mv;
	}
}