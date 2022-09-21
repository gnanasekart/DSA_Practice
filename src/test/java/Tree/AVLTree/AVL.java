package Tree.AVLTree;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {

    @Test
    public void example() {
        AVL avl = new AVL();

    }

    AVLBinaryNode root;

    AVL() {
        root = null;
    }

    //preorder
    public void preOrder(AVLBinaryNode node) {
        if (node == null) return;
        ;

        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //Inorder
    public void inOrder(AVLBinaryNode node) {
        if (node == null) return;
        ;
        preOrder(node.left);
        System.out.println(node.value + " ");
        preOrder(node.right);
    }

    //postorder
    public void postOrder(AVLBinaryNode node) {
        if (node == null) return;
        ;
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.value + " ");
    }

    //levelOrder
    public void levelOrder() {
        Queue<AVLBinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            AVLBinaryNode presentNode = queue.remove();
            System.out.println(presentNode.value + " ");
            if (presentNode.left != null) queue.add(presentNode.left);
            if (presentNode.right != null) queue.add(presentNode.right);
        }
    }

    //searchValue
    public AVLBinaryNode search(AVLBinaryNode node, int value) {
        if (node == null) {
            System.out.println(value + " not found in AVL");
            return null;
        } else if (node.value == value) {
            System.out.println(value + " found in AVL");
            return node;
        } else if (value < node.value) return search(node.left, value);
        else return search(node.right, value);
    }

}
