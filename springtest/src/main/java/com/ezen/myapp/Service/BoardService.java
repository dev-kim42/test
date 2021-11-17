package com.ezen.myapp.Service;

import java.util.ArrayList;

import com.ezen.myapp.domain.BoardVo;
import com.ezen.myapp.domain.CommentVo;
import com.ezen.myapp.domain.SearchCriteria;

public interface BoardService {

	//자바에서 넘기는 메소드 이름 정의, MyBatis에서 사용하기 위해선 Mapper 클래스에서도 정의 필요
	
	public int boardInsert(String subject,String contents,String writer,String pwd, String ip, int midx);
	
	public int boardTotalCount(SearchCriteria scri);
	
	public ArrayList<BoardVo> boardSelectAll(SearchCriteria scri);
	
	public BoardVo boardSelectOne(int bidx);
	
	public ArrayList<CommentVo> commentSelectAll(int bidx);
	
	public int commentInsert(CommentVo cv);
	
	public int commentDel(int cidx);
	
	public ArrayList<CommentVo> commentMore(int bidx, int page);
	
	public int commentTotalPage(int bidx);
	
	public int boardModify(int bidx, String subject, String contents, String writer, String pwd);
	
	public int boardDelete(int bidx, String pwd);
		
	public int boardReply(int originbidx, int depth, int nlevel, String subject, String contents, String writer,String ip,int midx,String pwd);
	
	}
