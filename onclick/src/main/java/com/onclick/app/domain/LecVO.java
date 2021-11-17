package com.onclick.app.domain;

public class LecVO { //강의
	
	private int lidx; //강의고유번호
	private String lname; //강의명
	private String lplan; //강의계획서
	private int lgrade; //학점
	private String ldelyn;
	private int ldiv; //분반
	private int pidx; //교수 사번
	
	public int getLidx() {
		return lidx;
	}
	public void setLidx(int lidx) {
		this.lidx = lidx;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLplan() {
		return lplan;
	}
	public void setLplan(String lplan) {
		this.lplan = lplan;
	}
	public int getLgrade() {
		return lgrade;
	}
	public void setLgrade(int lgrade) {
		this.lgrade = lgrade;
	}
	public String getLdelyn() {
		return ldelyn;
	}
	public void setLdelyn(String ldelyn) {
		this.ldelyn = ldelyn;
	}
	public int getLdiv() {
		return ldiv;
	}
	public void setLdiv(int ldiv) {
		this.ldiv = ldiv;
	}
	public int getPidx() {
		return pidx;
	}
	public void setPidx(int pidx) {
		this.pidx = pidx;
	}
	
	
}
