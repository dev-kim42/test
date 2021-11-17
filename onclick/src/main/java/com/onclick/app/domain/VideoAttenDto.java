//211027 jhr 작업
package com.onclick.app.domain;

//video-class join
public class VideoAttenDto {

	private int vidx; /* 동영상 출석 인덱스 */
	private int vfull; /* 동영상총시간 */
	private int vpercent; /* 시청기록 */
	private int vlevel; /* 강의난이도 */
	private String vattendence;  /* 동영상수강여부/출석 */
	private String vlast; /* 마지막접속일 */
	private int vstart; /* 재생시작시간 */
	private int vend; /* 재생종료시간 */
	private int sidx; /* 학번 */
	private int cidx; /* 강좌별 고유번호 */
	
	public int getVidx() {
		return vidx;
	}
	public void setVidx(int vidx) {
		this.vidx = vidx;
	}
	public int getVfull() {
		return vfull;
	}
	public void setVfull(int vfull) {
		this.vfull = vfull;
	}
	public int getVpercent() {
		return vpercent;
	}
	public void setVpercent(int vpercent) {
		this.vpercent = vpercent;
	}
	public int getVlevel() {
		return vlevel;
	}
	public void setVlevel(int vlevel) {
		this.vlevel = vlevel;
	}
	public String getVattendence() {
		return vattendence;
	}
	public void setVattendence(String vattendence) {
		this.vattendence = vattendence;
	}
	public String getVlast() {
		return vlast;
	}
	public void setVlast(String vlast) {
		this.vlast = vlast;
	}
	public int getVstart() {
		return vstart;
	}
	public void setVstart(int vstart) {
		this.vstart = vstart;
	}
	public int getVend() {
		return vend;
	}
	public void setVend(int vend) {
		this.vend = vend;
	}
	public int getSidx() {
		return sidx;
	}
	public void setSidx(int sidx) {
		this.sidx = sidx;
	}
	public int getCidx() {
		return cidx;
	}
	public void setCidx(int cidx) {
		this.cidx = cidx;
	}
	
	
}
