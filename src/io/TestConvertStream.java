package io;

import java.io.*;

public class TestConvertStream {
    /**
     * InputStreamReader/OutputStreamWriter����ʵ�ֽ��ֽ���ת�����ַ��������磬���³�����
     *System.in���ֽ������󣬴�����̵����룬��������밴�н����û�������ʱ��
     * �ͱ����õ������ַ���BufferedReader���еķ���readLine()��
     * ���Ǿ����۲�ᷢ���ڴ���BufferedReader�Ĺ��췽���Ĳ���������һ��Reader����
     * ��ʱ�����ǵ�ת����InputStreamReader�������ó��ˡ�
     *��System.outҲ���ֽ������󣬴����������ʾ�������ж�ȡ�û��������
     * ����Ҫ����ȡ��һ���ַ���ֱ����ʾ������̨������Ҫ�õ��ַ�����write(String str)������
     * ��������Ҫʹ��OutputStreamWriter���ֽ���ת��Ϊ�ַ�����
     * @param args
     */
    public static void main(String[] args) {
        testConv();

    }

    /**
     * ʹ��InputStreamReader�����û������룬�����������̨
     */
    static void testConv(){
        //�����ַ�������������ʹ��ת�������ֽ���ת��Ϊ�ַ���
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));

            //ʹ���ַ�����������
            String str = br.readLine();
            //һֱ��ȡ��ֱ���û�������exit
            while (!"exit".equals(str)){
                bw.write(str);
                bw.newLine();//����
                bw.flush();
                //�ٶ�һ��
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
