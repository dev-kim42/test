package com.onclick.app.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onclick.app.domain.LecNoticeVO;
import com.onclick.app.persistence.LecNoticeService_Mapper;

@Service("lecNoticeServiceImpl")
public class LecNoticeServiceImpl implements LecNoticeService{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ArrayList<LecNoticeVO> lecNoticeSelectAll(int lidx) {
		//���� �������� ���
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		ArrayList<LecNoticeVO> lnList = lnsm.lecNoticeSelectAll(lidx);
		return lnList;
	}

	@Override
	public ArrayList<LecNoticeVO> lecNoticeSelectDash(int lidx) {
		//���� �������� ���(��ú���)
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		ArrayList<LecNoticeVO> lndList = lnsm.lecNoticeSelectDash(lidx);
		return lndList;
	}

	@Override
	public LecNoticeVO lecNoticeContent(int lnidx) {
		//���� ���뺸��
		LecNoticeService_Mapper lnsm = sqlSession.getMapper(LecNoticeService_Mapper.class);
		LecNoticeVO lnv = lnsm.lecNoticeContent(lnidx);
		
		return lnv;
	}
}
