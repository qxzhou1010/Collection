package io;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileCopy02 {
    /**
     * ����FileReader��FileWriterʵ���ı��ļ��ĸ���
     * ��Ȼ�ֽ�������ʵ�ִ������е��ļ������޷��ܺô���unicode�ַ������������
     * ���ԣ��������ļ��ַ����������ı��ļ������ַ�Ϊ��λ���в���
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

            //�ַ�������Ϊ����
            char[]  buffer = new char[1024];

            //�߶ȱ�д
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
