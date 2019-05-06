package io;

import java.io.*;

public class TestBufferedFileCopy02 {
    /**
     *  1. readLine()������BufferedReader���еķ��������Զ��ı��ļ����и��ӷ���Ķ�ȡ������
     *  2. д��һ�к�Ҫ�ǵ�ʹ��newLine()�������С�
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

            //ʹ�û����ַ������а�װ
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            // BufferedReader �ṩ��readLine()���������ж�ȡ�ı�����
            while ((temp = br.readLine()) != null){
                // ����ȡ����һ���ַ�д���ļ���
                bw.write(temp);
                //�´ζ�ȡ֮ǰ��Ҫ����,���������һ�к�߼���׷��
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
