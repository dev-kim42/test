package com.onclick.app.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.ProfessorVO;
import com.onclick.app.service.LecService;
import com.onclick.app.service.ProfessorService;

@Controller
public class ProfessorController { 

	@Autowired
	ProfessorService ps;
	
	@Autowired
	LecService ls;
	
	@ResponseBody
	@RequestMapping(value="/professor/idCheck.do")
	public int professorIdCheck(@RequestParam("pidx") String pidx) {
		//교수 사번 중복체크 - ajax 이용
		int cnt = ps.professorIdCheck(pidx);

		return cnt;
	}
	
	@RequestMapping(value="/professor/joinAction.do")
	public String professorJoinAction(@RequestParam("pidx") int pidx,
									@RequestParam("pname") String pname,
									@RequestParam("ppwd") String ppwd,
									@RequestParam("pphone") int pphone,
									@RequestParam("pemail") String pemail) {
		//교수 회원가입 완료
		int cnt = ps.professorJoin(pidx, pname, ppwd, pphone, pemail);
		
		return "redirect:/";
	}

	@RequestMapping(value="/professor/proLogin.do")
	public String professorLogin(@RequestParam("pidx") int pidx,
								 @RequestParam("ppwd") String ppwd,
								 RedirectAttributes rttr,
								 HttpSession session) {
		//교수 로그인 
		ProfessorVO pv = ps.professorLogin(pidx, ppwd);
		
		String location = "";
		if(pv != null) {
			//login 성공시 

			//사번 저장 
			session.setAttribute("pidx", pidx);
			
			location ="redirect:/professor/proDashBoard.do";	
		}else {
			//login 실패시 
			rttr.addFlashAttribute("loginNok", "로그인 실패하셨습니다");
			location ="redirect:/";
		}
		return location;
	}
	
	@RequestMapping(value="/professor/proDashBoard.do")
	public String professorLecList(HttpSession session, Model model) {
		//대시보드 이동
		
		int pidx = (Integer)session.getAttribute("pidx");
		
		//교수 사번으로 강의 테이블에서 강의 목록 가져오기 
		ArrayList<LecVO> alist = ls.lecSelectAll(pidx);
		model.addAttribute("alist", alist);

		return "/professor/proDashBoard" ;
	}
	@RequestMapping(value="/professor/pwdCheck.do")
	public String professorpwdCheck() {
		//학생 정보수정 - 비밀번호 확인 페이지
		return "/professor/pwdCheck";
	}
	
	@ResponseBody
	@RequestMapping(value="/professor/pwdCheckAction.do")
	public int professorPwdCheckAction(@RequestParam("pwd") String ppwd) {
		//교수 정보수정 - 비밀번호 확인 실행 ajax
		int cnt = ps.proPwdCheck(ppwd);
		
		return cnt;
	}
	

	@RequestMapping(value="/professor/proInfo.do")
	public String professorInfo(@RequestParam("pidx") int pidx,Model model) {
		//교수정보 보기
		ProfessorVO pv = ps.proInfo(pidx);
		model.addAttribute("pv", pv);

		return "professor/proInfo";
	}
/*		
	@RequestMapping(value="*.do")
	public String professorModify() {
		//교수 정보 수정 화면
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorModifyAction() {
		//교수 정보 수정 완료
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorLogout() {
		//교수 로그아웃
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorLecList() {
		//교수 강의 목록
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorLecPlan() {
		//강의계획서
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorIdCheck() {
		//사번 체크
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorFindPwd() {
		//교수 비밀번호 찾기 화면
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorFindPwdAction() {
		//교수 비밀번호 찾기 완료
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorContents() {
		//교수 정보 보기
		return "";
	}
	*/
}
