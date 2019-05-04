package collection;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestList {
    //list是有序，可重复的容器
    //常用实现类有 ArrayList, LinkedList, Vector

    public static void main(String[] args) {
//        test01();
//        test02();
        Test03();
    }

    public static void test01(){
        /**
         * list常用方法
         */
        List<String> list = new ArrayList<String>();
        System.out.println(list.isEmpty()); // 判断list是否为空， true

        list.add("aa"); //增加元素
        System.out.println(list.isEmpty()); // 再次判断list是否为空

        list.add("bb");
        list.add("cc");
        System.out.println(list);

        System.out.println("size of the list:" + list.size()); //获取list的长度

        System.out.println("list contains some element?" + list.contains("aa")); //判断list是否包含指定元素

        list.remove("aa"); //移除指定元素

        System.out.println(list);

        Object[] objs = list.toArray();

        System.out.println("convert to the Object array" + Arrays.toString(objs));

        list.clear(); // 清空所有元素
        System.out.println("clear all the elements"+ list);

    }
    public static void test02(){
        /**
         * 两个list之间的元素处理
         */
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();

        list1.add("aa");
        list1.add("bb");
        list1.add("cc");

        list2.add("aa");
        list2.add("ba");
        list2.add("df");

        System.out.println(list1.containsAll(list2)); // list1是否包含list2中的所有元素
        System.out.println(list1);
        System.out.println(list2);
        list1.addAll(list2); // list2的所有元素添加到list1
        System.out.println(list1);
        list1.removeAll(list2);// 从list1中删除list1和list2中共有的元素
        System.out.println(list1);
        list1.retainAll(list2); //求二者交集
        System.out.println(list1);

    }

    public static void Test03(){
        /**
         * 测试list关于索引操作的方法
         */
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list);

        list.add(2, "da"); // 在制定位置插入制定元素(字符串)
        System.out.println(list);

        list.remove(2); // 移除指定位置的元素
        System.out.println(list);

        list.set(2, "C"); // 为指定位置赋值指定元素
        System.out.println(list);

        System.out.println(list.get(1)); // 按索引查找元素

        list.add("b"); // 尾部添加指定元素
        System.out.println(list);

        System.out.println(list.indexOf("b")); // 从头到尾寻找第一个指定元素的索引
        System.out.println(list.lastIndexOf("b")); // 从尾到头寻找第一个指定元素的索引



    }

}
