package com.onclick.app.service;

import com.onclick.app.domain.ProfessorVO;

public interface ProfessorService {

	//교수 아이디 중복 체크 
	public int professorIdCheck(String pidx);
	
	//교수 회원가입
	public int professorJoin(int pidx,String pname,String ppwd, int pphone,String pemail);
	
	//교수 로그인 
	public ProfessorVO professorLogin(int pidx, String ppwd);
	
	//교수 비밀번호 확인
	public int proPwdCheck(String ppwd);

	//교수 정보 보기 
	public ProfessorVO proInfo(int pidx);
}
