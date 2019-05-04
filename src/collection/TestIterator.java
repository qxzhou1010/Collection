package collection;

import z.qx.oo1203.TestHash;

import java.nio.channels.NonReadableChannelException;
import java.util.*;
import java.util.stream.Stream;

public class TestIterator {
    public static void main(String[] args) {
//        testList();
//        testSet();
//        testMap01();
        testMap02();
    }

    public static void testList(){
        /**
         * ��List�ı���
         */
        List<String> aList = new ArrayList<String>();
        for( int i=0; i<5; i++){
            aList.add("a" + i);
        }
        System.out.println(aList);

        // �����������������ж�ɾ��Ԫ�ص������ʹ�õ�����������
        for (Iterator<String> iter = aList.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp + "\t");
            if(temp.endsWith("3")){
                iter.remove(); // ɾ����3��β���ַ���
            }

        }
        System.out.println();
        System.out.println(aList);
    }
    public static void testSet(){
        /**
         * ����������Set
         */
        Set<String> set = new HashSet<String>();

        for (int i=0; i<5; i++){
            set.add("a" + i);
        }
        System.out.println(set);

        for (Iterator<String> iter = set.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp + "\t");
        }
        System.out.println();
        System.out.println(set);


    }

    public static void testMap01(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("A", "zz");
        map.put("B", "aaa");

        Set<Map.Entry<String, String>> ss = map.entrySet(); //??
        for (Iterator<Map.Entry<String, String>> iterator = ss.iterator(); iterator.hasNext();){
            Map.Entry<String, String> e = iterator.next();
            System.out.println(e.getKey() + "----" + e.getValue());
        }


    }
    public static void testMap02(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("A", "a");
        map.put("B", "b");

        Set<String> stringSet = map.keySet();
        for (Iterator<String> iterator = stringSet.iterator(); iterator.hasNext();){
            String key = iterator.next();
            System.out.println(key + "--->" + map.get(key));
        }



    }


}
