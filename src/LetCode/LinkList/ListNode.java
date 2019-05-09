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
//            ListNode temp = new ListNode(x);//���첢��ʼ���½ڵ�
//            head_t.next = temp;
//            head_t = temp;
//        }

//        // ����������
//        while (head_t != null){
//            System.out.println(head_t.val);
//            head_t = head_t.next;
//
//        }
    }

    /**
     * ��һ����������ת��Ϊ����
     * @param a
     * @return
     */
    public static ListNode createList(int[] a){
        //��ʼ��ͷ�ڵ�
        ListNode head = new ListNode(a[0]);
        ListNode head_t = head;
        for (int i=1; i<a.length; i++){
            ListNode temp = new ListNode(a[i]);//���첢��ʼ���½ڵ�
            head_t.next = temp;
            head_t = temp;

        }
        return head;
    }

    /**
     * ����������ӡ
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
