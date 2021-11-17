package com.ezen.myapp.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.ezen.myapp.domain.CommentVo;
import com.ezen.myapp.domain.MemberVo;
import com.ezen.myapp.domain.BoardVo;
import com.ezen.myapp.domain.SearchCriteria;

public interface MemberService_Mapper {
	
	// 자바파일(Interface)에서 정의한 메소드들을 MyBatis로 넘기기 위해서 정의

	public MemberVo memberLogin(String id, String pwd);
	
	}
