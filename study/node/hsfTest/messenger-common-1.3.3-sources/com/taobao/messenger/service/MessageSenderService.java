package com.taobao.messenger.service;

import java.util.Map;

import com.taobao.messenger.exception.MessageException;
import com.taobao.messenger.service.common.Channel;
import com.taobao.messenger.service.notify.MessageNotifiee;
import com.taobao.messenger.task.MessageTask;
import com.taobao.messenger.task.TaskResult;

/**
 * ��Ϣ���ͷ���<br>
 * ���÷�ʽ��<br>
 * <code>
 * {@code
 * <bean id="messageSenderService"
 *      class="com.taobao.hsf.app.spring.util.HSFSpringConsumerBean"
 *      init-method="init">
 *   <property name="interfaceName">
 *      <value>com.taobao.messenger.service.MessageSenderService</value>
 *   </property>
 * </bean>
 * }
 * </code>
 */
public interface MessageSenderService {

	/***************************************************************************
	 * �ɷ���ģ����Ϣ���ͽӿ�,�ѷ���
	 * 
	 * @param targets
	 *            Map<String, MessageNotifiee> target ��Ϣ���Ͷ���
	 *            {("wangwang",messageTarget),("mail",mailTarget),("arkWangwang"
	 *            ,messageTarget),("sms",messageTarget),("pmsg",messageTarget)
	 *            ...}
	 * @param messageId
	 *            String ��Ϣ����ID<message/>����<mail/>
	 * @param context
	 *            Map<String, Object>
	 *            ��Ϣģ���NotifyAO���õ��Ĳ���(DefaultMessageNotifyAO/MailNotifyAO)
	 * @exception MessageException
	 **************************************************************************/
	@Deprecated
	void send(Map<String, MessageNotifiee> targets) throws MessageException;

	/**
	 * ���ͼ�ʱ��Ϣ����
	 * 
	 * @param task
	 *            {@link MessageTask} ����Ŀ���û�targets������ģ�������������ʱ����Ϣ�� ��Ϣ�����������
	 * @return {@link TaskResult} �����Ƿ�ɹ����ա�
	 *         <ul>
	 *         <li>�Ѿ�����ϵͳ�����������쳣ʱ������ʧ��,ͨ��{@link TaskResult#getInfo()}��ȡʧ��ԭ��;</li>
	 *         <li>���ɹ����ս����������Ӧid����ͨ�� {@link TaskResult#getTaskID()}��ȡ</li>
	 *         </ul>
	 * @throws MessageException
	 *             �紫������Ƿ����������쳣���׳�
	 */

	TaskResult send(MessageTask task) throws MessageException;

	/**
	 * �ύ��ʱִ��������Ϣ
	 * 
	 * @param task
	 *            {@link MessageTask} ����Ŀ���û�targets������ģ�������������ʱ����Ϣ�� ��Ϣ�����������
	 * @return {@link TaskResult} �����Ƿ�ɹ����ա�
	 *         <ul>
	 *         <li>�Ѿ�����ϵͳ�����������쳣ʱ������ʧ��,��ͨ��{@link TaskResult#getInfo()}��ȡʧ��ԭ��;</li>
	 *         <li>���ɹ����ս����������Ӧid����ͨ�� {@link TaskResult#getTaskID()}��ȡ</li>
	 *         </ul>
	 * @throws MessageException
	 *             �紫������Ƿ����������쳣���׳�
	 */
	TaskResult submit(MessageTask task) throws MessageException;

	/**
	 * ��ʱ����
	 * @param address  ���͵�ַ, �ֻ����룬���� �ʼ���ַ������������
	 * @param subject  ��������
	 * @param content  ��������
	 * @param channel  ͨ��ѡ��
	 * @param sourceId  ����Դ��ַ
	 * @return
	 * @throws MessageException
	 */
	TaskResult send(String address, String subject, String content,
			Channel channel, String sourceId) throws MessageException;
	
}
