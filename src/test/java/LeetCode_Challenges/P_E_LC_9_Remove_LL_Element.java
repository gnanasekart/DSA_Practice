package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_LC_9_Remove_LL_Element {
//leetcode.com/problems/remove-linked-list-elements/
    @Test
    public void example1(){
        Node head = addNode(1);
        head.next=addNode(2);
        head.next.next=addNode(6);
        head.next.next.next=addNode(3);
        head.next.next.next.next=addNode(4);
        head.next.next.next.next.next=addNode(5);
        head.next.next.next.next.next.next=addNode(6);
        int k=6;
        System.out.println(removeDup(head, k));

//        Assert.assertEquals(head, new int[]{1,2,3,4,5});
}

    @Test
    public void example2(){
        Node head = addNode(1);
        int k=1;
        System.out.println(removeDup(head, k));
    }

    @Test
    public void example3(){
        Node head = addNode(7);
        head.next=addNode(7);
        head.next.next=addNode(7);
        head.next.next.next=addNode(7);
        int k=7;
        System.out.println(removeDup(head, k));
    }

    private Node removeDupRecursion(Node head, int val) {

        if (head == null) return null;
        if (head.data == val)
            return removeDup(head.next, val);
        head.next = removeDup(head.next, val);
        return head;
    }

        private Node removeDup(Node head, int val) {
            if (head == null) return null;
            Node temp = head;
            while (temp != null) {
                if (temp.next != null && temp.next.data == val) {
                    temp.next = temp.next.next;
                } else
                    temp = temp.next;
            }
            if (head.data == val)
                head = head.next;
            return head;
        }

    private Node removeDupMe(Node head, int val) {
        Node curr=head.next;
        Node prev=head;
        while(curr!=null){
            if(curr.data==val)
                prev.next=curr.next;
            else
                prev=curr;
            curr=curr.next;
        }
        return head;
    }

    public Node addNode(int data){
        return new Node(data);
    }

    public class Node{
        int data;
        Node next;
        Node prev;

        Node(){
            this.next=null;
        }
        public Node(int key){
            this.data=key;
            this.next=null;
        }

        public Node(Node next, int key){
            this.data=key;
            this.next=next;
        }
    }
}
