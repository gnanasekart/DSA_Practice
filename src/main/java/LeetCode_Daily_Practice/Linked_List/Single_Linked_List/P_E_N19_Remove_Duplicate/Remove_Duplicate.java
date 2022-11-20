package LeetCode_Daily_Practice.Linked_List.Single_Linked_List.P_E_N19_Remove_Duplicate;
import org.testng.annotations.Test;

public class Remove_Duplicate {

    @Test
    public void example1(){
        Node_Imp node = new Node_Imp();
        node.add(1);
        node.add(1);
        node.add(2);
        node.add(3);
        node.add(3);
        node.deleteDuplicates(node.head);
        node.print();
    }

    @Test
    public void example2(){
        Node_Imp node = new Node_Imp();
        node.add(1);
        node.add(1);
        node.add(2);
        node.deleteDuplicates(node.head);
        node.print();
    }

    @Test
    public void example3(){
        Node_Imp node = new Node_Imp();
        node.deleteDuplicates(node.head);
        node.print();
    }


}
