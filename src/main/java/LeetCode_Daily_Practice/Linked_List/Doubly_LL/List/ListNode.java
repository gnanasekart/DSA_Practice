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

    public void add(int input) {
        ListNode node = new ListNode(input);
        if (head == null) {
            head = node;
            tail = node;
            prev=null;
        } else {

            tail.next = node;
            tail = node;
            head=tail;
        }
        length++;
    }

    public int size() {
        return length;
    }

    public void print() {
        if(head==null)
            System.out.println("Empty Node");
        ListNode temp=head;
        while (temp != null) {
            System.out.print(temp.val +" ");
            temp = temp.next;
        }
    }

    public void remove(int input) {
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val == input) {
                temp.next = temp.next.next;
                length--;
            }
            temp = temp.next;
        }
    }

    public void removeind(int index) {
        ListNode temp = head;
        for (int i = 0; i < index-1; i++)
            temp=temp.next;

            temp.next = temp.next.next;
            length--;
        }

    public void set(int index, int value) {
        for (int i = 0; i < index-1; i++)
            head=head.next;
        head.next.val =value;
    }

    public void insert(int index, int value) {
        ListNode temp=head;
        ListNode node=new ListNode(value);
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
        return head.next.val;
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

}
