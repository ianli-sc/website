/**
 * 
 */
package com.taobao.messenger.service.notify;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.taobao.messenger.service.common.MessageConstants;

/**
 * ��Ϣ����Ŀ��,������Ա����nick��id�ͽ�����Ϣ�ĵ�ַaddress, ������email��ַ, Ҳ����������nick
 * ��Ϣ����ǰ����Ϣģ��ɰ汾����ʵ�֣��𲽷���
 * @author afei
 * @version 2008-1-10
 */
@Deprecated
public class MessageNotifiee implements Serializable {
    private static final long serialVersionUID = -4447098172073301877L;

    /**
     * ָ��ͨ��������Ϣ���ͳ���
     * */
    public static final String wangwang="arkWangwang" ;
    /**
     * ָ��ͨ���ʼ����ͳ���
     * */
    public static final String mail="mail" ;
    /**
     * ָ��ͨ��վ���ŷ��ͳ���
     * */
    public static final String pmsg="pmsg" ;

    /**
     * ָ��ͨ�����ŷ��Ͳ���
     * */
    public static final String sms = "sms" ;

    /**
     * ��Ա����, ��ѡ
     */
    /*private String userNick;*/



    /**
     * ������Ϣ�ĵ�ַaddress, ������email��ַ, Ҳ����������nick, Ҳ������վ���Ż�Աid  ����
     * �����ö���","�ͷֺ�";"ָ�����Ͷ����ַ
     */
    private String toAddress;


    /**
     * ������Ϣ�ĵ�ַ��Ӧ���û�,ֻ���ڷ���վ����ʱ��Ҫ�����ұ��룬��������Ҫ
     * �����ö���","�ͷֺ�";"ָ�����Ͷ����ַ
     */
    private String toAddressNicks ;
    /*private String toAddressIds;*/


    /**
     * ��Ϣ����ģ��id
     * */
    private String messageId;

    /**
     * ��MessageNotifiee��ĳЩ�����TempletContext
     * �ڵ���setXXX()ʱͬʱ����context��
     */
    private Map<String, String> context = new HashMap<String, String>();

    /**
     * ��ԱID, ��ѡ
     */
    private String userId;

    /**
     * ������Ϣ����
     * **/
    private Integer msgType;

    /**
     * email��ַ
     * **/
    /*  private String email ;*/

    /*****************
     * ҵ�񷽷���ʼ
     *****************/



    @Override
    public String toString() {
        return messageId + "-" + toAddress;
    }

    /**
     * �жϱ���������Ƿ�������
     * @return boolean
     */
    public boolean isValid() {
        if (isBlank(toAddress))
        {
            return false;
        }

        if (isBlank(messageId))
        {
            return false;
        }
        return true;
    }

    /*****************
     * ҵ�񷽷�����
     *****************/

    /*public String getUserNick() {
        return this.userNick;
    }*/

    public String getUserId() {
        return userId;
    }

    public String getToAddress() {
        return toAddress;
    }

    /*   public void setUserNick(String userNick) {
        this.userNick = userNick;
        this.context.put(MessageConstants.KEY_USER_NICK, this.userNick);
    }*/

    public void setUserId(final String userId) {
        this.userId = userId;
        context.put(MessageConstants.KEY_USER_ID, this.userId);
    }

    public void setToAddress(final String toAddress) {
        this.toAddress = toAddress;
    }

    public Map<String, String> getContext() {
        return context;
    }

    public void setContext(final Map<String, String> context) {
        this.context = context;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(final Integer msgType) {
        this.msgType = msgType;
    }

    /*public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}*/

    /*	public String getToAddressIds() {
		return toAddressIds;
	}

	public void setToAddressIds(String toAddressIds) {
		this.toAddressIds = toAddressIds;
	}*/

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(final String messageId) {
        this.messageId = messageId;
    }

    public String getToAddressNicks() {
        return toAddressNicks;
    }

    public void setToAddressNicks(final String toAddressNicks) {
        this.toAddressNicks = toAddressNicks;
    }

    public void addToAddress(final String address){
        if(toAddress==null) {
            toAddress = address;
            return ;
        }
        toAddress +="," + address;
    }

    public void addToAddressNicks(final String nick){
        toAddressNicks +="," + nick;
    }

    /**
     * ����ַ����Ƿ��ǿհף�<code>null</code>�����ַ���<code>""</code>��ֻ�пհ��ַ���
     * 
     * <pre>
     * StringUtil.isBlank(null)      = true
     * StringUtil.isBlank(&quot;&quot;)        = true
     * StringUtil.isBlank(&quot; &quot;)       = true
     * StringUtil.isBlank(&quot;bob&quot;)     = false
     * StringUtil.isBlank(&quot;  bob  &quot;) = false
     * </pre>
     * 
     * @param str Ҫ�����ַ���
     * @return ���Ϊ�հ�, �򷵻�<code>true</code>
     */
    public static boolean isBlank(final String str)
    {
        int length;

        if ((str == null) || ((length = str.length()) == 0))
        {
            return true;
        }

        for (int i = 0; i < length; i++)
        {
            if (!Character.isWhitespace(str.charAt(i)))
            {
                return false;
            }
        }

        return true;
    }

}
