package Data_Structure_Arraylist_pkg;
public class Stacklinkedlist {
	private static Node first = null;
	static Stacklinkedlist list = new Stacklinkedlist();

	public static void push(int data) {
		Node nn = new Node(data);
		nn.next = first;
		first = nn;
	}

	public static void pop()
	{
		Node temp = first;
		first = first.next;
		System.out.println("removed element: " +temp.data);
	}

	public static void printlist(Stacklinkedlist list) {
		Node cn = list.first;
		System.out.println("linked list element: ");
		while(cn != null){
			System.out.println(cn.data +" ");
			cn = cn.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		list.push(6);
		list.push(3);
		list.push(2);
		list.printlist(list);
		list.pop();
		list.printlist(list);
	}
}


