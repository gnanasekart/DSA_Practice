package LeetCode_Challenges;

import org.testng.annotations.Test;

public class P_M_LC_11_Remove_Mid_Node_LL {
//leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

    @Test
    public void example1(){
        ListNode head = addNode(1);
        head.next=addNode(3);
        head.next.next=addNode(4);
        head.next.next.next=addNode(7);
        head.next.next.next.next=addNode(1);
        head.next.next.next.next.next=addNode(2);
        head.next.next.next.next.next.next=addNode(6);
        deleteMiddle(head);
}

    @Test
    public void example2(){
        ListNode head = addNode(2);
        head.next=addNode(1);
        removeMidNode(head);
    }

    @Test
    public void example3(){
        ListNode head = addNode(1);
        head.next=addNode(2);
        head.next.next=addNode(3);
        head.next.next.next=addNode(4);
        deleteMiddle(head);
    }

    @Test
    public void example4(){
        ListNode head = addNode(1);
        removeMidNode(head);
    }

    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null)return null;
        ListNode slow=head;
        ListNode last=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            last=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(slow!=null)
            last.next=slow.next;
        return head;
    }

    private ListNode removeMidNode(ListNode head) {
        if(head==null || head.next==null) return null;
        int count=1;
        ListNode temp=head;
        ListNode n=head;
        while(temp.next!=null){
            count++;
            temp=temp.next;
        }

        int mid=count/2;
           for(int i=0; i<mid-1; i++)
               n=n.next;
           n.next=n.next.next;
       return head;
    }

    public ListNode addNode(int data){
        return new ListNode(data);
    }

    public class ListNode{
        int data;
        ListNode next;
        ListNode prev;

        ListNode(){
            this.next=null;
        }
        public ListNode(int key){
            this.data=key;
            this.next=null;
        }

        public ListNode(ListNode next, int key){
            this.data=key;
            this.next=next;
        }
    }
}