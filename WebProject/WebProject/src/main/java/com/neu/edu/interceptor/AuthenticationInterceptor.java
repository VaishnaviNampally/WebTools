package com.neu.edu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
		    throws Exception {
//		System.out.println("going here atleast");
//	 HttpServletRequest req = (HttpServletRequest) request;
//     HttpServletResponse res = (HttpServletResponse) response;
//		HttpSession session = req.getSession(false);
//		if ((session == null || session.getAttribute("userAccount") == null || req.getMethod().equalsIgnoreCase("POST"))&&!(req.getContextPath().equalsIgnoreCase("/WebProject")) ) {
//	        res.sendRedirect(req.getContextPath()+"/userlogin.htm"); // No logged-in user found, so redirect to login page.
//	        System.out.println("going here atleast");
//	        res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//	        res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//	        res.setDateHeader("Expires", 0);
//	        return false;
//		}
	 
			return true;
		}
}
