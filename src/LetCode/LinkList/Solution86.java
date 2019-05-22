package LetCode.LinkList;

public class Solution86 {

    public static void main(String[] args) {

    }
    public ListNode partition(ListNode head, int x){
        ListNode less_head = new ListNode(0);
        ListNode ptr_less = null;
        ListNode more_head = new ListNode(0);
        ListNode ptr_more = null;

        while (head != null){
            if (head.val < x){
                if (ptr_less == null){
                    // 表示是第一次遇见这样的节点
                    ptr_less = head;
                    less_head.next = ptr_less;
                }else {
                    ptr_less.next = head;
                    ptr_less = ptr_less.next;

                }

            }else {
                if (ptr_more == null){
                    ptr_more = head;
                    more_head.next = ptr_more;
                }else {
                    ptr_more.next = head;
                    ptr_more = ptr_more.next;
                }



        }
            head = head.next;

        }

        ptr_less.next = more_head.next;
        ptr_more.next = null;

        return less_head.next;
    }
    static ListNode partition01(ListNode head, int x){
        ListNode less_head = new ListNode(0);
        ListNode more_head = new ListNode(0);
        ListNode less_ptr = less_head;
        ListNode more_ptr = more_head;

        while ( head!=null){
            if (head.val < x){
                less_ptr.next = head;
                less_ptr = head;
            }else {
                more_ptr.next = head;
                more_ptr = head;

            }
            head = head.next;//遍历链表

        }
        less_ptr.next = more_head.next;
        more_ptr.next = null;
        return less_head.next;


    }
    static ListNode partition02(ListNode head, int x){
        ListNode less_head = new ListNode(0);
        ListNode less_ptr = less_head;
        ListNode more_head = new ListNode(0);
        ListNode more_ptr = more_head;

        while (head!=null){
            if (head.val < x){
                less_ptr.next = head;
                less_ptr = head;
            }else {
                more_ptr.next = head;
                more_ptr = head;
            }
            head = head.next;

        }
        less_ptr.next = more_head.next;
        more_ptr.next = null;

        return less_head;

    }
    static ListNode partition03(ListNode head, int x){
        //用于小于x节点的临时头节点
        ListNode head_less = new ListNode(0);
        //工作指针
        ListNode ptr_less = head_less;
        //用于大于x节点的临时头节点
        ListNode head_more = new ListNode(0);
        ListNode ptr_more = head_more;

        while (head!=null){//遍历原链表
            if (head.val < x){
                //如果小于x，添加到head_less后面
                //添加过程由ptr_less来完成
                ptr_less.next = head;
                ptr_less = head;
            }else {
                //如果大于x，添加到head_more后面
                ptr_more.next = head;
                ptr_more = head;
            }
            head = head.next;//遍历原链表
        }

        //完成遍历后，连接两部分
        ptr_more.next = null;
        ptr_less.next = head_more.next;
        //注意返回新链表的第一个节点，而不是临时头节点
        return head_less.next;

    }


}
