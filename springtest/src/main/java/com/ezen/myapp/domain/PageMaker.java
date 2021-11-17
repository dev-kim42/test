package com.ezen.myapp.domain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;

@Component
public class PageMaker { //페이징 처리 클래스
	
	private int totalCount;
	private int startPage;
	private int endPage;
	private int displayPageNum = 10; // 페이지 개수: 1 2 3.... 10
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
		/* 넘어오는 페이징 데이터를 계산해주는 메소드 생성
		 * startPage 값과 endPage 값을 정의 
		 * 이전, 다음 버튼 여부를 결정 */ 
		
		/* cri.getPage() = 페이지 값을 받는 메소드(Criteria 클래스를 cri으로 객체 생성)
		 * Math.ceil() : 괄호안의 값을 소수점을 제거하여 올림처리
		 * 	(입력받은 값보다 크거나 같은 정수 중 가장 작은 정수 리턴)
		 * Page 시작값, 마지막값 설정 방법
		 * endPage = 표현 페이지 값(x로 나눈 전체 페이지 수 ex.100개의 데이터 = 8개의 페이지) / 화면에 표시할 페이지 넘버(더블로 나눠서 소수점 자리 표시)
		 * endPage -> 마지막 페이지 값을 정의(Ex. 데이터 수가 1~10 안의 페이지로 표현 가능할 때 마지막 페이지는 10 11~20이면 20.)
		 * tempEndPage -> 실제 마지막 페이지 ( totalCount : 페이징 처리할 데이터 숫자 / 1페이지 당 표시할 데이터 수)를 표시 
		 */
		
		endPage = (int)(Math.ceil(scri.getPage()/(double)displayPageNum) * displayPageNum);
		
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int) Math.ceil(totalCount/(double)scri.getPerPageNum());		
		
		// if 구문을 활용하여 마지막 페이지의 값이 실제 표현되는 마지막 페이지 값보다 
		// 크면 마지막 페이지를 실제 표현되는 값으로 변환		
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
