package leetCode.Stack;

import java.util.Queue;
import java.util.Stack;

public class TestJavaStack {
    /**
     * java标准栈
     */
    public static void main(String[] args) {
        Stack stack = new Stack();

        //1.判断栈是否为空
        System.out.println(stack.isEmpty());
        //2.元素进栈
        stack.push(0);
        System.out.println(stack.isEmpty());
        //3.取栈顶元素
        stack.push("b");
        System.out.println(stack.peek());
        //4.元素出栈
        stack.pop();
        System.out.println(stack.peek());
        //5.栈中元素个数
        System.out.println(stack.size());




    }

}
