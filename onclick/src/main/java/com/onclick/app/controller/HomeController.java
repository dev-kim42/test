package com.onclick.app.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onclick.app.domain.LecNoticeVO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.StudentVO;
import com.onclick.app.service.LecNoticeService;
import com.onclick.app.service.LecService;

@Controller
public class HomeController {

	@Autowired
	LecService ls;
	
	@Autowired
	LecNoticeService lns;
	
	@RequestMapping(value="/")
	public String main() {
		//Main 페이지 전환
		return "index";
	}
	
	@RequestMapping(value="/join.do")
	public String join() {
		//학생,교수 회원 가입 화면
		return "join";
	}
	
	@RequestMapping(value="/siteMap.do")
	public String siteMap() {
		
		return "siteMap";
	}
	
	@RequestMapping(value="/lecHome.do")
	public String LecHome(@RequestParam("lidx") int lidx, Model model, HttpSession session) {

		//대시보드 강의 목록에서 강의 메인 홈으로 넘어가기
		LecVO lv = ls.lecHome(lidx);
		session.setAttribute("lv", lv);
		
		ArrayList<LecNoticeVO> lndList = lns.lecNoticeSelectDash(lidx);
		model.addAttribute("lndList", lndList);
		
		return "lecture/home";
	}
	
	@RequestMapping(value="/stuList.do")
	public String lecStudentList(@RequestParam("lidx") int lidx, Model model) {
		//강의 - 학생 목록 
		ArrayList<StudentVO> alist = ls.lecStudentList(lidx);
		model.addAttribute("alist", alist);
		
		return "lecture/stuList";
	}

	@RequestMapping(value="/test.do")
	public String test() {
		//강좌목록 페이지 
		return "lecture/lecContent_p2";

	}


}
