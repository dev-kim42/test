//211027 jhr 작업
package com.onclick.app.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.onclick.app.domain.FileVO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.S_taskDTO;
import com.onclick.app.domain.TaskVO;
import com.onclick.app.service.FileService;
import com.onclick.app.service.S_taskService;
import com.onclick.app.service.TaskService;
import com.onclick.app.util.UploadFileUtiles;

@Controller
public class S_taskController {
	
	@Autowired
	TaskService ts;
	
	@Autowired
	S_taskService sts;
	
	@Autowired
	FileService fs;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="/stuTaskWrite.do")
	public String taskWrite(@RequestParam("tuidx") int tuidx, HttpSession session) {
		//학생 과제작성 화면
		TaskVO tv = ts.taskSelectOne(tuidx);
		session.setAttribute("tv", tv);
		session.setAttribute("tuidx", tuidx);
		
		return "lecture/stuTaskWrite";
	}
	

	@RequestMapping(value="/stuTaskWriteAction.do")
	public String taskWriteAction(@RequestParam("s_taskSubject") String tsubject,
								@RequestParam("s_taskFile") MultipartFile tfile,
								@RequestParam("s_taskContents") String tcontents,
								HttpSession session) throws Exception{
		//학생 과제작성 실행
		int sidx = (Integer)session.getAttribute("sidx");
		int tuidx = (Integer)session.getAttribute("tuidx");
		int tidx = sts.s_taskTidx(sidx, tuidx);
		
		String str ="";
		
		if(tfile.isEmpty()) {//첨부파일 없는 경우
		
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put("tsubject", tsubject);
			hm.put("tcontents", tcontents);
			hm.put("tidx",tidx);
			
			int value = sts.s_taskUpdate(hm);
			
//			S_taskDTO std = sts.stuTask(tidx);
//			session.setAttribute("std", std);
			
			if(value == 0) {
				str = "redirect:/stuTaskWrite.do?tuidx="+tuidx;
			} else {
				str ="redirect:/stuTaskContent.do?tidx="+tidx;
			}
		} else { //첨부파일 있는 경우
			
			//첨부파일 저장
			//파일명
			String originalFileName = tfile.getOriginalFilename();
			//파일명 중 확장자만 추출
			String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			//파일경로
			String route = uploadPath;
			
			String savedName = UploadFileUtiles.uploadFile(uploadPath, originalFileName, tfile.getBytes());
			
			HashMap<String, Object> stuTaskFile = new HashMap<String, Object>();
			stuTaskFile.put("originName", originalFileName);
			stuTaskFile.put("savedName", savedName);
			stuTaskFile.put("originalFileExtension", originalFileExtension);
			stuTaskFile.put("route", route);
			
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put("tsubject", tsubject);
			hm.put("tcontents", tcontents);
			hm.put("tidx",tidx);
			
			int value = sts.s_taskAndFileUpdate(hm, stuTaskFile);
			
//			S_taskDTO std = sts.stuTask(tidx);
//			session.setAttribute("std", std);
			
			if(value == 2) {
				str ="redirect:/stuTaskContent.do?tidx="+tidx;
			} else {
				str = "redirect:/stuTaskWrite.do?tuidx="+tuidx;
			}
		}
		
		
		return str;
	}
	
	
	@RequestMapping(value="/stuTaskContent.do")
	public String taskContents(@RequestParam("tidx") int tidx,
							HttpSession session) {
		//학생 제출한 과제내용 보기
		S_taskDTO std = sts.s_taskSelectOne(tidx);
		session.setAttribute("std", std);
		//과제 정보 가져가기
//		TaskVO tv = ts.taskSelectOne(tuidx);
		TaskVO tv = (TaskVO)session.getAttribute("tv");
		//첨부파일 가져오기
		FileVO fv = fs.taskFileSelectAll(tv.getFidx());
		session.setAttribute("fv", fv);
		
		
		return "lecture/stuTaskContent";
	}
	
	
	@RequestMapping(value="/stuTaskModify.do")
	public String taskUpdate() {
		//학생 과제수정 화면
		
		return "lecture/stuTaskModify";
	}
	
	
	@RequestMapping(value="/stuTaskModifyAction.do")
	public String taskUpdateAction(@RequestParam("s_taskSubject") String tsubject,
								@RequestParam("s_taskFile") String tfile,
								@RequestParam("s_taskContents") String tcontents,
								@RequestParam("tidx") int tidx,
								HttpSession session) {
		//학생 과제수정  실행
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("tsubject", tsubject);
		hm.put("tcontents", tcontents);
		hm.put("tfile", tfile);
		hm.put("tidx", tidx);
		
		int sidx = (Integer)session.getAttribute("sidx");
		int tuidx = (Integer)session.getAttribute("tuidx");
		
		String str = null;
		int value = sts.s_taskUpdate(hm);
		
		if(value == 0) {
			str="redirect:/stuTaskModify.do";
		} else {
			str="redirect:/stuTaskContent.do?tuidx="+tuidx+"&sidx="+sidx;
		}
		
		return str;
	}
	
	
	@RequestMapping(value="/stuTaskDeleteAction.do")
	public String stuTaskDelete(@RequestParam("tidx") int tidx, HttpSession session) {
		//학생 과제삭제
		LecVO lv = (LecVO)session.getAttribute("lv");
		int lidx = lv.getLidx(); 
		
		String str = null;
		int value = sts.s_taskDelete(tidx);
		
		if(value == 1) {
			str="redirect:/taskList.do?lidx="+lidx;
		} else {
			str="redirect:/stuTaskContent.do?tidx="+tidx;
		}
		
		return str;
	}

}
