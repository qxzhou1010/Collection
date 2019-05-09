package LetCode.LinkList;

import java.util.HashSet;
import java.util.Set;

public class Solution142 {

    public static void main(String[] args) {

    }

    static ListNode detectCycle(ListNode head) {
        //新建集合，用于存储链表节点
        Set<ListNode> set = new HashSet<ListNode>();

        //遍历链表，逐个检验
        while (head != null){
            if (set.contains(head)){
                //若集合包含这个节点，则返回
                return head;
            }
            set.add(head);//不包含，所以集合里暂时还没有这节点，添加
            head = head.next; //指针前移，继续遍历

        }
        return null;

    }

    /**
     * 快慢指针的思路
     * @param head
     * @return
     */
    static ListNode detectCycle01(ListNode head){
        ListNode fast = head;//快慢指针都从head开始
        ListNode slow = head;
        ListNode meet = null; //记录相遇的指针位置
        while (fast!= null){
            //先都各走一步
            fast = fast.next;
            slow = slow.next;
            if ( fast == null){
                //fast一定先走完整个链表，如果fast为null了，说明没有环
                return null;
            }

            fast = fast.next;
            if (fast == slow){
                //相遇，跳出while循环
                meet = fast;
                break;
            }


        }
        if (meet == null){ //meet==null，说明meet没有改变，说明没有环
            return null;
        }
        while (head!=null && meet != null){
            //head 和meet同样的速度出发，相遇的节点就是环的起始位置
            if (head == meet){
                return head;
            }
            head = head.next;
            meet = meet.next;
        }
        return null;

    }

}
