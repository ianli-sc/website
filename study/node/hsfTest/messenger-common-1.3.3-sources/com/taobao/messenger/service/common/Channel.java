package com.taobao.messenger.service.common;

import java.util.ArrayList;
import java.util.List;

/**
 * ͨ������ö���� ȫ��ͨ��(0xFFFFFFFF),��ͨ��(0x0) <BR>
 * ͨ���ʼ����� MAIL(0x0001), ͨ�����ŷ��� SMS(0x0002), ͨ��վ���ŷ��� PMSG(0x0004); ͨ��������Ϣ����
 * WANGWANG(0x0008),
 * 
 * @author huohu
 * @since 1.0, 2009-4-7 ����02:30:18
 */

public enum Channel {
	/**
	 * ��ͨ��
	 */
	NONE(0x0),
	/**
	 * ����MessageType�е�ͨ�������趨
	 */
	AUTO(0xFFFFFFFF),
	/**
	 * ͨ���ʼ�����
	 */
	MAIL(0x0001),
	/**
	 * ͨ��������Ϣ����
	 */
	WANGWANG(0x0008),
	/**
	 * ͨ�����ŷ���
	 */
	SMS(0x0002),
	/**
	 * ͨ��վ���ŷ���
	 */
	PMSG(0x0004);

	private int value;

	private Channel(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return this.name();
	}

	/**
	 * ��intת��Ϊ��Ӧ��channelö�ٱ���
	 * 
	 * @param value
	 *            channle��Ӧ��int
	 * @return ��Ӧchannelö�ٱ������޶�Ӧchannel������null
	 */
	public static Channel parseChannel(int value) {
		for (Channel c : Channel.values()) {
			if (c.getValue() == value) {
				return c;
			}
		}
		return null;
	}

	/**
	 * ��int������������������channel
	 * 
	 * @param value
	 *            ��������channels���intֵ
	 * @return ��Ӧ��channel���У��޶�Ӧchannel������sizeΪ0��List
	 */
	public static List<Channel> parseChannels(int value) {
		List<Channel> channels = new ArrayList<Channel>();
		for (Channel c : Channel.values()) {
			if (c.equals(Channel.AUTO)) {
				continue;
			}
			if ((c.getValue() & value) > 0) {
				channels.add(c);
			}
		}
		return channels;
	}

	/**
	 * ��Channelö���������Ϊ��Ӧ��intֵ��<br>
	 * ��List����������(0x08)ͨ��,�ʼ�(0x01)ͨ�����򷵻�Ϊ 0x08|0x01=0x09
	 * 
	 * @param channels
	 *            ����ϵ�Channel����
	 * @return ��Ϻ��intֵ
	 */
	public static int toValue(List<Channel> channels) {
		int channelInt = 0;
		for (Channel channel : channels) {
			channelInt = channelInt | channel.getValue();
		}
		return channelInt;
	}

	public static void main(String[] dd) {
		System.out.println(Channel.valueOf("WANGWANG"));
	}
}
