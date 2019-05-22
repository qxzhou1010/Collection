package Internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 最简单的socket客户端
 */
public class BasicSocketClient {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        try {
            /**
             * 创建Socket对象，指定要连接的服务器的IP和端口
             * 而发送端口是随机的
             */
            socket = new Socket(InetAddress.getLocalHost(), 8888);
            //获取socket的输入流，用缓冲流包装
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //接收服务器端发生的信息
            System.out.println(br.readLine());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (br != null){
                try {
                    br.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
