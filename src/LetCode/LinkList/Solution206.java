package LetCode.LinkList;


import javax.sound.midi.Soundbank;
import javax.xml.stream.events.StartDocument;
import java.util.List;
import java.util.Map;

public class Solution206 {

    public static void main(String[] args) {
        int[] list = {1,2,3,4,5,6,7,8,9};
        ListNode head = ListNode.createList(list);
        ListNode temp = head;
        ListNode temp1 = head;
        ListNode.printList(temp);
        System.out.println(); //����
        ListNode new_head = null;
        new_head = reverseList(head);
        ListNode.printList(new_head);
//
//        new_head = reverseBetween01(temp1, 3, 5);
//        ListNode.printList(new_head);



    }
    static ListNode reverseList(ListNode head){
        /**
         * ����ת:��������ȫ����ת
         */
        ListNode new_head = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = new_head;
            new_head = head;
            head = next;
        }
        return new_head;

    }

    /**
     * ������ָ��λ�ý��з�ת
     * @param head
     * @param start ���
     * @param end   �յ�
     * @return
     */
    static ListNode reverseBetween(ListNode head, int start, int end){
        ListNode pre_head = null; //��¼headǰһ��λ��
        ListNode result = head; // ������ɷ�ת������Ľ��
        //�ƶ�head,��pre_head ����Ҫ��ת�������ʼλ��
        while (head != null && (--start)!=0){
            // ��Ҫ�ƶ�start-1�Σ�����--start
            pre_head = head;
            head = head.next;
        }
        //whileѭ���������ҵ���Ӧ����ʼλ��
        ListNode tail = head; //���巴ת���β���ڵ�ָ��,�������ڷ�ת�����ͷ�ڵ�
        ListNode new_head = null;
        ListNode next = null;
        //��ת
        int len = end - start + 1;
        while (head != null && len!=0){
            next = head.next;
            head.next = new_head;
            new_head = head;
            head =  next;
            len--;
        }
        //��ɷ�ת����Ҫ������ͷβ����
        //����head��λ�þ���ʣ�������ֵĵ�һ��λ��
//        tail.next = head;
        try {
            if (head != null){
                tail.next = head;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //���Ƕ���ǰ�벿�ֵ����ӣ���Ҫ��һ���ж�
        if (pre_head != null){
            // ���Ǵӵ�һ���ڵ㿪ʼ��ת
            pre_head.next = new_head;
        }else {
            result = new_head;
        }
    return result;
    }
    static ListNode reverseBetween01(ListNode head, int m, int n){
        int change_len = n-m+1;
        ListNode pre_head = null;
        ListNode result = head;
        while( head != null && (--m)!=0 ){
            pre_head = head;
            head = head.next;
        }
        ListNode next = null;
        ListNode new_head = null;
        ListNode tail = head;
        while(head !=null && change_len!=0){
            next = head.next;
            head.next = new_head;
            new_head = head;
            head = next;
            change_len--;

        }
//        tail.next = head;
        try {
            if (head != null){
                tail.next = null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if(pre_head != null){
            pre_head.next = new_head;
        }
        else{
            result = new_head;
        }
        return result;
    }


}
