package com.taobao.messenger.task.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.taobao.messenger.exception.MessageTaskInitException;
import com.taobao.messenger.service.common.Channel;
import com.taobao.messenger.service.common.UserInfoPrefix;
import com.taobao.messenger.task.MessageTask;

/**
 * Ĭ������ʵ���ࡣ<br>
 * ����Ŀ�����ã�����ͨ���������ַ�ʽ���
 * <ul>
 * <li>���û�����id��ʽ���target:{@link #addTarget(String)}��ͬһ����������û���������40��</li>
 * <li>��tag��ʽ��������û�: {@link #setTag(String, int)} ����֧�ִ���40���û���Ⱥ���ͣ����Ƚ��û�Ŀ����Ϣ�ϴ���target_List���ݿ�</li>
 * </ul>
 * ��ز����趨��
 * <ul>
 * <li> {@link #addChannel(Channel, int)}������跢�͵�ͨ���Լ���Ӧѡ�õ�ģ��id</li>
 * <li> {@link #setMessageTypeId(int)} ������������������Ϣ���ͣ�ȷ���������ȼ����Ƿ���Ҫ�־á�ƣ�Ͷȹ��˵���Ϣ</li>
 * <li> {@link #setContext(Map)} ������Ϣ��ʹ�õ�ģ���е�ʵ��key-valueֵ</li>
 * <li> {@link #setScheduleTime(Date)} ���������ִ��ʱ��</li>
 * </ul>
 * (��������ǰ����ͨ������ƽ̨�趨MessageType��MessageTemplet����ȡ��Ӧid) <br>
 * �趨��ɺ��ͨ�� {@link #isValid()} ����Ƿ��Ѿ��趨���Ҫ������
 * 
 * @author tianhu
 * @see MessageTask
 */
public class DefaultMessageTask implements MessageTask
{
    private static final int UID_UPPER_LIMIT = 40;
    private static final long ONE_HOUR = 3600000;
    private static final long ONE_DAY = 24 * ONE_HOUR;
    private static final long ONE_YEAR = 365 * ONE_DAY;

    private static final long serialVersionUID = -3346970538131677076L;

    /**
     * ������ID, ��ѡ
     */
    private String sourceId = "System";

    /**
     * ������Ϣ��Ŀ�����ֶΣ�userID��Mail��ַ���ֻ������Tag��Ⱥ��ǩ
     */
    private String userInfoPrefix = UserInfoPrefix.UID.getValue();
    /**
     * ����target����ƴ�ӳɵ��ַ�����userInfoPrefix��ǵľ���ֵ�����֮����TARGET_SPLIT�ָ�
     */
    protected String targets = "";

    /**
     * ��¼target�����ڿ��ٽ����ظ�target����ж������������紫��
     */
    //�����ظ���target
    transient protected List<String> targetList = null;

    /**
     * ������Ϣ��user����
     */
    protected int targetsNum = 0;

    /**
     * ģ����Ⱦ����ʹ�õ���ر���ȡֵkey-Value��
     */
    private final Map<String, Object> context = new HashMap<String, Object>();

    /**
     * ����id
     */
    private String taskId;
    /**
     * ��ʱ���͵�ʱ��,Ĭ��Ϊ��ǰϵͳʱ��
     */
    private final Date scheduleTime = new Date(System.currentTimeMillis());
    /**
     * ��Ϣ��ʱ��ʱ�䣬Ĭ��Ϊ��ǰϵͳʱ��+1��
     */
    private final Date scheduleDeadline = new Date(System.currentTimeMillis() + ONE_YEAR);
    /**
     * �Ƿ���Ҫ�����û���Ϣ���Ի���ʾ
     */
    private boolean needDiversity = false;
    /**
     * �Ƿ���Ҫ�־û�
     */
    private boolean persistence = false;
    
	/**
     * ��ϢЯ����ҵ�����ͣ��������ҵ�����Ϳ��Բ鵽���ĵ�ͨ��
     */
	private int businessTpye=0;
    /**
     * ��������(����)ID
     */
    private int messageTypeId = -1;

    /**
     * ChannelΪAutoʱѡ��MessageType���趨��ͨ���� ����ʱȡMessageTask�е�Channel ��MessageType�е�Channel�еĽ���
     */
    private int channel = 0x00;
    private String templetIdList = "";

    /**
     * Ĭ�Ϲ��캯��
     */
    public DefaultMessageTask()
    {
    }

