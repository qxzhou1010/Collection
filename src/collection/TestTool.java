package collection;

import java.util.*;

public class TestTool {
    /**
     * Collection常用的工具类
     */
    public static void main(String[] args) {
        testList();
    }

    public static void testList(){
        List<String> a = new ArrayList<String>();
        for (int i=0; i<5; i++){
            a.add("a" + i);

        }
        System.out.println(a);

        Collections.shuffle(a); // 随机排序
        System.out.println(a);
        Collections.reverse(a); //逆序（这里是将上述随机排序的结果进行逆序）
        System.out.println(a);
        Collections.sort(a);//升序
        System.out.println(a);

        System.out.println(Collections.binarySearch(a, "a2")); // 二分查找特定元素，返回index
        Collections.fill(a, "hello"); //特定元素写入整个list
        System.out.println(a);
    }

}
