package SingleLinkedList;

import org.testng.annotations.Test;

public class ReverseLinkedList {

	@Test
	public void testReverse(){
		Node head = addNode(10);
		head.next = addNode(24);
		head.next.next = addNode(33);
		head.next.next.next = addNode(40);

		Node tail = reverseNodes(head);
		printAllNodes(tail);

		//print only odd numbers
		//printOddNodes(head);
		
		//printOddValues(head);
	}

	private void printAllNodes(Node node){
		while(node != null){
			System.out.println(node.data);
			node=node.next;
		}
	}

	private void printOddNodes(Node node){
		while(node != null){
			System.out.println(node.data);
			node=node.next.next;
		}
	}

	private void printOddValues(Node node){
		while(node != null){
			if(node.data % 2 == 1)
				System.out.println(node.data);
			node=node.next.next;
		}
	}

	private Node reverseNodes(Node node){
		Node curr=node, prev=null, next=null;

		while(curr != null){
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
			//printAllNodes(curr);
		}
		return prev;
	}

	public class Node{
		int data;
		Node next;
		//Node prev;

		Node(int key){
			this.data=key;
			next=null;
		}
	}

	public Node addNode(int data){
		return new Node(data);
	}
}
