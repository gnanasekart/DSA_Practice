package sample;

public class Node {
    int data;
    Node head;
    Node next;
    Node tail;
    int length;

    Node() {
        head = null;
    }

    Node(int input) {
        this.data = input;
        head = null;
        tail = null;
    }
    /*
    remove(int index)
    remove(int value)
    set(int index, int value)
    get(int index)
     */

    public void add(int input) {
        Node node = new Node(input);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        length++;
    }

    public int size() {
        return length;
    }

    public void print() {
        if(head==null)
            System.out.println("Empty Node");
        Node temp=head;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public void remove(int input) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == input) {
                temp.next = temp.next.next;
                length--;
            }
            temp = temp.next;
        }
    }

    public void removeind(int index) {
        Node temp = head;
        for (int i = 0; i < index-1; i++)
            temp=temp.next;

            temp.next = temp.next.next;
            length--;
        }

    public void set(int index, int value) {
        for (int i = 0; i < index-1; i++)
            head=head.next;
        head.next.data=value;
    }

    public void insert(int index, int value) {
        Node temp=head;
        Node node=new Node(value);
        if(index==0) {
            node.next = temp;
            temp = node;
        }

        for (int i = 0; i < index-1; i++)
            temp=temp.next;

            node.next=temp.next;
            temp.next=node;
            length++;
    }

    public int get(int index) {

        for (int i = 0; i < index-1; i++)
            head=head.next;
        return head.next.data;
//        Node temp = head;
//        int i = 0;
//        int ret=0;
//        while (temp.next != null) {
//            i += 1;
//            tail = temp.next;
//            if (i == index) {
//                ret = temp.data;
//            }
//            temp = tail;
//            tail = tail.next;
//        }
//        return ret;
    }

    public Node deleteDuplicates(Node head) {
        Node temp=head;
        if(head==null) return head;
        while(head.next!=null){
            if(head.data==head.next.data){
                head.next=head.next.next;
            }else
                head=head.next;
        }
        return temp;
    }
}
