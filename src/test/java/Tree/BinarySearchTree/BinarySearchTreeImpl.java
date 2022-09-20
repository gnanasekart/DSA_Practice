package Tree.BinarySearchTree;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeImpl {
    BinaryNode root;

    @Test
    public void operation() {
        BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
        bst.insert(70);
        bst.insert(50);
        bst.insert(90);
        bst.insert(30);
        bst.insert(60);
        bst.insert(80);
        bst.insert(100);
        bst.insert(20);
        bst.insert(40);
        bst.levelOrder();

    }

    BinarySearchTreeImpl() {
        root = null;
    }

    // Insert Method
    private BinaryNode insert(BinaryNode currentNode, int value) {
        if (currentNode == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            // System.out.println("The value successfully inserted");
            return newNode;
        } else if (value <= currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    void insert(int value) {
        root = insert(root, value);
    }


    // PreOrder Traversal
    //time comp=O(N)
    //space comp=O(N)
    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Inorder Traversal
    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    // PostOrder Traversal
    public void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // Level Order
    //time comp=O(N)
    //space comp=O(N)
    void levelOrder() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }

    // Search Method
    //time comp = O(n/2)
    //space comp = O(n/2)
    BinaryNode search(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("Value: " + value + " not found in BST");
            return null;
        } else if (node.value == value) {
            System.out.println("Value: " + value + " found in BST");
            return node;
        } else if (value < node.value) {
            return search(node.left, value);//--> O(n/2)
        } else {
            return search(node.right, value);//--> O(n/2)
        }
    }

    // Minimum node
    public static BinaryNode minimumNode(BinaryNode root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    // Delete node
    //time comp = O(log n)
    //space comp = O(log n)
    public BinaryNode deleteNode(BinaryNode root, int value) {
        if (root == null) {
            System.out.println("Value not found in BST");
            return null;
        }
        if (value < root.value) {
            root.left = deleteNode(root.left, value);//--> O(n/2)
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);//--> O(n/2)
        } else {
            if (root.left != null && root.right != null) {
                BinaryNode temp = root;
                BinaryNode minNodeForRight = minimumNode(temp.right);//--> O(Log n)
                root.value = minNodeForRight.value;
                root.right = deleteNode(root.right, minNodeForRight.value);//--> O(n/2)
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }

        return root;
    }

    public void deleteBST() {
        root = null;
        System.out.println("BST has been deleted successfully");
    }

}