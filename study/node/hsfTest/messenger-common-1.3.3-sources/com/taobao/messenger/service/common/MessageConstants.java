package com.taobao.messenger.service.common;

/**
 * ��Ϣģ����Ⱦģ��ĳ�������ӿ�
 * 
 * @author afei
 * @version 2008-1-12
 */
public interface MessageConstants {
	/*********************************
	 * ���������
	 *********************************/

	/**
	 * ������Ϣ����AO��ʱ��¼��־(����)
	 */
	long INVOKE_AO_TIME_OUT = 60 * 1000;

	/**
	 * ������Ϣ��ʱ��¼��־(����)
	 */
	long INVOKE_SENDER_TIME_OUT = 3 * 1000;

	/*********************************
	 * messages.xml�б�ǩ���ƶ���
	 *********************************/
	String KEY_MESSAGES = "messages";
	String KEY_MESSAGE = "message";
	String KEY_ID = "id";
	String KEY_CHARSET = "charset";
	String KEY_FROM = "from";
	String KEY_SUBJECT = "subject";
	String KEY_TEMPLATE = "template";
	String KEY_CONTENT = "content";
	String KEY_MEMO = "memo";

	/*********************************
	 * ����TemplateContextʱʹ�õļ�����
	 *********************************/
	String KEY_USER_ID = "userId";
	String KEY_USER_NICK = "userNick";
	String KEY_MESSAGE_ID = "message_id";
	String KEY_MESSAGE_FROM = "message_from";
	String KEY_MESSAGE_SUBJECT = "message_subject";

	/****************************************************
	 * MessageNotifier����MessageNotifyAO�в���ʹ�õļ�����
	 ****************************************************/
	String KEY_AO_MESSAGE_ID = "messageId";
	String KEY_AO_MESSAGE_PARAMS = "messageParams";
	String KEY_AO_MESSAGE_TARGET = "messageTarget";
	String KEY_AO_MESSAGE_CALLBACK = "messageCallback";
	String KEY_AO_MESSAGE_TIME = "messageTime";

	/****************************************************
	 * MessageNotifier����MailNotifyAO�в���ʹ�õļ�����
	 ****************************************************/
	String KEY_MAIL = "mail";
	String KEY_MAIL_ID = "mailId";
	String KEY_MAIL_FROM_ADDRESS = "fromAddress";
	String KEY_MAIL_TO_ADDRESS = "toAddress";
	String KEY_MAIL_REPLY_TO_ADDRESS = "replyToAddress";
	String KEY_MAIL_SUBJECT = "subject";
	String KEY_MAIL_CHARSET_OVERRIDE = "charsetOverride";

	/*********************************************************
	 * MessageNotifier����MessageNotifyAOʱ����Command��Ĭ������
	 *********************************************************/
	String DEFAULT_COMMAND_DISPATCH_NAME = "commandDispatcher";
	String DEFAULT_COMMAND_AO_NAME = "messageNotifyAO";

	/*********************************************************
	 * Messageģ����Ϣ����������MessageNotifyGateway��
	 *********************************************************/
	String MESSAGE_TYPE_MAIL = "mail";
	String MESSAGE_TYPE_WANGWANG = "wangwang";
	String MESSAGE_TYPE_ARKWANGWANG = "arkWangwang";
	String MESSAGE_TYPE_SMS = "sms";
	String MESSAGE_TYPE_PMSG = "pmsg";

	public static final String DEFAULT_SPLIT_1 = ";"; // һ���ָ���
	public static final String DEFAULT_SPLIT_2 = ":"; // �����ָ���
	public static final String DEFAULT_SPLIT_3 = ","; // �����ָ���

	public static final String DEFAULT_SPLIT_FILTER = "_"; // �������ָ���
	public static final String DOT_SPLIT = ".";

	public final static String DEFAULT_EXECUTOR = "00000000";

	/*********************************************************
	 * Я������Ϣ��key-value�е�UserInfo��Ⱥ�ĵ�ַ��Ӧkey����
	 *********************************************************/
	/**
	 * �û�����id ��Ӧkey��
	 */
	public static final String TAG_USER_ID = "USER_ID";
	/**
	 * �û��ַ���id��Ӧkey��
	 */
	public static final String TAG_STR_ID = "STR_ID";
	/**
	 * �û�nick��Ӧkey��
	 */
	public static final String TAG_NICK = "NICK";
	/**
	 * �û�email��Ӧkey��
	 */
	public static final String TAG_EMAIL = "EMAIL";
	/**
	 * �����û�EMail��ʾ�ķ�����EMail��Ӧkey��
	 */
	public static final String TAG_EMAIL_FROM = "EMAIL_FROM";
	/**
	 * �����û���ʹ������Ϣ��ʾ�ķ����ߵ�Nick��Ӧkey��
	 */
	public static final String TAG_NICK_FROM = "NICK_FROM";

