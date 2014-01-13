package com.taobao.messenger.task;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.taobao.messenger.exception.MessageTaskInitException;
import com.taobao.messenger.service.MessageSenderService;
import com.taobao.messenger.service.common.Channel;

/**
 * ������Ϣ�����������ݵ�Ԫ��<br>
 * ��������Ŀ��{@link #addTarget}����Ϣ����{@link #setMessageTypeId}������ƻ�ִ��ʱ��{@link #setScheduleTime}���Ƿ���Ҫ������־�
 * {@link #setPersistence}�������Ҫ��Ϣ<br>
 * <li>��ʼ��ʧ�ܽ��׳� {@link MessageTaskInitException}<br> <li>����������ɺ󣬿�ͨ��{@code isValid()}У���Ƿ��Ѿ������Ҫ������<br>
 * �������ɳɹ���ͨ��{@link MessageSenderService#send}��{@link MessageSenderService#submit}�ӿڷ�������<br>
 * 
 * @author tianhu
 * 
 */
public interface MessageTask extends Serializable
{

    public static final String TARGET_SPLIT = ",";
    public static final String KEYVALUE_SPLIT = "=";
    public static final int MAX_TARGETS_LENGTH = 800;

    /**
     * �ж��Ƿ������˱�Ҫ�Ĳ���
     * 
     * @return true-���б�Ҫ�����Ѿ�����
     */
    public boolean isValid();

    /**
     * @return ������ID
     */
    public String getSourceId();

    /**
     * ���÷�����Դ��Ĭ��Ϊ0-��ʹ��ϵͳĬ�Ϸ���Դ��Ϣ
     * @param sourceId ������ID, ��ѡ
     * @throws MessageTaskInitException
     */
    public void setSourceId(String sourceId) throws MessageTaskInitException;

    /**
     * ��ȡ���з���Ŀ���û�
     * 
     * @return ������Ϣ��user�б��������ַ�����-�綺��","��ֺ�";"
     */
    public String getTargets();

    /**
     * ���Ŀ���û���һ��ֻ�����һ���û���
     * 
     * @param target ��Ӧ�û���ʾ
     * @return ��ǰ�Ѿ�����û�����
     * @throws MessageTaskInitException target�����϶�Ӧʵ��Լ����prefix����ȷ�����׳��쳣���Ѽ���������������������
     */
    public int addTarget(String target) throws MessageTaskInitException;

    /**
     * �������ڴ�������Ⱥ���ͣ����ڱ�ʾ��Ⱥ��Դ��Ϣ�ı�ǩ
     * @param tag ��Ⱥ��ǩ
     * @param targetsNum Ŀ����Ⱥ����
     * @throws MessageTaskInitException tag�����϶�Ӧʵ��Լ����Ŀ����Ⱥ��=<0ʱ�׳��쳣
     */
    public void setTag(String tag, int targetsNum) throws MessageTaskInitException;

    /**
     * �������Ŀ�����(For test)
     */
    public void clearTargets();

    /**
     * @return �����û�ǰ׺��ID��Mail��Phone��Tag
     */
    public String getUserInfoPrefix();

    /**
     * ��ȡĿ���û����� ��target��ʽ�����û���targetsNum��Ϊtarget�ڵ���Ŀ ��taggedTarget��ʽ�����û���targetsNum��Ϊ����ǵ��û�Ⱥ����
     * 
     * @return Ŀ���û���
     */
    public int getTargetsNum();

    /**
     * ��ȡ����ģ����Ⱦ����ز����Լ�����ֵ
     * 
     * @return ����ģ����Ⱦ��Key-Value��ֵ��
     */
    public Map<String, Object> getContext();

    /**
     * ��������������Ϣģ����Ⱦ����ز����Լ�����ֵ<br>
     * ��Ϣ�ı�����������������key-value�Ծ���ͨ���˷���ָ��<br>
     * 
     * @param context ����ģ����Ⱦ��Key-Value��ֵ�ԣ�Ŀǰ��֧��{@code Map<String, String>}
     * @throws MessageTaskInitException contextΪnull��context�а���null��key-valueʱ�׳�
     */
    public void setContext(Map<String, Object> context) throws MessageTaskInitException;

    /**
     * ���������Ϣģ����Ⱦ����ز����Լ�����ֵ��<br>
     * ��Ϣ�ı�����������������key-value�Ծ���ͨ���˷�����ӣ�<br>
     * �Ѿ�����key��������
     * 
     * @param key ��Ⱦ����key
     * @param value ��Ⱦ����value��Ŀǰ��֧��{@code String} ����
     * @throws MessageTaskInitException key-valueΪnull
     */
    public void addContext(String key, Object value) throws MessageTaskInitException;

    /**
     * ��ȡ����ID�����ã�Ŀǰ��ʵ�����壩
     * 
     * @return ����ID
     */
    public String getTaskId();

