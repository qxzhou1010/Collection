package LetCode.LinkList;
//package sort


import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution23 {
    public static void main(String[] args) {

    }

    static ListNode mergeKLists(ListNode[] lists){

        //�½�List���洢K�������е�ÿһ���ڵ�
        List<ListNode> new_list = new ArrayList<>();

        //��ȡÿһ�������ͷ�ڵ�
        for (ListNode temp:lists){
            while (temp!=null){
                new_list.add(temp); //��ӽڵ㵽�µ�List��
                temp = temp.next; //����
            }
        }//forѭ������,K����������нڵ㶼����ӵ���new_list��
        //��new_list����
        //��д����
        Collections.sort(new_list, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                if (a.val < b.val){
                    return -1;
                }
                if (a.val > b.val){
                    return 1;
                }
                return 0;
            }
                }
        );//�������
        //����new_list��ÿһ���ڵ�
        //�½���ʱ�ڵ�
        ListNode temp_head = new ListNode(0);
        ListNode ptr = temp_head;

        //����new_list����ӽڵ�
        int len = new_list.size();
        for (int i=0; i<len; i++){
            ptr.next = new_list.get(i);
            ptr = ptr.next;
        }
        //������нڵ�����ӣ���β�ڵ���Ϊnull
        ptr.next = null;

        //������ʱͷ�ڵ�ĺ�һ���ڵ�
        return temp_head.next;

    }
    static ListNode mergeKList02(ListNode[] lists){
        if (lists.length == 0 ){

            return null;
        }
        if (lists.length == 1){
            return lists[0];
        }
        if (lists.length == 2){
            return mergeTwoLists(lists[0], lists[1]);

        }
        int mid = lists.length / 2;

//        List<ListNode> sub_list1 = new ArrayList<>();
//        List<ListNode> sub_list2 = new ArrayList<>();
        ListNode[] sub_list1 = new ListNode[lists.length];
        ListNode[] sub_list2 = new ListNode[lists.length];


        for (int i=0; i<mid; i++){
            sub_list1[i] = lists[i];
        }
        for (int i=mid;i<lists.length; i++){
//            sub_list2.add(lists[i]);
            sub_list2[i - mid] = lists[i];
        }

        //Listת��Ϊ����
//        ListNode[] sub_list11 = new ListNode[sub_list1.size()];
//        sub_list1.toArray(sub_list11);
//        ListNode[] sub_list22 = new ListNode[sub_list2.size()];
//        sub_list1.toArray(sub_list22);

        ListNode l1 = mergeKLists(sub_list1);
        ListNode l2 = mergeKLists(sub_list2);

        return mergeTwoLists(l1,l2);



    }
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

