package com.ezen.myapp.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	//�α����� �ϰ� �� �� ���ǰ��� ��� ����  ������ �ϴ� Ŭ����
	
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
		
		// �޼ҵ� ���� ���� ���ǰ��� ������ ����
		
		HttpSession session = request.getSession();
		if(session.getAttribute("memberId") != null) {
		session.removeAttribute("memberId");
		session.invalidate();
		}
		
		return true;
	}
	

}