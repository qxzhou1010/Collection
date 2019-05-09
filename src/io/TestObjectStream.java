package io;

import java.io.*;
import java.io.IOException;
import java.util.Date;

public class TestObjectStream {
    /**
     *����ǰ��ѧ����������ֻ��ʵ�ֶԻ����������ͺ��ַ������͵Ķ�д�������ܶ�ȡ����(�ַ�������)��
     * ���Ҫ��ĳ��������ж�д������������Ҫѧϰһ���µĴ�������ObjectInputStream/ObjectOutputStream��
     *ObjectInputStream/ObjectOutputStream���ԡ�����Ϊ����Դ�����Ǳ��뽫����Ķ���������л��뷴���л�������
     */
    public static void main(String[] args) {
        write();
        read();

    }

    /**
     * ʹ�ö��������������д���ļ�
     */
    static void write(){
        //����Object�����������װ�����������ӻ��幦��
        OutputStream os = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            os = new FileOutputStream(new File("D:\\new.txt"));
            bos = new BufferedOutputStream(os);
            oos = new ObjectOutputStream(bos);
            //ʹ��Object�����
            //������Ҳ���ԶԻ����������ͽ��ж�д����
            oos.writeInt(12);
            oos.writeDouble(3.14);
            oos.writeChar('a');
            oos.writeBoolean(true);
            oos.writeUTF("zqx");

            //�������ܹ��Զ����������ͽ��ж�д����
            //Date��ϵͳ�࣬�Ѿ�ʵ�������л��ӿ�
            //������Զ����࣬��Ҫ�Լ�ʵ�����л��ӿ�
            oos.writeObject(new Date());

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //�ر������
            try {
                if ( oos!= null){
                    oos.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (bos != null){
                    bos.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (os != null){
                    os.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }

    }

    /**
     * ʹ�ö������������ݶ������
     */
    static void read(){
        //����������
        InputStream is = null;
        BufferedInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            is = new FileInputStream(new File("D:\\new.txt"));
            bis = new BufferedInputStream(is);
            ois = new ObjectInputStream(bis);
            //ʹ��Object����д��˳���ȡ
            System.out.println(ois.readInt());
            System.out.println(ois.readDouble());
            System.out.println(ois.readChar());
            System.out.println(ois.readBoolean());
            System.out.println(ois.readUTF());
            System.out.println(ois.readObject().toString());


        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (ois != null){
                    ois.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (bis != null){
                    bis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (is != null){
                    is.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }


}
