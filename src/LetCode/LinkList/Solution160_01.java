package LetCode.LinkList;

import java.util.List;

public class Solution160_01 {

    public static void main(String[] args) {

    }

    static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        // ���ȼ�����������ĳ���
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        if (lenA > lenB){
            int diff = lenA - lenB;
            // �ƶ��ϳ�����ͷ�ڵ㵽�϶�����ͷ�ڵ�һ�µ�λ��
            headA = shift(headA, diff);

            //ͬ���ƶ������ڵ㣬ֱ������򷵻�
            while (headA != null){
                if (headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            //����������������û�������ĵ㣬�򷵻�Null;
            return null;


        }else {

            int diff = lenB - lenA;
            // �ƶ��ϳ�����ͷ�ڵ㵽�϶�����ͷ�ڵ�һ�µ�λ��
            headA = shift(headB, diff);

            //ͬ���ƶ������ڵ㣬ֱ������򷵻�
            while (headA != null){
                if (headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            //����������������û�������ĵ㣬�򷵻�Null;
            return null;
        }
    }

    /**
     * ��ȡһ������ĳ���
     * @param head
     */
    static int getLen(ListNode head){
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }

    /**
     * �ƶ��ϳ�������϶�������ͬ��λ��
     * @param head ���ƶ�����ͷ�ڵ�
     * @param diff ��Ҫ�ƶ��ĳ���
     * @return
     */
    static ListNode shift(ListNode head, int diff){
        while ( head!= null && diff !=0){
            head = head.next;
            diff--;
        }
        return head;

    }






}
