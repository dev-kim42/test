package com.ezen.team.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.team.domain.BoardVo;
import com.ezen.team.domain.MemberVo;
import com.ezen.team.domain.SearchCriteria;
import com.ezen.team.persistence.BoardService_Mapper;
import com.ezen.team.persistence.MemberService_Mapper;

@Service
public class MemberServiceImpl implements MemberService{
	
	//1. 마이바티스를 주입받는다
	@Autowired
	SqlSession sqlSession;

	@Override
	public MemberVo memberLogin(String memberId, String memberPwd) {
		
		MemberService_Mapper msm =sqlSession.getMapper(MemberService_Mapper.class);	
		MemberVo mv = msm.memberLogin(memberId,memberPwd);
		
		
		
		return mv;
	}
	

	
	
	
	

	
	}
