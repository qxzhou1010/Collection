package io;
import java.io.*;

public class TestIO01 {
    /**
     * �������ڲ��ԣ����淶д��
     * @param args
     */
    public static void main(String[] args) {
        try {
            //����������
            FileInputStream fis = new FileInputStream("D:\\Users\\xiaopangtou\\OneDrive\\javaDell\\src\\io\\a.txt");
//            FileInputStream fileInputStream = new FileInputStream("a.txt");
            //����ֽڵĶ�ȡ����
            int s1 = fis.read();
            int s2 = fis.read();
            int s3 = fis.read();
            int s4 = fis.read();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);
            System.out.println(s4);
//            System.out.println();
            //������ʹ����Ϻ����ر�
            fis.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
