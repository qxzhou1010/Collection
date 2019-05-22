package Internet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����ͨ��Socket֮��������
 * ��򵥵ķ������˴���
 */
public class BasicSocketServer {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedWriter bw = null;
        try {
            //�������������׽��֣�ָ�������Ķ˿�
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Create the server listen");
            //�������ȴ��ͻ�������Ը���������
            socket = serverSocket.accept();
            //��ȡsocket����������û��������а�װ
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            //��ͻ��˷��ͷ�����Ϣ
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
