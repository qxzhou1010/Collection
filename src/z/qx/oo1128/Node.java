package z.qx.oo1128;

public class Node{
	public static void main(String[] args) {
	}
	//����˽������
		public Node previous;
		public Object obj;
		public Node next;
		//������
		public Node(){

		}
		public Node(Node previous, Object obj, Node next) {
			super();
			this.previous = previous;
			this.obj = obj;
			this.next = next;
		}
		//���з���������˽������
		public void setPrevious( Node previous) {
			this.previous = previous;
		}
		public Node getPrevious() {

			return previous;
		}
		public void setObj( Object obj) {
			this.obj = obj;
		}
		public Object getObj() {

			return obj;
		}
		public void setNext( Node next) {
			this.next = next;
		}
		public Node getNext() {
			 return next;
		}

}
