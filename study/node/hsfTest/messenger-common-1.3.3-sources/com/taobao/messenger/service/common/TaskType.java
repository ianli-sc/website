package com.taobao.messenger.service.common;
/**
 * ��������
 * @author huohu
 * @since 1.0, 2009-5-7 ����05:30:35
 */
public enum TaskType {
	
	/**
	 * Ĭ����������
	 */
	DEFAULT(1);
	
	private int value;
	private TaskType(int value){
		this.value = value;
	}
	public int getValue(){
		return value;
	}

}
