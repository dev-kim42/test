package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.TaskVO;

public interface TaskService { //교수 과제
	
	//과제 내용보기
	public TaskVO taskSelectOne(int tuidx);

	//과제 목록
	public ArrayList<TaskVO> taskSelectAll(int lidx);
	
	//과제 세션에 담기
	public TaskVO taskAll(int lidx);
	
	//과제 & 파일 업로드
	public int taskAndFileInsert(HashMap<String,Object> hm,HashMap<String, Object> hmFile, int lidx);
	
	//과제만 업로드
	public int taskInsert(HashMap<String,Object> hm, int lidx);
	
	//과제 삭제
	public int taskDelete(int tuidx);
	
	//과제 수정
	public int taskModify(HashMap<String,Object> hm);
	
	//과제 & 파일 수정
	public int taskAndFileModify(HashMap<String,Object> hm,HashMap<String, Object> hmFile);
	
	//과제 파일인덱스 삭제
	public int tExFileDelete(int tuidx, int fidx);
	
}
