package LeetCode_Daily_Practice.Linked_List.Single_Linked_List;

import LeetCode_Daily_Practice.Linked_List.Single_Linked_List.List.Node;
import org.testng.Assert;
import org.testng.annotations.Test;

public class P_M_N24_1_Rotate_LL {

/*
    Given the head of a linked list, rotate the list to the right by k places.

            Input: head = [1,2,3,4,5], k = 2
    Output: [4,5,1,2,3]

    explaination
       1 -> 2 -> 3 -> 4 -> 5
    round1 5 -> 1 -> 2 -> 3 -> 4
    round2 4 -> 5 -> 1 -> 2 -> 3

    Constraints:
    The number of nodes in the list is in the range [0, 500].
            -100 <= Node.val <= 100
            0 <= k <= 2 * 10^9

*/

ListNode node=null;
    @Test
    public void example1() {
        int[] h = {1, 2, 3, 4, 5};
        int k=2;
        for (int i : h)
            node = add(i);
        Assert.assertEquals(rotateRight(node, k), new int[]{4,5,1,2,3});
    }

    @Test
    public void example2() {
        int[] h = {0,1, 2};
        int k=4;
        for (int i : h)
            node = add(i);
        Assert.assertEquals(rotateRight(node, k), new int[]{2,0,1});
    }

    @Test
    public void example3() {
        int[] h = {0};
        int k=4;
        for (int i : h)
            node = add(i);
        Assert.assertEquals(rotateRight(node, k), new int[]{0});
    }

    @Test
    public void example4() {
        int[] h = {1,2,3};
        int k=2000000000;
        for (int i : h)
            node = add(i);
        Assert.assertEquals(rotateRight(node, k), new int[]{2,0,1});
    }

    public ListNode add(int input) {
        if (head == null) {
            head = tail = new ListNode(input);
        } else {
            tail.next = tail = new ListNode(input);
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*
    1. consider base condition for k=0, head and next node is null
    2. take two traversal for k times
    3. additional while loop to move the pointer to end of the iteration
    4. check for condition as
    curr, curr next as tail and prev item
    5. take three position values and assign the last to head position
    6. move to next place

    time - O(n*n)
    space - O(1) using same space without creating new node
     */


    int length = 0;
    ListNode head = null, tail = null, prev = null, temp = null;

    public ListNode rotateRights(ListNode head, int k) {

        if(k==0 || head==null || head.next==null)
            return head;

        ListNode curr=head, headtemp=null, tail=null;

        for(int i=0; i<k; i++){//O(n)

            headtemp=curr;

            while(curr.next.next!=null){//O(n)
                curr=curr.next;
            }
            tail=curr.next;
            curr.next = curr.next.next;
            tail.next=headtemp;
            curr=tail;
        }
        return curr;
    }

    /*
    logic 2
    1. traverse the index upto k time i<k
    2. consider k next index as current
    3. move till end of the node length
    4. make current.next as head and its last node as pointing to previous head
    5. make the current next as null
    6. return the repointed node


     */

    public ListNode rotateRight(ListNode head, int k) {
        final ListNode c = head;
        if (k == 0 || head == null || head.next == null)
            return head;

        ListNode curr = c, headtemp = null, tail = null, end = null;
        int i = 0;
        while (i < k) {
            if(curr.next==null) curr.next=c;
            curr = curr.next;
            i++;
        }
        headtemp = c;
        while (headtemp.next != null) {
            headtemp=headtemp.next;
            end = headtemp;
        }
        tail = curr.next;
        end.next = head;
        head=tail;
        curr.next = null;
        return tail;
    }


    public void print(ListNode node1) {
        ListNode node = node1;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
