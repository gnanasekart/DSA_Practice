package LeetCode_Daily_Practice.Linked_List.Single_Linked_List.P_E_N19_Merge_Two_Sorted_Lists;

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