    /**
     * @param userInfo �û���Ϣǰ�ñ�ʾ��ID��Mail���ֻ�����
     */
    protected DefaultMessageTask(final UserInfoPrefix userInfo)
    {
        userInfoPrefix = userInfo.getValue();
    }

    public String getSourceId()
    {
        return sourceId;
    }

    public void setSourceId(final String sourceId) throws MessageTaskInitException
    {
        if (null == sourceId)
        {
            throw new MessageTaskInitException("sourceId can't be null");
        }
        this.sourceId = sourceId;
    }

    public String getTargets()
    {
        return targets;
    }

    /**
     * ����û�userId ,Task�ڲ�ƴ��Ϊ�Զ����ʽ���ַ���
     * 
     * @param uid ��ӦUIC�е�����id��Long�ͣ�id > 0
     * @return ��ǰ�Ѿ�����û�����
     * @throws MessageTaskInitException uid�޷�ת��ΪLong�͡�uid <= 0��prefix����ȷ��Ŀ����Ⱥ���������ƾ����׳��쳣
     */
    public int addTarget(final String uid) throws MessageTaskInitException
    {
        isTargetValid(uid);
        if ((targets.length() + TARGET_SPLIT.length() + uid.length()) >= MAX_TARGETS_LENGTH)
        {
            throw new MessageTaskInitException("Targets numer has reached to upper limit");
        }
        if (targetsNum == 0)
        {
            targetList = new ArrayList<String>();
            targetList.add(uid);
            targets = uid;
        } else
        {
            if (targetList.add(uid))
            {
                targets += TARGET_SPLIT + uid;
            } else
            {
                throw new MessageTaskInitException(userInfoPrefix + " " + uid + " already exist.");
            }
        }
        targetsNum = targetList.size();

        return targetsNum;
    }

    /**
     * �ж������target�Ƿ�Ϸ�
     * 
     * @param uid
     * @return TODO
     * @throws MessageTaskInitException
     */
    protected boolean isTargetValid(final String uid) throws MessageTaskInitException
    {
        if (!userInfoPrefix.equals(UserInfoPrefix.UID.getValue()))
        {
            throw new MessageTaskInitException("Task tag expect UID,but is " + userInfoPrefix);
        }

        try
        {
            final Long id = Long.parseLong(uid);
            if (id <= 0)
            {
                throw new MessageTaskInitException("Target id can't be nagetive,but is " + id);
            }
        } catch (final NumberFormatException e)
        {
            throw new MessageTaskInitException("Target expect long type UID,but is " + uid);
        }

        return true;
    }

    /**
     * ��������������Ⱥ��ǩ
     * 
     * @param tag ��Ⱥ��ǩ�����汾�ţ���"="�ָ��ʽtag=version ����11385=1
     * @param targetsNum Ŀ����Ⱥ����
     * @throws MessageTaskInitException tag�����϶�Ӧʵ��Լ����Ŀ����Ⱥ��<=0ʱ�׳��쳣
     */
    public void setTag(final String tag, final int targetsNum) throws MessageTaskInitException
    {
        if (this.targetsNum != 0)
        {
            throw new MessageTaskInitException("tag already be set to " + userInfoPrefix + ":" + targets);
        }
        if (null == tag)
        {
            throw new MessageTaskInitException("set tag is null");
        }
        if (targetsNum <= 0)
        {
            throw new MessageTaskInitException("targetsNum can't set negative or zero");
        }
        userInfoPrefix = UserInfoPrefix.TAG.getValue();
        targets = tag;
        this.targetsNum = targetsNum;
    }

    public void clearTargets()
    {
        targets = "";
        targetsNum = 0;
        userInfoPrefix = UserInfoPrefix.UID.toString();
    }

    public String getUserInfoPrefix()
    {
        return userInfoPrefix;
    }

    public Map<String, Object> getContext()
    {
        return context;
    }

    public void setContext(final Map<String, Object> context) throws MessageTaskInitException
    {
        if (null == context)
        {
            throw new MessageTaskInitException("input context is null.");
        }
        this.context.clear();
        for (final Entry<String, Object> c : context.entrySet())
        {
            if (null == c.getKey())
            {
                throw new MessageTaskInitException("context map include null key.");
            }
            if (null == c.getValue())
            {
                throw new MessageTaskInitException("context value is null with key=" + c.getKey());
            }
            this.context.put(c.getKey(), c.getValue());
        }
    }

    public void addContext(final String key, final Object value) throws MessageTaskInitException
    {
        if (null == key)
        {
            throw new MessageTaskInitException("input key is null.");
        }
        if (null == value)
        {
            throw new MessageTaskInitException("input value is null.");
        }
        context.put(key, value);

    }

