package leetCode.Stack;

import java.util.Stack;

/**
 * ʹ��ջ��ʵ�ֶ���
 */


public class Solution232 {
}

class MyQueue{

    public MyQueue(){

    }

    //�½�java��׼ջ
    Stack<Integer> stack_temp = new Stack<>();
    //�½���ʱջ
    Stack<Integer> stack = new Stack<>();

    public void push( int x){
        //��Ԫ��ѹ����ʱջ
        Stack<Integer> temp = new Stack<>();
        //stack����Ԫ��ѹ��temp
        while (!stack.isEmpty()){
            temp.push(stack.peek());
            stack.pop();
        }
        temp.push(x);

        //tempԪ��ѹ��stack
        while (!temp.isEmpty()){
            stack.push(temp.peek());
            temp.pop();
        }
    }

    public int pop(){
        //����ʱջ������Ԫ�ظ��Ƶ�stack
        //ȡջ��Ԫ��
        int a = stack.peek();
        stack.pop();
        return a;
    }
    public int peek(){
        return stack.peek();
    }
    public boolean empty(){
        return stack.isEmpty();

    }


}
class MyQueue02{

    Stack<Integer> data = new Stack<>();
    public void push(int x){
        Stack<Integer> temp = new Stack<>();

        while (!data.isEmpty()){
            temp.push(data.peek());
            data.pop();
        }
        temp.push(x);
        while (!temp.isEmpty()){
            data.push(temp.peek());
            temp.pop();
        }


    }

    public int pop(){
        int x = data.peek();
        data.pop();
        return x;

    }
    public int peek(){
        return data.peek();
    }
    public boolean empty(){
        return data.isEmpty();
    }



}