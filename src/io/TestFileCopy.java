package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class TestFileCopy {
    /**
     * �����ļ���ʵ���ļ��ĸ���
     * 1.Ϊ�˼��ٶ�Ӳ�̵Ķ�д���������Ч�ʣ�ͨ�����û������顣��Ӧ�أ���ȡʱʹ�õķ���Ϊ��
     * read(byte[] b);д��ʱ�ķ���Ϊ��write(byte[ ] b, int off, int length)��
     * 2. ��������������������ÿ������Ҫ�����رգ���ֹ����һ���������쳣�����������޷��رյ������
     *
     */


    public static void main(String[] args) {
        copyFile("D:\\a.txt", "D:\\b.txt");

    }

    /**
     * src�ļ����ݿ�����dec�ļ�
     * @param src Դ�ļ�
     * @param dec Ŀ���ļ�
     */
    static void copyFile(String src, String dec){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //���û����ֽ����飬���Ч��
        byte[] buffer = new byte[1024];

        int temp = 0;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dec);
            //�߶���д
            //tempָ���ζ�ȡ����ʵ����,temp����-1ʱ��ʾ��ȡ����
            while ((temp = fis.read(buffer)) != -1){
                /*
                ���������������д���ļ��У�ע�⣺д����Ƕ�ȡ����ʵ����;
                ��ʹ��fos.write(buffer)��������д��ĳ�����1024�����ǻ�������ĳ���
                 */
                fos.write(buffer, 0, temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                //��������Ҫ�ֱ�ر�
                if (fos != null){
                    fos.close();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                if (fis != null){
                    fis.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}
