package LetCode.LinkList;

public class ListNode {
    int val;
    ListNode next;
    ListNode (int x){
        val = x;
        next = null;
    }
    public static void main(String[] args) {
//        int[] a = {1,2,3};
//        ListNode head = new ListNode(0);
//        ListNode head_t = head;
//        for (int x:a){
//            ListNode temp = new ListNode(x);//构造并初始化新节点
//            head_t.next = temp;
//            head_t = temp;
//        }

//        // 遍历新链表
//        while (head_t != null){
//            System.out.println(head_t.val);
//            head_t = head_t.next;
//
//        }
    }

    /**
     * 将一个整型数组转换为链表
     * @param a
     * @return
     */
    public static ListNode createList(int[] a){
        //初始化头节点
        ListNode head = new ListNode(a[0]);
        ListNode head_t = head;
        for (int i=1; i<a.length; i++){
            ListNode temp = new ListNode(a[i]);//构造并初始化新节点
            head_t.next = temp;
            head_t = temp;

        }
        return head;
    }

    /**
     * 遍历链表并打印
     * @param head
     */
    public static void printList(ListNode head){
        while (head != null){
            System.out.print(head.val+"--->");
//            System.out.println(head.val);
            head = head.next;
        }
        System.out.print("null");

    }

}