    /**
     * ��������ID�����ã�Ŀǰ��ʵ�����壩
     * 
     * @param taskId
     * @throws MessageTaskInitException
     */
    public void setTaskId(String taskId) throws MessageTaskInitException;

    /**
     * ��ȡ�ƻ�����ʱ��
     * 
     * @return ��ʱ���͵�ʱ��
     */
    public Date getScheduleTime();

    /**
     * ��������ƻ�����ʱ�䣬��ʱ���񽫴����ָ��ʱ�����з��͡�<br>
     * ��֧����ʱʱ�����30���������
     * 
     * @param scheduleTime �ƻ�����ʱ��
     * @throws MessageTaskInitException �ƻ�ִ��ʱ�����ڵ�ǰϵͳʱ�佫�׳��쳣
     */
    public void setScheduleTime(Date scheduleTime) throws MessageTaskInitException;

    /**
     * ��ȡ����Ĺ���ʱ�䣬���ڵ������Զ�����ִ��
     * 
     * @return ����Ĺ���ʱ��
     */
    public Date getScheduleDeadline();

    /**
     * (optional)<br>
     * ��������Ĺ���ʱ�䣬Ĭ��Ϊ�ƻ�ִ��ʱ��+1��<br>
     * ������δ��ִ�е������Զ�����ִ��
     * 
     * @param deadline ��Ϣ���ڵ�ʱ��
     * @throws MessageTaskInitException ����ʱ�����ڼƻ�ִ��ʱ�佫�׳��쳣
     */
    public void setScheduleDeadline(Date deadline) throws MessageTaskInitException;

    /**
     * ��ȡ�Ƿ���Ҫ�����û����Ի���Ϣ������շ�������
     * 
     * @return true - ��Ҫ
     */
    public boolean isNeedDiversity();

    /**
     * (optional)<br>
     * ָ�������Ƿ���Ҫ�����û���NICK�ȸ��Ի���Ϣ��<br>
     * Ĭ��Ϊ������ (����ʵ������)
     * 
     * @param needDiversity true-��Ҫ�����û���Ϣ���Ի���Ϣ
     */
    public void setNeedDiversity(boolean needDiversity);

    /**
     * �ж�����ʱ����Ҫ�־û����Ա����ͼ�¼��ѯ
     * @return �Ƿ���Ҫ�־û�
     */
    public boolean isPersistence();

    /**
     * (optional)<br>
     * ���������Ƿ���Ҫ�־û����Ա����ͼ�¼��ѯ<br>
     * ����ѡ��Ĭ��δ�ǳ־ã� ��MessageType������Ϊ����Ҫ�־ã��˴���������Ч
     * 
     * @param persistence true-��Ҫ
     */
    public void setPersistence(boolean persistence);

    /**
     * ��ȡ��������������Ϣ����
     * 
     * @return ��������ID
     */
    public int getMessageTypeId();

    /**
     * ������������������Ϣ����<br>
     * ����Ϣ����MessageType�����ȼ���ͨ�����Ƿ�����־á��Ƿ���Ҫƣ�Ͷȹ��˵���Ϣ������
     * 
     * @param messageTypeId ��������ID
     * @throws MessageTaskInitException id����ʵ����Լ�����׳��쳣
     */
    public void setMessageTypeId(int messageTypeId) throws MessageTaskInitException;

    /**
     * ��ȡ��Ϣ������ʹ�õ�����ͨ��
     * @see Channel
     * @return ������ͨ��ת��Ϊʮ���ƺ�ĺ�
     */
    public int getChannels();

    /**
     * �����Ϣ������ʹ��ͨ��-{@link Channel} �Լ�����ʹ�õĶ�Ӧģ��
     * 
     * @see Channel
     * @param channel ������ͨ������ʵ�����ڲ�ת��Ϊ�ڲ��洢��ʽ
     * @param templetId ������ͨ����Ӧ��ģ��Id
     * @throws MessageTaskInitException channel�ظ����á�templetId����ʵ����Լ��ʱ���׳��쳣
     */
    public void addChannel(Channel channel, int templetId) throws MessageTaskInitException;

    /**
     * ��ȡͨ������Ӧģ���ַ���
     * @return ͨ����ģ��ID��Ӧ��ϵ�ַ�������ʽ�磺8=123456;2=123457
     */
    public String getChannelTempletId();

    /**
     * �������ͨ������(For test)
     */
    public void clearChannels();
    
	/**
	 * ���Ӷ���ʱ��ҵ�����ͣ����ö�����Ϣ��ҵ������
	 * @param businessTpye
	 * @return
	 */
	public void setBusinessTpye(int businessTpye);

	/**
	 * �õ���Ϣ�Ķ���ҵ������
	 * @return
	 */
	public int getBusinessTpye();


}
