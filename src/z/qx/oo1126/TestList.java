package z.qx.oo1126;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestList {
	public static void main(String[] args) {
		//test01();
		//test02();
		test03();
	}
	/*
	 * ���Գ��÷���
	 */
	public static void test01() {
		List<String> list = new  ArrayList<String>();
		System.out.println(list.isEmpty());
		list.add("zqx");
		System.out.println(list.isEmpty());
		list.add("zwj");
		list.add("xp");
		System.out.println(list);
		System.out.println(" the size of list " + list.size());
		System.out.println(" �Ƿ����ָ��Ԫ��"+ list.contains("zwj"));
		
		list.remove("zqx");
		
		System.out.println(list);
		
		Object[] objects = list.toArray();
		System.out.println("ת��ΪObject����" + Arrays.toString(objects));
		
		list.clear();
		System.out.println("�������Ԫ��"+ list);
		
	}
	/*
	 * ��������List֮���Ԫ�ش���
	 */
	public static void test02() {
		List<String> list = new ArrayList<String>();
		list.add("zwj");
		list.add("xp");
		list.add("zqx");
		
		List<String> list2 = new ArrayList<String>();
		list2.add("zwj");
		list2.add("zs");
		list2.add("ls");
		
		System.out.println(list.containsAll(list2));//list�Ƿ����list2������Ԫ��
		System.out.println(list);
		
		list.addAll(list2);//��list2������Ԫ��������list;
		System.out.println(list);
		
		list.removeAll(list2);//��list��ɾ�� ͬʱ��list��list2�е�Ԫ��
		System.out.println(list);
		
		list.retainAll(list2);//ȡ����
		System.out.println(list);
	}
	/*
	 * ����List�����������ķ���
	 */
	public static void test03() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println(list);
		
		list.add(2,"e");//��e ���� list[2]��λ��  ԭ����Ԫ�غ���
		System.out.println(list);
		
		list.remove(2);//�Ƴ� list[2]
		System.out.println(list);
	
		list.set(2, "h");//��h ���� list[2]
		System.out.println(list);
		System.out.println(list.get(1));//��ȡlist[1]
		list.set(1, "B");
		
		list.add("B");
		System.out.println(list);
		System.out.println(list.indexOf("B")); //��ͷ��β ���ص�һ��B������
		System.out.println(list.lastIndexOf("B"));//��β��ͷ ���ص�һ��B������
		
	}
}
