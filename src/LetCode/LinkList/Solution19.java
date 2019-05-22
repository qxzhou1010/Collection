package LetCode.LinkList;

public class Solution19 {

    public static void main(String[] args) {

    }

    /**
     * 思路一:移除倒数第n个，就是移除正数第len - n + 1个元素
     * 建立一个工作指针，向后移动(len-n+1) - 1 次，找到该移除元素的前一个位置
     * 一个细节在于当需要移除的是正数第1个节点时候，需要利用pre_pr是否为null来判断
     * @param head
     * @param n
     * @return
     */
    public static  ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr = head;
        ListNode pre_ptr = null;

        int len = ListNode.getLen(head);
        int num = len - n + 1;
        while (ptr!=null && (--num)!=0){
            pre_ptr = ptr;
            ptr = ptr.next;
        }
        //它不等于null，说明要移除的元素不是第1个
        if (pre_ptr!=null){
            pre_ptr.next = ptr.next;
            return head;
        }else {
            return head.next;

        }
    }

}
