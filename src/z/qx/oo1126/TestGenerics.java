package z.qx.oo1126;

public class TestGenerics {
	public static void main(String[] args) {
		//"String"就是实际传入的数据类型
		MyCollection<String> mc = new MyCollection<String>();
		mc.set("aaa", 0);
		mc.set("bbb", 1);
		String str = mc.get(1);//增加了泛型 可以直接返回String类型，无需强制类型转换
		System.out.println(str);
	}

}

class MyCollection<E>{//类的声明处增加泛型  E:表示泛型
	Object[] objs = new Object[5];
	
	public E get(int index) { //E:理解为一个占位符号， 表示某个未知的数据类型， 当真正调用的时候传入"数据类型"
		return (E) objs[index];
	}
	public void set(E e, int index) {
		objs[index] = e;
	}

}
