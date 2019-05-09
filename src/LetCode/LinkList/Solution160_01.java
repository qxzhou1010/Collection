package LetCode.LinkList;

import java.util.List;

public class Solution160_01 {

    public static void main(String[] args) {

    }

    static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        // 首先计算两个链表的长度
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        if (lenA > lenB){
            int diff = lenA - lenB;
            // 移动较长链表头节点到较短链表头节点一致的位置
            headA = shift(headA, diff);

            //同步移动两个节点，直至相等则返回
            while (headA != null){
                if (headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            //遍历完整个链表，都没有这样的点，则返回Null;
            return null;


        }else {

            int diff = lenB - lenA;
            // 移动较长链表头节点到较短链表头节点一致的位置
            headA = shift(headB, diff);

            //同步移动两个节点，直至相等则返回
            while (headA != null){
                if (headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            //遍历完整个链表，都没有这样的点，则返回Null;
            return null;
        }
    }

    /**
     * 获取一个链表的长度
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
     * 移动较长链表到与较短链表相同的位置
     * @param head 待移动链表头节点
     * @param diff 需要移动的长度
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