	/**
	 * ��UIC�鵽����Ϣ������ǵ����û�����Ϣ������ġ� ����û�����Ϣ�ӵ�USER_INFO_LIST���棬���������������
	 */
	public static final String USER_INFO_LIST = "USER_INFO_LIST";
	/**
	 * �û��ֻ������Ӧkey��
	 * 
	 */
	public static final String TAG_MOBILE_PHONE = "MOBILE_PHONE";

	/*********************************************************
	 * tair�����ռ�
	 *********************************************************/
	public static final int TAIR_NP_FAGITUE = 27;
	/**
	 * ��Ϣ����
	 */
	public static final int TAIR_NP_MSG_TYPE = 28;
	/**
	 * ��Ϣģ��
	 */

	public static final int TAIR_NP_MSG_TEMPLATE = 29;
	
	
	
	/**
	 * Tair���Ʊ��� namespace
	 */
	public static final int TAIR_NP_MSG_CONTROLLER_KEYVALUE=206;

	/**
	 * ָ��Ϊ0 ����tair�� version
	 */
	public static final int TAIR_VERSION = 0;

	/*********************************************************
	 * Notify�����ռ�
	 *********************************************************/
	public static final String NOTIFY_TOPIC = "MESSENGER";
	/**
	 * ����ֹͣnotify��Ϣ����
	 */
	public static final String NT_STOP_TASK = "msg-stop-task";
	/**
	 * ģ�����notify��Ϣ����
	 */
	public static final String NT_TEMPLET_UPDATE = "msg-templet-update";
	/**
	 * ��Ϣ���͸���notify��Ϣ����
	 */
	public static final String NT_MSG_TYPE_UPDATE = "msg-type-update";
	
	/**
	 * sourceˢ��notify��Ϣ����
	 */
	public static final String NT_SOURCE_REFRESH = "600-MSGSYNC-SOURCESYNC";
	
	/**
	 * channelˢ��notify��Ϣ����
	 */
	public static final String NT_CHANNEL_REFRESH = "500-MSGSYNC-CHANNELSYNC";

	/*********************************************************
	 * ���غͻָ�����ƫ�Ƶ�ǰʱ��ĳ��ȣ���λ��
	 *********************************************************/
	public static final long LOAD_INSURE_DATE = 60 * 60 * 24;
	public static final long RENEW_INSURE_DATE = 60 * 60 * 24 * 2;

	/*********************************************************
	 * FIXME վ���ŷ����˱�ʶ 2010-01-13
	 *********************************************************/
	public static final String PMSG_SENDER_NICKNAME = "PMSG_SENDER_NICKNAME";
	public static final String PMSG_SENDER_ID = "PMSG_SENDER_ID";

	/**
	 * վ���ŵı�ʶID
	 */
	public static final String PMSG_TASK_ID = "PMSG_TASI_ID";
	
	/**
	 * ������ʶ�� 
	 */
	public static final String ENV_PREPUB = "prepub";
	public static final String ENV_DAILY = "daily";
	public static final String ENV_PUB = "online";
	
	/**
	 * imsӪ������sourceId��
	 */
	public static final String SOURCE_IMS_MARKETING = "ims*promotion";
	public static final String SOURCE_WIRELESS_MARKETING = "wireless_galaxy_801@potian";
	
	/**
	 * ����������p4p�ƹ����Ʒid��
	 */
	public static final String WW_P4P_ITEM_KEY = "itemIdForP4p";
	
	public static final String WW_CONNECTION_PRIORITY="connectionPriority";
	
	/**
	 * �Ա�ϵͳվ���ŷ���<key, value>�������context�д��ݹ�����
	 */
	public static final String PMSG_TYPE_KEY = "pmsgType";
	public final static Integer PMSG_TYPE_OFFICIAL 	= 1;	// �ٷ���̬
	public final static Integer PMSG_TYPE_REMIND 	= 2;	// ��Ҫ����
	public final static Integer PMSG_TYPE_SERVICE 	= 3;	// ��������
	public final static Integer PMSG_TYPE_ACTIVITY 	= 4;	// �Ա��
	public final static Integer PMSG_TYPE_TRADE 	= 5;	// ��������
}
