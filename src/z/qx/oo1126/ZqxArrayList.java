package z.qx.oo1126;
/*
 * �ֶ�ʵ��ArrayList�ĵײ�
 */

import java.util.ArrayList;
import java.util.List;



public class ZqxArrayList {
	
	private Object[] elementData; //������һ�� Object������ 
	
	private int size; //ArralList�ĳ���
	
	
	public int size() {//��ȡ�����С
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public ZqxArrayList() {
		this(10);
	}
	
	public ZqxArrayList( int initialCapacity ) {
		if( initialCapacity < 0) { //�쳣����
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
		//��������
		ensureCapacity();
		elementData[size++] = obj;//����Խ����ô�죿 �Զ����ݣ�
	}
	public void add(int index, Object obj) {
		ensureCapacity();
		rangeCheck(index);
		//Դ���� Դ������������ķ�Χ(index - end) Ŀ������ Ŀ��������տ����ķ�Χ(index+1 - end) ����Ԫ�ص�����
		
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
		//ɾ��ָ��λ�õĶ���
		rangeCheck(index);//���index�ĺϷ���
		
		int numMoved = size - index - 1;//��Ҫ�ƶ���Ԫ�صĸ���
		if( numMoved > 0) {//�Ϸ����ж�
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);//�����index+1λ��Ԫ����ǰ��һλ
		}
		elementData[--size] = null; //����size-1��ĩλ��ֵnull
		
	}
	public void remove(Object obj) {//ɾ��ָ������
		for(int i=0; i<size;i++) {
			if( get(i).equals(obj)) {
				remove(i); //���ð�����ɾ������
			}
		}
	}
	public Object set(int index, Object obj) {
		rangeCheck(index);
		Object oldValue = elementData[index];
		elementData[index] = obj;
		return oldValue;
	}
	
	private void rangeCheck(int index) { //���������������ĺ�������
		if( index<0 || index >= size) {
			try {
				throw new Exception();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	private void ensureCapacity() {//��������
		if(size == elementData.length) {
			Object[] newArray = new Object[ size*2 + 1]; //�½������������������
			System.arraycopy(elementData, 0, newArray, 0, elementData.length); //  ԭ���鿽����������
			
			elementData = newArray; //����������ø�ֵ��ԭ����   �ʣ���ԭ�����أ� ȥ�����ˣ�
		}
	}
	
	
	
	
	public static void main(String[] args) {
		ZqxArrayList list = new ZqxArrayList(); //��ʼsize=2
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
		
		
		//ϵͳԭ��ʵ�� ���жԱ�
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
		l.remove( new String("a"));//ֻҪ����������ͬ ����ɾ�� ��Ϊ�ײ�����ж��õ� equal��
		for( int i=0; i<l.size();i++) {
			System.out.println(l.get(i));
		}
		
		l.set(0, "f");
		for( int i=0; i<l.size();i++) {
			System.out.println(l.get(i));
		}
		
	}

}
