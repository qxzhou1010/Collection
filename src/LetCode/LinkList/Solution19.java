package LetCode.LinkList;

public class Solution19 {

    public static void main(String[] args) {

    }

    /**
     * ˼·һ:�Ƴ�������n���������Ƴ�������len - n + 1��Ԫ��
     * ����һ������ָ�룬����ƶ�(len-n+1) - 1 �Σ��ҵ����Ƴ�Ԫ�ص�ǰһ��λ��
     * һ��ϸ�����ڵ���Ҫ�Ƴ�����������1���ڵ�ʱ����Ҫ����pre_pr�Ƿ�Ϊnull���ж�
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
        //��������null��˵��Ҫ�Ƴ���Ԫ�ز��ǵ�1��
        if (pre_ptr!=null){
            pre_ptr.next = ptr.next;
            return head;
        }else {
            return head.next;

        }
    }

}
