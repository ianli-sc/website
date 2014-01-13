package com.taobao.messenger.service.common;
/**
 * ƣ�Ͷ�����
 * @author huohu
 * @since 1.0, 2009-5-7 ����05:30:35
 */
public enum Period {
	
	/**
	 * ��
	 */
	ONEDAY(1),
	/**
	 * �ܣ����죩
	 */
	ONEWEEK(7),
	/**
	 * �£�31�죩
	 */
	ONEMONTH(31);
	
	private int value;
	private Period(int value){
		this.value = value;
	}
	public int getValue(){
		return value;
	}

}
