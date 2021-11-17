//211027 jhr 작업
package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.ClassVo;

public interface ClassService {

	//강좌 작성 
	public int classInsert(ClassVo cv);
	
	//강좌 리스트
	public ArrayList<ClassVo> classSelect(int lidx);
	
}
