package LeetCode_Daily_Practice.Linked_List.Single_Linked_List;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class P_E_N22_1_Palindrome_LL {
    /*
    Given the head of a singly linked list, return true if it is a palindrome or
     false otherwise.
Constraints:

The number of nodes in the list is in the range [1, 10^5].
0 <= Node.val <= 9
     */

    class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  ListNode head=null, tail = null, next=null, res=null;
    ListNode node=null, temp=null;
    int length=0;

    @Test
    public void example1(){
        int[] a ={1,2,2,1};
        for(int x : a)
            node = add(x);
        Assert.assertEquals(palindrome(node), true);
    }

    @Test
    public void example2(){
        int[] a ={1,2};
        for(int x : a)
            node = add(x);
        Assert.assertEquals(palindrome(node), false);
    }

    @Test
    public void example3(){
        int[] a ={1};
        for(int x : a)
            node = add(x);
        Assert.assertEquals(palindrome(node), true);
    }

    @Test
    public void example4(){
        int[] a ={};
        for(int x : a)
            node = add(x);
        Assert.assertEquals(palindrome(node), false);
    }

    @Test
    public void example5(){
        int[] a ={1,0,0};
        for(int x : a)
            node = add(x);
        Assert.assertEquals(palindrome(node), false);
    }

    @Test
    public void example6(){
        int[] a ={1,1,2,1};
        for(int x : a)
            node = add(x);
        Assert.assertEquals(palindrome(node), false);
    }

    public ListNode add(int input){
        if(head==null){
            head=tail=new ListNode(input);
        }else{
            tail.next =tail=new ListNode(input);
        }
        length++;
        return head;
    }

    public void print(ListNode node1){
        ListNode node = node1;
        while(node!=null){
            System.out.println(node.val+" ");
            node = node.next;
        }
    }

    public int[] toArray(ListNode node) {
        int[] arr = new int[length];
        int i = 0;
        while (node != null) {
            if (i < length)
                arr[i++] = node.val;
            node = node.next;
        }
        return arr;
    }


    /*
    Logic 1 - 45min  Time Limit exceeded
    1. consider the node to reverse with reverse helper method
    2. compare the two node values by converting into array

    Complexity
    Time - O(n) * O(m*n)
    space - O(n)

     */
    public ListNode reverseLL(int input){
            ListNode t = temp;
            temp = new ListNode(input);
            temp.next = t;
        return temp;
    }

    public boolean palindrome(ListNode n){
        if(n.next==null) return true;
        if(n==null) return false;
        ListNode ntemp = n;
        while(ntemp!=null){  //O(n)
            res = reverseLL(ntemp.val);
            ntemp=ntemp.next;
        }
        return Arrays.equals(toArray(res),toArray(n));  //O(m*n)
    }

}
