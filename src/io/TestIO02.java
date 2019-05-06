package io;
import java.io.*;

public class TestIO02 {
    /**
     * 典型的规范的文件读取代码
     * @param args
     */
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\a.txt");
            StringBuilder sb = new StringBuilder();
            int temp = 0;
            while ((temp = fileInputStream.read()) != -1){
                // 这里先是把fileInputStream.read()的值赋值给temp
                //然后做条件判断
                //temp=-1的时候表示到了文件末尾，停止读取
                sb.append((char)temp);

            }
            System.out.println(sb);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                //这种写法，保证了即使遇到异常情况，也会关闭流对象
                //关闭的语句需要在finally中执行
                if (fileInputStream != null){
                    fileInputStream.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}
