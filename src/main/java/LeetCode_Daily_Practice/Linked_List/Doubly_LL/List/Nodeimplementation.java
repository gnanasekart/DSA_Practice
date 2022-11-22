package LeetCode_Daily_Practice.Linked_List.Doubly_LL.List;

import LeetCode_Daily_Practice.Linked_List.Single_Linked_List.List.Node;
import org.testng.annotations.Test;

public class Nodeimplementation {

    public ListNode head = null;
    public ListNode tail = null;
    public ListNode prev = null;
    public int length = 0;
    ListNode node = null;

    @Test
    public void example1() {
        //ListNode node = new ListNode();
//        add(1);
//        add(2);
//        add(3);
//        add(4);
//        add(5);
//        add(6);

        add(3);
        add(2);
        add(0);
        add(-4);
        print();
        //System.out.println(size());
        //remove(1);
        //remove(6);
        //System.out.println(size());
        removeind(0);
         //set(5, 10);
        //insert(4, 15);
        //System.out.println(get(5));
        // node.deleteDuplicates(node.head);
        print();
    }

    public void add(int input) {
        node = new ListNode(input);
        if (head == null) {
            head = node;
            tail = node;
            prev = null;
            tail.next = null;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
            tail.next = null;
        }
        length++;
    }

    public int size() {
        return length;
    }

    public void print() {
        if (head == null)
            System.out.println("Empty Node");
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public void remove(int input) {
        if (head.prev == null) {
            head = head.next;
            head.prev = null;
        } else {
            while (head.next != null) {
                if (head.val == input) {
                    head.prev.next = head.next;
                    head.next.prev = head.prev.next;
                    head.next = null;
                    head.prev = null;
                    length--;
                }
                head = head.next;
            }
        }
        length--;
    }

    public void removeind(int index) {
        if (index == 0) {
            remove(get(0));
        } else {
            ListNode temp = head;
            for (int i = 0; i < index - 1; i++)
                temp = temp.next;

            temp.next = temp.next.next;
            temp.next.prev = temp;
        }
        length--;
    }

    public void set(int index, int value) {
        ListNode temp=head;
        for (int i = 0; i < index - 1; i++)
            temp = temp.next;
        temp.next.val = value;
    }

    public void insert(int index, int value) {
        ListNode temp = head;
        ListNode node = new ListNode(value);
        if (index == 0) {
            head.prev = node;
            node.next = head;
            head = node;
        } else {
            for (int i = 0; i < index - 1; i++)
                temp = temp.next;

            node.next = temp.next;
            temp.next.prev = node;
            temp.next = node;
            node.prev = temp;
            temp = node;
        }
        length++;
    }

    public int get(int index) {
        ListNode temp = head;
        for (int i = 0; i < index - 1; i++)
            temp = temp.next;
        return temp.next.val;
    }




}
