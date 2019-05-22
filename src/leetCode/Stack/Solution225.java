package leetCode.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列的数据结构来实现栈
 */
public class Solution225 {
    public static void main(String[] args) {

    }
}

class MyStack{

    //新建java标准队列
    Queue<Integer> queue = new LinkedList<>();

    public MyStack(){
    }

    public void push(int x){
        //新建临时队列
        Queue<Integer> temp = new LinkedList<>();
        //数据入队
        temp.add(x);
        //原始队列不为空，将其所有元素导入临时队列
        while (!queue.isEmpty()){
            //取队列元素，压入临时队列
            temp.add(queue.element());
            //移除队列首部元素
            queue.remove();
        }
        //临时队列不为空
        while (!temp.isEmpty()){
            //取临时队列元素，压入原始队列
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

    //新建java标准队列
    Queue<Integer> queue = new LinkedList<>();

    public void push(int x){
        //新建临时队列
        Queue<Integer> temp = new LinkedList<>();
        //入队
        temp.add(x);

        //将队列queue的数据都拷贝到temp中
        while (!queue.isEmpty()){
            temp.add( queue.element());
            //移除队列头部元素
            queue.remove();
        }
        //队列temp的元素拷贝到queue
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

        //queue复制到temp
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
