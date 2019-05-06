package io;
import java.io.*;

public class TestIO02 {
    /**
     * ���͵Ĺ淶���ļ���ȡ����
     * @param args
     */
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\a.txt");
            StringBuilder sb = new StringBuilder();
            int temp = 0;
            while ((temp = fileInputStream.read()) != -1){
                // �������ǰ�fileInputStream.read()��ֵ��ֵ��temp
                //Ȼ���������ж�
                //temp=-1��ʱ���ʾ�����ļ�ĩβ��ֹͣ��ȡ
                sb.append((char)temp);

            }
            System.out.println(sb);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                //����д������֤�˼�ʹ�����쳣�����Ҳ��ر�������
                //�رյ������Ҫ��finally��ִ��
                if (fileInputStream != null){
                    fileInputStream.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}
