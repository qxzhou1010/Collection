package collection;

import java.util.*;

public class TestMap {
    /**
     * HashMap���ù�ϣ�㷨ʵ��
     * �ײ�����˹�ϣ��洢���ݣ����Լ������ظ�����������ظ����µļ�ֵ������ɵļ�ֵ
     * HashMap�ڲ��ң�ɾ�����޸ĵȷ���Ч�ʺܸ�
     * 1. HashMap: �̲߳���ȫ��Ч�ʸߡ�����key��valueΪnull��
     *2. HashTable: �̰߳�ȫ��Ч�ʵ͡�������key��valueΪnull��
     */
    public static void main(String[] args) {
//       testHashMap();
//       testHashSet();
        testTreeSet();

    }

    public static void testHashMap(){
        /**
         * ����HashMap�Ļ����÷�
         */
        Map<Integer, String> m1 = new HashMap<Integer, String>();
        Map<Integer, String> m2 = new HashMap<Integer, String>();

        m1.put(1, "one");
        m1.put(2, "two");
        m1.put(3, "three");

        m2.put(1, "yi");
        m2.put(2, "er");

        System.out.println(m1.size());
        System.out.println(m1.containsKey(1));
        System.out.println(m2.containsValue("er"));

        m1.put(3, "third"); // �ظ��ļ������µļ�ֵ�滻�ɵļ�ֵ

        Map<Integer, String> m3 = new HashMap<Integer, String>();
        m3.putAll(m1);
        m3.putAll(m2); // �ظ��ļ� �Ḳ�ǵ��ɵļ�ֵ
        System.out.println("m1:"+ m1);
        System.out.println("m2:" + m2);
        System.out.println("m3:"+ m3);

    }
    public static void testHashSet(){
        /**
         * ����HashSet�Ļ����÷�
         * ���򣬲����ظ�
         */
        Set<String> s = new HashSet<String>();
        s.add("hello");
        s.add("world");
        System.out.println(s);

        s.add("hello"); //��ͬԪ�ز��ᱻ����
        System.out.println(s);

        s.add(null);
        System.out.println(s);
        s.add(null);
        System.out.println(s);

    }

    public static void testTreeSet(){
        User u1 = new User(1001, "aaa", 18);
        User u2 = new User(2001, "bbb", 13);

        Set<User> set = new TreeSet<User>();
        set.add(u1);
        set.add(u2);

    }

}
class User implements Comparable<User>{
    int id;
    String uname;
    int age;

    public User(int id, String uname, int age){
        this.id = id;
        this.uname = uname;
        this.age = age;
    }

    public int compareTo(User o){
        if(this.id > o.id) {
            return 1;
        } else if( this.id < id){
            return -1;
        }
        else {
            return 0;
        }
    }

}
