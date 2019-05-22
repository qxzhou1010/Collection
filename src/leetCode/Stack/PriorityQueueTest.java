package leetCode.Stack;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
    /**
     * 测试java标准的优先级队列(最小堆)的基本使用
     */
    public static void main(String[] args) {
//        test01();
        test02();



    }

    /**
     * 优先队列实现最小堆(默认)
     */
    static void test01(){
        Queue<Integer> queue = new PriorityQueue<>();
        //增加元素
        queue.add(8);
        queue.add(4);
        queue.add(10);
        queue.add(23);
        queue.add(1);
//        System.out.println(queue.element());
        while (!queue.isEmpty()){
            //输出元素
            System.out.println(queue.element());
            queue.remove();
        }

    }

    /**
     * 优先队列实现最大堆
     */
    static void test02(){
        //自定义比较方式，实现最大堆
        Queue<Integer> queue = new PriorityQueue<Integer>(11, new Comparator<Integer>(){
            public int compare(Integer t1, Integer t2){
                return t2 - t1;
            }
        });
        queue.add(8);
        queue.add(4);
        queue.add(10);
        queue.add(23);
        queue.add(1);

        while (!queue.isEmpty()){
            //输出元素
            System.out.println(queue.element());
            queue.remove();
        }








    }



}
