package Internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * ��򵥵�socket�ͻ���
 */
public class BasicSocketClient {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        try {
            /**
             * ����Socket����ָ��Ҫ���ӵķ�������IP�Ͷ˿�
             * �����Ͷ˿��������
             */
            socket = new Socket(InetAddress.getLocalHost(), 8888);
            //��ȡsocket�����������û�������װ
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //���շ������˷�������Ϣ
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
