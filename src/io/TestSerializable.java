package io;

import javax.naming.Name;
import java.io.*;

public class TestSerializable {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        try {
            //通过ObjectOutputStream将person对象写入文件就是序列化
            Person person = new Person(18, true, "zqx");
            //序列化
            fos = new FileOutputStream("D:\\c.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(person);
            oos.flush();

            //反序列化
            fis = new FileInputStream("D:\\c.txt");
            //通过ObjectInputStream将文件中的二进制数据反序列化成Person对象
            ois = new ObjectInputStream(fis);
            Person person1 = (Person) ois.readObject();
            System.out.println(person1);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if ( oos!= null){
                    oos.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if ( fos!= null){
                    fos.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if ( ois!= null){
                    ois.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if ( fis!= null){
                    fis.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

}

/**
 * Person实现序列化接口后，Person对象才能被序列化。
 */
class Person implements Serializable{
    //添加序列化ID,它决定着是否能够成功被序列化
    private static final long serialVersionID = 1L;
    int age;
    boolean isMan;
    String name;

    public Person(int age, boolean isMan, String name){
        super();
        this.age = age;
        this.isMan = isMan;
        this.name = name;
    }
    @Override
    public String toString(){
        return "Person[age=" + age + ", isMan " + isMan + ", name = " + name + "]";
    }



}
