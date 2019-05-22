package leetCode.Stack;

import jdk.dynalink.beans.StaticClass;
import jdk.swing.interop.SwingInterOpUtils;
import org.apache.xerces.impl.Constants;
import org.apache.xerces.impl.xs.util.LSInputListImpl;
import org.w3c.dom.svg.SVGLength;

import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.UnknownFormatConversionException;

public class Solution224 {
    public static void main(String[] args) {
//        String s = "(1+(1-1)-1)+1";
//        String s = "(1+(4+5+2)-3)+(6+8)";
        String s = "(2-1)-(2+1)";
        int res = calculate(s);
        System.out.println(res);


    }

    public static int calculate(String s) {
        final int  BEGIN_STATE = 0;
        final int NUMBER_STATE = 1;
        final int OP_STATE = 2;

        Stack<Integer> num_stack = new Stack<>();
        Stack<String> op_stack = new Stack<>();

        int number = 0;
        int STATE = BEGIN_STATE;
        int compute_flag = 0;


        char[] chars = s.toCharArray();
//        System.out.println(chars);

        for (int i=0; i<chars.length; i++){

            //空格不考虑
            if (chars[i] == ' '){
                continue;
            }


            switch (STATE){

                case BEGIN_STATE:
                    if (chars[i] >='0' && chars[i] <= '9'){
                        STATE = NUMBER_STATE;
                    }else{
                        STATE = OP_STATE;
                    }
                    //i--的原因是这里没有对当前的字符chars[i]没有做处理(入栈)
                    //换一种说法，当前的STATE下无法对当前的chars[i]做出处理
                    //需要在其他的STATE中处理，但是这里break后，回到for里面，会有一个i++的操作
                    //所以，为了在下一个STATE中能够对这里的chars[i]做处理，所以必须i--
                    i--;
                    break;

                case NUMBER_STATE:

                    if (chars[i] >= '0' && chars[i] <='9'){
                        number = number*10 + chars[i] - '0';
                    }else {
                        num_stack.push(number);
                        if (compute_flag == 1){
                            compute(num_stack,op_stack);
                        }
                        number = 0;
                        i--;
                        STATE = OP_STATE;
                    }
                    break;

                case OP_STATE:
                    if (chars[i] == '+' || chars[i] == '-'){
                        String temp = String.valueOf(chars[i]);
                        op_stack.push(temp);
                        compute_flag = 1;
                    }else if (chars[i] == '('){
                        STATE  = NUMBER_STATE;
                        compute_flag = 0;

                    }else if (chars[i] >= '0' && chars[i] <='9'){
                        STATE = NUMBER_STATE;
                        i--;
                    }else if (chars[i] == ')'){
                        compute(num_stack, op_stack);
                    }
                    break;
            }
        }
        if (number != 0){
            num_stack.push(number);
            compute(num_stack, op_stack);
        }
        if (number == 0 && num_stack.isEmpty()){
            return 0;
        }
        return num_stack.peek();

    }

    public static int calculate02(String s){
        //定义状态常量
        final int BEGIN_STATE = 0;
        final int NUM_STATE = 1;
        final int OP_STATE = 2;

        //定义状态变量，用于状态间的切换
        int STATE = BEGIN_STATE;
        //定义计算标识符
        int computate_flag = 0;
        //用于把字符的'0'-'9'转换为数字
        int number = 0;

        //定义两个栈，一个存放数据，一个存放操作符
        Stack<Integer> num_stack = new Stack<>();
        Stack<String> op_stack = new Stack<>();

        //将字符串对象转换为字符数组，方便遍历
        char[] s_char = s.toCharArray();
        for (int i=0; i<s_char.length; i++){

            //消除字符串中空格的影响
            if (s_char[i] == ' '){
                continue;
            }
            switch (STATE){
                //初始状态
                // 0 - 9 ---> NUM_STATE
                // other ---> OP_STATE
                case BEGIN_STATE:
                    if (s_char[i]>'0' && s_char[i]<'9'){
                        STATE = NUM_STATE;
                    }else {
                        STATE = OP_STATE;
                    }
                    i--;
                    break;
                case NUM_STATE:
                    if (s_char[i] >'0' && s_char[i] < '9'){
                        //将字符的数字转换为数值
                        number = number*10 + s_char[i] - '0';
                    }else {
                        //进入这个分支，肯定遇到的字符不是数字了
                        //首先将刚才的数字入栈
                        num_stack.push(number);
                        //判断计算标志，是否需要计算
                        if (computate_flag == 1){
                            compute(num_stack, op_stack);
                        }

                        //置零，为下一次的转换做准备
                        number = 0;
                        //
                        i--;
                        STATE = OP_STATE;
                    }
                    break;

                case OP_STATE:
                    if (s_char[i] > '0' && s_char[i] < '9'){
                        STATE = NUM_STATE;
                        i--;
                    }else if (s_char[i] == '+' || s_char[i] == '-'){
                        //字符转换为字符串对象再压入栈
                        String temp = String.valueOf(s_char[i]);
                        op_stack.push(temp);
                        computate_flag = 1;

                    }else if (s_char[i] == '('){
                        STATE = NUM_STATE;
                        computate_flag = 0;

                    }else if (s_char[i] == ')'){
                        compute(num_stack, op_stack);

                    }
                    break;
            }
        }
        if (number!=0){
            num_stack.push(number);
            compute(num_stack, op_stack);
        }
        //判断极端情况
        if (number == 0 && num_stack.isEmpty()){
            return 0;
        }

        return num_stack.peek();








    }

