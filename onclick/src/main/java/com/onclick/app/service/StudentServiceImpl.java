//211027 jhr 작업
package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.StudentVO;
import com.onclick.app.domain.TaskVO;
import com.onclick.app.persistence.StudentService_Mapper;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int studentJoin(int sidx, String spwd,String sname,String sphone,String semail) {
		//학생 가입
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("sidx", sidx);
		hm.put("spwd", spwd);
		hm.put("sname", sname);
		hm.put("sphone", sphone);
		hm.put("semail", semail);
		
		StudentService_Mapper ssm = sqlSession.getMapper(StudentService_Mapper.class);
		int cnt = ssm.studentJoin(hm);

		return cnt;
	}

	@Override
	public int studentIdChcek(int sidx) {
		//학생 아이디 중복 체크
		StudentService_Mapper ssm = sqlSession.getMapper(StudentService_Mapper.class);
		int cnt = ssm.studentIdChcek(sidx);
		
		return cnt;
	}

	@Override
	public StudentVO studentLogin(int id, String pwd) {
		//학생 로그인
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("id", id);
		hm.put("pwd", pwd);
		
		StudentService_Mapper ssm = sqlSession.getMapper(StudentService_Mapper.class);
		StudentVO sv = ssm.studentLogin(hm);
		
		return sv;
	}

	@Override
	public ArrayList<EnrollDTO> stuLecSelectAll(int sidx) {
		//학생과목
		StudentService_Mapper ssm = sqlSession.getMapper(StudentService_Mapper.class);
		ArrayList<EnrollDTO> alist = ssm.stuLecSelectAll(sidx);
		
		return alist;
	}

	@Override
	public int studentPwdCheck(String spwd) {
		//학생 비밀번호 확인
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("spwd", spwd);
		
		StudentService_Mapper ssm = sqlSession.getMapper(StudentService_Mapper.class);
		int cnt = ssm.studentPwdCheck(hm);

		return cnt;
	}

	@Override
	public int studentModifyAction(int sidx, String spwd) {
		//학생 정보 수정 
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("sidx", sidx);
		hm.put("spwd", spwd);
		
		StudentService_Mapper ssm = sqlSession.getMapper(StudentService_Mapper.class);
		int cnt = ssm.studentModifyAction(hm);
		
		return cnt;
	}

	@Override
	public StudentVO studentSelectOne(int sidx) {
		//학생정보 가져오기
		StudentService_Mapper ssm = sqlSession.getMapper(StudentService_Mapper.class);
		StudentVO sv = ssm.studentSelectOne(sidx);
		
		return sv;
	}

	@Override
	public ArrayList<TaskVO> stuTaskSelectAll(int sidx) {
		//학생 과제(대시보드)
		StudentService_Mapper ssm = sqlSession.getMapper(StudentService_Mapper.class);
		ArrayList<TaskVO> stuTaskList = ssm.stuTaskSelectAll(sidx);
		
		return stuTaskList;
	}
	
	@Override
	public TaskVO stuTaskContent(String tuname) {
		// 대시보드에서 과제 내용보기로 이동

		return null;
	}

}
