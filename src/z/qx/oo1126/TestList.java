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
	 * 测试常用方法
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
		System.out.println(" 是否包含指定元素"+ list.contains("zwj"));
		
		list.remove("zqx");
		
		System.out.println(list);
		
		Object[] objects = list.toArray();
		System.out.println("转换为Object数组" + Arrays.toString(objects));
		
		list.clear();
		System.out.println("清空所有元素"+ list);
		
	}
	/*
	 * 测试两个List之间的元素处理
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
		
		System.out.println(list.containsAll(list2));//list是否包含list2的所有元素
		System.out.println(list);
		
		list.addAll(list2);//将list2的所有元素增加至list;
		System.out.println(list);
		
		list.removeAll(list2);//从list中删除 同时在list和list2中的元素
		System.out.println(list);
		
		list.retainAll(list2);//取交集
		System.out.println(list);
	}
	/*
	 * 测试List中索引操作的方法
	 */
	public static void test03() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println(list);
		
		list.add(2,"e");//把e 插在 list[2]的位置  原来的元素后移
		System.out.println(list);
		
		list.remove(2);//移除 list[2]
		System.out.println(list);
	
		list.set(2, "h");//用h 覆盖 list[2]
		System.out.println(list);
		System.out.println(list.get(1));//获取list[1]
		list.set(1, "B");
		
		list.add("B");
		System.out.println(list);
		System.out.println(list.indexOf("B")); //从头到尾 返回第一个B的索引
		System.out.println(list.lastIndexOf("B"));//从尾到头 返回第一个B的索引
		
	}
}
