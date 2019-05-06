package io;

import java.io.FileOutputStream;

public class TestFileOutputStream {
    /**
     * 将字符串/字节数组的内容写入文件
     */
    public static void main(String[] args) {
        FileOutputStream fos = null;
        String string = "zqx";
        try {
            //true表示内容追加到文件末尾，false表示重写整个文件
            fos = new FileOutputStream("D:\\a.txt", true);
            fos.write(string.getBytes());
            // 核心的write方法, 不是逐个字节写入，而是直接写入一个字节数组
            // write 还有一个重载方法，可以指定从字节数组哪个位置开始写入

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
