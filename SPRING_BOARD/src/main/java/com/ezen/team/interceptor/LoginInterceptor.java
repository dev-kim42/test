package com.ezen.team.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		    throws Exception {
		
		HttpSession session = request.getSession();		 
		 
			 if(session.getAttribute("Midx") == null){			
				 response.sendRedirect(request.getContextPath()+"/member/memberLogin.do");
				 return false;
			 
			 }else {	
				 
			 }
			 return true;
		 }
		
	}
	
	
	
	

