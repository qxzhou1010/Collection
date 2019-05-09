package LetCode.LinkList;

import java.util.*;

public class Solution138 {
    public static void main(String[] args) {

    }

    static Node copyRandomList(Node head){
        Map<Node, Integer> node_map = new HashMap<Node, Integer>();// ��ַ���ڵ�λ�õ�map
//        List<Node> node_vec = new ArrayList<Node>();//�洢�ڵ�λ�÷��ʵ�ַ
        List<Node> node_vec = new Vector<>(); // �洢�ڵ�λ�ã� �����һһ��Ӧ
        Node ptr = head;
        int i=0;
        while (ptr!=null){
            //������ڵ㱣�浽node_vec��
            // ����Ŀ����ͷ�������һ��
            node_vec.add(new Node(ptr.val,ptr.next,ptr.random));
            node_map.put(ptr, i); //�����ӵ�ַ��λ�õ�ӳ�䣬Ϊ�˺����ܹ��ҵ������ָ��Ľڵ�
            ptr = ptr.next; //����
            i++; //λ��ǰ��
        }
        node_vec.add(null);//�������
        ptr = head;//Ϊ���±�����׼��
        i=0;
        while (ptr != null){
            //�ٴα���ԭʼ����,�����������next��random��
            node_vec.get(i).next = node_vec.get(i+1);
            if (ptr.random != null){
                //��ǰ�ڵ�����ָ����Ϊ��
                int id = node_map.get(ptr.random);//��ȡ����ڵ�λ�õ����ָ����ָ��Ľڵ�λ�ã����λ�ö�����ýڵ�����
                node_vec.get(i).random = node_vec.get(id);//Ȼ��ͨ����ţ����ǿ�����������node_vec���ҵ������Ŷ�Ӧ��λ��
            }
            ptr = ptr.next;//����
            i++;

        }
        return node_vec.get(0);

    }
    static Node copyRandomList01(Node head){
        Map<Node, Integer> node_map = new HashMap<>();
        List<Node> node_vec = new Vector<>();
        Node ptr = head;
        int i=0;
        //��һ�α���ԭ��������node_map��vec_map
        while (ptr!=null){
            //���ԭ�����ÿһ���ڵ㣬�ݴ���node_vec��
            //ע������ֻ����ʱ�洢�˽ڵ㣬֮����ʱ��������
            //�����ǰ�ԭ�����˳��һһ���
            node_vec.add( new Node(ptr.val, ptr.random, ptr.next));
            //��¼ԭ����ÿһ���ڵ��ַ �� ��� �Ĺ�ϵ
            node_map.put(ptr, i);
            i++; //�������ֵ
            ptr = ptr.next; //��������
        }
        ptr = head; //����ptr��Ϊ��һ�α�����׼��
        i=0;
        //�ڶ��α���ԭ����
        //��α�������ҪĿ�����ڲ�ѯÿ���ڵ��randomָ����Ϣ����������������
        while (ptr!=null){
            //������ӵ�ʱ���ǰ�˳��һһ��ӣ�����ÿ���ڵ��nextָ������ȷ����
            node_vec.get(i).next = node_vec.get(i+1);
            //�ж�ԭ����ÿһ���ڵ��randomָ����Ϣ
            if (ptr.random != null){
                //ptr.random��node_map�����ѯ��Ӧ�Ľڵ�id
                int id = node_map.get(ptr.random);
                //����id��vec_node������randomָ��
                node_vec.get(i).random = node_vec.get(id);
            }
            i++;
            ptr = ptr.next; //����
        }
        node_vec.get(i).next = null; //βָ����0

        return node_vec.get(0);






    }

}
