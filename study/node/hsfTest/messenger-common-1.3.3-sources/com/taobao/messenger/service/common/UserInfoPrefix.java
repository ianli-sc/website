package com.taobao.messenger.service.common;
/**
 * 
 * @author huohu
 * @since 1.0, 2009-4-15 ����05:07:06
 */

public enum UserInfoPrefix {
	

	
	/**
	 * �����û�ID
	 */
	UID("[user.id]"),	
	/**
	 * �����û��ǳ�
	 */
	NICK("[user.nick]"),	
    /**
     * �����û�����
     */
    MAIL("[user.mail]"),
	/**
	 * �����û��ֻ�����
	 */
	PHONE("[user.phone]"),
	/**
	 * ������Ⱥ��ǩ
	 */
	TAG("[user.tag]");
	
	private String value;
	private UserInfoPrefix(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
	
	public String toString(){
		return value;
	}

}
