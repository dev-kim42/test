package com.ezen.myapp.domain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;

@Component
public class PageMaker { //����¡ ó�� Ŭ����
	
	private int totalCount;
	private int startPage;
	private int endPage;
	private int displayPageNum = 10; // ������ ����: 1 2 3.... 10
	private boolean prev;
	private boolean next;
	private SearchCriteria scri;
	private Criteria cri;
		
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}	
	public SearchCriteria getScri() {
		return scri;
	}
	public void setScri(SearchCriteria scri) {
		this.scri = scri;
	}	
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public void calcData() { 
		/* �Ѿ���� ����¡ �����͸� ������ִ� �޼ҵ� ����
		 * startPage ���� endPage ���� ���� 
		 * ����, ���� ��ư ���θ� ���� */ 
		
		/* cri.getPage() = ������ ���� �޴� �޼ҵ�(Criteria Ŭ������ cri���� ��ü ����)
		 * Math.ceil() : ��ȣ���� ���� �Ҽ����� �����Ͽ� �ø�ó��
		 * 	(�Է¹��� ������ ũ�ų� ���� ���� �� ���� ���� ���� ����)
		 * Page ���۰�, �������� ���� ���
		 * endPage = ǥ�� ������ ��(x�� ���� ��ü ������ �� ex.100���� ������ = 8���� ������) / ȭ�鿡 ǥ���� ������ �ѹ�(����� ������ �Ҽ��� �ڸ� ǥ��)
		 * endPage -> ������ ������ ���� ����(Ex. ������ ���� 1~10 ���� �������� ǥ�� ������ �� ������ �������� 10 11~20�̸� 20.)
		 * tempEndPage -> ���� ������ ������ ( totalCount : ����¡ ó���� ������ ���� / 1������ �� ǥ���� ������ ��)�� ǥ�� 
		 */
		
		endPage = (int)(Math.ceil(scri.getPage()/(double)displayPageNum) * displayPageNum);
		
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int) Math.ceil(totalCount/(double)scri.getPerPageNum());		
		
		// if ������ Ȱ���Ͽ� ������ �������� ���� ���� ǥ���Ǵ� ������ ������ ������ 
		// ũ�� ������ �������� ���� ǥ���Ǵ� ������ ��ȯ		
		if( endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		//System.out.println("endPage ="+ endPage);
		//System.out.println("startPage ="+ startPage);
		
		prev = startPage == 1 ? false : true;
		next = endPage*scri.getPerPageNum() >= totalCount ? false : true;		
	}
	public String encoding(String keyword) {
		
		String keyword2 = null;
		
		if(keyword == null || keyword.trim().length() == 0) {
			keyword2 = "";
		}		
		try {			
			keyword2 = URLEncoder.encode(keyword, "UTF-8");
		}catch(UnsupportedEncodingException e) {			
			e.printStackTrace();
			keyword2 = "";
		}
		
		return keyword2;
	}
	
	
	
}
