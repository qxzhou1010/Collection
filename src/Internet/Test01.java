package Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress
 *�����û�й��췽�������Ҫ�õ�����
 * ֻ��ͨ����̬������getLocalHost()��getByName()�� getAllByName()�� getAddress()��getHostName()��
 */
public class Test01 {

    public static void main(String[] args) throws UnknownHostException {
        test01();
//        test02();
        test03();


    }

    /**
     * ����InetAddress:��װIP��ַ��DNS
     */
    static void test01()throws UnknownHostException{
        //��ȡ������Ϣ��һ������
        InetAddress addr = InetAddress.getLocalHost();
        //��ӡ����IP��ַ
        System.out.println(addr.getHostAddress());
        //��ӡ������
        System.out.println(addr.getHostName());
    }

    /**
     * ���������õ�InetAddress����
     * @throws UnknownHostException
     */
    static void test02() throws UnknownHostException{
        //�½�����
        InetAddress address = InetAddress.getByName("www.baidu.com");
        //��ȡ������Ӧ��IP��ַ
        System.out.println(address.getHostAddress());
        //��ȡ����
        System.out.println(address.getHostName());

    }

    /**
     * ����IP���InetAddress����
     * @throws UnknownHostException
     */
    static void test03() throws UnknownHostException{
        InetAddress address = InetAddress.getByName("180.97.33.108");
        System.out.println(address.getHostAddress());
        /*
         * ���ip������������������IP��ַ�����ڻ�DNS���������������IP��ַ
         * ��������ӳ�䣬getHostName������ֱ�ӷ������IP��ַ��
         */
        System.out.println(address.getHostName());

    }


}
