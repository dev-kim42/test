package com.onclick.app.persistence;

import java.util.ArrayList;

import com.onclick.app.domain.LecNoticeVO;

public interface LecNoticeService_Mapper {
	
	//강의 공지사항 목록
	public ArrayList<LecNoticeVO> lecNoticeSelectAll(int lidx);
	
	//강의 공지사항(대시보드)
	public ArrayList<LecNoticeVO> lecNoticeSelectDash(int lidx);
	
	//강의 내용보기
	public LecNoticeVO lecNoticeContent(int lnidx);
}
