package com.ezen.myapp.Service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.myapp.domain.BoardVo;
import com.ezen.myapp.domain.CommentVo;
import com.ezen.myapp.domain.SearchCriteria;
import com.ezen.myapp.persistence.BoardService_Mapper;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService{
	
	//1. 마이바티스를 주입받는다
	@Autowired
	SqlSession sqlSession;
	
	public int boardInsert(String subject, String contents, String writer, String pwd, String ip, int midx) {
		
		int result = 0;			
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("subject", subject);
		hm.put("contents", contents);
		hm.put("writer", writer);
		hm.put("pwd", pwd);
		hm.put("ip", ip);
		hm.put("midx", midx);
				
		BoardService_Mapper bsm =sqlSession.getMapper(BoardService_Mapper.class);		
		result  = bsm.boardInsert(hm);		
		
		return result;
	}
	
	@Override
	public int boardTotalCount(SearchCriteria scri) {
			
		int cnt = 0;
		
		//MyBatis 연동
		BoardService_Mapper bsm = sqlSession.getMapper(BoardService_Mapper.class);
		
		cnt = bsm.boardTotalCount(scri);			
		return cnt;			
	}
	
	@Override
	public ArrayList<BoardVo> boardSelectAll(SearchCriteria scri) {
		
//		System.out.println(scri.getKeyword());
//		System.out.println(scri.getSearchType());
		
		// MyBatis 연동
		BoardService_Mapper bsm = sqlSession.getMapper(BoardService_Mapper.class);
		ArrayList<BoardVo> alist = bsm.boardSelectAll(scri);	
		
		return alist;
		
	}

	@Override
	public BoardVo boardSelectOne(int bidx) {
		
		BoardService_Mapper bsm = sqlSession.getMapper(BoardService_Mapper.class);
		BoardVo bv = bsm.boardSelectOne(bidx);		
		
		return bv;
	}
	
	@Override
	public ArrayList<CommentVo> commentSelectAll(int bidx) {
				
		BoardService_Mapper bsm = sqlSession.getMapper(BoardService_Mapper.class);
		ArrayList<CommentVo> clist = bsm.commentSelectAll(bidx);
		
		return clist;
	}

	@Override
	public int commentInsert(CommentVo cv) {
		
//		HashMap<String, Object> hm = new HashMap<String, Object>();
				
		BoardService_Mapper bsm = sqlSession.getMapper(BoardService_Mapper.class);
		int value = bsm.commentInsert(cv);
		
		return value;
	}

	@Override
	public int commentDel(int cidx){
		
		BoardService_Mapper bsm = sqlSession.getMapper(BoardService_Mapper.class);
		int value = bsm.commentDel(cidx);
		
		return value;
		
	}

	@Override
	public ArrayList<CommentVo> commentMore(int bidx, int page) {
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("bidx", bidx);
		hm.put("page", page);
		
		BoardService_Mapper bsm = sqlSession.getMapper(BoardService_Mapper.class);
		ArrayList<CommentVo> clist = bsm.commentMore(hm);
		
		
		return clist;
	}

	@Override
	public int commentTotalPage(int bidx) {
		
		BoardService_Mapper bsm = sqlSession.getMapper(BoardService_Mapper.class);
		int cnt = bsm.commentTotalPage(bidx);
		
		return cnt;
	}

	@Override
	public int boardModify(int bidx, String subject, String contents, String writer, String pwd) {
					
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("bidx", bidx);
			hm.put("subject", subject);
			hm.put("contents", contents);
			hm.put("writer", writer);
			hm.put("pwd", pwd);
					
			BoardService_Mapper bsm =sqlSession.getMapper(BoardService_Mapper.class);		
			int value  = bsm.boardModify(hm);			
			
			return value;		
	}

	@Override
	public int boardDelete(int bidx, String pwd) {		
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("bidx", bidx);
		hm.put("pwd", pwd);
		
		BoardService_Mapper bsm = sqlSession.getMapper(BoardService_Mapper.class);
		int value = bsm.boardDelete(hm);
		
		return value;
	}
	@Transactional
	@Override
	public int boardReply(int originbidx, int depth, int nlevel, String subject, String contents, String writer,String ip,int midx,String pwd) {
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("originbidx", originbidx);
		hm.put("depth", depth);
		hm.put("nlevel", nlevel);
		hm.put("subject", subject);
		hm.put("contents", contents);
		hm.put("writer", writer);
		hm.put("ip", ip);
		hm.put("midx", midx);
		hm.put("pwd", pwd);		

		BoardService_Mapper bsm = sqlSession.getMapper(BoardService_Mapper.class);		
		bsm.boardReplyUpdate(originbidx, depth);
		int value = bsm.boardReplyInsert(hm);
		
		return value;
	}




		
	
	

	
}
