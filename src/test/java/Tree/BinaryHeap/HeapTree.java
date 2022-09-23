package Tree.BinaryHeap;

import org.testng.annotations.Test;

public class HeapTree {

    @Test
    public void example(){
        HeapNode newNode = new HeapNode(5);
        //newNode.peek();
        newNode.levelOrder();
    }


}
