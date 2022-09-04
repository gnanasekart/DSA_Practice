package SingleLinkedList;

import org.testng.annotations.Test;

public class MergeLinkedList {

	@Test
	public void testReverse(){
		Node head1 = addNode(1);
		head1.next = addNode(3);
		//head1.next.next = addNode(5);
		//head1.next.next.next = addNode(7);

		Node head2 = addNode(2);
		head2.next = addNode(4);
		head2.next.next = addNode(6);
		head2.next.next.next = addNode(8);

		Node t = mergeLL(head1, head2);

		printAllNodes(t);
	}

	private Node mergeLL(Node node1, Node node2) {
		Node merged = new Node();
		Node curr = merged;
		while(node1!=null && node2!=null) {
			if(node1.data < node2.data) {
				curr.next=node1;
				node1=node1.next;
			}else {
				curr.next=node2;
				node2=node2.next;
			}
			curr = curr.next;
		}

		if(node1==null) {
			curr.next=node2;
		}else {
			curr.next=node1;
		}
		
		//curr.next = node1!=null ? node1 : node2;
		
		return merged.next;
	}

	private void printAllNodes(Node node){
		while(node != null){
			System.out.println(node.data);
			node=node.next;
		}
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
