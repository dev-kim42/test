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
		//���� ����Ʈ �������� 
		LecService_Mapper lsm = sqlSession.getMapper(LecService_Mapper.class);
		ArrayList<LecVO> alist = lsm.lecSelectAll(pidx);
		
		return alist;
	}

	@Override
	public LecVO lecHome(int lidx) {
		//����Ȩ����
		LecService_Mapper lsm = sqlSession.getMapper(LecService_Mapper.class);
		LecVO lv = lsm.lecHome(lidx);
		
		return lv;
	}

	@Override
	public LecVO lecSelectOne(int lidx) {
		//�ش� ���� ���� ��������
		LecService_Mapper lsm = sqlSession.getMapper(LecService_Mapper.class);
		LecVO lv = lsm.lecSelectOne(lidx);
		
		return lv;
	}
	
	@Override
	public ArrayList<StudentVO> lecStudentList(int lidx) {
		//���� ���� �������Ʈ 
		LecService_Mapper lsm = sqlSession.getMapper(LecService_Mapper.class);
		ArrayList<StudentVO> alist = lsm.lecStudentList(lidx);
		
		return alist;
	}

}
