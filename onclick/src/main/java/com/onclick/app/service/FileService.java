package com.onclick.app.service;

import java.util.HashMap;

import com.onclick.app.domain.FileVO;

public interface FileService {

	//���� ÷������ ��������
	public FileVO taskFileSelectAll(int fidx);
	
	//���� ÷������ �ٿ�ε�
	public HashMap<String, Object> taskFileDownload(int fidx);
	
	//���� ����
	public int fileDelete(int fidx);
}
