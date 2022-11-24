package LeetCode_Daily_Practice.Linked_List.Single_Linked_List.P_E_N19_2_Merge_Two_Sorted_Lists;

import org.testng.annotations.Test;

import java.util.LinkedList;

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
        list.mergeTwoList(node1.head,node2.head);
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
        list.mergeTwoList(node1.head,node2.head);
        list.print(list.mergeNode.head);
    }

    @Test
    public void example3(){
        Sorted_List list = new Sorted_List();
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        list.mergeTwoList(node1.head,node2.head);
        list.print(list.mergeNode.head);
    }

    @Test
    public void example4(){
        Sorted_List list = new Sorted_List();
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        list.add(0, node2);
        list.mergeTwoList(node1.head,node2.head);
        list.print(list.mergeNode.head);
    }

    @Test
    public void example5(){
        Sorted_List list = new Sorted_List();
        ListNode node1 = new ListNode();
        list.add(1, node1);
        ListNode node2 = new ListNode();

        list.mergeTwoList(node1.head,node2.head);
        list.print(list.mergeNode.head);
    }

    public void print(ListNode head) {
        if(head==null)
            System.out.println("Empty Node");
        while (head != null) {
            System.out.print(head.val +" ");
            head = head.next;
        }
    }

    /*
    logic 1 using external head and tail
    1. creating an additional node to store the sorted item
    2. compare the nodes not to be null
    3. compare the first two values and add the smallest number into node
    4. continue till the end
    5. Any one of the node failed to traversal and reaches null value
    6. then compare any one value which is not null and add the remaining item into node

    time -
     */

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

    ListNode mergeNode=null;
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        mergeNode=new ListNode();
        if(l1==null && l2==null) return l1;

        while(l1!=null && l2!=null){//O(n)

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
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                add(l1.val, mergeNode);
                l1 = l1.next;
            } else {
                add(l2.val, mergeNode);
                l2 = l2.next;
            }
        }
        return mergeNode;
    }

    ListNode t=null, h=null;
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null || l1!=null && l2==null) return l1;
        //if(l1!=null && l2==null) return l1;
        if (l1==null && l2!=null) return l2;

        if(l1!=null && l2!=null){
            //ListNode nn = new ListNode();
            if(l1.val < l2.val){
                h=t=new ListNode(l1.val);
                l1=l1.next;
            }else{
                h=t=new ListNode(l2.val);
                l2=l2.next;
            }
        }

        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                t.next=t=new ListNode(l1.val);
                l1=l1.next;
            }else{
                t.next=t=new ListNode(l2.val);
                l2=l2.next;
            }
        }

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                t.next=t=new ListNode(l1.val);
                l1=l1.next;
            } else if(l2!=null){
                t.next=t=new ListNode(l2.val);
                l2=l2.next;
            }
        }

        return h;
    }

}