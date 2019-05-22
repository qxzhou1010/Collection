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

            //�ո񲻿���
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
                    //i--��ԭ��������û�жԵ�ǰ���ַ�chars[i]û��������(��ջ)
                    //��һ��˵������ǰ��STATE���޷��Ե�ǰ��chars[i]��������
                    //��Ҫ��������STATE�д�����������break�󣬻ص�for���棬����һ��i++�Ĳ���
                    //���ԣ�Ϊ������һ��STATE���ܹ��������chars[i]���������Ա���i--
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
        //����״̬����
        final int BEGIN_STATE = 0;
        final int NUM_STATE = 1;
        final int OP_STATE = 2;

        //����״̬����������״̬����л�
        int STATE = BEGIN_STATE;
        //��������ʶ��
        int computate_flag = 0;
        //���ڰ��ַ���'0'-'9'ת��Ϊ����
        int number = 0;

        //��������ջ��һ��������ݣ�һ����Ų�����
        Stack<Integer> num_stack = new Stack<>();
        Stack<String> op_stack = new Stack<>();

        //���ַ�������ת��Ϊ�ַ����飬�������
        char[] s_char = s.toCharArray();
        for (int i=0; i<s_char.length; i++){

            //�����ַ����пո��Ӱ��
            if (s_char[i] == ' '){
                continue;
            }
            switch (STATE){
                //��ʼ״̬
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
                        //���ַ�������ת��Ϊ��ֵ
                        number = number*10 + s_char[i] - '0';
                    }else {
                        //���������֧���϶��������ַ�����������
                        //���Ƚ��ղŵ�������ջ
                        num_stack.push(number);
                        //�жϼ����־���Ƿ���Ҫ����
                        if (computate_flag == 1){
                            compute(num_stack, op_stack);
                        }

                        //���㣬Ϊ��һ�ε�ת����׼��
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
                        //�ַ�ת��Ϊ�ַ���������ѹ��ջ
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
        //�жϼ������
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
