//211027 jhr 작업
package com.onclick.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onclick.app.domain.ClassVo;
import com.onclick.app.service.ClassService;

@Controller
public class ClassController {
	
	@Autowired
	ClassService cs;
	
	@RequestMapping(value="/lecUpload.do")
	public String classWrite() {
		//강좌업로드 화면
		return "lecture/lecUpload";
	}
	
	@RequestMapping(value="/lecUploadAction.do")
	public String classWriteAction(ClassVo cv) {
		//교수만 가능한 기능으로 접속계정이 교수인지 확인 필요
		//강좌업로드 실행
		if(cv.getCnotyn() == null) {
			cv.setCnotyn("N");
		}else if(cv.getCreyn() == null) {
			cv.setCreyn("N");
		}
		int result = cs.classInsert(cv);
		
		return "redirect:/lecList.do?lidx="+cv.getLidx();
	}
	
/*	
	@RequestMapping(value="/.do")
	public String classContents() {
		//강좌내용보기? 동영상?
		return null;
	}
*/	
	@RequestMapping(value="/lecList.do")
	public String classList(@RequestParam("lidx") int lidx, Model model) {
		//강좌리스트 보기
		ArrayList<ClassVo> alist = cs.classSelect(lidx);
		model.addAttribute("alist", alist);

		return "lecture/classList";
	}
/*	
	@RequestMapping(value="/.do")
	public String classUpdate() {
		//강좌내용 수정화면
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String classUpdateAction() {
		//강좌내용 수정 실행
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String classDelete() {
		//강좌내용 삭제화면
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String classDeleteAction() {
		//강좌내용 삭제 실행
		return null;
	}
*/	
	
}
