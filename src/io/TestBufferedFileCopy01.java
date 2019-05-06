package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class TestBufferedFileCopy01 {
    /**
     * ʹ�û�����ʵ���ļ��ĸ�Ч�ʸ���
     */
    public static void main(String[] args) {

        long time1 = System.currentTimeMillis();
        copyFile01("D:\\a.mp4", "D:\\b.mp4");
        long time2 = System.currentTimeMillis();
        System.out.println("�����ֽ�������ʱ��:" + (time2 - time1));

        long time3 = System.currentTimeMillis();
        copyFile02("D:\\a.mp4", "D:\\c.mp4");
        long time4 = System.currentTimeMillis();
        System.out.println("��ͨ�ֽ�������ʱ��:"+(time4 - time3));

    }

    /**
     * ʹ�û����ֽ���ʵ���ļ�����
     * @param src
     * @param dec
     */
    static void copyFile01(String src, String dec){
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        int temp = 0;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dec);
            //ʹ�û����ֽ�����װ�ļ��ֽ��������ӻ��幦�ܣ�����Ч��
            // ������Ĭ�ϴ�С8192��Ҳ�����Զ����С
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            while ( (temp = bis.read()) != -1){
                bos.write(temp);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // ���Ӵ����������Ĺر�˳��Ϊ�󿪵��ȹ�
            try {
                if (bos != null){
                    bos.close();
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
                if (bis != null){
                    bis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (fis != null){
                    fis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }

    }

    /**
     * ��ͨ����ʵ���ļ��ĸ���
     * @param src
     * @param dec
     */
    static void copyFile02(String src, String dec){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        int temp = 0;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dec);
            while ( (temp = fis.read()) != -1){
                fos.write(temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fos != null){
                    fos.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (fis != null){
                    fis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
