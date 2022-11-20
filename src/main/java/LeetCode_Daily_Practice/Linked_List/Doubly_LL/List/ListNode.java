package LeetCode_Daily_Practice.Linked_List.Doubly_LL.List;

public class ListNode {
    int val;
    ListNode head;
    ListNode next;
    ListNode prev;
    ListNode tail;
    int length;

    ListNode() {
        head = null;
    }

    ListNode(int input) {
        this.val = input;
        head = null;
        next = null;
        prev = null;
    }
}
