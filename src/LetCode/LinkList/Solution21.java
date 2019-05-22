package LetCode.LinkList;

public class Solution21 {

    public static void main(String[] args) {

    }

    /**
     * �Լ�д��
     * @param l1
     * @param l2
     * @return
     */
    static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode temp_head = new ListNode(0); //������ʱͷ�ڵ�
        ListNode ptr = temp_head;

        //��������ָ�룬����ָ�붼��Ϊ��
        while (l1 != null && l2!=null){
            if (l1.val < l2.val){
                ptr.next = l1;
                ptr = l1;
                l1 = l1.next;//l1����ǰ�ƣ����ż����ж�l1
            }else {
                ptr.next = l2;
                ptr = l2;
                l2 = l2.next;//l2����ǰ�ƣ������ж�l2
            }

        }
        //����whileuѭ����һ��������һ�������������
        if (l1 != null){//���l1����ʣ�࣬
            ptr.next = l1;
        }
        if (l2 != null){//���l2����ʣ��
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
