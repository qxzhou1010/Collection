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
            //ͨ��ObjectOutputStream��person����д���ļ��������л�
            Person person = new Person(18, true, "zqx");
            //���л�
            fos = new FileOutputStream("D:\\c.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(person);
            oos.flush();

            //�����л�
            fis = new FileInputStream("D:\\c.txt");
            //ͨ��ObjectInputStream���ļ��еĶ��������ݷ����л���Person����
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
 * Personʵ�����л��ӿں�Person������ܱ����л���
 */
class Person implements Serializable{
    //������л�ID,���������Ƿ��ܹ��ɹ������л�
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
