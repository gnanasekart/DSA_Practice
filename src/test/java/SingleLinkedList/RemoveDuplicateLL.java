package SingleLinkedList;

import org.testng.annotations.Test;

public class RemoveDuplicateLL {

	/*
input head = [1, 1, 2]
output = [1, 2]

input head = [1, 1, 2, 3, 3]
output = [1, 2, 3]
	 */
	@Test
	public void removeDuplicate() {
		Node head = addNode(1);
		head.next=addNode(1);
		head.next.next=addNode(2);

		Node node = removedups(head);
		System.out.println(node);
	}

	private Node removedups(Node node) {
		if(node==null || node.next==null) return node;
		Node curr = node.next;
		Node prev = node;
		while(curr!=null) {
			if(prev.data==curr.data) prev.next = curr.next;
			else prev=curr;
			curr=curr.next;
		}
		return node;
	}

	public class Node{
		int data;
		Node next;
		//Node prev;

		Node(int key){
			this.data=key;
			next=null;
		}
		public Node() {
			next=null;
		}
	}

	public Node addNode(int data){
		return new Node(data);
	}
}
