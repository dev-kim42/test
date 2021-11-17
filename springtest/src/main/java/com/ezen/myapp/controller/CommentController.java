package com.ezen.myapp.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.myapp.Service.BoardService;
import com.ezen.myapp.domain.CommentVo;

@RestController
public class CommentController {
	
	
	@Autowired
	BoardService bs;
	
	//댓글 기능 구현하기
	
	//Spring에서는 Mapping된 주소값을 보내는 것이므로 전부다 "" 사이의 주소값에 해당하는 것들을 보냄.
	//객체를 보내고 싶다면 Mapping위에 @ResponseBody를 해줘야 한다.(객체를 매핑한다는 뜻으로)
	@RequestMapping(value="/board/commentsAll.do")
	public ArrayList<CommentVo> commentsAll(@RequestParam("bidx") int bidx) {
		
		ArrayList <CommentVo> clist = null;
		//해당 글번호(bidx)를 넘김 , bidx를 넘겨받아 CommentSelectAll 메소드 호출
		clist = bs.commentSelectAll(bidx);		
		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("id","test");
		
		
		//객체 리턴
		return clist;
	}
	
	@RequestMapping(value="/board/comments.do")
	public HashMap<String, Integer> commentWrite(CommentVo cv) {
		
			int value=0;
			
			value = bs.commentInsert(cv);
			
			HashMap<String, Integer> hm = new HashMap<String, Integer>(); 
			hm.put("result", value);
			
//			System.out.println("value?"+value);
//			System.out.println("hm"+hm);
						
			return hm;		
		
	}
	
	@RequestMapping(value="/board/{cidx}/commentDelete.do")
	public HashMap<String, Integer> commentDelete(@PathVariable("cidx") int cidx) {
		int value = 0;
		
		value = bs.commentDel(cidx);		
		
		//해시맵을 사용해서 객체를 반환
		HashMap<String, Integer> hm = new HashMap<String, Integer>(); 
		hm.put("result", value);
		
		return hm;
	}
	
	@RequestMapping(value="/board/{bidx}/{page}/commentMore.do")
	public HashMap<String, Object> commentMo(
			@PathVariable("bidx") int bidx,
			@PathVariable("page") int page
			) {
		
		int nextpage = 0;
		
		int commentTotalPage = bs.commentTotalPage(bidx);
//		System.out.println("CTP?"+commentTotalPage);
		
		
		if (page < commentTotalPage) {
	            nextpage = page +1;
	         }else {
	            nextpage = 9999;
	         }	
						
		ArrayList<CommentVo> clist = new ArrayList<CommentVo>();		
		clist = bs.commentMore(bidx, page);
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("ja", clist);
		hm.put("nextpage", nextpage);
		
		return hm;		
		
	}
	



}
