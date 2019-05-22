package Internet;

import java.net.InetSocketAddress;

/**
 * 测试InetSocketAddress的使用
 * 包含IP和端口信息，常用于Socket通信。此类实现 IP 套接字地址(IP 地址 + 端口号)，不依赖任何协议。
 */
public class Test02 {
    public static void main(String[] args) {

        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress socketAddress1 = new InetSocketAddress("localhost", 9000);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress1.getAddress());

    }

}
