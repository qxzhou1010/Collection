package z.qx.oo1203;
/*
HashMap 学习
 */

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<Integer, String> m1 = new HashMap<Integer, String>();
        Map<Integer, String> m2 = new HashMap<Integer, String>();
        m1.put(1, "one");
        m1.put(2, "two");
        m1.put(3, "three");
        m2.put(1, "first");
        m2.put(2, "second");
        System.out.println(m1.size());
        System.out.println(m1.containsKey(1));
        System.out.println(m2.containsValue("two"));
        m1.put(3, "third");
        Map<Integer,String> m3 = new HashMap<Integer, String>();
        m3.putAll(m1);
        m3.putAll(m2);//相同的键 会被覆盖
        System.out.println("m1:"+m1);
        System.out.println("m2:"+m2);
        System.out.println("m3:"+ m3);


    }





}
