package com.onclick.app.domain;

public class FileVO { //÷������
	
	private int fidx; //÷�������ε���
	private String ftype; //Ȯ���ڸ�
	private String froute; //���
	private String fdelyn; //��������
	private String fsavedname; //����� �̸�
	private String foriginname; //���� ���� �̸�
	
	
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
