package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class TestBufferedFileCopy01 {
    /**
     * 使用缓冲流实现文件的高效率复制
     */
    public static void main(String[] args) {

        long time1 = System.currentTimeMillis();
        copyFile01("D:\\a.mp4", "D:\\b.mp4");
        long time2 = System.currentTimeMillis();
        System.out.println("缓冲字节流花费时间:" + (time2 - time1));

        long time3 = System.currentTimeMillis();
        copyFile02("D:\\a.mp4", "D:\\c.mp4");
        long time4 = System.currentTimeMillis();
        System.out.println("普通字节流花费时间:"+(time4 - time3));

    }

    /**
     * 使用缓冲字节流实现文件复制
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
            //使用缓冲字节流包装文件字节流。增加缓冲功能，提升效率
            // 缓冲区默认大小8192，也可以自定义大小
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            while ( (temp = bis.read()) != -1){
                bos.write(temp);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 增加处理流后，流的关闭顺序为后开的先关
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
     * 普通节流实现文件的复制
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
