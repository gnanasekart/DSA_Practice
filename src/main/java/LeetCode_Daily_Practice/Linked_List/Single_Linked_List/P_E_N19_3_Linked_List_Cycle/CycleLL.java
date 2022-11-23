package LeetCode_Daily_Practice.Linked_List.Single_Linked_List.P_E_N19_3_Linked_List_Cycle;

import org.testng.Assert;
import org.testng.annotations.Test;
import LeetCode_Daily_Practice.Linked_List.Single_Linked_List.List.Node;
import java.util.HashSet;

public class CycleLL{

    @Test
    public void example1() {
        Node newNode = new Node();
        int[] a = {3,2,0,-4};
        newNode.addAll(a);
        Assert.assertEquals(hasCycle(newNode.head), true);
        newNode.print();
    }

    @Test
    public void example2() {
        int[] a = {-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5};
        Node newNode = new Node();
        newNode.addAll(a);
        Assert.assertEquals(hasCycle(newNode.head), false);
        newNode.print();
    }

    @Test
    public void example3() {
        Node newNode = new Node();
        int[] a = {1,2};
        newNode.addAll(a);
        Assert.assertEquals(hasCycle(newNode.head), true);
        newNode.print();
    }

    @Test
    public void example4() {
        Node newNode = new Node();
        int[] a = {1};
        newNode.addAll(a);
        Assert.assertEquals(hasCycle(newNode.head), false);
        newNode.print();
    }

    private boolean hasCycle(Node head) {
        HashSet<Node> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head))
                return true;

            set.add(head);
            head = head.next;
        }
        return false;
    }
}

