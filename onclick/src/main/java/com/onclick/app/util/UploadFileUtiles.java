package com.onclick.app.util;

import java.io.File;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtiles {

	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtiles.class);
	
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception{
		//파일명 겹치지 않도록 
		UUID uid = UUID.randomUUID();
		//원본 파일 이름과 UUID 결합
		String savedName = uid.toString() + "_"+ originalName;
		//저장할 파일 준비
		File target = new File(uploadPath, savedName);
		//파일저장
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}
	
	
}
