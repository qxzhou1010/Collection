package io;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileCopy02 {
    /**
     * 利用FileReader和FileWriter实现文本文件的复制
     * 虽然字节流可以实现处理所有的文件，但无法很好处理unicode字符，会出现乱码
     * 所以，建立用文件字符流来处理文本文件，以字符为单位进行操作
     */

    public static void main(String[] args) {
        copyFile("D:\\a.txt", "D:\\c.txt");

    }
    static void copyFile(String src, String dec){
        FileReader fr = null;
        FileWriter fw = null;

        int len = 0;

        try {
            fr = new FileReader(src);
            fw = new FileWriter(dec);

            //字符数组作为缓存
            char[]  buffer = new char[1024];

            //边度边写
            while ((len = fr.read(buffer)) != -1){
                fw.write(buffer, 0, len);

            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (fw != null){
                    fw.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                if (fr != null){
                    fr.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
