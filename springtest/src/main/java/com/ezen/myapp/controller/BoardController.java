package com.ezen.myapp.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.myapp.Service.BoardService;
import com.ezen.myapp.domain.BoardVo;
import com.ezen.myapp.domain.CommentVo;
import com.ezen.myapp.domain.PageMaker;
import com.ezen.myapp.domain.SearchCriteria;


@Controller
public class BoardController {

	@Autowired
	BoardService bs;
	
//	@Autowired
//	SqlSession sqlSession;
	
	@Autowired
	PageMaker pm;
		
	@RequestMapping(value="/board/boardWrite.do")
	public String boardWrite() {
		
//		System.out.println("SqlSession"+sqlSession);
		
		return "board/boardWrite";
	}
	
	@RequestMapping(value="/board/boardWriteAction.do")
	public String boardWriteAction(
			//RequestParam = ()안의 값을 받는 파라미터 어노테이션 -> 받은 값을 객체로 만들어줌.
			@RequestParam("subject") String subject,
			@RequestParam("contents") String contents,
			@RequestParam("writer") String writer,
			@RequestParam("pwd") String pwd
			){		
		
			String ip= null;
			try {
				ip = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e) {				
				e.printStackTrace();
			}
			int midx = 1;		
				
			int result = bs.boardInsert(subject, contents, writer, pwd, ip, midx);
		
		return "redirect:/board/boardList.do";
	}
	
	@RequestMapping(value="/board/boardList.do")
	public String boardList(SearchCriteria scri, Model model) {	
		
		/* serviceImpl 처리
		 * 1. 전체 개수 뽑기, 전체 리스트 뽑기
		 * 2. PageMaker에 담고 Model이라는 객체에 담아서 화면에 넘긴다.
		 * cf. Model = 스프링에서 Attribute를 담고 있는 객체
		 */
		
		int cnt = bs.boardTotalCount(scri);
//		System.out.println("cnt?" + cnt);
		ArrayList<BoardVo> alist = bs.boardSelectAll(scri);
//		System.out.println("alist?" + alist);
				
		pm.setScri(scri);
		pm.setTotalCount(cnt);
		
		//외부에서 담을때만 model에 담고 꺼낼 땐 request로 꺼낸다.
		model.addAttribute("alist", alist); 
		model.addAttribute("pm", pm);
				
		return "board/boardList";
	}
		
	@RequestMapping(value="/board/boardContents.do")
	public String boardContents(
			@RequestParam("bidx") int bidx,			
			Model model) {
		
		bs.boardSelectOne(bidx);
		
		//bidx를 넘겨주고 데이터 가져오기
		BoardVo bv = bs.boardSelectOne(bidx);
		//모델에 담아주고 화면으로 넘겨준다.
		model.addAttribute("bv", bv);		
		
		return "board/boardContents";
	}
	
	@RequestMapping(value="/board/boardModify.do")
	public String boardModify(
			@RequestParam("bidx") int bidx,
			Model model) {
				
		BoardVo bv = bs.boardSelectOne(bidx);
		model.addAttribute("bv", bv);
		
		return "board/boardModify";
	}
	@RequestMapping(value="/board/boardModifyAction.do")
	public String boardModifyAction(
			@RequestParam("bidx") int bidx,
			@RequestParam("subject") String subject,
			@RequestParam("contents") String contents,
			@RequestParam("writer") String writer,
			@RequestParam("pwd") String pwd,
			RedirectAttributes rttr
			) {				

		//메소드 호출
		
		int value = bs.boardModify(bidx, subject, contents, writer, pwd);		
		
		System.out.println("value?"+value);
		
		String movelocation = null;
		
		if(value == 0) {
			movelocation = "redirect:/board/boardModify.do?bidx="+bidx;
		}else {
			rttr.addFlashAttribute("msg", "수정되었습니다.");
			movelocation = "redirect:/board/boardContents.do?bidx="+bidx;
		}
		
		return movelocation;
	}
	
	@RequestMapping(value="/board/boardDelete.do")
	public String boardDelete(
			@RequestParam("bidx") int bidx,
			Model model) {
				
		BoardVo bv = bs.boardSelectOne(bidx);
		model.addAttribute("bv", bv);
		
		return "board/boardDelete";
	}
	
	@RequestMapping(value="/board/boardDeleteAction.do")
	public String boardDeleteAction(
			@RequestParam("bidx") int bidx,
			@RequestParam("pwd") String pwd,
			RedirectAttributes rttr
			) {				

		//메소드 호출
		
		int value = bs.boardDelete(bidx, pwd);		
		
		System.out.println("value?"+value);
		
		String movelocation = null;
		
		if(value == 0) {
			movelocation = "redirect:/board/boardDelete.do?bidx="+bidx;
		}else {
			rttr.addAttribute("msg", "수정되었습니다.");
			movelocation = "redirect:/board/boardList.do?bidx="+bidx;
		}
		
		return movelocation;
	}
	
	@RequestMapping(value="/board/boardReply.do")
	public String boardReply(
			BoardVo bv,
			Model model) {
		
		model.addAttribute("bv", bv);
		
		return "board/boardReply";
	}
	
	@RequestMapping(value="/board/boardReplyAction.do")
	public String boardReplyAction(BoardVo bv, Model model) {				

		//트랜잭션을 이용해서 Update, Insert 구문을 동시에 처리
		int midx = 1;
		String ip = null;
		
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		bs.boardReply(bv.getOriginbidx(), bv.getDepth(), bv.getNlevel(), bv.getSubject(), bv.getContents(), bv.getWriter(), ip, midx, bv.getPwd());
		
		
		
		return "redirect:/board/boardList.do";
	}
	
	
	
}
