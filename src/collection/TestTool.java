package collection;

import java.util.*;

public class TestTool {
    /**
     * Collection���õĹ�����
     */
    public static void main(String[] args) {
        testList();
    }

    public static void testList(){
        List<String> a = new ArrayList<String>();
        for (int i=0; i<5; i++){
            a.add("a" + i);

        }
        System.out.println(a);

        Collections.shuffle(a); // �������
        System.out.println(a);
        Collections.reverse(a); //���������ǽ������������Ľ����������
        System.out.println(a);
        Collections.sort(a);//����
        System.out.println(a);

        System.out.println(Collections.binarySearch(a, "a2")); // ���ֲ����ض�Ԫ�أ�����index
        Collections.fill(a, "hello"); //�ض�Ԫ��д������list
        System.out.println(a);
    }

}
