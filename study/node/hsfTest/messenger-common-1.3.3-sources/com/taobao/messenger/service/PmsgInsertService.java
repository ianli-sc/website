package com.taobao.messenger.service;

import java.util.Date;
import java.util.List;

public interface PmsgInsertService {
	/**
	 * ����վ����ѹ������
	 * @param recipient_id
	 * @param recipient_nick
	 * @param sender_id
	 * @param sender_nick
	 * @param subject
	 * @param body
	 * @return
	 */
	public long sendPmsgPerformance(long pmsg_id,long recipient_id,String recipient_nick,
			long sender_id,String sender_nick,
			String subject,String body,
			Date gmt_create,
			Date gmt_modified,
			byte status,
			byte deleted,
			String send_ip);
	
	

  public long sendDraftPmsg(long pmsg_id,long sender_id,
		  String sender_nick,long recipient_id,String recipient_nick,String subject ,String body,Date gmt_create,Date gmt_modified,byte status,byte deleted);
	/**
	 * ����pmsg_id
	 * @param pmsg_id
	 * @return
	 */
	public int updatePmsgStatus(long pmsg_id);
	
	
	/**
	 * ��������id��ѯpmsg
	 * @param pmsg_id
	 * @return
	 */
	public Object selectPmsgById(long pmsg_id);
	
	/**
	 * ����recipientId��ѯվ��������
	 * @param recipientId
	 * @return
	 */
	public int countPmsgByRecientId(long recipientId);
	
	/**
	 * ��������id����ɾ��
	 * @param pmsgIds
	 * @return
	 */
	public int deletePmsgChecked(String pmsgIds);
	
	
	public List<Object> selectPmsgsByRecipientId(long recipientId,boolean isAdmin,int startNum);
	
	public boolean sendEmailPerformance(String mailFrom,String mailTo,String subject,String content);

	
	public void downloadFile();
}
