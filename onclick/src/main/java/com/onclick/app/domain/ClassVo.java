//211027 jhr 작업
package com.onclick.app.domain;

public class ClassVo {

	private int cidx;  /* 강좌별 고유번호 */
	private String cname;  /* 강의명 */
	private String ccontents;/* 내용 */
	private String cdate; /* 작성일 */
	private String csta;/* 출석 인정 시작일 */
	private String cfin; /* 출석 인정 마감일 */
	private String creyn;/* 다시보기 여부 */
	private int cweek; /* 강의 주차 */
	private int cseq; /* 주차별순서 */
	private String cfile; /* 첨부파일 */
	private String cnotyn;/* 알림 여부 */
	private String cdelyn; /* 삭제 여부 */
	private int lidx;/* 강의 고유번호 */

	public int getCidx() {
		return cidx;
	}
	public void setCidx(int cidx) {
		this.cidx = cidx;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCcontents() {
		return ccontents;
	}
	public void setCcontents(String ccontents) {
		this.ccontents = ccontents;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getCsta() {
		return csta;
	}
	public void setCsta(String csta) {
		this.csta = csta;
	}
	public String getCfin() {
		return cfin;
	}
	public void setCfin(String cfin) {
		this.cfin = cfin;
	}
	public String getCreyn() {
		return creyn;
	}
	public void setCreyn(String creyn) {
		this.creyn = creyn;
	}
	public int getCweek() {
		return cweek;
	}
	public void setCweek(int cweek) {
		this.cweek = cweek;
	}
	public int getCseq() {
		return cseq;
	}
	public void setCseq(int cseq) {
		this.cseq = cseq;
	}
	public String getCfile() {
		return cfile;
	}
	public void setCfile(String cfile) {
		this.cfile = cfile;
	}
	public String getCnotyn() {
		return cnotyn;
	}
	public void setCnotyn(String cnotyn) {
		this.cnotyn = cnotyn;
	}
	public String getCdelyn() {
		return cdelyn;
	}
	public void setCdelyn(String cdelyn) {
		this.cdelyn = cdelyn;
	}
	public int getLidx() {
		return lidx;
	}
	public void setLidx(int lidx) {
		this.lidx = lidx;
	}
	
	
	
}
