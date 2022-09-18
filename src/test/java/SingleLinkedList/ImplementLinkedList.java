package SingleLinkedList;

import org.testng.annotations.Test;

public class ImplementLinkedList {

    @Test
    public void example1() {
        ImplementLinkedList implement = new ImplementLinkedList();
        implement.addNode(10);
        implement.addNode(20);
        implement.addNode(25);
        implement.insertAtStart(5);
        implement.display();
        implement.insertAt(2, 15);
        //implement.delete(20);
        implement.display();
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

        Node() {
            next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public Node addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {//first node
            head = newNode;
            tail = newNode;
        } else {//remaining node
            tail.next = newNode;
            tail = newNode;
        }
        return head;
    }

    Node insertAtStart(int data){
        Node newNode = new Node(data);
        newNode.data=data;
        newNode.next=null;
        newNode.next=head;
        head=newNode;

        return head;
    }

    void insertAt(int index, int data){
        Node newNode = new Node(data);
        newNode.data=data;
        newNode.next=null;
        if(index==0) insertAtStart(data);

        for(int i=0; i<index-1; i++) head=head.next;

        newNode.next=head.next;
        head.next=newNode;

       // return head;
    }

//    public void addNode(int data){
//        Node node = new Node();
//        node.data=data;
//        node.next=null;
//
//        if(head==null) head=node;
//        else {
//            while (head.next!=null){
//                head=head.next;
//            }
//            head.next=node;
//        }
//    }

    public void delete(int data) {
        if (head == null) System.out.println("List empty");
        else {
            if (head != tail && head.data == data) {
                head = head.next;
            } else {
                head = tail = null;
            }
        }
    }

    public void deleteAll() {
        head = null;
    }

    public void display() {
        if (head == null) System.out.println("Empty list");

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
