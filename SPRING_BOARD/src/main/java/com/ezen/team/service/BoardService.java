package com.ezen.team.service;

import java.util.ArrayList;

import com.ezen.team.domain.BoardVo;
import com.ezen.team.domain.SearchCriteria;



public interface BoardService {
		
	public int boardTotal(SearchCriteria scri);
	
	public ArrayList<BoardVo> boardselectAll(SearchCriteria scri);
	
	public int boardInsert(String bsubject,String bcontents,String bwriter,String bpassword, String ip);
	
	public int boardView(int bidx);
	
	public BoardVo boardSelectOne(int bidx);
	
	public int boardUpdate(String bsubject,String bcontents,String bwriter, int bidx);	
	
	public int boardDelete(int bidx, String bpassword);
	
	public int boardReply(int bidx, int orginbidx, int updown, int leftright, String bsubject,
			String bcontent, String bwriter, String bpassword, String ip);
	
	public int boardRecommend(int bidx);
	
	}
