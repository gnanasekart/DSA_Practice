package Tree.BinaryTree;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL1 {

    BinaryNode1 root;

    public BinaryTreeLL1() {
        this.root = null;
    }

    //@Test
    public void traversal() {
        BinaryTreeLL1 rootNode = new BinaryTreeLL1();
        BinaryNode1 n1 = new BinaryNode1();
        n1.value = "N1";
        BinaryNode1 n2 = new BinaryNode1();
        n2.value = "N2";
        BinaryNode1 n3 = new BinaryNode1();
        n3.value = "N3";
        BinaryNode1 n4 = new BinaryNode1();
        n4.value = "N4";
        BinaryNode1 n5 = new BinaryNode1();
        n5.value = "N5";
        BinaryNode1 n6 = new BinaryNode1();
        n6.value = "N6";
        BinaryNode1 n7 = new BinaryNode1();
        n7.value = "N7";
        BinaryNode1 n8 = new BinaryNode1();
        n8.value = "N8";
        BinaryNode1 n9 = new BinaryNode1();
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
        BinaryTreeLL1 node = new BinaryTreeLL1();
        node.insertNode("N1");
        node.insertNode("N2");
        node.insertNode("N3");
        node.insertNode("N4");
        node.insertNode("N5");
        node.insertNode("N6");
        node.insertNode("N7");
        node.insertNode("N8");
        node.insertNode("N9");

        node.levelOrder();
        System.out.println();
        node.deleteAll();
        // node.levelOrder();
//        System.out.println(node.getDeepestNode().value);

    }

    //preorder
    //time comp = O(n)
    //space comp - O(n)
    void preOrder(BinaryNode1 node) {
        if (node == null) return;

        System.out.print(node.value + " ");
        preOrder(node.left); //----> O(n/2)
        preOrder(node.right); //----> O(n/2)
    }

    //InOrder
    //time comp = O(n)
    //space comp - O(n)
    void inOrder(BinaryNode1 node) {
        if (node == null) return;

        inOrder(node.left); //----> O(n/2)
        System.out.print(node.value + " ");
        inOrder(node.right); //----> O(n/2)
    }

    //postOrder
    //time comp = O(n)
    //space comp - O(n)
    void postOrder(BinaryNode1 node) {
        if (node == null) return;

        postOrder(node.left); //----> O(n/2)
        postOrder(node.right); //----> O(n/2)
        System.out.print(node.value + " ");
    }

    //time comp = O(n)
    //space comp - O(n)
    void levelOrder() {
        Queue<BinaryNode1> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {  //--> O(n)
            BinaryNode1 presentnode = queue.remove();
            System.out.print(presentnode.value + " ");
            if (presentnode.left != null) queue.add(presentnode.left);
            if (presentnode.right != null) queue.add(presentnode.right);
        }
    }

    //time comp = O(n)
    //space comp - O(n)
    void searchNode(String value) {
        Queue<BinaryNode1> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode1 presentNode = queue.remove();
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
        BinaryNode1 newNode = new BinaryNode1();
        newNode.value = value;

        if (root == null) {
            root = newNode;
            System.out.println("root node inserted");
            return;
        }
        Queue<BinaryNode1> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode1 presentNode = queue.remove();
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

    //find deepest node
    BinaryNode1 getDeepestNode() {
        Queue<BinaryNode1> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode1 presentNode = null;

        while (!queue.isEmpty()) {
            presentNode = queue.remove();
            if (presentNode.left != null) queue.add(presentNode.left);
            if (presentNode.right != null) queue.add(presentNode.right);
        }
        return presentNode;
    }

    void deleteDeepestnode() {
        Queue<BinaryNode1> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode1 prevNode, currNode = null;
        while (!queue.isEmpty()) {
            prevNode = currNode;
            currNode = queue.remove();
            if (currNode.left == null) {
                prevNode.right = null;
                return;
            } else if (currNode.right == null) {
                currNode.left = null;
                return;
            } else {
                queue.add(currNode.left);
                queue.add(currNode.right);
            }
        }
    }

    //time comp = O(n)
    //space comp - O(n)
    void deleteValue(String value) {
        Queue<BinaryNode1> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) { // ---> O(n)
            BinaryNode1 presentNode = queue.remove();
            if (presentNode.value == value) {
                presentNode.value = getDeepestNode().value;// ---> O(n)
                deleteDeepestnode();// ---> O(n)
                System.out.println("node deleted");
                return;
            } else {
                if (presentNode.left != null) queue.add(presentNode.left);
                if (presentNode.right != null) queue.add(presentNode.right);
            }
        }
    }

    void deleteAll() {
        root = null;
        System.out.println("Deleted root node");
    }

}




