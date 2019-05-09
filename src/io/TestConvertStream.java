package io;

import java.io.*;

public class TestConvertStream {
    /**
     * InputStreamReader/OutputStreamWriter用来实现将字节流转化成字符流。比如，如下场景：
     *System.in是字节流对象，代表键盘的输入，如果我们想按行接收用户的输入时，
     * 就必须用到缓冲字符流BufferedReader特有的方法readLine()，
     * 但是经过观察会发现在创建BufferedReader的构造方法的参数必须是一个Reader对象，
     * 这时候我们的转换流InputStreamReader就派上用场了。
     *而System.out也是字节流对象，代表输出到显示器，按行读取用户的输入后，
     * 并且要将读取的一行字符串直接显示到控制台，就需要用到字符流的write(String str)方法，
     * 所以我们要使用OutputStreamWriter将字节流转化为字符流。
     * @param args
     */
    public static void main(String[] args) {
        testConv();

    }

    /**
     * 使用InputStreamReader接收用户的输入，并输出到控制台
     */
    static void testConv(){
        //创建字符输入和输出流，使用转换流将字节流转换为字符流
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));

            //使用字符输入和输出流
            String str = br.readLine();
            //一直读取，直到用户输入了exit
            while (!"exit".equals(str)){
                bw.write(str);
                bw.newLine();//换行
                bw.flush();
                //再读一行
                str = br.readLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (bw != null){
                    bw.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (br != null){
                    br.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }


    }
}
