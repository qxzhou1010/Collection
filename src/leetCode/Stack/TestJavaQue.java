package leetCode.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class TestJavaQue {
    /**
     * java标准队列
     */
    public static void main(String[] args) {
        //1.新建队列
        Queue<String> queue = new LinkedList();
        //2.元素入队
        queue.add("a");
        queue.add("b");
        System.out.println(queue);
        //2.元素出队(remove),先进先出，若对为空，会抛出异常
        queue.remove();
        System.out.println(queue);
        //3.元素出队(poll),元素为空抛出null
        queue.poll();
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
        //4.判断队列是否为空
        System.out.println(queue.isEmpty());
        queue.add("a");
        //5.判断队列元素个数
        System.out.println(queue.size());
        //6.获取队列头部元素:element() 队列为空时会有异常
        System.out.println(queue.element());
        //
        System.out.println(queue.peek());


    }
}
