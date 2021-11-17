package com.onclick.app.domain;

public class FileVO { //첨부파일
	
	private int fidx; //첨부파일인덱스
	private String ftype; //확장자명
	private String froute; //경로
	private String fdelyn; //삭제여부
	private String fsavedname; //저장된 이름
	private String foriginname; //파일 원래 이름
	
	
	public String getFsavedname() {
		return fsavedname;
	}
	public void setFsavedname(String fsavedname) {
		this.fsavedname = fsavedname;
	}
	public String getForiginname() {
		return foriginname;
	}
	public void setForiginname(String foriginname) {
		this.foriginname = foriginname;
	}
	
	public int getFidx() {
		return fidx;
	}
	public void setFidx(int fidx) {
		this.fidx = fidx;
	}

	public String getFtype() {
		return ftype;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	public String getFroute() {
		return froute;
	}
	public void setFroute(String froute) {
		this.froute = froute;
	}
	public String getFdelyn() {
		return fdelyn;
	}
	public void setFdelyn(String fdelyn) {
		this.fdelyn = fdelyn;
	}

}
