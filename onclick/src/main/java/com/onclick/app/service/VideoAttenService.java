//211027 jhr �۾�
package com.onclick.app.service;

import java.util.HashMap;

import com.onclick.app.domain.VideoAttenDto;

public interface VideoAttenService {


	//���� ��û�� ��û��� ������Ʈ
	public int videoUpdate(VideoAttenDto vd);
	
	//���� ��û ��� ��������
	public VideoAttenDto videoSelectOne(int sidx, int cidx);
}