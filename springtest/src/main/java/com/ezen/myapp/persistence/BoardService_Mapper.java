package com.ezen.myapp.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.ezen.myapp.domain.CommentVo;
import com.ezen.myapp.domain.BoardVo;
import com.ezen.myapp.domain.SearchCriteria;

public interface BoardService_Mapper {
	
	// 자바파일(Interface)에서 정의한 메소드들을 MyBatis로 넘기기 위해서 정의

	public int boardInsert(HashMap<String,Object> hm);
	
	public int boardTotalCount(SearchCriteria scri);
	
	public ArrayList<BoardVo> boardSelectAll(SearchCriteria scri);
	
	public BoardVo boardSelectOne(int bidx);
	
	public ArrayList<CommentVo> commentSelectAll(int bidx);
	
	public int commentInsert(CommentVo cv);
	
	public int commentDel(int cidx);
	
	public ArrayList<CommentVo> commentMore(HashMap<String,Integer> hm);
	
	public int commentTotalPage(int bidx);
	
	public int boardModify(HashMap<String,Object> hm);
	
	public int boardDelete(HashMap<String,Object> hm);
	
	public int boardReplyUpdate(int originbidx, int depth);
	
	public int boardReplyInsert(HashMap<String,Object> hm);	
	
	}
