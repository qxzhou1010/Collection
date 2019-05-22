package Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress
 *这个类没有构造方法。如果要得到对象，
 * 只能通过静态方法：getLocalHost()、getByName()、 getAllByName()、 getAddress()、getHostName()。
 */
public class Test01 {

    public static void main(String[] args) throws UnknownHostException {
        test01();
//        test02();
        test03();


    }

    /**
     * 测试InetAddress:封装IP地址和DNS
     */
    static void test01()throws UnknownHostException{
        //获取本机信息的一个对象
        InetAddress addr = InetAddress.getLocalHost();
        //打印本机IP地址
        System.out.println(addr.getHostAddress());
        //打印本机名
        System.out.println(addr.getHostName());
    }

    /**
     * 根据域名得到InetAddress对象
     * @throws UnknownHostException
     */
    static void test02() throws UnknownHostException{
        //新建对象
        InetAddress address = InetAddress.getByName("www.baidu.com");
        //获取域名对应的IP地址
        System.out.println(address.getHostAddress());
        //获取域名
        System.out.println(address.getHostName());

    }

    /**
     * 根据IP获得InetAddress对象
     * @throws UnknownHostException
     */
    static void test03() throws UnknownHostException{
        InetAddress address = InetAddress.getByName("180.97.33.108");
        System.out.println(address.getHostAddress());
        /*
         * 输出ip而不是域名。如果这个IP地址不存在或DNS服务器不允许进行IP地址
         * 和域名的映射，getHostName方法就直接返回这个IP地址。
         */
        System.out.println(address.getHostName());

    }


}
