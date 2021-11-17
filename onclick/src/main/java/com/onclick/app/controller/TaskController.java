 package com.onclick.app.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.onclick.app.domain.FileVO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.S_taskDTO;
import com.onclick.app.domain.TaskVO;
import com.onclick.app.service.FileService;
import com.onclick.app.service.LecService;
import com.onclick.app.service.S_taskService;
import com.onclick.app.service.TaskService;
import com.onclick.app.util.UploadFileUtiles;

@Controller
public class TaskController { //교수 과제 컨트롤러

	@Autowired
	TaskService ts;
	
	@Autowired
	LecService ls;
	
	@Autowired
	FileService fs;
	
	@Autowired
	S_taskService sts;
	
	@Resource(name="uploadPath")
	private String uploadPath;

	@RequestMapping(value="/taskContent.do")
	public String taskContent(@RequestParam("tuidx") int tuidx, 
							@RequestParam("lidx") int lidx, Model model, HttpSession session) {
		
		//대시보드 과제 목록에서 과제 내용보기로 넘어가기
		TaskVO tv = ts.taskSelectOne(tuidx);
		session.setAttribute("tv", tv);
		//해당 과목 정보 가져오기
		LecVO lv = ls.lecSelectOne(lidx);
		session.setAttribute("lv", lv);
		//첨부파일 가져오기
		FileVO fv = fs.taskFileSelectAll(tv.getFidx());
		if(fv != null) {
			session.setAttribute("fv", fv);
		}
		return "lecture/taskContent";
	}

