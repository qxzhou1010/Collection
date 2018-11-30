package z.qx.oo1128;

public class Node{
	public static void main(String[] args) {
	}
	//定义私有属性
		public Node previous;
		public Object obj;
		public Node next;
		//构造器
		public Node(){

		}
		public Node(Node previous, Object obj, Node next) {
			super();
			this.previous = previous;
			this.obj = obj;
			this.next = next;
		}
		//公有方法来访问私有属性
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
