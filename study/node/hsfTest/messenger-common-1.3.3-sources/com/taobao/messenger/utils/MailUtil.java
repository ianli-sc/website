package com.taobao.messenger.utils;

/**
 * �����๤��
 * 
 * @author tianhu E-mail:
 * @version ����ʱ�䣺2009-5-29 ����03:03:26
 */
public class MailUtil
{

    /**
     * һ�����Ϸ�()<>,;:\"@�ַ� + һ��@ +һ��������ĸ+ +һ������(.+��ĸ)���
     */
	private static final String MAIL_VAILD_CHECK_REGEX = "[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+";
	

    /**
     * �ж������ַ�Ƿ�Ϸ�
     * 
     * @param mail ���ж������ַ
     * @return
     */
    public static boolean isVaildAdress(final String mail)
    {
        if (null != mail && mail.matches(MAIL_VAILD_CHECK_REGEX))
        {
            return true;
        }
        return false;
    }

    public static String getAdressDomain(final String mail)
    {
        // TODO
        return null;
    }

    public static String getAdressLocalName(final String mail)
    {
        // TODO
        return null;
    }

    public static void main(final String[] args)
    {

        // should true
        System.out.println(("skyfox@1.com").matches(MAIL_VAILD_CHECK_REGEX));
        System.out.println(("skyfox@163.vip.com").matches(MAIL_VAILD_CHECK_REGEX));
        System.out.println(("w-l@opd-china.com").matches(MAIL_VAILD_CHECK_REGEX));
        // should fasle
        System.out.println(("skyfox@1..com").matches(MAIL_VAILD_CHECK_REGEX));
        System.out.println(("sk\\yfx@163.vip.com").matches(MAIL_VAILD_CHECK_REGEX));
        System.out.println(("sk\"yfx@163.vip.com").matches(MAIL_VAILD_CHECK_REGEX));
        System.out.println(("sk<yfx@163.vip.com").matches(MAIL_VAILD_CHECK_REGEX));
        System.out.println(("skyf[ox@163@vip.com").matches(MAIL_VAILD_CHECK_REGEX));
        System.out.println(("skyfox@163@vip.com").matches(MAIL_VAILD_CHECK_REGEX));
        System.out.println(("skyfox@@1.com").matches(MAIL_VAILD_CHECK_REGEX));
        System.out.println(("skyfox@1.").matches(MAIL_VAILD_CHECK_REGEX));
        System.out.println("163"+("huanlituo@163.com").matches(MAIL_VAILD_CHECK_REGEX));
        System.out.println(("skyfox@.com").matches(MAIL_VAILD_CHECK_REGEX));
        System.out.println(("1.com").matches(MAIL_VAILD_CHECK_REGEX));
        System.out.println(("1.@com").matches(MAIL_VAILD_CHECK_REGEX));
        System.out.println(("jocelyn.shen@transcosmos-cn.com").matches(MAIL_VAILD_CHECK_REGEX));
        System.out.println(("jocelyn.shen@transcosmos-cn.com ").matches("[^()<>,;:\\]\\[\"\\\\@]+@[\\w]+([.][\\w]+)+"));
        System.out.println("qq" + "946280421@qq.com".matches(MAIL_VAILD_CHECK_REGEX));
        System.out.println("aliba" + "wiko.wangk@alibaba-inc.com".matches(MAIL_VAILD_CHECK_REGEX));
        System.out.println("aliba" + "zhaoxuelin1983.com@163.com".matches(MAIL_VAILD_CHECK_REGEX));
      
    }
    // if (indexOfAny(addr, " \t\n\r") >= 0) {
    // throw new AddressException("Illegal whitespace in address", addr);
    // }
    //
    // if (indexOfAny(s1, "()<>,;:\\\"[]@") >= 0) {
    // throw new AddressException("Illegal character in local name", addr);
    // }
    //
    // if ((s2 != null) && (s2.indexOf('[') < 0) && (indexOfAny(s2, "()<>,;:\\\"[]@") >= 0)) {
    // throw new AddressException("Illegal character in domain", addr);
    // } else {
    // return;
    // }
}
