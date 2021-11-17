//211027 jhr �۾�
package com.onclick.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onclick.app.domain.VideoAttenDto;
import com.onclick.app.service.VideoAttenService;

@Controller
public class VideoAttenController {
	
	@Autowired
	VideoAttenService vs;
	
	/*
	
	@RequestMapping(value="/.do")
	public String videoContents() {
		//��û��� ��ư ������ ���
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String videoLevelUpdate() {
		//������ ��û�� ���ǳ��̵� �ۼ�
		return null;
	}
		 */

	@ResponseBody
	@RequestMapping(value="/videoEnd.do")
	public int videoEnd(VideoAttenDto vd) {
		//��û�� ������(â�� ���� ���, �α׾ƿ��� ���, ������ư�� �������)
		//��ü�ð�,���۽ð�,����ð� �޾ƿ�
		int result=vs.videoUpdate(vd);
		
		return result;
	}
	
	/*
	@RequestMapping(value="/.do")
	public String videoStart() {
		//��û���� ��ư ���� ���
		return null;
	}

	 */

	
	@RequestMapping(value="/stuLecContent.do")
	public String lecContent(@RequestParam("sidx") int sidx, @RequestParam("cidx") int cidx, Model model) {
		//�л� ������ �⼮ ȭ��
		VideoAttenDto vd = vs.videoSelectOne(sidx, cidx);
		model.addAttribute("vd", vd);
		
		return "lecture/lecContent_p";
	}
	
	
	@RequestMapping(value="/proLecContent.do")
	public String videoProAtten(@RequestParam("pidx") int pidx, @RequestParam("cidx") int cidx, Model model) {
		//���� ������ �⼮ ȭ��
		System.out.println();
		return null;
	}
	
}