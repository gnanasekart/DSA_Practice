package Tree.BinaryTree;

import org.testng.annotations.Test;

public class BinaryTreeArray {
    @Test
    public void example() {
        BinaryTree2 newNode = new BinaryTree2(9);
        newNode.insert("N1");
        newNode.insert("N2");
        newNode.insert("N3");
        newNode.insert("N4");
        newNode.insert("N5");
        newNode.insert("N6");
        newNode.insert("N7");
        newNode.insert("N8");
        newNode.insert("N9");

        newNode.delete("N7");
    }

}
