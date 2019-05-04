package collection;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestList {
    //list�����򣬿��ظ�������
    //����ʵ������ ArrayList, LinkedList, Vector

    public static void main(String[] args) {
//        test01();
//        test02();
        Test03();
    }

    public static void test01(){
        /**
         * list���÷���
         */
        List<String> list = new ArrayList<String>();
        System.out.println(list.isEmpty()); // �ж�list�Ƿ�Ϊ�գ� true

        list.add("aa"); //����Ԫ��
        System.out.println(list.isEmpty()); // �ٴ��ж�list�Ƿ�Ϊ��

        list.add("bb");
        list.add("cc");
        System.out.println(list);

        System.out.println("size of the list:" + list.size()); //��ȡlist�ĳ���

        System.out.println("list contains some element?" + list.contains("aa")); //�ж�list�Ƿ����ָ��Ԫ��

        list.remove("aa"); //�Ƴ�ָ��Ԫ��

        System.out.println(list);

        Object[] objs = list.toArray();

        System.out.println("convert to the Object array" + Arrays.toString(objs));

        list.clear(); // �������Ԫ��
        System.out.println("clear all the elements"+ list);

    }
    public static void test02(){
        /**
         * ����list֮���Ԫ�ش���
         */
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();

        list1.add("aa");
        list1.add("bb");
        list1.add("cc");

        list2.add("aa");
        list2.add("ba");
        list2.add("df");

        System.out.println(list1.containsAll(list2)); // list1�Ƿ����list2�е�����Ԫ��
        System.out.println(list1);
        System.out.println(list2);
        list1.addAll(list2); // list2������Ԫ����ӵ�list1
        System.out.println(list1);
        list1.removeAll(list2);// ��list1��ɾ��list1��list2�й��е�Ԫ��
        System.out.println(list1);
        list1.retainAll(list2); //����߽���
        System.out.println(list1);

    }

    public static void Test03(){
        /**
         * ����list�������������ķ���
         */
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list);

        list.add(2, "da"); // ���ƶ�λ�ò����ƶ�Ԫ��(�ַ���)
        System.out.println(list);

        list.remove(2); // �Ƴ�ָ��λ�õ�Ԫ��
        System.out.println(list);

        list.set(2, "C"); // Ϊָ��λ�ø�ֵָ��Ԫ��
        System.out.println(list);

        System.out.println(list.get(1)); // ����������Ԫ��

        list.add("b"); // β�����ָ��Ԫ��
        System.out.println(list);

        System.out.println(list.indexOf("b")); // ��ͷ��βѰ�ҵ�һ��ָ��Ԫ�ص�����
        System.out.println(list.lastIndexOf("b")); // ��β��ͷѰ�ҵ�һ��ָ��Ԫ�ص�����



    }

}
