package io;

import java.io.*;
import java.io.IOException;
import java.util.Date;

public class TestObjectStream {
    /**
     *我们前边学到的数据流只能实现对基本数据类型和字符串类型的读写，并不能读取对象(字符串除外)，
     * 如果要对某个对象进行读写操作，我们需要学习一对新的处理流：ObjectInputStream/ObjectOutputStream。
     *ObjectInputStream/ObjectOutputStream是以“对象”为数据源，但是必须将传输的对象进行序列化与反序列化操作。
     */
    public static void main(String[] args) {
        write();
        read();

    }

    /**
     * 使用对象输出流将数据写入文件
     */
    static void write(){
        //创建Object输出流，并包装缓冲流，增加缓冲功能
        OutputStream os = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            os = new FileOutputStream(new File("D:\\new.txt"));
            bos = new BufferedOutputStream(os);
            oos = new ObjectOutputStream(bos);
            //使用Object输出流
            //对象流也可以对基本数据类型进行读写操作
            oos.writeInt(12);
            oos.writeDouble(3.14);
            oos.writeChar('a');
            oos.writeBoolean(true);
            oos.writeUTF("zqx");

            //对象流能够对对象数据类型进行读写操作
            //Date是系统类，已经实现了序列化接口
            //如果是自定义类，需要自己实现序列化接口
            oos.writeObject(new Date());

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭输出流
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
     * 使用对象流，将数据读入程序
     */
    static void read(){
        //创建对象流
        InputStream is = null;
        BufferedInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            is = new FileInputStream(new File("D:\\new.txt"));
            bis = new BufferedInputStream(is);
            ois = new ObjectInputStream(bis);
            //使用Object按照写入顺序读取
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
