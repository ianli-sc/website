package com.taobao.messenger.task;

import java.io.Serializable;

/**
 * ������Ϣ��������������
 * ���������ӦΨһid
 * @author huohu
 * @since 1.0, 2009-4-3 ����10:33:00
 */
public interface TaskResult extends Serializable{

	/**
	 * ��ȡtaskID
	 * @return  ����ID
	 */
	public long getTaskID();

    /**
     * ����taskID
     * @param taskID
     */
    public void setTaskID(long taskID);

	/**
	 * �ж���������Ƿ�ɹ�
	 * @return  �����Ƿ񱻳ɹ�����MessageCenter
	 */
	public boolean isSuccess();
	/**
	 * ��ȡ���ؽ����Ϣ
	 * @return  ��ȡ���ظ�Ӧ�õ���Ϣ
	 */
	public String getInfo();
	
	/**
	 * ���ý��Ϊʧ�ܲ���¼ʧ����Ϣ
	 * @param info ʧ����Ϣ
	 */
	public void setFailure(String info);
	
	/**
	 * ���÷�����Ϣ
	 * @param info ������Ϣ
	 */
	public void setInfo(String info);
	
	/**
	 * ���ý��Ϊ�ɹ� 
	 */
	public void setSuccess();
}
