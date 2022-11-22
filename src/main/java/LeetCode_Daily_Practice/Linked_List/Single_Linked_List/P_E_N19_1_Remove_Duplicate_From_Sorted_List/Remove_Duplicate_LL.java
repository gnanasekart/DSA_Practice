package LeetCode_Daily_Practice.Linked_List.Single_Linked_List.P_E_N19_1_Remove_Duplicate_From_Sorted_List;
import LeetCode_Daily_Practice.Linked_List.Single_Linked_List.List.Node;
import LeetCode_Daily_Practice.Linked_List.Single_Linked_List.List.Nodeimplementation;
import org.testng.annotations.Test;


public class Remove_Duplicate_LL {

    /*
leetcode.com/problems/remove-duplicates-from-sorted-list/
Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
Return the linked list sorted as well.
Input: head = [1,1,2,3,3]
Output: [1,2,3]
Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.

     */

    public Node node;
    public Node head = null;
    public Node next = null;
    public int length=0;

    @Test
    public void example1(){
         node = new Node();
         node.add(1);
         node.add(1);
         node.add(2);
         deleteDuplicate(node);
         node.print();//1,2
    }

    @Test
    public void example2(){
        node = new Node();
        node.add(1);
        node.add(1);
        node.add(2);
        node.add(3);
        node.add(3);
        deleteDuplicate(node);
        node.print();//1,2,3
    }

   public Node deleteDuplicate(Node node){
//        Node temp = head;
//        if(temp==null) return temp;
//        while(temp.next!=null){
//            if(temp.next==data){
//                temp.next = temp.next.next;
//            }else temp=temp.next;
//        }
      return node;
    }

}