    public static int calculate03(String s){
        final int BEGIN_STATE = 0;
        final int NUM_STATE = 1;
        final int OP_STATE = 2;

        Stack<Integer> num_stack = new Stack<>();
        Stack<String> op_stack = new Stack<>();

        int number = 0;
        int STATE = BEGIN_STATE;
        int com_flag = 0;




        for (int i=0; i<s.length(); i++){

            if (s.charAt(i) == ' '){
                continue;
            }

            switch (STATE){
                case BEGIN_STATE:
                    if (s.charAt(i) >= '0' && s.charAt(i) <= '9' ){
                        STATE = NUM_STATE;
                    }else {
                        STATE = OP_STATE;
                    }
                    i--;
                    break;

                case NUM_STATE:
                    if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                        number = number * 10 + s.charAt(i) - '0';
                    }else {
                        num_stack.push(number);
                        if (com_flag == 1){
                            compute(num_stack, op_stack);
                        }
                        number = 0;
                        i--;
                        STATE = OP_STATE;
                    }
                    break;

                case OP_STATE:
                    if (s.charAt(i)>='0' && s.charAt(i)<='9' ){
                        STATE = NUM_STATE;
                        i--;
                    }else if (s.charAt(i) == '+' || s.charAt(i) == '-'){
                        op_stack.push(String.valueOf(s.charAt(i)));
                        com_flag = 1;
                    }else if (s.charAt(i) == '('){
                        STATE = NUM_STATE;
                        com_flag = 0;
                    }else if (s.charAt(i) == ')'){
                        compute(num_stack, op_stack);
                    }
                    break;
            }
        }
        if (number != 0 ){
            num_stack.push(number);
            compute(num_stack, op_stack);
        }
        if (number == 0 && num_stack.isEmpty()){
            return 0;
        }
        return num_stack.peek();


    }




//    static void compute(Stack<Integer> num_stack, Stack<String> op_stack){
//        if (num_stack.size() < 2){
//            return;
//        }
//        int num2 = num_stack.peek();
//        num_stack.pop();
//        int num1 = num_stack.peek();
//        num_stack.pop();
//        if (!op_stack.isEmpty() && op_stack.peek().equals("+")){
//            num_stack.push(num2 + num1);
//        }else if (!op_stack.isEmpty() && op_stack.peek().equals("-")){
//            num_stack.push(num1 - num2);
//        }
//        op_stack.pop();
//    }
    static void compute(Stack<Integer> num_stack, Stack<String> op_stack){
        if (num_stack.size() < 2){
            return;
        }
        int num2 = num_stack.peek();
        num_stack.pop();
        int num1 = num_stack.peek();
        num_stack.pop();

        if (!op_stack.isEmpty() && op_stack.peek().equals("+")){
            num_stack.push(num2 + num1);
            op_stack.pop();
        }else if (!op_stack.isEmpty() && op_stack.peek().equals("-")){
            num_stack.push(num1 - num2);
            op_stack.pop();
        }

    }


}
