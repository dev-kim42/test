package com.ezen.team.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.team.domain.SearchCriteria;
import com.ezen.team.service.BoardService;
import com.ezen.team.service.BoardServiceImpl;
import com.ezen.team.service.MemberService;
import com.ezen.team.domain.BoardVo;
import com.ezen.team.domain.MemberVo;
import com.ezen.team.domain.PageMaker;

@Controller
public class MemberController  {
	
	@Autowired
	MemberService md;
		
	@RequestMapping(value="/member/memberLogin.do")
	public String memberLogin() {
		
		return "memberLogin";
	}
	
	@RequestMapping(value="/member/memberLoginAction.do")
	public String memberLoginAction(
			@RequestParam("memberId") String memberId,
			@RequestParam("memberPwd") String memberPwd,
			Model model
			) throws Exception {		
			
		MemberVo mv = md.memberLogin(memberId,memberPwd);
		model.addAttribute("Midx", mv.getMidx());
//		HttpSession session = request.getSession(true);
//		if (mv != null) {			
//		session.setAttribute("midx", mv.getMidx());
//		}else {
//		session.setAttribute("midx", "0");	
//		}	
			
		return "redirect:/board/boardList.do";
	}	
	
}
