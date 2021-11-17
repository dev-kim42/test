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
public class LecNoticeController { //���� �������� ��Ʈ�ѷ�

	@Autowired
	LecNoticeService lns;
	
	@RequestMapping(value="/noticeList.do")
	public String lecNoticeList(@RequestParam("lidx") String lidx, Model model) {
		//���� �������� ���
		ArrayList<LecNoticeVO> lnList = lns.lecNoticeSelectAll(Integer.parseInt(lidx));		
		model.addAttribute("lnList", lnList);
		
		return "lecture/noticeList";
	}
	
	@RequestMapping(value="/lecNoticeContent.do")
	public String lecNoticeContents(@RequestParam("lnidx") int lnidx,
									HttpSession session) {
		//���� �������� ���뺸��
		LecNoticeVO lnv = lns.lecNoticeContent(lnidx);
		session.setAttribute("lnv", lnv);
		
		return "lecture/noticeContent";
	}
	
	
/*	@RequestMapping(value="*.do")
	public String lecNoticeWrite() {
		//���� �������� �ۼ� ȭ��
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String lecNoticeWriteAction() {
		//���� �������� �ۼ� �Ϸ�
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String lecNoticeModify() {
		//���� �������� ���� ȭ��
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String lecNoticeModifyAction() {
		//���� �������� ���� �Ϸ�
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String lecNoticeDelete() {
		//���� �������� ����
		return "";
	}
	*/
}
