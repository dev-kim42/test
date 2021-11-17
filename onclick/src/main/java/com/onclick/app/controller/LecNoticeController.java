package com.onclick.app.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onclick.app.domain.LecNoticeVO;
import com.onclick.app.service.LecNoticeService;

@Controller
public class LecNoticeController { //과목 공지사항 컨트롤러

	@Autowired
	LecNoticeService lns;
	
	@RequestMapping(value="/noticeList.do")
	public String lecNoticeList(@RequestParam("lidx") String lidx, Model model) {
		//강의 공지사항 목록
		ArrayList<LecNoticeVO> lnList = lns.lecNoticeSelectAll(Integer.parseInt(lidx));		
		model.addAttribute("lnList", lnList);
		
		return "lecture/noticeList";
	}
	
	@RequestMapping(value="/lecNoticeContent.do")
	public String lecNoticeContents(@RequestParam("lnidx") int lnidx,
									HttpSession session) {
		//강의 공지사항 내용보기
		LecNoticeVO lnv = lns.lecNoticeContent(lnidx);
		session.setAttribute("lnv", lnv);
		
		return "lecture/noticeContent";
	}
	
	
/*	@RequestMapping(value="*.do")
	public String lecNoticeWrite() {
		//과목 공지사항 작성 화면
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String lecNoticeWriteAction() {
		//과목 공지사항 작성 완료
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String lecNoticeModify() {
		//과목 공지사항 수정 화면
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String lecNoticeModifyAction() {
		//과목 공지사항 수정 완료
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String lecNoticeDelete() {
		//과목 공지사항 삭제
		return "";
	}
	*/
}
