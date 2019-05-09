package LetCode.LinkList;

public class Node {
    /**
     * 含有一个随机指针域的链表节点
     */
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
