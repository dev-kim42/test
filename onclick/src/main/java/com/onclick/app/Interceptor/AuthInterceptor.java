package com.onclick.app.Interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		// 로그인 여부 체크(세션 객체 받아오기)
		
		HttpSession session = request.getSession();
		
		System.out.println("현재 세션에 담아있는 값은?" +session.getAttribute("sidx"));
		
		if(session.getAttribute("sidx") == null) {
			response.sendRedirect(request.getContextPath()+"/");
			
			//컨트롤러로 요청을 보내지 않기 위해서 false 리턴
			
			return false;
			
		}else if(session.getAttribute("pidx") == null) {
			response.sendRedirect(request.getContextPath()+"/");
			
			return false;
		}
		
		return true;
	}

}
