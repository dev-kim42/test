package com.onclick.app.persistence;

import java.util.ArrayList;

import com.onclick.app.domain.LecNoticeVO;

public interface LecNoticeService_Mapper {
	
	//���� �������� ���
	public ArrayList<LecNoticeVO> lecNoticeSelectAll(int lidx);
	
	//���� ��������(��ú���)
	public ArrayList<LecNoticeVO> lecNoticeSelectDash(int lidx);
	
	//���� ���뺸��
	public LecNoticeVO lecNoticeContent(int lnidx);
}
