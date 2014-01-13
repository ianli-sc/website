package com.taobao.messenger.exception;

/**
 * ����̨�����쳣��<br>
 * ���쳣��message�Լ�causeƴ��Ϊ�ַ����׳������⽫�޷������л�Throwable�׳����ͻ���
 * 
 * @author tianhu E-mail:
 * @version ����ʱ�䣺2009-4-27 ����02:20:55
 */
// TODO: �����
public class MessengerManageException extends Exception {
	private static final long serialVersionUID = 3066155589655543589L;

	public MessengerManageException() {
		super();
	}

	public MessengerManageException(final String msg) {
		super(msg);
	}

	/**
	 * ���쳣message�Լ�causeƴ��Ϊ�ַ����׳������⽫�޷������л�Throwable�׳����ͻ���
	 * 
	 * @param cause
	 */
	public MessengerManageException(final Throwable cause) {
		super(transCauseToMessage(cause));
	}

	/**
	 * ��message���쳣message�Լ�causeƴ��Ϊ�ַ����׳������⽫�޷������л�Throwable�׳����ͻ���
	 * 
	 * @param msg
	 * @param cause
	 */
	public MessengerManageException(final String msg, final Throwable cause) {
		super(msg + transCauseToMessage(cause));
	}

	/**
	 * ���쳣message�Լ�causeƴ��Ϊ�ַ���
	 * 
	 * @param cause
	 * @return
	 */
	private static String transCauseToMessage(final Throwable cause) {
		final StringBuffer stringBuffer = new StringBuffer();
		if (cause.getMessage() != null) {
			stringBuffer.append(cause.getMessage());
		}
		if (cause.getCause() != null && cause.getCause().getMessage() != null) {
			stringBuffer.append("cause:" + cause.getCause().getMessage());
		}
		return stringBuffer.toString();
	}
}
