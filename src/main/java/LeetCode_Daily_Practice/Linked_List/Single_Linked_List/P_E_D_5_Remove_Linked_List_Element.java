package LeetCode_Daily_Practice.Linked_List.Single_Linked_List;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class P_E_D_5_Remove_Linked_List_Element {
    /*

     */

    class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    ListNode node=null;

    @Test
    public void ex1(){
        int[] arr = {1,2,6,3,4,5,6};
        int k=6;
        for(int a: arr)
            node=add(a);
        removeDuplicate(node, k);
    }

    @Test
    public void ex2(){
        int[] arr = {};
        int k=1;
        for(int a: arr)
            node=add(a);
        removeDuplicate(node, k);
    }

    @Test
    public void ex3(){
        int[] arr = {7,7,7,7};
        int k=7;
        for(int a: arr)
            node=add(a);
        removeDuplicate(node, k);
    }

    @Test
    public void ex4(){
        int[] arr = {};
        int k=1;
        for(int a: arr)
            node=add(a);
        removeDuplicate(node, k);
    }

    int length=0;
    ListNode head=null, tail=null;
    public ListNode add(int a){
        if(head==null){
            head=tail=new ListNode(a);
        }else{
            tail.next=tail=new ListNode(a);
        }
        length++;
        return head;
    }

    ListNode h=null, t=null;
    private ListNode removeDuplicateSL(ListNode node, int k) {
        if(node==null) return node;
        ListNode temp = node;

        while(temp!=null){
            if(temp.val!=k){
                if(h==null) h=t=new ListNode(temp.val);
                else t.next=t=new ListNode(temp.val);
            }
            temp=temp.next;
        }
        return h;
    }

//------------------------------------------------------------

    private ListNode removeDuplicate(ListNode node, int k) {
        removeDuplicateRecursion(node, k);
        return h;
    }

    private void removeDuplicateRecursion(ListNode temp, int k) {
        if(temp==null) return;
        if(temp.val!=k){
            if(h==null) h=t=new ListNode(temp.val);
            else t.next=t=new ListNode(temp.val);
        }
       removeDuplicateRecursion(temp.next, k);
    }
}
