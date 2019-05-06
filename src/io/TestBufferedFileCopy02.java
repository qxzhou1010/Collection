package io;

import java.io.*;

public class TestBufferedFileCopy02 {
    /**
     *  1. readLine()方法是BufferedReader特有的方法，可以对文本文件进行更加方便的读取操作。
     *  2. 写入一行后要记得使用newLine()方法换行。
     * @param args
     */
    public static void main(String[] args) {
        copyFile("D:\\a.txt", "D:\\e.txt");

    }

    static void copyFile(String src, String dec){
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        String temp = "";
        try {
            fr = new FileReader(src);
            fw = new FileWriter(dec);

            //使用缓冲字符流进行包装
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            // BufferedReader 提供了readLine()方法，按行读取文本内容
            while ((temp = br.readLine()) != null){
                // 将读取到的一行字符写入文件中
                bw.write(temp);
                //下次读取之前需要换行,否则会在上一行后边继续追加
                bw.newLine();

            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (bw != null){
                    bw.close();
                }
            }catch (IOException e1){
                e1.printStackTrace();
            }

            try {
                if (br != null){
                    br.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if ( fw != null){
                    fw.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (fr != null){
                    fr.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }


    }

}
