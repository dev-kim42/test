package com.ezen.team.service;

import java.util.ArrayList;

import com.ezen.team.domain.BoardVo;
import com.ezen.team.domain.MemberVo;
import com.ezen.team.domain.SearchCriteria;



public interface MemberService {
		
	public MemberVo memberLogin(String memberId, String memberPwd);
	
	}
