package LetCode.LinkList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionSortExample {
    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(3);
        ListNode b1 = new ListNode(1);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(1);
        List<ListNode> list = new ArrayList<>();

        list.add(a);
        list.add(b);
        list.add(b1);
        list.add(c);
        list.add(d);
        System.out.println("Before Sorted");
        for (ListNode listNode : list) {
            System.out.println(listNode.val);
        }


        //��д�����㷨
        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                if (a.val < b.val) { //���������Ҫ����Ϊ�������������
                    return -1; // -1��ʾǰ�� С�� ���� -1,1,0����ĺ����ǹ̶���
                }
                if (a.val > b.val) {
                    return 1;
                }

                //�������0,����Ϊ����
                return 0;
            }
        });
        System.out.println("After Sorted");
        for (ListNode listNode : list) {
            System.out.println(listNode.val);
        }
    }

}
