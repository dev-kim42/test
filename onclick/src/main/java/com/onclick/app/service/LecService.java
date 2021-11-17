package com.onclick.app.service;

import java.util.ArrayList;

import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.StudentVO;

public interface LecService {

	//���� ����Ʈ �������� 
	public ArrayList<LecVO> lecSelectAll(int pidx);
	
	//����Ȩ����
	public LecVO lecHome(int lidx);
	
	//�ش� ���� ���� ��������
	public LecVO lecSelectOne(int lidx);

	//���� ���� �������Ʈ 
	public ArrayList<StudentVO> lecStudentList(int lidx);
}