    public String getTaskId()
    {
        return taskId;
    }

    public void setTaskId(final String taskId)
    {
        this.taskId = taskId;
    }

    public Date getScheduleTime()
    {
        return scheduleTime;
    }

    /**
     * ���ö�ʱ����ʱ�䣬����ʱ��DeadlineĬ��Ϊ�˷���ʱ���һ��
     * 
     * @param scheduleTime ��ʱ���͵�ʱ��
     * @throws MessageTaskInitException �ƻ�ִ���������ڵ�ǰϵͳ���ڽ��׳��쳣
     */
    @SuppressWarnings("deprecation")
    public void setScheduleTime(final Date scheduleTime) throws MessageTaskInitException
    {
        if (null == scheduleTime)
        {
            throw new MessageTaskInitException("schedule time is null");
        }
        final Date currentTime = new Date(System.currentTimeMillis());
        if (scheduleTime.getDate() < currentTime.getDate())
        {
            if (scheduleTime.getMonth() <= currentTime.getMonth())
            {
            	//�ų�����Ŀ���
            	if(scheduleTime.getYear()<=currentTime.getYear())
            		
                throw new MessageTaskInitException("schedule date:" + scheduleTime
                        + " can't be earlier than current date:" + currentTime);
            }
        }
        if (scheduleTime.after(scheduleDeadline))
        {
            scheduleDeadline.setTime(scheduleTime.getTime() + ONE_YEAR);
        }
        this.scheduleTime.setTime(scheduleTime.getTime());

    }

    public Date getScheduleDeadline()
    {
        return scheduleDeadline;
    }

    public void setScheduleDeadline(final Date deadline) throws MessageTaskInitException
    {
        if (null == deadline)
        {
            throw new MessageTaskInitException("deadLine time is null");
        }
        if (deadline.before(scheduleTime))
        {
            throw new MessageTaskInitException("deadLine time:" + deadline + "is before scheduleTime:" + scheduleTime);
        }
        scheduleDeadline.setTime(deadline.getTime());
    }

    public boolean isNeedDiversity()
    {
        return needDiversity;
    }

    public void setNeedDiversity(final boolean needDiversity)
    {
        this.needDiversity = needDiversity;
    }

    public boolean isPersistence()
    {
        return persistence;
    }

    public void setPersistence(final boolean persistence)
    {
        this.persistence = persistence;
    }

    public int getMessageTypeId()
    {
        return messageTypeId;
    }

    public void setMessageTypeId(final int messageTypeId) throws MessageTaskInitException
    {
        if (messageTypeId < 0)
        {
            throw new MessageTaskInitException("messageTypeId can't be negative");
        }
        this.messageTypeId = messageTypeId;
    }

    public int getChannels()
    {
        return channel;
    }

    public void addChannel(final Channel channel, final int templetId) throws MessageTaskInitException
    {
        /**
         * yundong Ӧ����У����Ч�ԣ������ظ�������ͬ�����ݣ�
         */
        if ((this.channel & channel.getValue()) > 0)
        {
            throw new MessageTaskInitException("channel already be set");
        }
        if (channel.getValue() == 0)
        {
            throw new MessageTaskInitException("channel can not be zero !");
        }
        if (templetId < 0)
        {
            throw new MessageTaskInitException("message templet Id can't be negative");
        }

        this.channel = this.channel | channel.getValue();

        if (templetIdList.length() == 0)
        {
            templetIdList = channel.getValue() + KEYVALUE_SPLIT + templetId;
        } else
        {
            templetIdList = templetIdList + TARGET_SPLIT + channel.getValue() + KEYVALUE_SPLIT + templetId;
        }
    }

    public String getChannelTempletId()
    {
        return templetIdList;
    }

    public void clearChannels()
    {
        channel = 0x00;
        templetIdList = "";
    }

    public int getTargetsNum()
    {
        return targetsNum;
    }
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.taobao.messenger.task.MessageTask#getBusinessTpye()
	 */
	public int getBusinessTpye() {
		// TODO Auto-generated method stub
		return businessTpye;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.taobao.messenger.task.MessageTask#setBusinessTpye(int)
	 */
	public void setBusinessTpye(int businessTpye) {
	this.businessTpye=businessTpye;

	}

    public boolean isValid()
    {
        if (targets == null)
        {
            return false;
        }
        if (targetsNum <= 0)
        {
            return false;
        }
        if (messageTypeId < 0)
        {
            return false;
        }
        if (channel == 0)
        {
            return false;
        }
        return true;
    }

}
