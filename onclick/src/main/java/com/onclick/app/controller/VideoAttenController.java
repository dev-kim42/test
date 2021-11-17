//211027 jhr 작업
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
		//시청기록 버튼 누르는 경우
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String videoLevelUpdate() {
		//동영상 시청후 강의난이도 작성
		return null;
	}
		 */

	@ResponseBody
	@RequestMapping(value="/videoEnd.do")
	public int videoEnd(VideoAttenDto vd) {
		//시청중 멈춘경우(창을 닫은 경우, 로그아웃된 경우, 정지버튼을 누른경우)
		//전체시간,시작시간,종료시간 받아옴
		int result=vs.videoUpdate(vd);
		
		return result;
	}
	
	/*
	@RequestMapping(value="/.do")
	public String videoStart() {
		//시청시작 버튼 누른 경우
		return null;
	}

	 */

	
	@RequestMapping(value="/stuLecContent.do")
	public String lecContent(@RequestParam("sidx") int sidx, @RequestParam("cidx") int cidx, Model model) {
		//학생 동영상 출석 화면
		VideoAttenDto vd = vs.videoSelectOne(sidx, cidx);
		model.addAttribute("vd", vd);
		
		return "lecture/lecContent_p";
	}
	
	
	@RequestMapping(value="/proLecContent.do")
	public String videoProAtten(@RequestParam("pidx") int pidx, @RequestParam("cidx") int cidx, Model model) {
		//교수 동영상 출석 화면
		System.out.println();
		return null;
	}
	
}
