package leetCode.Stack;

import java.util.Queue;
import java.util.Stack;

public class TestJavaStack {
    /**
     * java��׼ջ
     */
    public static void main(String[] args) {
        Stack stack = new Stack();

        //1.�ж�ջ�Ƿ�Ϊ��
        System.out.println(stack.isEmpty());
        //2.Ԫ�ؽ�ջ
        stack.push(0);
        System.out.println(stack.isEmpty());
        //3.ȡջ��Ԫ��
        stack.push("b");
        System.out.println(stack.peek());
        //4.Ԫ�س�ջ
        stack.pop();
        System.out.println(stack.peek());
        //5.ջ��Ԫ�ظ���
        System.out.println(stack.size());




    }

}
