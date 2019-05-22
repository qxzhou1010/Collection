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
                    // ��ʾ�ǵ�һ�����������Ľڵ�
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
            head = head.next;//��������

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
        //����С��x�ڵ����ʱͷ�ڵ�
        ListNode head_less = new ListNode(0);
        //����ָ��
        ListNode ptr_less = head_less;
        //���ڴ���x�ڵ����ʱͷ�ڵ�
        ListNode head_more = new ListNode(0);
        ListNode ptr_more = head_more;

        while (head!=null){//����ԭ����
            if (head.val < x){
                //���С��x����ӵ�head_less����
                //��ӹ�����ptr_less�����
                ptr_less.next = head;
                ptr_less = head;
            }else {
                //�������x����ӵ�head_more����
                ptr_more.next = head;
                ptr_more = head;
            }
            head = head.next;//����ԭ����
        }

        //��ɱ���������������
        ptr_more.next = null;
        ptr_less.next = head_more.next;
        //ע�ⷵ��������ĵ�һ���ڵ㣬��������ʱͷ�ڵ�
        return head_less.next;

    }


}
