package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.TaskVO;

public interface TaskService { //���� ����
	
	//���� ���뺸��
	public TaskVO taskSelectOne(int tuidx);

	//���� ���
	public ArrayList<TaskVO> taskSelectAll(int lidx);
	
	//���� ���ǿ� ���
	public TaskVO taskAll(int lidx);
	
	//���� & ���� ���ε�
	public int taskAndFileInsert(HashMap<String,Object> hm,HashMap<String, Object> hmFile, int lidx);
	
	//������ ���ε�
	public int taskInsert(HashMap<String,Object> hm, int lidx);
	
	//���� ����
	public int taskDelete(int tuidx);
	
	//���� ����
	public int taskModify(HashMap<String,Object> hm);
	
	//���� & ���� ����
	public int taskAndFileModify(HashMap<String,Object> hm,HashMap<String, Object> hmFile);
	
	//���� �����ε��� ����
	public int tExFileDelete(int tuidx, int fidx);
	
}