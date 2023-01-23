package LeetCode_Daily_Practice.Linked_List.Single_Linked_List.List;

import java.util.Objects;

public class Node {
    public int data;
    public Node head;
    public Node next;
    public Node tail;
    int length;

    public Node() {
        head = null;
    }

    public Node(int input) {
        this.data = input;
        head = null;
        tail = null;
    }

    public Node add(int input) {
        Node node = new Node(input);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = tail = node;
        }
        length++;
        return node;
    }

    public void addFirst(int input) {
        Node temp = head;
        head = new Node(input);
        head.next = temp;
        //head=node;
    }

    public void insert(int index, int value) {
        Node temp = head;
        Node node = new Node(value);
        if (index == 0) {
            node.next = temp;
            temp = node;
        } else {
            for (int i = 0; i < index - 1; i++)
                temp = temp.next;
                node.next = temp.next;
                temp.next = node;
        }
        length++;
    }

    public boolean addAll(int[] input) {
        if (input.length == 0) return false;
        for (int x : input)
            add(x);

        return true;
    }

    public void set(int index, int value) {
        for (int i = 0; i < index - 1; i++)
            head = head.next;
        head.next.data = value;
    }

    public int get(int index) {
        if (index < 0 || index >= length)
            throw new ArrayIndexOutOfBoundsException();
        Node temp = getNode(index);
        return temp.data;
    }

    public int size() {
        return length;
    }

    public void print() {
        if (head == null)
            System.out.println("Empty Node");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void removeFirstIndex() {
        if (length == 0) return;
        if (length == 1) head = tail = null;
        else head = head.next;

        length--;
    }

    public void removeLastIndex() {
        if (length == 0) return;
        if (length == 1) head.tail = null;
        else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        length--;
    }

    public void remove(int input) {
        if (length == 0) return;
        if (length == 1) tail = head = null;
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == input) {
                temp.next = temp.next.next;
                length--;
            }
            temp = temp.next;
        }
    }

    public void deleteAll() {
        head = null;
    }

    //inProgress
    public void removeAll(int input) {
        Objects.requireNonNull(input);
//        if(head.data==input){
//            head=head.next;
//            length--;
//        }

        Node temp = head;//1,1,2,3,1    1,2,3,2,1
        while (temp != null) {
            if (temp.data == input) {
                //temp=temp.next;
            } else if (temp.next.data == input && temp.next != null) {
                temp.next = temp.next.next;
            } else if (temp.next.data == input && temp.next == null) {
                temp.next = null;
            }
            length--;
            temp = temp.next;
        }
    }

    public void removeIndex(int index) {
        if (index >= length || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        if (index == 0)
            removeFirstIndex();
        else if (index == length - 1)
            removeLastIndex();
        else {
            Node node = getNode(index - 1);
            node.next = node.next.next;
        }
        length--;
    }

    public Node getNode(int index) {
        Node temp = head;
        int currentIndex = 0;
        while (index >= 0 && currentIndex++ != index)
            temp = temp.next;

        return temp;
    }

    public int indexOf(int input) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == input)
                return index;
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(int input) {
        Node temp = head;
        int count = 0, index = -1;
        while (temp != null) {
            if (temp.data == input)
                index = count;
            temp = temp.next;
            count++;
        }
        return index;
    }
}
