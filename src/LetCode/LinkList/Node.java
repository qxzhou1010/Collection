package LetCode.LinkList;

public class Node {
    /**
     * ����һ�����ָ���������ڵ�
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
