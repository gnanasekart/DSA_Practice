//package leetcodechallenge;
//
//import org.testng.annotations.Test;
//
//public class Add_Two_number {
//
//    //redquark.org/leetcode/0002-add-two-numbers/
//
//    @Test
//    public void example1(){
//       int[] l1 = {2,4,3}, l2 = {5,6,4};
//        //Output: [7,0,8]
//        //Explanation: 342 + 465 = 807.
//
//        Add2number_LinkedList(l1, l2, true);
//    }
//
//    private ListNode Add2number_LinkedList(int[] l1, int[] l2, boolean flag) {
//        boolean a= (l1==null);
//        boolean b= (l2==null);
//        if (a && b && flag) {
//            return null;
//        }
//
//        int val=(a ? 0:l1.val)+(b ? 0:l2.val)+(flag ? 0:1);
//        int v=val%10;
//        boolean f= (v==val);
//        ListNode answer=new ListNode(v);
//        answer.next=add(a ? null:l1.next, b ? null:l2.next, f);
//        return answer;
//    }
//}
