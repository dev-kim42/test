package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.ClassVo;

public interface ClassService_Mapper {


	//강좌 작성 
	public int classInsert(HashMap<String,Object> hm);
	
	//강좌 순서 수정
	public int classUpdate(int cweek);
	
	//강좌 리스트 
	public ArrayList<ClassVo> classSelect(int lidx);
	
}
