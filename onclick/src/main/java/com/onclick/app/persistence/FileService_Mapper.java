package com.onclick.app.persistence;

import java.util.HashMap;

import com.onclick.app.domain.FileVO;

public interface FileService_Mapper {

	//���� ÷������ ��������
	public FileVO taskFileSelectAll(int fidx);

	//���� ÷������ �ٿ�ε�
	public HashMap<String, Object> taskFileDownload(int fidx);
	
	//���� ����
	public int fileDelete(int fidx);
}
