package io;

import java.io.FileOutputStream;

public class TestFileOutputStream {
    /**
     * ���ַ���/�ֽ����������д���ļ�
     */
    public static void main(String[] args) {
        FileOutputStream fos = null;
        String string = "zqx";
        try {
            //true��ʾ����׷�ӵ��ļ�ĩβ��false��ʾ��д�����ļ�
            fos = new FileOutputStream("D:\\a.txt", true);
            fos.write(string.getBytes());
            // ���ĵ�write����, ��������ֽ�д�룬����ֱ��д��һ���ֽ�����
            // write ����һ�����ط���������ָ�����ֽ������ĸ�λ�ÿ�ʼд��

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fos != null){
                    fos.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
