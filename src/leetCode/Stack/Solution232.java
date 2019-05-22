package leetCode.Stack;

import java.util.Stack;

/**
 * 使用栈来实现队列
 */


public class Solution232 {
}

class MyQueue{

    public MyQueue(){

    }

    //新建java标准栈
    Stack<Integer> stack_temp = new Stack<>();
    //新建临时栈
    Stack<Integer> stack = new Stack<>();

    public void push( int x){
        //将元素压入临时栈
        Stack<Integer> temp = new Stack<>();
        //stack所有元素压入temp
        while (!stack.isEmpty()){
            temp.push(stack.peek());
            stack.pop();
        }
        temp.push(x);

        //temp元素压入stack
        while (!temp.isEmpty()){
            stack.push(temp.peek());
            temp.pop();
        }
    }

    public int pop(){
        //将临时栈的所有元素复制到stack
        //取栈顶元素
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