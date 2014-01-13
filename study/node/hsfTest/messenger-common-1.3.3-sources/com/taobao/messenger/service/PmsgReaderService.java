package com.taobao.messenger.service;

public interface PmsgReaderService {

	/**
	 * �����û�����ID��ѯINBOX����û���Ķ���վ��������
	 * @param recipientId �û�����ID
 	 * @return Integer ����δ�� վ��������  ����ѯ�쳣 ����-1
	 */
   public Integer  queryInboxPmsgCountNotReadByRecipientId(Long recipientId);
   
   /**
    * �����û��ǳƲ�ѯINBOX����û���Ķ���վ��������
    * @param nick 
    * @return Integer ����δ��վ�������� ����ѯ�쳣 ����-1
    */
   public Integer  queryInboxPmsgCountNotReadByNick(String nick);
}
