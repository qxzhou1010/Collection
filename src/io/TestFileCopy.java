package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class TestFileCopy {
    /**
     * 利用文件流实现文件的复制
     * 1.为了减少对硬盘的读写次数，提高效率，通常设置缓存数组。相应地，读取时使用的方法为：
     * read(byte[] b);写入时的方法为：write(byte[ ] b, int off, int length)。
     * 2. 程序中如果遇到多个流，每个流都要单独关闭，防止其中一个流出现异常后导致其他流无法关闭的情况。
     *
     */


    public static void main(String[] args) {
        copyFile("D:\\a.txt", "D:\\b.txt");

    }

    /**
     * src文件内容拷贝到dec文件
     * @param src 源文件
     * @param dec 目标文件
     */
    static void copyFile(String src, String dec){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //设置缓存字节数组，提高效率
        byte[] buffer = new byte[1024];

        int temp = 0;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dec);
            //边读边写
            //temp指本次读取的真实长度,temp等于-1时表示读取结束
            while ((temp = fis.read(buffer)) != -1){
                /*
                将缓存数组的数据写入文件中，注意：写入的是读取的真实长度;
                若使用fos.write(buffer)方法，则写入的长度是1024，即是缓存数组的长度
                 */
                fos.write(buffer, 0, temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                //两个流需要分别关闭
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
