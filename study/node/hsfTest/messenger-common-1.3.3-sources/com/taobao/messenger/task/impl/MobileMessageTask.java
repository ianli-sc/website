package com.taobao.messenger.task.impl;

import com.taobao.messenger.exception.MessageTaskInitException;
import com.taobao.messenger.service.common.UserInfoPrefix;
import com.taobao.messenger.task.MessageTask;
import com.taobao.messenger.utils.MobilePhoneUtil;

/**
 * �����ֻ�������Ϣ�����ֻ��б�����Ա��û���ʹ���ֻ�
 * 
 * @author tianhu E-mail:
 * @version ����ʱ�䣺2009-4-30 ����12:28:19
 * @see MessageTask
 * @see DefaultMessageTask
 * @see MailMessageTask
 */
public class MobileMessageTask extends DefaultMessageTask
{
    private static final long serialVersionUID = 5712631063971562132L;

    /**
     * ��ʼ�������ֻ���������
     */
    public MobileMessageTask()
    {
        super(UserInfoPrefix.PHONE);
    }

    @Override
    final protected boolean isTargetValid(final String phone) throws MessageTaskInitException
    {
        // TODO:��������ֻ��ж��Ƿ�Ϊ��ע���û�
        if (!super.getUserInfoPrefix().equals(UserInfoPrefix.PHONE.getValue()))
        {
            throw new MessageTaskInitException("Task tag expect PHONE,but is " + super.getUserInfoPrefix());
        }
        if (!MobilePhoneUtil.isVaildAdress(phone))
        {
            throw new MessageTaskInitException("Target PHONE is invalid:" + phone);
        }

        return true;
    }

}
