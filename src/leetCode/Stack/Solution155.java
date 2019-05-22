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
            //如果两个栈都为空，元素直接进入两个栈
            stack.push(x);
            min.push(x);
        }else {
            //元素先入栈
            stack.push(x);

            if (x < min.peek()){
                //如果新入栈的元素比上一个状态下栈的最小值要小的话，压入min栈
                min.push(x);
            }else {
                //否则，当前状态栈的最小值就是上一个状态栈的最小值
                min.push(min.peek());
            }

        }
    }
    public void pop(){
        //元素栈和min栈需要同时pop
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