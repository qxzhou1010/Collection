package z.qx.oo1128;

public class Node{
	public static void main(String[] args) {
	}
	//����˽������
		private Object previous;
		private Object obj;
		private Object next;
		//������
		public Node() {
		}
		//���з���������˽������
		public void setPrevious( Object previous) {
			this.previous = previous;
		}
		public Object getPrevious() {
			return previous;
		}
		public void setObj( Object obj) {
			this.obj = obj;
		}
		public Object getObj() {
			return obj;
		}
		public void setNext( Object next) {
			this.next = next;
		}
		public Object getNext() {
			 return next;
		}

}
