package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.StudentVO;
import com.onclick.app.domain.TaskVO;

public interface StudentService_Mapper {

	//학생 회원가입
	public int studentJoin(HashMap<String,Object> hm);
	
	//학생 아이디 중복 체크
	public int studentIdChcek(int sidx);
	
	//학생로그인
	public StudentVO studentLogin(HashMap<String,Object> hm);
	
	//학생과목
	public ArrayList<EnrollDTO> stuLecSelectAll(int id);
	
	//학생과제
	public ArrayList<TaskVO> stuTaskSelectAll(int sidx);
	
	//학생 비밀번호 확인
	public int studentPwdCheck(HashMap<String,String> hm);
	
	//학생 정보 수정 
	public int studentModifyAction(HashMap<String,Object> hm);
	
	//학생 정보 가져오기
	public StudentVO studentSelectOne(int sidx);
	
	//대시보드에서 과제 내용보기로 이동
	public TaskVO stuTaskContent(String tuname);
		
}
