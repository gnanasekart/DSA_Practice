package Data_Structure_Tree;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {

    BinaryNode root;

    public BinaryTreeLL() {
        this.root = null;
    }

    //@Test
    public void traversal() {
        BinaryTreeLL rootNode = new BinaryTreeLL();
        BinaryNode n1 = new BinaryNode();
        n1.value = "N1";
        BinaryNode n2 = new BinaryNode();
        n2.value = "N2";
        BinaryNode n3 = new BinaryNode();
        n3.value = "N3";
        BinaryNode n4 = new BinaryNode();
        n4.value = "N4";
        BinaryNode n5 = new BinaryNode();
        n5.value = "N5";
        BinaryNode n6 = new BinaryNode();
        n6.value = "N6";
        BinaryNode n7 = new BinaryNode();
        n7.value = "N7";
        BinaryNode n8 = new BinaryNode();
        n8.value = "N8";
        BinaryNode n9 = new BinaryNode();
        n9.value = "N9";

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n8;
        n4.right = n9;
        n3.left = n6;
        n3.right = n7;
        rootNode.root = n1;

        //System.out.println("PreOrder traversal");
        //rootNode.preOrder(rootNode.root);

        //System.out.println("InOrder traversal");
        //rootNode.inOrder(rootNode.root);

        //System.out.println("PostOrder traversal");
        //rootNode.postOrder(rootNode.root);

        //System.out.println("LevelOrder traversal");
        //rootNode.levelOrder();

        rootNode.searchNode("N5");
    }

    @Test
    public void operation() {
        BinaryTreeLL node = new BinaryTreeLL();
        node.insertNode("N1");
        node.insertNode("N2");
        node.insertNode("N3");
        node.insertNode("N4");
        node.insertNode("N5");
        node.insertNode("N6");
        node.insertNode("N7");

        node.levelOrder();

    }

    //preorder
    //time comp = O(n)
    //space comp - O(n)
    void preOrder(BinaryNode node) {
        if (node == null) return;

        System.out.print(node.value + " ");
        preOrder(node.left); //----> O(n/2)
        preOrder(node.right); //----> O(n/2)
    }

    //InOrder
    //time comp = O(n)
    //space comp - O(n)
    void inOrder(BinaryNode node) {
        if (node == null) return;

        inOrder(node.left); //----> O(n/2)
        System.out.print(node.value + " ");
        inOrder(node.right); //----> O(n/2)
    }

    //postOrder
    //time comp = O(n)
    //space comp - O(n)
    void postOrder(BinaryNode node) {
        if (node == null) return;

        postOrder(node.left); //----> O(n/2)
        postOrder(node.right); //----> O(n/2)
        System.out.print(node.value + " ");
    }

    //time comp = O(n)
    //space comp - O(n)
    void levelOrder() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {  //--> O(n)
            BinaryNode presentnode = queue.remove();
            System.out.print(presentnode.value + " ");
            if (presentnode.left != null) queue.add(presentnode.left);
            if (presentnode.right != null) queue.add(presentnode.right);
        }
    }

    //time comp = O(n)
    //space comp - O(n)
    void searchNode(String value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.value == value) {
                System.out.println("the value " + value + " is found");
                return;
            } else {
                if (presentNode.left != null) queue.add(presentNode.left);
                if (presentNode.right != null) queue.add(presentNode.right);
            }
        }
        System.out.println("the value " + value + "is not found");
    }

    //time comp = O(n)
    //space comp - O(n)
    void insertNode(String value) {
        BinaryNode newNode = new BinaryNode();
        newNode.value = value;

        if (root == null) {
            root = newNode;
            System.out.println("root node inserted");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.left == null) {
                presentNode.left = newNode;
                System.out.println("successfully added");
                break;
            } else if (presentNode.right == null) {
                presentNode.right = newNode;
                System.out.println("successfully added");
                break;
            } else {
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }
}


