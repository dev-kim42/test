package com.ezen.myapp.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	//로그인을 하고 난 후 세션값을 담아 놓는  역할을 하는 클래스
	
	@Override
	public void postHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler, 
			ModelAndView modelAndView
			) throws Exception {
		
			Object memberId = modelAndView.getModel().get("memberid");
			
			if(memberId != null) {
				HttpSession session = request.getSession();
				session.setAttribute("memberId", memberId);
			}
		
	}	
	
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) {
		
		// 메소드 동작 전에 세션값이 있으면 제거
		
		HttpSession session = request.getSession();
		if(session.getAttribute("memberId") != null) {
		session.removeAttribute("memberId");
		session.invalidate();
		}
		
		return true;
	}
	

}
