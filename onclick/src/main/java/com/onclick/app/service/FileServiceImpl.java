package com.onclick.app.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onclick.app.domain.FileVO;
import com.onclick.app.persistence.FileService_Mapper;
import com.onclick.app.persistence.TaskService_Mapper;

@Service("fileServiceImpl")
public class FileServiceImpl implements FileService{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public FileVO taskFileSelectAll(int fidx) {
		//과제 파일 목록
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		FileVO fv = fsm.taskFileSelectAll(fidx);
		
		return fv;
	}

	@Override
	public HashMap<String, Object> taskFileDownload(int fidx) {
		//과제 파일 다운로드
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		HashMap<String, Object> hm = fsm.taskFileDownload(fidx);
		return hm;
	}

	@Override
	public int fileDelete(int fidx) {
		//파일 삭제
		FileService_Mapper fsm = sqlSession.getMapper(FileService_Mapper.class);
		int value = fsm.fileDelete(fidx);
		return value;
	}

}
