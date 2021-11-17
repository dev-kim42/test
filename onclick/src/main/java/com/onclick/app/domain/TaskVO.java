package com.onclick.app.domain;

public class TaskVO { //교수님 과제 업로드

	private int tuidx; //과제 인덱스
	private String tuname; //과제 제목
	private String tustart; //제출 시작일
	private String tufin; //제출 종료일
	private String tudate; //작성일
	private String tunotyn; //알림 여부
	private String tudelyn;
	private int lidx; //강의고유번호
	private String tucontents; //과제 내용
	private int fidx; //첨부파일 번호
	
	public int getFidx() {
		return fidx;
	}
	public void setFidx(int fidx) {
		this.fidx = fidx;
	}
	public String getTucontents() {
		return tucontents;
	}
	public void setTucontents(String tucontents) {
		this.tucontents = tucontents;
	}
	public int getTuidx() {
		return tuidx;
	}
	public void setTuidx(int tuidx) {
		this.tuidx = tuidx;
	}
	public String getTuname() {
		return tuname;
	}
	public void setTuname(String tuname) {
		this.tuname = tuname;
	}
	public String getTustart() {
		return tustart;
	}
	public void setTustart(String tustart) {
		this.tustart = tustart;
	}
	public String getTufin() {
		return tufin;
	}
	public void setTufin(String tufin) {
		this.tufin = tufin;
	}
	public String getTudate() {
		return tudate;
	}
	public void setTudate(String tudate) {
		this.tudate = tudate;
	}
	public String getTunotyn() {
		return tunotyn;
	}
	public void setTunotyn(String tunotyn) {
		this.tunotyn = tunotyn;
	}
	public String getTudelyn() {
		return tudelyn;
	}
	public void setTudelyn(String tudelyn) {
		this.tudelyn = tudelyn;
	}
	public int getLidx() {
		return lidx;
	}
	public void setLidx(int lidx) {
		this.lidx = lidx;
	}
	
	
}
