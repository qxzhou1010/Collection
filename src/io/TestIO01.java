package io;
import java.io.*;

public class TestIO01 {
    /**
     * 仅仅用于测试，不规范写法
     * @param args
     */
    public static void main(String[] args) {
        try {
            //创建输入流
            FileInputStream fis = new FileInputStream("D:\\Users\\xiaopangtou\\OneDrive\\javaDell\\src\\io\\a.txt");
//            FileInputStream fileInputStream = new FileInputStream("a.txt");
            //逐个字节的读取数据
            int s1 = fis.read();
            int s2 = fis.read();
            int s3 = fis.read();
            int s4 = fis.read();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);
            System.out.println(s4);
//            System.out.println();
            //流对象使用完毕后必须关闭
            fis.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
