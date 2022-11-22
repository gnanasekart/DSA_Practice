package LeetCode_Daily_Practice.Linked_List.Single_Linked_List.P_E_N19_2_Merge_Two_Sorted_Lists;

import org.testng.annotations.Test;
public class Sorted_List {

    public ListNode head=null;
    public ListNode tail=null;
    public int length=0;

    @Test
    public void example1(){
        Sorted_List list = new Sorted_List();
        ListNode node1 = new ListNode();
        list.add(1, node1);
        list.add(2, node1);
        list.add(4, node1);
        //print(node1.head);
        ListNode node2 = new ListNode();
        list.add(1, node2);
        list.add(3, node2);
        list.add(4, node2);
        //print(node2.head);
        list.mergeTwoLists(node1.head,node2.head);
        list.print(list.mergeNode.head);
    }

    @Test
    public void example2(){
        Sorted_List list = new Sorted_List();
        ListNode node1 = new ListNode();
        list.add(1, node1);
        list.add(2, node1);
        list.add(5, node1);
        //print(node1.head);
        ListNode node2 = new ListNode();
        list.add(1, node2);
        list.add(3, node2);
        list.add(4, node2);
        list.add(7, node2);
        list.add(9, node2);
        list.add(10, node2);
        //print(node2.head);
        list.mergeTwoLists(node1.head,node2.head);
        list.print(list.mergeNode.head);
    }

    @Test
    public void example3(){
        Sorted_List list = new Sorted_List();
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        list.mergeTwoLists(node1.head,node2.head);
        list.print(list.mergeNode.head);
    }

    @Test
    public void example4(){
        Sorted_List list = new Sorted_List();
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        list.add(0, node2);
        list.mergeTwoLists(node1.head,node2.head);
        list.print(list.mergeNode.head);
    }

    @Test
    public void example5(){
        Sorted_List list = new Sorted_List();
        ListNode node1 = new ListNode();
        list.add(1, node1);
        ListNode node2 = new ListNode();

        list.mergeTwoLists(node1.head,node2.head);
        list.print(list.mergeNode.head);
    }

    public int size() {
        return length;
    }

    public void print(ListNode head) {
        if(head==null)
            System.out.println("Empty Node");
        while (head != null) {
            System.out.print(head.val +" ");
            head = head.next;
        }
    }

    ListNode mergeNode=null;
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        mergeNode=new ListNode();
        if(l1==null && l2==null) return l1;

        while(l1!=null && l2!=null){

            if(l1.val==l2.val){
                add(l1.val, mergeNode);
                l2=l2.next;
            }else if(l1.val<l2.val){
                add(l1.val, mergeNode);
                l1=l1.next;
            }else{
                add(l2.val, mergeNode);
                l2=l2.next;
            }
        }
        if(l1!=null){
            add(l1.val, mergeNode);
            l1=l1.next;
        }else{
            add(l2.val,mergeNode);
            l2=l2.next;
        }
        return mergeNode;
    }

    public ListNode newNode=null;
    public ListNode add(int input, ListNode node){
        newNode = new ListNode(input);
        if(node.head==null){
            newNode.val=input;
            node.head=newNode;
            node.tail=newNode;
        }else{
            node.tail.next=newNode;
            node.tail=newNode;
        }
        length++;
        return newNode;
    }

}
