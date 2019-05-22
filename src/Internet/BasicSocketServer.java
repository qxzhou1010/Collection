package Internet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单向通信Socket之服务器端
 * 最简单的服务器端代码
 */
public class BasicSocketServer {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedWriter bw = null;
        try {
            //建立服务器端套接字：指定监听的端口
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Create the server listen");
            //监听，等待客户端请求，愿意接收连接
            socket = serverSocket.accept();
            //获取socket的输出流，用缓冲流进行包装
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            //向客户端发送反馈消息
            bw.write("hhh");


        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (bw!=null){
                try {
                    bw.close();
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
