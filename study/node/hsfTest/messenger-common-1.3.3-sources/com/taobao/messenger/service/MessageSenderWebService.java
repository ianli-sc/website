package com.taobao.messenger.service;

import com.taobao.messenger.exception.MessageException;

public interface MessageSenderWebService {
	
	/**
	 * WEB SERVICE�򵥽ӿ�
	 * @param address			����ͨ�����õ���� ����ռ��˵�ַ
	 * @param subject			ģ�������еı���KEY-VALUE�ԣ���ʽ key1:value1;key2:value2
	 * @param content			ģ�������еı���KEY-VALUE�ԣ���ʽ key1:value1;key2:value2
	 * @param channel			�ĸ�ͨ�����ֱ�ʶ  1, 2, 4, 8 	 �ֱ��Ӧ  	�ʼ�,����,վ����,���� 
	 * @param sourceId			����Ӧ�ñ�ʾ
	 * @param templateId		ģ��ID
	 * @param messageTypeId 	��Ϣ����ID
	 * @return
	 * @throws MessageException
	 */
	String  send(String address, String subject, String content,
			String channel, String sourceId,String templateId,String messageTypeId) throws MessageException;

}
