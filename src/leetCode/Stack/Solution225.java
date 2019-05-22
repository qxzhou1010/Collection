package leetCode.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �ö��е����ݽṹ��ʵ��ջ
 */
public class Solution225 {
    public static void main(String[] args) {

    }
}

class MyStack{

    //�½�java��׼����
    Queue<Integer> queue = new LinkedList<>();

    public MyStack(){
    }

    public void push(int x){
        //�½���ʱ����
        Queue<Integer> temp = new LinkedList<>();
        //�������
        temp.add(x);
        //ԭʼ���в�Ϊ�գ���������Ԫ�ص�����ʱ����
        while (!queue.isEmpty()){
            //ȡ����Ԫ�أ�ѹ����ʱ����
            temp.add(queue.element());
            //�Ƴ������ײ�Ԫ��
            queue.remove();
        }
        //��ʱ���в�Ϊ��
        while (!temp.isEmpty()){
            //ȡ��ʱ����Ԫ�أ�ѹ��ԭʼ����
            queue.add(temp.element());
            temp.remove();
        }
    }
    public int pop(){
        int x = queue.element();
        queue.remove();
        return x;
    }
    public int top(){
        return queue.element();
    }
    public boolean empty(){
        return queue.isEmpty();

    }

}

class MyStack02{
    public MyStack02(){

    }

    //�½�java��׼����
    Queue<Integer> queue = new LinkedList<>();

    public void push(int x){
        //�½���ʱ����
        Queue<Integer> temp = new LinkedList<>();
        //���
        temp.add(x);

        //������queue�����ݶ�������temp��
        while (!queue.isEmpty()){
            temp.add( queue.element());
            //�Ƴ�����ͷ��Ԫ��
            queue.remove();
        }
        //����temp��Ԫ�ؿ�����queue
        while (!temp.isEmpty()){
            queue.add(temp.element());
            temp.remove();
        }

    }
    public int pop(){
        int x = queue.element();
        queue.remove();
        return x;

    }
    public int top(){
        return queue.element();
    }
    public boolean empty(){
        return queue.isEmpty();
    }

}

class MyStack03{
    public MyStack03(){

    }
    Queue<Integer> queue = new LinkedList<>();
    public void push(int x){
        Queue<Integer> temp = new LinkedList<>();

        temp.add(x);

        //queue���Ƶ�temp
        while (!temp.isEmpty()){
            temp.add(queue.element());
            queue.poll();
        }

        //temp--->queue
        while (!temp.isEmpty()){
            queue.add(temp.element());
            temp.poll();

        }


    }
    public int pop(){
        int x = queue.element();
        queue.poll();
        return x;
    }

    public int top(){
        return queue.element();
    }
    public boolean empty(){
        return queue.isEmpty();
    }





}
