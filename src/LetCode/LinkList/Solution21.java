package LetCode.LinkList;

public class Solution21 {

    public static void main(String[] args) {

    }

    /**
     * 自己写的
     * @param l1
     * @param l2
     * @return
     */
    static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode temp_head = new ListNode(0); //设置临时头节点
        ListNode ptr = temp_head;

        //遍历两个指针，两个指针都不为空
        while (l1 != null && l2!=null){
            if (l1.val < l2.val){
                ptr.next = l1;
                ptr = l1;
                l1 = l1.next;//l1继续前移，接着继续判断l1
            }else {
                ptr.next = l2;
                ptr = l2;
                l2 = l2.next;//l2继续前移，接着判断l2
            }

        }
        //跳出whileu循环，一定是至少一条链表遍历完了
        if (l1 != null){//如果l1还有剩余，
            ptr.next = l1;
        }
        if (l2 != null){//如果l2还有剩余
            ptr.next = l2;
        }
        return temp_head.next;
    }
    static ListNode mergeTwoLists02(ListNode l1, ListNode l2){
        ListNode new_head = new ListNode(0);
        ListNode ptr = new_head;

        while (l1!=null && l2!=null){
            if (l1.val < l2.val){
                ptr.next = l1;
                ptr = l1;
                l1 = l1.next;
            }else {
                ptr.next = l2;
                ptr = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null){
            ptr.next = l1;
        }
        if (l2 != null){
            ptr.next = l2;
        }

        return new_head.next;


    }



}
