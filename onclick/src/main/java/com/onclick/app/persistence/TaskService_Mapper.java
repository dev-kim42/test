package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.TaskVO;

public interface TaskService_Mapper {

	//과제 내용보기
	public TaskVO taskSelectOne(int tuidx);

	//과제 목록
	public ArrayList<TaskVO> taskSelectAll(int lidx);
	
	//과제 세션에 담기
	public TaskVO taskAll(int lidx);
	
	//과제 파일 업로드
	public int taskFileInsert(HashMap<String,Object> hmFile);
	
	//과제 내용 업로드
	public int taskInsert(HashMap<String,Object> hm);
	
	//과제 삭제
	public int taskDelete(int tuidx);
	
	//학생 과제 삽입(교수 과제 업로드 시)
	public int stuTaskDefault(int lidx, int tuidx);
	
	//과제 수정
	public int taskModify(HashMap<String,Object> hm);
	
	//과제 파일 수정
	public int taskFileModify(HashMap<String,Object> hm);
	
	//과제 파일인덱스 삭제
	public int tExFileDelete(int tuidx);
	
}
