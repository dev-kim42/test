package com.ezen.team.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ezen.team.domain.MemberVo;
import com.ezen.team.service.MemberService;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(
				HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
				throws Exception {
			
		Object Midx = modelAndView.getModel().get("Midx");
			
		System.out.println("Midx:"+Midx);
		HttpSession session = request.getSession();	
		session.setAttribute("Midx", Midx);	
		
//		HttpSession session = request.getSession(true);
//		if (midx != null) {			
//		session.setAttribute("midx", midx);
//		}else {
//		session.setAttribute("midx", 0);	
//		}
		
		
		}
	
	
	
	
}
