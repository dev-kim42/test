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
			//RequestParam = ()���� ���� �޴� �Ķ���� ������̼� -> ���� ���� ��ü�� �������.
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
		
		/* serviceImpl ó��
		 * 1. ��ü ���� �̱�, ��ü ����Ʈ �̱�
		 * 2. PageMaker�� ��� Model�̶�� ��ü�� ��Ƽ� ȭ�鿡 �ѱ��.
		 * cf. Model = ���������� Attribute�� ��� �ִ� ��ü
		 */
		
		int cnt = bs.boardTotalCount(scri);
//		System.out.println("cnt?" + cnt);
		ArrayList<BoardVo> alist = bs.boardSelectAll(scri);
//		System.out.println("alist?" + alist);
				
		pm.setScri(scri);
		pm.setTotalCount(cnt);
		
		//�ܺο��� �������� model�� ��� ���� �� request�� ������.
		model.addAttribute("alist", alist); 
		model.addAttribute("pm", pm);
				
		return "board/boardList";
	}
		
	@RequestMapping(value="/board/boardContents.do")
	public String boardContents(
			@RequestParam("bidx") int bidx,			
			Model model) {
		
		bs.boardSelectOne(bidx);
		
		//bidx�� �Ѱ��ְ� ������ ��������
		BoardVo bv = bs.boardSelectOne(bidx);
		//�𵨿� ����ְ� ȭ������ �Ѱ��ش�.
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

		//�޼ҵ� ȣ��
		
		int value = bs.boardModify(bidx, subject, contents, writer, pwd);		
		
		System.out.println("value?"+value);
		
		String movelocation = null;
		
		if(value == 0) {
			movelocation = "redirect:/board/boardModify.do?bidx="+bidx;
		}else {
			rttr.addFlashAttribute("msg", "�����Ǿ����ϴ�.");
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

		//�޼ҵ� ȣ��
		
		int value = bs.boardDelete(bidx, pwd);		
		
		System.out.println("value?"+value);
		
		String movelocation = null;
		
		if(value == 0) {
			movelocation = "redirect:/board/boardDelete.do?bidx="+bidx;
		}else {
			rttr.addAttribute("msg", "�����Ǿ����ϴ�.");
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

		//Ʈ������� �̿��ؼ� Update, Insert ������ ���ÿ� ó��
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
