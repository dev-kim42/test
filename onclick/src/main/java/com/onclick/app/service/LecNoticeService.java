package com.onclick.app.service;

import java.util.ArrayList;

import com.onclick.app.domain.LecNoticeVO;

public interface LecNoticeService {
	
	//���� �������� ���
	public ArrayList<LecNoticeVO> lecNoticeSelectAll(int lidx);
	
	//���� ��������(��ú���)
	public ArrayList<LecNoticeVO> lecNoticeSelectDash(int lidx);
	
	//���� ���뺸��
	public LecNoticeVO lecNoticeContent(int lnidx);
}
