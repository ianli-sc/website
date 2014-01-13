/**
 * 
 */
package com.taobao.messenger.service.notify;

import com.taobao.messenger.service.common.MessageConstants;

/**
 * ��ӦMailNotifyAO�е�Command�������
 * ��Ϣ����ǰ����Ϣģ��ɰ汾���ݽӿڣ��𲽷���
 * @author afei
 * @version 2008-1-12
 */
@Deprecated
public class MailNotifiee extends MessageNotifiee {
    private static final long serialVersionUID = 3976570945182818003L;
    
    /**
     * ��Դ��ַ, ��ѡ
     */
    private String fromAddress;
    
    /**
     * �ظ���ַ, ��ѡ
     */
    private String replyToAddress;
    
    /**
     * �ʼ����⸲��mail.xml������, ��ѡ
     */
    private String subject;
    
    /**
     * �ʼ����븲��mail.xml������, ��ѡ
     */
    private String charsetOverride;

    public String getFromAddress() {
        return this.fromAddress;
    }

    public String getReplyToAddress() {
        return this.replyToAddress;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getCharsetOverride() {
        return this.charsetOverride;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
        this.getContext().put(MessageConstants.KEY_MAIL_FROM_ADDRESS, this.fromAddress);
    }

    public void setReplyToAddress(String replyToAddress) {
        this.replyToAddress = replyToAddress;
        this.getContext().put(MessageConstants.KEY_MAIL_REPLY_TO_ADDRESS, this.replyToAddress);
    }

    public void setSubject(String subject) {
        this.subject = subject;
        this.getContext().put(MessageConstants.KEY_MAIL_SUBJECT, this.subject);
    }

    public void setCharsetOverride(String charsetOverride) {
        this.charsetOverride = charsetOverride;
        this.getContext().put(MessageConstants.KEY_MAIL_CHARSET_OVERRIDE, this.charsetOverride);
    }
}
