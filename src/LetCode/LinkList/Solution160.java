package LetCode.LinkList;
//import

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Solution160 {


    public static void main(String[] args) {



    }


    static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        List<ListNode> list = new ArrayList<ListNode>();

        // ����A����
        while (headA != null){
            list.add(headA);
            headA = headA.next;
        }
        //����B��������list�����Ƚ�
        while (headB != null){
            if (list.contains(headB)){
                return headB;
            }
            headB = headB.next;

        }
        return null;

    }
    static ListNode getIntersectionNode01(ListNode headA, ListNode headB){
        List<ListNode> temp = new Vector<>();
        while (headA!=null){
            temp.add(headA);
            headA = headA.next;
        }
        while (headB!=null){
            if (temp.contains(headB)){
                return headB;
            }
            headB = headB.next;

        }
        return null;





    }







}
