package LeetCode_Challenges;

import org.testng.annotations.Test;

public class P_M_LC_10_Delete_Node_From_List {
    //https://leetcode.com/problems/delete-node-in-a-linked-list/

    @Test
    public void example1(){
        Node head = addNode(4);
        head.next=addNode(5);
        head.next.next=addNode(1);
        head.next.next.next=addNode(9);
         removeNode( head);
    }

    private void removeNode(Node node) {
        node.data=node.next.data;
        node.next=node.next.next;
        //System.out.println(head);
    }


    public Node addNode(int data){
        return new Node(data);
    }
    public class Node{
        int data;
        Node next;

        Node(){
            this.next=null;
        }
        public Node(int key){
            this.data=key;
            this.next=null;
        }
    }
}
