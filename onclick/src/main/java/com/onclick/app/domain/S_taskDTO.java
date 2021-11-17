//211027 jhr 작업
package com.onclick.app.domain;

public class S_taskDTO { //학생 과제 제출
	
	private int tidx; //과제제출인덱스
	private String tsubyn; //제출여부
	private String tsubject; //제목
	private String tdate; //작성일
	private String tcontents; //내용
	private String tdelyn; //삭제여부
	private int sidx; //학번
	private int tuidx; //과제인덱스
	private int fidx; //첨부파일 인덱스
	
	
	public int getFidx() {
		return fidx;
	}
	public void setFidx(int fidx) {
		this.fidx = fidx;
	}
	public int getTidx() {
		return tidx;
	}
	public void setTidx(int tidx) {
		this.tidx = tidx;
	}
	public String getTsubyn() {
		return tsubyn;
	}
	public void setTsubyn(String tsubyn) {
		this.tsubyn = tsubyn;
	}
	public String getTsubject() {
		return tsubject;
	}
	public void setTsubject(String tsubject) {
		this.tsubject = tsubject;
	}
	public String getTdate() {
		return tdate;
	}
	public void setTdate(String tdate) {
		this.tdate = tdate;
	}
	public String getTcontents() {
		return tcontents;
	}
	public void setTcontents(String tcontents) {
		this.tcontents = tcontents;
	}
	public String getTdelyn() {
		return tdelyn;
	}
	public void setTdelyn(String tdelyn) {
		this.tdelyn = tdelyn;
	}
	public int getSidx() {
		return sidx;
	}
	public void setSidx(int sidx) {
		this.sidx = sidx;
	}
	public int getTuidx() {
		return tuidx;
	}
	public void setTuidx(int tuidx) {
		this.tuidx = tuidx;
	}
	
}
