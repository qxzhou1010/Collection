package leetCode.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class TestJavaQue {
    /**
     * java��׼����
     */
    public static void main(String[] args) {
        //1.�½�����
        Queue<String> queue = new LinkedList();
        //2.Ԫ�����
        queue.add("a");
        queue.add("b");
        System.out.println(queue);
        //2.Ԫ�س���(remove),�Ƚ��ȳ�������Ϊ�գ����׳��쳣
        queue.remove();
        System.out.println(queue);
        //3.Ԫ�س���(poll),Ԫ��Ϊ���׳�null
        queue.poll();
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
        //4.�ж϶����Ƿ�Ϊ��
        System.out.println(queue.isEmpty());
        queue.add("a");
        //5.�ж϶���Ԫ�ظ���
        System.out.println(queue.size());
        //6.��ȡ����ͷ��Ԫ��:element() ����Ϊ��ʱ�����쳣
        System.out.println(queue.element());
        //
        System.out.println(queue.peek());


    }
}
