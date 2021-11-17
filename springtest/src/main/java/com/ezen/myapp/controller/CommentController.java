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
	
	//��� ��� �����ϱ�
	
	//Spring������ Mapping�� �ּҰ��� ������ ���̹Ƿ� ���δ� "" ������ �ּҰ��� �ش��ϴ� �͵��� ����.
	//��ü�� ������ �ʹٸ� Mapping���� @ResponseBody�� ����� �Ѵ�.(��ü�� �����Ѵٴ� ������)
	@RequestMapping(value="/board/commentsAll.do")
	public ArrayList<CommentVo> commentsAll(@RequestParam("bidx") int bidx) {
		
		ArrayList <CommentVo> clist = null;
		//�ش� �۹�ȣ(bidx)�� �ѱ� , bidx�� �Ѱܹ޾� CommentSelectAll �޼ҵ� ȣ��
		clist = bs.commentSelectAll(bidx);		
		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("id","test");
		
		
		//��ü ����
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
		
		//�ؽø��� ����ؼ� ��ü�� ��ȯ
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
