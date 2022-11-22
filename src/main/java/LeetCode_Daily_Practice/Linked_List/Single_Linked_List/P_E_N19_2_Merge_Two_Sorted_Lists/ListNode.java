package LeetCode_Daily_Practice.Linked_List.Single_Linked_List.P_E_N19_2_Merge_Two_Sorted_Lists;

/*
https://leetcode.com/problems/merge-two-sorted-lists/
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list.
The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

 */

public class ListNode {
    int val;
    ListNode head;
    ListNode next;
    ListNode tail;
    int length;

    ListNode() {
        head = null;
    }

    ListNode(int input) {
        this.val = input;
        head = null;
        tail = null;
    }

    ListNode(int input, ListNode next){
        this.val =input;
        this.next=next;
    }
}
