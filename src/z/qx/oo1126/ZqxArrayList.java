package z.qx.oo1126;
/*
 * 手动实现ArrayList的底层
 */

import java.util.ArrayList;
import java.util.List;



public class ZqxArrayList {
	
	private Object[] elementData; //定义了一个 Object的数组 
	
	private int size; //ArralList的长度
	
	
	public int size() {//获取数组大小
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public ZqxArrayList() {
		this(10);
	}
	
	public ZqxArrayList( int initialCapacity ) {
		if( initialCapacity < 0) { //异常处理
			try {
				throw new Exception();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		elementData = new Object[ initialCapacity];
	}
	public void add( Object obj) {
		//数组扩容
		ensureCapacity();
		elementData[size++] = obj;//数组越界怎么办？ 自动扩容！
	}
	public void add(int index, Object obj) {
		ensureCapacity();
		rangeCheck(index);
		//源数组 源数组决定拷贝的范围(index - end) 目标数组 目标数组接收拷贝的范围(index+1 - end) 拷贝元素的数量
		
		System.arraycopy(elementData, index, elementData, index + 1, size - 1);
		elementData[index] = obj;
		size++;
	}
	
	public Object get(int index) {
		if( index<0 || index >= size) {
			try {
				throw new Exception();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return elementData[index];
		
	}
	public void remove( int index) {
		//删除指定位置的对象
		rangeCheck(index);//检查index的合法性
		
		int numMoved = size - index - 1;//需要移动的元素的个数
		if( numMoved > 0) {//合法性判断
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);//数组从index+1位置元素往前移一位
		}
		elementData[--size] = null; //数组size-1，末位赋值null
		
	}
	public void remove(Object obj) {//删除指定对象
		for(int i=0; i<size;i++) {
			if( get(i).equals(obj)) {
				remove(i); //调用按索引删除方法
			}
		}
	}
	public Object set(int index, Object obj) {
		rangeCheck(index);
		Object oldValue = elementData[index];
		elementData[index] = obj;
		return oldValue;
	}
	
	private void rangeCheck(int index) { //这个函数仅供本类的函数调用
		if( index<0 || index >= size) {
			try {
				throw new Exception();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	private void ensureCapacity() {//数组扩容
		if(size == elementData.length) {
			Object[] newArray = new Object[ size*2 + 1]; //新建更大容量的数组对象
			System.arraycopy(elementData, 0, newArray, 0, elementData.length); //  原数组拷贝到新数组
			
			elementData = newArray; //新数组的引用赋值给原数组   问：那原数组呢？ 去哪里了？
		}
	}
	
	
	
	
	public static void main(String[] args) {
		ZqxArrayList list = new ZqxArrayList(); //初始size=2
		System.out.println( list.size());
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		//System.out.println( list.size());
		System.out.println(list.get(3));
		for(int i=0;i<list.size();i++) {
			System.out.println( list.get(i));
		}
		list.remove(3);
		System.out.println(list.get(3));
		
		
		//系统原生实现 进行对比
		List<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		l.add("a");
		l.add("e");
		for( int i=0; i<l.size();i++) {
			System.out.println(l.get(i));
		}
		l.remove("a");
		for( int i=0; i<l.size();i++) {
			System.out.println(l.get(i));
		}
		l.remove( new String("a"));//只要对象内容相同 即可删除 因为底层代码判断用的 equal；
		for( int i=0; i<l.size();i++) {
			System.out.println(l.get(i));
		}
		
		l.set(0, "f");
		for( int i=0; i<l.size();i++) {
			System.out.println(l.get(i));
		}
		
	}

}
