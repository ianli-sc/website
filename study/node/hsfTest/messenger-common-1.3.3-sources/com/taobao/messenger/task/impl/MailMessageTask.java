package com.taobao.messenger.task.impl;

import com.taobao.messenger.exception.MessageTaskInitException;
import com.taobao.messenger.service.common.UserInfoPrefix;
import com.taobao.messenger.task.MessageTask;
import com.taobao.messenger.utils.MailUtil;

/**
 * �����ʼ������ʼ��б�����Ա��û���ʹ������
 * 
 * @author tianhu E-mail:
 * @version ����ʱ�䣺2009-4-30 ����12:28:19
 * @see MessageTask
 * @see DefaultMessageTask
 * @see MobileMessageTask
 */
public class MailMessageTask extends DefaultMessageTask
{
    private static final long serialVersionUID = 5712631063971562132L;

    /**
     * ��ʼ�������ʼ�����
     */
    public MailMessageTask()
    {
        super(UserInfoPrefix.MAIL);
    }


    @Override
    final protected boolean isTargetValid(final String mail) throws MessageTaskInitException
    {
        //TODO:������������ж��Ƿ�Ϊ��ע���û�
        if (!super.getUserInfoPrefix().equals(UserInfoPrefix.MAIL.getValue()))
        {
            throw new MessageTaskInitException("Task tag expect MAIL,but is " + getUserInfoPrefix());
        }

        if (!MailUtil.isVaildAdress(mail))
        {
            throw new MessageTaskInitException("Target MAIL is invalid:" + mail);
        }
        return true;
    }


}
