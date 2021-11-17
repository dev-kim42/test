package com.ezen.team.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.ezen.team.domain.BoardVo;
import com.ezen.team.domain.MemberVo;
import com.ezen.team.domain.SearchCriteria;

public interface MemberService_Mapper {
		
	public MemberVo memberLogin(String memberId, String memberPwd);
	}
