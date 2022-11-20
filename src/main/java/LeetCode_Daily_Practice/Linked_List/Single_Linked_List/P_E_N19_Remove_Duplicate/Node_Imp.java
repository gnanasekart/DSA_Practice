package LeetCode_Daily_Practice.Linked_List.Single_Linked_List.P_E_N19_Remove_Duplicate;

public class Node_Imp {
    int data;
    Node_Imp head;
    Node_Imp next;
    Node_Imp tail;
    int length;

    Node_Imp() {
        head = null;
    }

    Node_Imp(int input) {
        this.data = input;
        head = null;
        tail = null;
    }


    public void add(int input) {
        Node_Imp node = new Node_Imp(input);
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
        Node_Imp temp=head;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public Node_Imp deleteDuplicates(Node_Imp head) {
       Node_Imp temp=head;
        if(head==null) return head;
        while(head.next!=null){
            if(head.data==head.next.data){
                head.next=head.next.next;
                length--;
            }else
                head=head.next;
        }
        return temp;
    }
}
