package LetCode.LinkList;


import javax.sound.midi.Soundbank;
import javax.xml.stream.events.StartDocument;
import java.util.List;
import java.util.Map;

public class Solution206 {

    public static void main(String[] args) {
        int[] list = {1,2,3,4,5,6,7,8,9};
        ListNode head = ListNode.createList(list);
        ListNode temp = head;
        ListNode temp1 = head;
        ListNode.printList(temp);
        System.out.println(); //换行
        ListNode new_head = null;
        new_head = reverseList(head);
        ListNode.printList(new_head);
//
//        new_head = reverseBetween01(temp1, 3, 5);
//        ListNode.printList(new_head);



    }
    static ListNode reverseList(ListNode head){
        /**
         * 链表反转:整个链表全都反转
         */
        ListNode new_head = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = new_head;
            new_head = head;
            head = next;
        }
        return new_head;

    }

    /**
     * 在链表指定位置进行反转
     * @param head
     * @param start 起点
     * @param end   终点
     * @return
     */
    static ListNode reverseBetween(ListNode head, int start, int end){
        ListNode pre_head = null; //记录head前一个位置
        ListNode result = head; // 定义完成反转后链表的结点
        //移动head,和pre_head 至需要反转段落的起始位置
        while (head != null && (--start)!=0){
            // 需要移动start-1次，所以--start
            pre_head = head;
            head = head.next;
        }
        //while循环结束，找到对应的起始位置
        ListNode tail = head; //定义反转后的尾部节点指针,就是现在反转区间的头节点
        ListNode new_head = null;
        ListNode next = null;
        //反转
        int len = end - start + 1;
        while (head != null && len!=0){
            next = head.next;
            head.next = new_head;
            new_head = head;
            head =  next;
            len--;
        }
        //完成反转，需要连接上头尾两端
        //现在head的位置就是剩下链表部分的第一个位置
//        tail.next = head;
        try {
            if (head != null){
                tail.next = head;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //但是对于前半部分的连接，需要有一个判断
        if (pre_head != null){
            // 不是从第一个节点开始反转
            pre_head.next = new_head;
        }else {
            result = new_head;
        }
    return result;
    }
    static ListNode reverseBetween01(ListNode head, int m, int n){
        int change_len = n-m+1;
        ListNode pre_head = null;
        ListNode result = head;
        while( head != null && (--m)!=0 ){
            pre_head = head;
            head = head.next;
        }
        ListNode next = null;
        ListNode new_head = null;
        ListNode tail = head;
        while(head !=null && change_len!=0){
            next = head.next;
            head.next = new_head;
            new_head = head;
            head = next;
            change_len--;

        }
//        tail.next = head;
        try {
            if (head != null){
                tail.next = null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if(pre_head != null){
            pre_head.next = new_head;
        }
        else{
            result = new_head;
        }
        return result;
    }


}
