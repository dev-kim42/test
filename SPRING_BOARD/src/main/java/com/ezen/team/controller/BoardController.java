package com.ezen.team.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.team.domain.SearchCriteria;
import com.ezen.team.service.BoardService;
import com.ezen.team.service.BoardServiceImpl;
import com.ezen.team.domain.BoardVo;
import com.ezen.team.domain.PageMaker;

@Controller
public class BoardController  {
	
	@Autowired
	BoardService bd;
	
	@Autowired(required= false)
	PageMaker pageMaker;
	
	@RequestMapping(value = "/board/boardList.do")
	public String boardList(SearchCriteria scri, Model model) {
	
		int cnt = bd.boardTotal(scri);			
		System.out.println("cnt:"+cnt);			
		
	//	PageMaker pageMaker = new PageMaker();
		pageMaker.setScri(scri);		
		pageMaker.setTotalCount(cnt);	
		
		
		ArrayList<BoardVo> alist =  bd.boardselectAll(scri);
		System.out.println("alist°ªÀº"+alist);
		
		model.addAttribute("alist", alist);
		model.addAttribute("pm", pageMaker);		
		
		return "boardList";
	}
	
	@RequestMapping(value="/board/boardWrite.do")
	public String boardWrite() {
		
		return "boardWrite";
	}
	
	@RequestMapping(value="/board/boardWriteAction.do")
	public String boardWriteAction(
			@RequestParam("bsubject") String bsubject,
			@RequestParam("bcontents") String bcontents,
			@RequestParam("bwriter") String bwriter,
			@RequestParam("bpassword") String bpassword
			) throws Exception {		
		
		System.out.println("boardWriteAction");
		
			String ip= null;
			try {
				ip = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e) {				
				e.printStackTrace();
			}
				
			int value = bd.boardInsert(bsubject,bcontents,bwriter,bpassword,ip);
		
		return "redirect:/board/boardList.do";
	}
	
	@RequestMapping(value="/board/boardContent.do")
	public String boardContent(
			@RequestParam("bidx") int bidx,
			Model model
			) {			
		
		bd.boardView(bidx);
		BoardVo bv = bd.boardSelectOne(bidx);
		model.addAttribute("bv",bv);
					
		return "boardContent";
	}
	
	@RequestMapping(value="/board/boardModify.do")	
	public String boardModify(
			@RequestParam("bidx") int bidx,
			Model model
			) {
				
		BoardVo bv = bd.boardSelectOne(bidx);
		model.addAttribute("bv",bv);		
		
		return "boardModify";
	}
	
	@RequestMapping(value="/board/boardModifyAction.do")
	public String boardModifyAction(
			@RequestParam("bsubject") String bsubject,
			@RequestParam("bcontents") String bcontents,
			@RequestParam("bwriter") String bwriter,
			@RequestParam("bidx") int bidx
			) {	
		System.out.println("boardModifyAction");
							
		int value = bd.boardUpdate(bsubject,bcontents,bwriter,bidx);
				
		String path = null;
		if (value==1)
		path = "/board/boardContent.do?bidx="+bidx;
		else
		path = "/board/boardModify.do?bidx="+bidx;
		
		return "redirect:/"+path;
	}
	
	@RequestMapping(value="/board/boardDelete.do")	
	public String boardDelete(
			@RequestParam("bidx") int bidx,
			Model model
			) {				
		
		model.addAttribute("bidx",bidx);		
		
		return "boardDelete";
	}						
	
	@RequestMapping(value="/board/boardDeleteAction.do")
	public String boardDeleteAction(
			@RequestParam("bpassword") String bpassword,
			@RequestParam("bidx") int bidx
			) {	
		System.out.println("boardDeleteAction");
							
		int value = bd.boardDelete(bidx,bpassword);
				
		String path = null;
		if (value==1)
		path = "/board/boardList.do";
		else
		path = "/board/boardDelete.do?bidx="+bidx;
		
		return "redirect:/"+path;
	}
	
	@RequestMapping(value="/board/boardReply.do")
	public String boardReply(
			@RequestParam("bidx") int bidx,
			@RequestParam("orginbidx") int orginbidx,
			@RequestParam("updown") int updown,
			@RequestParam("leftright") int leftright,
			Model model) {
		
			model.addAttribute("bidx", bidx);
			model.addAttribute("orginbidx", orginbidx);
			model.addAttribute("updown", updown);
			model.addAttribute("leftright", leftright);
				
		return "boardReply";
	}
	
	@RequestMapping(value="/board/boardReplyAction.do")
	public String boardReplyAction(
			@RequestParam("bidx") int bidx,
			@RequestParam("orginbidx") int orginbidx,
			@RequestParam("updown") int updown,
			@RequestParam("leftright") int leftright,
			@RequestParam("bsubject") String bsubject,
			@RequestParam("bcontents") String bcontents,
			@RequestParam("bwriter") String bwriter,
			@RequestParam("bpassword") String bpassword,
			Model model) {
		
			String ip = null;
			try {
				ip = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e) {				
				e.printStackTrace();
			}
		
			int value = bd.boardReply(bidx,orginbidx,updown,leftright,bsubject,bcontents,bwriter,bpassword,ip);
					
			String path = null;
			if (value==1)
			path = "/board/boardList.do";
			else
			path = "/board/boardReply.do?bidx="+bidx+"&orginbidx="+orginbidx+"&updown="+updown+"&leftright="+leftright;
			
			return "redirect:/"+path;
	}
	
	@RequestMapping(value="/board/boardRecommend.do")	
	public String boardRecommend(
			@RequestParam("bidx") int bidx			
			) {				
		
		int value = bd.boardRecommend(bidx);	
		
		String path = null;
		path = "/board/boardContent.do?bidx="+bidx;
		
		return "redirect:/"+path;		
	}	
	
	
	
	
	
	
	
}
