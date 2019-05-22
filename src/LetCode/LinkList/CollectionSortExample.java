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


        //重写排序算法
        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                if (a.val < b.val) { //这里根据需要，人为的设置排序规则
                    return -1; // -1表示前者 小于 后者 -1,1,0代表的含义是固定的
                }
                if (a.val > b.val) {
                    return 1;
                }

                //如果返回0,则认为等于
                return 0;
            }
        });
        System.out.println("After Sorted");
        for (ListNode listNode : list) {
            System.out.println(listNode.val);
        }
    }

}
