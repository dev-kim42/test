package com.ezen.team.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.team.domain.BoardVo;
import com.ezen.team.domain.SearchCriteria;
import com.ezen.team.persistence.BoardService_Mapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	//1. 마이바티스를 주입받는다
	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public int boardTotal(SearchCriteria scri) {
		//2. sqlSession 값이 있는지 찍어본다
		System.out.println("sqlSession:"+sqlSession);
		//3.마이바티스 메소드 사용(매퍼를 사용하기 위한 매퍼연동)
		BoardService_Mapper bsm =sqlSession.getMapper(BoardService_Mapper.class);
		//4. 메소드의 리턴값을 받는다
		int cnt = bsm.boardTotal(scri);
		//5. 컨트롤러에 리턴값을 보낸다.		
		return cnt;
	}
	
	@Override
	public ArrayList<BoardVo> boardselectAll(SearchCriteria scri) {
		
		BoardService_Mapper bsm =sqlSession.getMapper(BoardService_Mapper.class);	
		ArrayList<BoardVo> alist = bsm.boardselectAll(scri);
		return alist;
	}	
	
	
	public int boardInsert(String bsubject,String bcontents,String bwriter,String bpassword, String ip) {
		
		int execValue = 0;			
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("bsubject", bsubject);
		map.put("bcontents", bcontents);
		map.put("bwriter", bwriter);
		map.put("bpassword", bpassword);
		map.put("bip", ip);
		
		System.out.println("boardInsert");
		
		BoardService_Mapper bsm =sqlSession.getMapper(BoardService_Mapper.class);		
		execValue  = bsm.boardInsert(map);		
		
		return execValue;
	}

	@Override
	public int boardView(int bidx) {
		
		BoardService_Mapper bsm =sqlSession.getMapper(BoardService_Mapper.class);		
		int value = bsm.boardView(bidx);
		
		return value;
	}

	@Override
	public BoardVo boardSelectOne(int bidx) {
		//마이바티스에서 매퍼를 가져온다
		BoardService_Mapper bsm =sqlSession.getMapper(BoardService_Mapper.class);		
		BoardVo bv = bsm.boardSelectOne(bidx);
		
		return bv;
	}

	@Override
	public int boardUpdate(String bsubject, String bcontents, String bwriter, int bidx) {
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("bsubject", bsubject);
		map.put("bcontents", bcontents);
		map.put("bwriter", bwriter);
		map.put("bidx", bidx);
		
		BoardService_Mapper bsm =sqlSession.getMapper(BoardService_Mapper.class);		
		int value  = bsm.boardUpdate(map);	
		
		return value;
	}

	@Override
	public int boardDelete(int bidx, String bpassword) {
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("bidx", bidx);
		map.put("bpassword", bpassword);
		
		BoardService_Mapper bsm =sqlSession.getMapper(BoardService_Mapper.class);		
		int value  = bsm.boardDelete(map);
		
		return value;
	}

	@Transactional
	@Override
	public int boardReply(int bidx, int orginbidx, int updown, int leftright, String bsubject, String bcontent,
			String bwriter, String bpassword, String ip) {
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("bidx", bidx);
		map.put("orginbidx", orginbidx);
		map.put("updown", updown);
		map.put("leftright", leftright);
		map.put("bsubject", bsubject);
		map.put("bcontents", bcontent);
		map.put("bwriter", bwriter);
		map.put("bpassword", bpassword);
		map.put("ip", ip);
		
		BoardService_Mapper bsm =sqlSession.getMapper(BoardService_Mapper.class);		
		bsm.boardReplyUpdate(orginbidx, updown);
		int value2  = bsm.boardReplyInsert(map);
				
		
		return value2;
	}

	@Override
	public int boardRecommend(int bidx) {
				
		BoardService_Mapper bsm =sqlSession.getMapper(BoardService_Mapper.class);		
		int value= bsm.boardRecommend(bidx);
		
		return value;
	}

	
	
	
	

	
	}
