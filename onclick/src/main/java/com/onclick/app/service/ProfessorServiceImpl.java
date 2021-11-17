package com.onclick.app.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onclick.app.domain.ProfessorVO;
import com.onclick.app.persistence.ProfessorService_Mapper;
import com.onclick.app.persistence.StudentService_Mapper;

@Service("professorServiceImpl")
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int professorIdCheck(String pidx) {
		//교수 아이디 중복 체크
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("pidx", pidx);
		
		ProfessorService_Mapper psm = sqlSession.getMapper(ProfessorService_Mapper.class);
		int cnt = psm.professorIdCheck(hm);
		
		return cnt;
	}

	@Override
	public int professorJoin(int pidx, String pname, String ppwd, int pphone, String pemail) {
		//교수 회원가입
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("pidx", pidx);
		hm.put("pname", pname);
		hm.put("ppwd", ppwd);
		hm.put("pphone",pphone);
		hm.put("pemail", pemail);
		
		ProfessorService_Mapper psm = sqlSession.getMapper(ProfessorService_Mapper.class);
		int cnt = psm.professorJoin(hm);
		
		return cnt;
	}

	@Override
	public ProfessorVO professorLogin(int pidx, String ppwd) {
		//교수 로그인 
		HashMap<String, Object> hm = new HashMap<String,Object>();
		hm.put("pidx", pidx);
		hm.put("ppwd", ppwd);
		
		ProfessorService_Mapper psm = sqlSession.getMapper(ProfessorService_Mapper.class);
		ProfessorVO pv  = psm.professorLogin(hm);
		
		return pv;
	}

	@Override
	public int proPwdCheck(String ppwd) {
		//교수 비밀번호 확인
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("ppwd", ppwd);
		
		ProfessorService_Mapper psm = sqlSession.getMapper(ProfessorService_Mapper.class);
		int cnt = psm.proPwdCheck(hm);

		return cnt;
	}
	
	@Override
	public ProfessorVO proInfo(int pidx) {
		//교수 정보 보기 
		ProfessorService_Mapper psm = sqlSession.getMapper(ProfessorService_Mapper.class);
		ProfessorVO pv  = psm.proInfo(pidx);
		
		return pv;
	}
}
