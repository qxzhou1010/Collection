package Internet;

import java.net.InetSocketAddress;

/**
 * ����InetSocketAddress��ʹ��
 * ����IP�Ͷ˿���Ϣ��������Socketͨ�š�����ʵ�� IP �׽��ֵ�ַ(IP ��ַ + �˿ں�)���������κ�Э�顣
 */
public class Test02 {
    public static void main(String[] args) {

        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress socketAddress1 = new InetSocketAddress("localhost", 9000);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress1.getAddress());

    }

}
