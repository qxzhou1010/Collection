package z.qx.oo1126;

public class TestGenerics {
	public static void main(String[] args) {
		//"String"����ʵ�ʴ������������
		MyCollection<String> mc = new MyCollection<String>();
		mc.set("aaa", 0);
		mc.set("bbb", 1);
		String str = mc.get(1);//�����˷��� ����ֱ�ӷ���String���ͣ�����ǿ������ת��
		System.out.println(str);
	}

}

class MyCollection<E>{//������������ӷ���  E:��ʾ����
	Object[] objs = new Object[5];
	
	public E get(int index) { //E:���Ϊһ��ռλ���ţ� ��ʾĳ��δ֪���������ͣ� ���������õ�ʱ����"��������"
		return (E) objs[index];
	}
	public void set(E e, int index) {
		objs[index] = e;
	}

}
