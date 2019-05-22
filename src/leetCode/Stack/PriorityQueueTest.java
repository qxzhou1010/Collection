package leetCode.Stack;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
    /**
     * ����java��׼�����ȼ�����(��С��)�Ļ���ʹ��
     */
    public static void main(String[] args) {
//        test01();
        test02();



    }

    /**
     * ���ȶ���ʵ����С��(Ĭ��)
     */
    static void test01(){
        Queue<Integer> queue = new PriorityQueue<>();
        //����Ԫ��
        queue.add(8);
        queue.add(4);
        queue.add(10);
        queue.add(23);
        queue.add(1);
//        System.out.println(queue.element());
        while (!queue.isEmpty()){
            //���Ԫ��
            System.out.println(queue.element());
            queue.remove();
        }

    }

    /**
     * ���ȶ���ʵ������
     */
    static void test02(){
        //�Զ���ȽϷ�ʽ��ʵ������
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
            //���Ԫ��
            System.out.println(queue.element());
            queue.remove();
        }








    }



}
