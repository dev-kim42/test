package com.onclick.app.persistence;

import java.util.HashMap;

import com.onclick.app.domain.FileVO;

public interface FileService_Mapper {

	//과제 첨부파일 가져오기
	public FileVO taskFileSelectAll(int fidx);

	//과제 첨부파일 다운로드
	public HashMap<String, Object> taskFileDownload(int fidx);
	
	//파일 삭제
	public int fileDelete(int fidx);
}
