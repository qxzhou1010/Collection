package LetCode.LinkList;

import java.util.HashSet;
import java.util.Set;

public class Solution142 {

    public static void main(String[] args) {

    }

    static ListNode detectCycle(ListNode head) {
        //�½����ϣ����ڴ洢����ڵ�
        Set<ListNode> set = new HashSet<ListNode>();

        //���������������
        while (head != null){
            if (set.contains(head)){
                //�����ϰ�������ڵ㣬�򷵻�
                return head;
            }
            set.add(head);//�����������Լ�������ʱ��û����ڵ㣬���
            head = head.next; //ָ��ǰ�ƣ���������

        }
        return null;

    }

    /**
     * ����ָ���˼·
     * @param head
     * @return
     */
    static ListNode detectCycle01(ListNode head){
        ListNode fast = head;//����ָ�붼��head��ʼ
        ListNode slow = head;
        ListNode meet = null; //��¼������ָ��λ��
        while (fast!= null){
            //�ȶ�����һ��
            fast = fast.next;
            slow = slow.next;
            if ( fast == null){
                //fastһ�������������������fastΪnull�ˣ�˵��û�л�
                return null;
            }

            fast = fast.next;
            if (fast == slow){
                //����������whileѭ��
                meet = fast;
                break;
            }


        }
        if (meet == null){ //meet==null��˵��meetû�иı䣬˵��û�л�
            return null;
        }
        while (head!=null && meet != null){
            //head ��meetͬ�����ٶȳ����������Ľڵ���ǻ�����ʼλ��
            if (head == meet){
                return head;
            }
            head = head.next;
            meet = meet.next;
        }
        return null;

    }

}
