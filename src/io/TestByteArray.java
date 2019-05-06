package io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

public class TestByteArray {
    /**
     * �����ֽ�������
     * FileInputStream�ǰ��ļ���������Դ��ByteArrayInputStream���ǰ��ڴ��еġ�ĳ���ֽ�������󡱵�������Դ��
     */
    public static void main(String[] args) {
        //���ַ�������ֽ�����
        byte[] b = "abcdadfajf".getBytes();
        test(b);



    }

    static void test(byte[] b){
        ByteArrayInputStream bais = null;
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        //�����ȡ���ֽ���
        int num = 0;
        try {
            //�ù��췽���Ĳ�����һ���ֽ����飬����ֽ������������Դ
            bais = new ByteArrayInputStream(b);
            while ((temp = bais.read()) != -1){
                sb.append((char) temp);
                num++;
            }
            System.out.println(sb);
            System.out.println("��ȡ���ֽ���:"+num);

        }finally {
            try {
                if (bais != null){
                    bais.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }


    }
}
