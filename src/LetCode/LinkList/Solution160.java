package LetCode.LinkList;
//import

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

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







}
