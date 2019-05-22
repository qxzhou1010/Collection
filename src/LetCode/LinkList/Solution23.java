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

        //新建List，存储K条链表中的每一个节点
        List<ListNode> new_list = new ArrayList<>();

        //获取每一条链表的头节点
        for (ListNode temp:lists){
            while (temp!=null){
                new_list.add(temp); //添加节点到新的List中
                temp = temp.next; //遍历
            }
        }//for循环结束,K条链表的所有节点都被添加到了new_list中
        //对new_list排序
        //重写排序
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
        );//完成排序
        //链接new_list的每一个节点
        //新建临时节点
        ListNode temp_head = new ListNode(0);
        ListNode ptr = temp_head;

        //遍历new_list，添加节点
        int len = new_list.size();
        for (int i=0; i<len; i++){
            ptr.next = new_list.get(i);
            ptr = ptr.next;
        }
        //完成所有节点的连接，将尾节点置为null
        ptr.next = null;

        //返回临时头节点的后一个节点
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

        //List转换为数组
//        ListNode[] sub_list11 = new ListNode[sub_list1.size()];
//        sub_list1.toArray(sub_list11);
//        ListNode[] sub_list22 = new ListNode[sub_list2.size()];
//        sub_list1.toArray(sub_list22);

        ListNode l1 = mergeKLists(sub_list1);
        ListNode l2 = mergeKLists(sub_list2);

        return mergeTwoLists(l1,l2);



    }
    static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode temp_head = new ListNode(0); //设置临时头节点
        ListNode ptr = temp_head;

        //遍历两个指针，两个指针都不为空
        while (l1 != null && l2!=null){
            if (l1.val < l2.val){
                ptr.next = l1;
                ptr = l1;
                l1 = l1.next;//l1继续前移，接着继续判断l1
            }else {
                ptr.next = l2;
                ptr = l2;
                l2 = l2.next;//l2继续前移，接着判断l2
            }

        }
        //跳出whileu循环，一定是至少一条链表遍历完了
        if (l1 != null){//如果l1还有剩余，
            ptr.next = l1;
        }
        if (l2 != null){//如果l2还有剩余
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

