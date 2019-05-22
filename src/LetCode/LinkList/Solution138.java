package LetCode.LinkList;

import java.util.*;

public class Solution138 {
    public static void main(String[] args) {

    }

    static Node copyRandomList(Node head){
        Map<Node, Integer> node_map = new HashMap<Node, Integer>();// 地址到节点位置的map
//        List<Node> node_vec = new ArrayList<Node>();//存储节点位置访问地址
        List<Node> node_vec = new Vector<>(); // 存储节点位置， 和序号一一对应
        Node ptr = head;
        int i=0;
        while (ptr!=null){
            //新链表节点保存到node_vec中
            // 链表的拷贝就发生在这一步
            node_vec.add(new Node(ptr.val,ptr.next,ptr.random));
            node_map.put(ptr, i); //建立从地址到位置的映射，为了后续能够找到随机域指向的节点
            ptr = ptr.next; //遍历
            i++; //位置前移
        }
        node_vec.add(null);//遍历完毕
        ptr = head;//为重新遍历做准备
        i=0;
        while (ptr != null){
            //再次遍历原始链表,链接新链表的next和random；
            node_vec.get(i).next = node_vec.get(i+1);
            if (ptr.random != null){
                //当前节点的随机指针域不为空
                int id = node_map.get(ptr.random);//获取这个节点位置的随机指针域指向的节点位置，这个位置对于这该节点的序号
                node_vec.get(i).random = node_vec.get(id);//然后通过序号，我们可以在新链表node_vec中找到这个序号对应的位置
            }
            ptr = ptr.next;//遍历
            i++;

        }
        return node_vec.get(0);

    }
    static Node copyRandomList01(Node head){
        Map<Node, Integer> node_map = new HashMap<>();
        List<Node> node_vec = new Vector<>();
        Node ptr = head;
        int i=0;
        //第一次遍历原链表，构建node_map和vec_map
        while (ptr!=null){
            //深拷贝原链表的每一个节点，暂存在node_vec中
            //注意这里只是暂时存储了节点，之间暂时并无链接
            //这里是按原链表的顺序一一添加
            node_vec.add( new Node(ptr.val, ptr.random, ptr.next));
            //记录原链表每一个节点地址 和 序号 的关系
            node_map.put(ptr, i);
            i++; //更新序号值
            ptr = ptr.next; //继续遍历
        }
        ptr = head; //重置ptr，为下一次遍历做准备
        i=0;
        //第二次遍历原链表
        //这次遍历的主要目的在于查询每个节点的random指针信息，拷贝到新链表中
        while (ptr!=null){
            //由于添加的时候是按顺序一一添加，所以每个节点的next指针域是确定的
            node_vec.get(i).next = node_vec.get(i+1);
            //判断原链表每一个节点的random指针信息
            if (ptr.random != null){
                //ptr.random在node_map里面查询对应的节点id
                int id = node_map.get(ptr.random);
                //根据id在vec_node里设置random指针
                node_vec.get(i).random = node_vec.get(id);
            }
            i++;
            ptr = ptr.next; //遍历
        }
        node_vec.get(i).next = null; //尾指针置0

        return node_vec.get(0);

    }

    static Node copyRandomList02(Node head){
        //建立一个 原链表节点地址到 这个节点在链表中的位置(序号)的map
        Map<Node, Integer> node_map = new HashMap<>();
        //建立一个 节点在链表中的位置(序号) 到 节点地址的map
        //这里的位置直接用数组下标来表示
        List<Node> node_vec = new ArrayList<>();

        Node ptr = head;    //建立工作指针，用于遍历原链表
        int i = 0;          //用于记录每个节点的位置
        while (ptr!=null){
            //拷贝原链表的每一个节点到node_vec，注意是深拷贝
            node_vec.add(new Node(ptr.val, ptr.next, ptr.random));
            //建立从节点地址 到 节点位置的map
            node_map.put(ptr, i);
            i++;
            ptr = ptr.next;

        }//遍历完毕，完成了每个节点的深拷贝，以及两个map的建立
        //这一点尤其注意，对于尾节点的处理
        node_vec.add(null);
        //下面将拷贝每个节点之间的关系
        ptr = head;
        i = 0;
        while (ptr != null){
            //完成每个节点next域的复制
            node_vec.get(i).next = node_vec.get(i+1);

            //如果当前链表的random域不为空
            if (ptr.random != null){
                //根据ptr.random指向的节点地址获取该节点的位置
                int id = node_map.get(ptr.random);
                //根据id在node_vec中查到该id对应的节点地址，完成random的复制
                node_vec.get(i).random = node_vec.get(id);
            }
            i++;
            ptr = ptr.next;
        }


        return node_vec.get(0);



    }




}
