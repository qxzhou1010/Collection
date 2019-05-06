package io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

public class TestByteArray {
    /**
     * 测试字节数组流
     * FileInputStream是把文件当做数据源。ByteArrayInputStream则是把内存中的”某个字节数组对象”当做数据源。
     */
    public static void main(String[] args) {
        //将字符串变成字节数组
        byte[] b = "abcdadfajf".getBytes();
        test(b);



    }

    static void test(byte[] b){
        ByteArrayInputStream bais = null;
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        //保存读取的字节数
        int num = 0;
        try {
            //该构造方法的参数是一个字节数组，这个字节数组就是数据源
            bais = new ByteArrayInputStream(b);
            while ((temp = bais.read()) != -1){
                sb.append((char) temp);
                num++;
            }
            System.out.println(sb);
            System.out.println("读取的字节数:"+num);

        }finally {
            try {
                if (bais != null){
                    bais.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }


    }
}
