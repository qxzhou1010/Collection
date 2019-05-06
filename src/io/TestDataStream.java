package io;

import java.awt.*;
import java.io.*;

public class TestDataStream {
    /**
     * 1.�������������������������ַ������͡���Ϊ����Դ��
     * �Ӷ����������������޹صķ�ʽ�ӵײ�����������в���Java���������������ַ������͡�
     *  2.  DataInputStream��DataOutputStream�ṩ�˿��Դ�ȡ������޹ص�����Java������������
     * (�磺int��double��String��)�ķ�����
     * 3.DataInputStream��DataOutputStream�Ǵ����������Զ������ڵ������������а�װ������һЩ��������Ч�Ĺ��ܡ�
     * @param args
     */
    public static void main(String[] args) {
        test("D:\\data.txt", "D:\\data.txt");
    }

    static void test(String src, String dec){
        DataOutputStream dos = null;
        DataInputStream dis = null;
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream(src);
            fis = new FileInputStream(dec);

            //ʹ���������Ի��������а�װ���������幦��
            dos = new DataOutputStream(new BufferedOutputStream(fos));
            dis = new DataInputStream(new BufferedInputStream(fis));
            //����������д���ļ�
            dos.writeChar('a');
            dos.writeInt(10);
            dos.writeDouble(Math.random());
            dos.writeBoolean(true);
            dos.writeUTF("zqxzqx");
            //�ֶ�ˢ�»�����,����������д�뵽�ļ�
            dos.flush();
            //ֱ�Ӷ�ȡ���ݣ���ȡ��˳���д��һ��
            System.out.println("char:"+dis.readChar());
            System.out.println("int:"+ dis.readInt());
            System.out.println("Double:" + dis.readDouble());
            System.out.println("Boolean:" + dis.readBoolean());
            System.out.println("UTF:"+ dis.readUTF());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fis != null){
                    fis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (fos != null){
                    fos.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (dis != null){
                    dis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (dos != null){
                    dos.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
