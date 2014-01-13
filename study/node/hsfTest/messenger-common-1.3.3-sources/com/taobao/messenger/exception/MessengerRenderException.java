package com.taobao.messenger.exception;

/**
 * ģ����Ⱦ�쳣��
 * 
 * @author tianhu E-mail:
 * @version ����ʱ�䣺2009-4-27 ����02:20:55
 */

public class MessengerRenderException extends Exception
{

    private static final long serialVersionUID = 4042882280778010609L;

    public MessengerRenderException()
    {
        super("ģ����Ⱦʧ��");
    }

    public MessengerRenderException(final String msg)
    {
        super("ģ����Ⱦʧ��:" + msg);
    }

    public MessengerRenderException(final Throwable cause)
    {
        super("ģ����Ⱦʧ��", cause);
    }

    public MessengerRenderException(final String msg, final Throwable cause)
    {
        super("ģ����Ⱦʧ��:" + msg, cause);
    }
}
