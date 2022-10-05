package LeetCode_Practice;

import org.testng.annotations.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class MergeTwoSortedLists {

	@Test
	public void example1() {
		ListNode head1 = addNode(1);
		head1.next = addNode(2);
		head1.next.next = addNode(4);
		
		ListNode head2 = addNode(1);
		head2.next = addNode(3);
		head2.next.next = addNode(4);

		//Output: [1,1,2,3,4,4]
		System.out.println(mergeTwoSortedArray(head1, head2));
	}


	private ListNode mergeTwoSortedArray(ListNode l1, ListNode l2) {
		if (l1==null) return l2;
		
		if (l2==null) return l1;
	
		ListNode l=null;
		if (l1.val>l2.val) {
			l=new ListNode(l2.val);
			l.next=mergeTwoSortedArray(l1,l2.next);
		}else {
			l=new ListNode(l1.val);
			l.next=mergeTwoSortedArray(l1.next,l2);
		}
		return l;
	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode addNode(int data){
		return new ListNode(data);
	}
}