	@RequestMapping(value="/taskList.do")
	public String taskList(@RequestParam("lidx") int lidx, Model model, HttpSession session) {
		//교수가 업로드한 과제 목록
		ArrayList<TaskVO> tlist = ts.taskSelectAll(lidx);
		model.addAttribute("tlist", tlist);
		//해당 강의 정보 가져오기
		LecVO lv = ls.lecSelectOne(lidx);
		session.setAttribute("lv", lv);
		
		TaskVO tv = ts.taskAll(lidx);
//		session.setAttribute("tv", tv);
//		int tuidx = tv.getTuidx();
		
//		int sidx = (Integer)session.getAttribute("sidx");
//		
//		if(sidx != 0) {
//			
//			S_taskDTO std = sts.stuTask(sidx);
//			//학생 과제 정보 세션에 담기
//			session.setAttribute("std", std);
//			
//			System.out.println("std"+std);
//		}
	
		return "lecture/taskList";
	}
	
		
	@RequestMapping(value="/taskWrite.do")
	public String taskWrite() {
		//교수 과제 작성 화면
		return "lecture/taskUpload";
	}
	
	
	@RequestMapping(value="/taskWriteAction.do")
	public String taskWriteAction(@RequestParam("lidx") int lidx,
			@RequestParam("taskSubject") String tusubject,
			@RequestParam("taskStart") String tustart,
			@RequestParam("taskFin") String tufin,
			@RequestParam("taskContents") String tucontents,
			@RequestParam("taskNotice") String tunotyn,
			@RequestParam("taskFile") MultipartFile tufile) throws Exception{

		String str = null;
		
		if(tufile.isEmpty()) { //첨부파일 없는 경우
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("tusubject", tusubject);
			hm.put("tustart", tustart);
			hm.put("tufin", tufin);
			hm.put("tunotyn", tunotyn);
			hm.put("lidx", lidx);
			hm.put("tucontents", tucontents);
			
			int value = ts.taskInsert(hm, lidx);
			int tuidx = Integer.parseInt(String.valueOf(hm.get("tuidx")));
			
			if(value == 2) {
				str = "redirect:/taskContent.do?tuidx="+tuidx+"&lidx="+lidx;
			} else {
				str = "redirect:/taskWrite.do";
			}
			
		} else {//첨부파일 있는 경우
			
			//첨부파일 저장
			//파일명
			String originalFileName = tufile.getOriginalFilename();
			//파일명 중 확장자만 추출
			String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			//파일경로
			String route = uploadPath;
			
			String savedName = UploadFileUtiles.uploadFile(uploadPath, originalFileName, tufile.getBytes());
			
			HashMap<String, Object> taskFile = new HashMap<String, Object>();
			taskFile.put("originName", originalFileName);
			taskFile.put("savedName", savedName);
			taskFile.put("originalFileExtension", originalFileExtension);
			taskFile.put("route", route);
			
	//		int value1 = fs.taskFileInsert(hmFile);
	//		int key = Integer.parseInt(String.valueOf(hmFile.get("fidx")));
			
			//교수 과제 작성 완료
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("tusubject", tusubject);
			hm.put("tustart", tustart);
			hm.put("tufin", tufin);
			hm.put("tunotyn", tunotyn);
			hm.put("lidx", lidx);
			hm.put("tucontents", tucontents);
	//		hm.put("fidx", key);
			
			int value = ts.taskAndFileInsert(hm, taskFile, lidx);
			int tuidx = Integer.parseInt(String.valueOf(hm.get("tuidx")));
			
			if(value == 3) {
				str = "redirect:/taskContent.do?tuidx="+tuidx+"&lidx="+lidx;
			} else {
				str = "redirect:/taskWrite.do";
			}
		}
		
		return str;
	}
	
	
	@RequestMapping(value="/taskFileDownload.do")
	public void taskFileDownload(@RequestParam("fidx") int fidx,HttpServletResponse response) throws Exception{
		//과제 파일 다운로드
		HashMap<String,Object> fileDown = fs.taskFileDownload(fidx);
		String savedName = (String)fileDown.get("FSAVEDNAME");
		String originName = (String)fileDown.get("FORIGINNAME");
		
		//파일을 저장했던 위치에서 첨부파일을 읽어 byte[]형식으로 변환
		byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:/java exercise/dev_html/workspace/onclick/onclick/onclick/uploadFiles/"+savedName));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(originName, "UTF-8")+"\";");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
		return;
	}
	
	
	@RequestMapping(value="/taskModify.do")
	public String taskModify(@RequestParam("tuidx") int tuidx,
							HttpSession session) {
		//교수 과제 수정 화면
		TaskVO tv = ts.taskSelectOne(tuidx);
		session.setAttribute("tv", tv);
		
//		System.out.println("tv:"+session.getAttribute("tv"));
		
		return "lecture/taskModify";
	}
	
	
	@RequestMapping(value="/taskModifyAction.do")
	public String taskModifyAction(@RequestParam("lidx") int lidx,
			@RequestParam("taskSubject") String tusubject,
			@RequestParam("taskStart") String tustart,
			@RequestParam("taskFin") String tufin,
			@RequestParam("taskContents") String tucontents,
			@RequestParam("taskNotice") String tunotyn,
			@RequestParam("taskFile") MultipartFile tufile,
			@RequestParam("tuidx") int tuidx) throws Exception{
		//교수 과제 수정 완료
		
		String str = null;
		
		if(tufile.isEmpty()) { //첨부파일 수정 X
			
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("tusubject", tusubject);
			hm.put("tustart", tustart);
			hm.put("tufin", tufin);
			hm.put("tunotyn", tunotyn);
			hm.put("tucontents", tucontents);
			hm.put("tuidx", tuidx);
			
			int value = ts.taskModify(hm);
			
			if(value == 1) {
				str = "redirect:/taskContent.do?tuidx="+tuidx+"&lidx="+lidx;
			} else {
				str = "redirect:/taskModify.do?tuidx="+tuidx;
			}
			
		} else {//첨부파일 수정 O
			
			//파일 수정 -> 새로운 파일 저장
			//파일명
			String originalFileName = tufile.getOriginalFilename();
			//파일명 중 확장자만 추출
			String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			//파일경로
			String route = uploadPath;
			
			String savedName = UploadFileUtiles.uploadFile(uploadPath, originalFileName, tufile.getBytes());
			
			HashMap<String, Object> taskFile = new HashMap<String, Object>();
			taskFile.put("originName", originalFileName);
			taskFile.put("savedName", savedName);
			taskFile.put("originalFileExtension", originalFileExtension);
			taskFile.put("route", route);
			
			//교수 과제 수정
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("tusubject", tusubject);
			hm.put("tustart", tustart);
			hm.put("tufin", tufin);
			hm.put("tunotyn", tunotyn);
			hm.put("tucontents", tucontents);
			hm.put("tuidx", tuidx);
			
			int value = ts.taskAndFileModify(hm, taskFile);
			
			if(value == 2) {
				str = "redirect:/taskContent.do?tuidx="+tuidx+"&lidx="+lidx;
			} else {
				str = "redirect:/taskModify.do?tuidx="+tuidx;
			}
		}
		
		return "";
	}
	
	
	@RequestMapping(value="/taskDeleteAction.do")
	public String taskDelete(HttpSession session) {
		//교수 과제 삭제
		LecVO lv = (LecVO)session.getAttribute("lv");
		int lidx = lv.getLidx(); 
		TaskVO tv = (TaskVO)session.getAttribute("tv");
		int tuidx = tv.getTuidx();
		
		int value = ts.taskDelete(tuidx);
		
		String str = "";
		
		if(value == 0) {
			str="redirect:/taskContent.do?tuidx="+tuidx+"&lidx="+lidx;
		} else {
			str="redirect:/taskList.do?lidx="+lidx;
		}
		
		return str;
	}
	
	
	@RequestMapping(value="/taskSubmitList.do")
	public String taskSubmitList(@RequestParam("tuidx") int tuidx, Model model) {
		//과제에 대한 학생 제출 리스트
		ArrayList<S_taskDTO> submitList = sts.taskSubmitList(tuidx);
		model.addAttribute("submitList", submitList);
		
		return "lecture/taskSubmitList";
	}

	@ResponseBody
	@RequestMapping(value="/tExFileDelete.do")
	public HashMap<String,Object> fileDelete(@RequestParam("fidx") int fidx,
							@RequestParam("tuidx") int tuidx) {
		//수정페이지에서 파일 삭제 -ajax이용
		int value = ts.tExFileDelete(tuidx, fidx);
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("value",value);
		
		return hm;
	}
}
