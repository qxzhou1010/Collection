package leetCode.Stack;

import java.sql.SQLOutput;
import java.util.Stack;

public class Solution155 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.peek());

    }



}

class MinStack{
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStack(){

    }
    public void push (int x){
        if (stack.isEmpty() && min.isEmpty()){
            //�������ջ��Ϊ�գ�Ԫ��ֱ�ӽ�������ջ
            stack.push(x);
            min.push(x);
        }else {
            //Ԫ������ջ
            stack.push(x);

            if (x < min.peek()){
                //�������ջ��Ԫ�ر���һ��״̬��ջ����СֵҪС�Ļ���ѹ��minջ
                min.push(x);
            }else {
                //���򣬵�ǰ״̬ջ����Сֵ������һ��״̬ջ����Сֵ
                min.push(min.peek());
            }

        }
    }
    public void pop(){
        //Ԫ��ջ��minջ��Ҫͬʱpop
        stack.pop();
        min.pop();

    }
    public int top(){
        return stack.peek();
    }
    public int getMin(){
        return min.peek();
    }





}