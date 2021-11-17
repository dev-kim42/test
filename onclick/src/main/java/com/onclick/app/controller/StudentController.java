//211027 jhr 작업
package com.onclick.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.StudentVO;
import com.onclick.app.service.StudentService;
import com.onclick.app.domain.TaskVO;

@Controller
public class StudentController {

	@Autowired
	StudentService ss;
	
	@ResponseBody
	@RequestMapping(value="/student/idCheck.do")
	public int studentIdCheck(@RequestParam("sidx") int sidx) {
		//학생 학번 중복체크 - ajax 이용
		int cnt = ss.studentIdChcek(sidx);
		
		return cnt;
	}
	
	@RequestMapping(value="/student/joinAction.do")
	public String studentJoinAction(@RequestParam("sidx") int sidx, 
									@RequestParam("spwd") String spwd,
									@RequestParam("sname") String sname,
									@RequestParam("sphone") String sphone,
									@RequestParam("semail") String semail,
									RedirectAttributes rttr ) {
		//학생 회원 가입 
		int cnt = ss.studentJoin(sidx, spwd, sname, sphone, semail);
		rttr.addFlashAttribute("joinOk", "회원가입에 성공하였습니다");
		
		return "redirect:/";
	}

	
	@RequestMapping(value="/student/stuLogin.do")
	public String studentLogin( @RequestParam("stuId") int sidx,
								@RequestParam("stuPwd") String spwd,
								RedirectAttributes rttr, 
								HttpSession session) {
		//학생 로그인 후 대시보드 이동
		String str = "";
		StudentVO sv = ss.studentLogin(sidx, spwd);
		
		//학번 세션에 저장 
		session.setAttribute("sidx", sidx);
		
		if(sv != null) { 
			//로그인 성공 시
			rttr.addAttribute("sidx", sidx);
			str = "redirect:/student/stuDashBoard.do";	
		} else{
			//로그인 실패 시 
			rttr.addFlashAttribute("loginNok", "로그인에 실패하였습니다.");
			str = "redirect:/";
		}
		
		return str;
	}
	
	@RequestMapping(value="/student/stuDashBoard.do")
	public String DashBoard(@RequestParam("sidx") String sidx, Model model) {
		//학생 대시보드 이동 
		//강의 이름 가져오기(대시보드-강의목록)
		ArrayList<EnrollDTO> stuLecList = ss.stuLecSelectAll(Integer.parseInt(sidx));
		model.addAttribute("stuLecList", stuLecList);
		
		//대시보드-과제목록
		ArrayList<TaskVO> stuTaskList = ss.stuTaskSelectAll(Integer.parseInt(sidx));
		model.addAttribute("stuTaskList", stuTaskList);
		
		return "/student/stuDashBoard";
	}

	
	@RequestMapping(value="/student/pwdCheck.do")
	public String studentpwdCheck() {
		//학생 정보수정 - 비밀번호 확인 페이지
		
		return "/student/pwdCheck";
	}
	
	@ResponseBody
	@RequestMapping(value="/student/pwdCheckAction.do")
	public int studentpwdCheckAction(@RequestParam("pwd") String spwd) {
		//학생 정보수정 - 비밀번호 확인 실행 ajax
		int cnt = ss.studentPwdCheck(spwd);
		
		return cnt;
	}
	
	@RequestMapping(value="/student/stuModify.do")
	public String studentModify(HttpSession session, HttpServletRequest request) {
		//학생 정보 수정화면 이동
		int sidx = (Integer)session.getAttribute("sidx");
		StudentVO sv = ss.studentSelectOne(sidx);
		request.setAttribute("sv", sv);

		return "/student/stuModify";
	}

	@RequestMapping(value="/student/stuModifyAction.do")
	public String studentModifyAction(@RequestParam("spwd") String spwd,
									  @RequestParam("semail1") String semail1,
									  @RequestParam("semail2") String semail2,
									  @RequestParam("sphone1") String sphone1,
									  @RequestParam("sphone2") String sphone2,
									  @RequestParam("sphone3") String sphone3
									) {
		//학생 정보 수정실행
		String semail = semail1+"@"+semail2;
		String sphone = sphone1 + "-" + sphone2 + "-" +sphone3;
		
		return "redirect:/student/pwdCheck.do";
	}

/*	
	@RequestMapping(value="/.do")
	public String studentLogout() {
		//학생 로그아웃
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String studentIdCheck() {
		//학생 회원가입시 학번확인
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String studentFindPwd() {
		//학생 비밀번호 찾기
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String noticeList() {
		//학생  알림화면
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String noticeNonCheck() {
		//학생  알림 읽음 체크
		return null;
	}
	*/
	@RequestMapping(value="/lecture/stuList.do")
	public String enrollList() {
		//학생 수강신청 목록
		return "lecture/stuList";
	}
	
}
