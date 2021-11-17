package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.S_taskDTO;

public interface S_taskService_Mapper {

	//�����Ǿ��ִ� ���� ��ȣ ��������
	public int s_taskTidx(int sidx, int tuidx);
	
	//���� ����
	public int s_taskUpdate(HashMap<String,Object> hm);
	
	//���� ����
	public int s_taskFileInsert(HashMap<String,Object> stuTaskFile);
	
	//������ ���� ���뺸��
	public S_taskDTO s_taskSelectOne(int tidx);
	
	//���� ����
	public int s_taskModify(HashMap<String,Object> hm);
	
	//�л��� ���� ���(���� ������ ������Ȳ)
	public ArrayList<S_taskDTO> taskSubmitList(int tuidx);

	//�л� ���� ���� ��������
	public S_taskDTO stuTask(int sidx);
	
	//�л� ������ ���� ����
	public int s_taskDelete(int tidx);
}
