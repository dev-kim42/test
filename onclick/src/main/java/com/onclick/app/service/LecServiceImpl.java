package com.onclick.app.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.StudentVO;
import com.onclick.app.persistence.LecService_Mapper;
import com.onclick.app.persistence.StudentService_Mapper;

@Service("lecServiceImpl")
public class LecServiceImpl implements LecService{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ArrayList<LecVO> lecSelectAll(int pidx) {
		//강의 리스트 가져오기 
		LecService_Mapper lsm = sqlSession.getMapper(LecService_Mapper.class);
		ArrayList<LecVO> alist = lsm.lecSelectAll(pidx);
		
		return alist;
	}

	@Override
	public LecVO lecHome(int lidx) {
		//강의홈가기
		LecService_Mapper lsm = sqlSession.getMapper(LecService_Mapper.class);
		LecVO lv = lsm.lecHome(lidx);
		
		return lv;
	}

	@Override
	public LecVO lecSelectOne(int lidx) {
		//해당 과목 정보 가져오기
		LecService_Mapper lsm = sqlSession.getMapper(LecService_Mapper.class);
		LecVO lv = lsm.lecSelectOne(lidx);
		
		return lv;
	}
	
	@Override
	public ArrayList<StudentVO> lecStudentList(int lidx) {
		//강의 수강 멤버리스트 
		LecService_Mapper lsm = sqlSession.getMapper(LecService_Mapper.class);
		ArrayList<StudentVO> alist = lsm.lecStudentList(lidx);
		
		return alist;
	}

}
