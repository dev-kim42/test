package com.onclick.app.persistence;

import java.util.HashMap;

import com.onclick.app.domain.VideoAttenDto;

public interface VideoAttenService_Mapper {

	//영상 시청시 시청기록 업데이트
	public int videoUpdate(HashMap<String,Object> hm);
		
	//이전 시청 기록 가져오기
	public VideoAttenDto videoSelectOne(HashMap<String,Object> hm);
}
