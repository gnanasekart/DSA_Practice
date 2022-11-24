package LeetCode_Daily_Practice.Linked_List.Single_Linked_List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_N23_1_Reverse_LL {
    /*

     https://leetcode.com/problems/reverse-linked-list/

     Given the head of a singly linked list, reverse the list, and return the reversed list.

     Constraints:
     The number of nodes in the list is the range [0, 5000].
             -5000 <= Node.val <= 5000

 */
    @Test
    public void example1() {
        int[] h = {1, 2, 3, 4, 5};
        for (int i : h)
            node = add(i);
        Assert.assertEquals(toArray(reverseSwap(node)), new int[]{5, 4, 3, 2, 1});
    }

    @Test
    public void example2() {
        int[] h = {1, 2};
        for (int i : h)
            node = add(i);
        Assert.assertEquals(toArray(reverseLL(node)), new int[]{2,1});
    }

    @Test
    public void example3() {
        int[] h = {};
        for (int i : h)
            node = add(i);
        Assert.assertEquals(toArray(reverseLL(node)), new int[]{});
    }

    int length = 0;
    public ListNode add(int input) {
        if (head == null) {
            temp = new ListNode(input, next);
            head = tail = temp;
        } else {
            temp = new ListNode(input, next);
            tail.next = temp;
            tail = temp;
        }
        length++;
        return head;
    }

    /*
    logic 1 - 1hr
    1. consider the input node with data and assign it to temp variable
    2. iterate the temp variable
    3. passing the value to new listnode to add in first position
        - helper method addFirst
        - add first if listnode is null
        - else add in new listnode and assign it as tail to next new node
    4. return the new list node

    Complexity:-
    time -O(n)
    space -O(n)
     */


    class ListNode {
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

    ListNode node = null;
    ListNode next = null;
    ListNode temp = null, tempNode = null;
    ListNode head = null, tail = null;

    public ListNode addFirst(int input) {
        if (tempNode == null) {
            tempNode = new ListNode(input);
        } else {
            ListNode t = tempNode;
            tempNode = new ListNode(input, next);
            tempNode.next = t;
        }
        return tempNode;
    }

    private ListNode reverseLL(ListNode node) {
        if (node == null) return node;
        ListNode curr = node;
        while (curr != null) {//O(n)
            tempNode = addFirst(curr.val);//O(n)
            curr = curr.next;
        }
        return tempNode;
    }

    public int[] toArray(ListNode node) {
        int[] arr = new int[length];
        int i = 0;
        while (node != null) {
            if (i < length)
                arr[i++] = node.val;
            node = node.next;
        }
        length=0;
        return arr;
    }

    /*
    logic 2
    1. consider the based and breaking condition
    2. first separate the current node from main nodes
    3. assign the current node next pointer to prev value
    4. now prev node have first value
    5. now move the curr pointer to prev node
    6. switch back to mail list temp node
    7. return the prev node

    complexity
    space - O(n)
    time - O(1)
     */

    private ListNode reverseSwap(ListNode node) {
        if(node==null) return node;
        ListNode tempNode=null, prevNode=null, currNode=node;
        while(currNode!=null) {
            tempNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = tempNode;
        }
        return prevNode;
    }
}
