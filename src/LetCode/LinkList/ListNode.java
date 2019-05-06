package LetCode.LinkList;

public class ListNode {
    int val;
    ListNode next;
    ListNode (int x){
        val = x;
        next = null;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3};
        ListNode head = new ListNode(0);
        ListNode head_t = head;
        for (int x:a){
            ListNode temp = new ListNode(x);//构造并初始化新节点
            head_t.next = temp;
            head_t = temp;
        }

//        // 遍历新链表
//        while (head_t != null){
//            System.out.println(head_t.val);
//            head_t = head_t.next;
//
//        }
    }

}
