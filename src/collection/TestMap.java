package collection;

import java.util.*;

public class TestMap {
    /**
     * HashMap采用哈希算法实现
     * 底层采用了哈希表存储数据，所以键不能重复，如果发生重复，新的键值会替代旧的键值
     * HashMap在查找，删除，修改等方面效率很高
     * 1. HashMap: 线程不安全，效率高。允许key或value为null。
     *2. HashTable: 线程安全，效率低。不允许key或value为null。
     */
    public static void main(String[] args) {
//       testHashMap();
//       testHashSet();
        testTreeSet();

    }

    public static void testHashMap(){
        /**
         * 测试HashMap的基本用法
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

        m1.put(3, "third"); // 重复的键，则新的键值替换旧的键值

        Map<Integer, String> m3 = new HashMap<Integer, String>();
        m3.putAll(m1);
        m3.putAll(m2); // 重复的键 会覆盖掉旧的键值
        System.out.println("m1:"+ m1);
        System.out.println("m2:" + m2);
        System.out.println("m3:"+ m3);

    }
    public static void testHashSet(){
        /**
         * 测试HashSet的基本用法
         * 无序，不可重复
         */
        Set<String> s = new HashSet<String>();
        s.add("hello");
        s.add("world");
        System.out.println(s);

        s.add("hello"); //相同元素不会被加入
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
