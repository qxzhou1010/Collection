package z.qx.oo1128;


public class ZqxLinkedList {
	
	private Node first;
	private Node last;
	private int size;


	public void add( Object obj) {
		Node n = new Node();
		if (first == null){
			n.setPrevious(null);
			n.setObj(obj);
			n.setNext(null);

			first = n;
			last = n;
		}else{
			//��last�������ӽڵ㼴��
			n.setPrevious(last);
			n.setObj(obj);
			n.setNext(null);
			last.setNext(n);
			last = n;
		}
		size++;
		
	}
	public Object get(int index){
		//indexԽ�紦��
		rangeCheck(index);

		Node temp = node(index);
		if ( temp!= null){
			return temp.obj;
		}
		return null;
	}
	public void remove(int index){
			rangeCheck(index);
			Node temp = node(index);
			if (temp != null){
				Node up = temp.previous;
				Node down = temp.next;
				up.next = down;
				down.previous = up;
			}
		size--;

		}





	private int size(){
		return size;
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
	 public Node node(int index) {
		 Node temp = null;
		 if (first != null) {
			 temp = first;
			 for (int i = 0; i < index; i++) {
				 temp = temp.next;
			 }
		 }
		 return temp;
	 }
	
	
	public static void main(String[] args) {
		ZqxLinkedList list = new ZqxLinkedList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		//System.out.println(list.size());
		//list.get(2);
		list.remove(1);


	}
}


