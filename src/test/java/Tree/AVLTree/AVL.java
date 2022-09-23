package Tree.AVLTree;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {

    @Test
    public void example() {
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(10);
        avl.insert(15);
        avl.insert(20);
        avl.levelOrder();
        ;
    }

    AVLBinaryNode root;

    AVL() {
        root = null;
    }

    //preorder
    public void preOrder(AVLBinaryNode node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //Inorder
    public void inOrder(AVLBinaryNode node) {
        if (node == null) return;
        preOrder(node.left);
        System.out.print(node.value + " ");
        preOrder(node.right);
    }

    //postorder
    public void postOrder(AVLBinaryNode node) {
        if (node == null) return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.value + " ");
    }

    //levelOrder
    public void levelOrder() {
        Queue<AVLBinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            AVLBinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
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

    public int getHeight(AVLBinaryNode node) {
        if (node == null) return 0;
        return node.height;
    }

    //rotate right
    private AVLBinaryNode rotateRight(AVLBinaryNode disBalancedNode) {
        AVLBinaryNode newRoot = disBalancedNode.left;
        disBalancedNode.left = disBalancedNode.left.right;
        newRoot.right = disBalancedNode;
        disBalancedNode.height = 1 + Math.max(getHeight(disBalancedNode.left), getHeight(disBalancedNode.left));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    //rotate left
    private AVLBinaryNode rotateLeft(AVLBinaryNode disBalancedNode) {
        AVLBinaryNode newRoot = disBalancedNode.right;
        disBalancedNode.right = disBalancedNode.right.left;
        newRoot.left = disBalancedNode;
        disBalancedNode.height = 1 + Math.max(getHeight(disBalancedNode.left), getHeight(disBalancedNode.left));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    //getBalance
    public int getBalance(AVLBinaryNode node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    //insertNode
    //time comp = O(log n)
    //space comp = O(log n) here we're using stack because of recursive call methods
    private AVLBinaryNode insert(AVLBinaryNode node, int newValue) {
        if (node == null) {
            AVLBinaryNode newNode = new AVLBinaryNode();
            newNode.value = newValue;
            newNode.height = 1;
            return newNode;
        } else if (newValue < node.value) node.left = insert(node.left, newValue); //---> O(log n)
        else node.right = insert(node.right, newValue); //---> O(log n)

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);

        if (balance > 1 && newValue < node.left.value) return rotateRight(node);

        if (balance > 1 && newValue > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && newValue > node.right.value) return rotateLeft(node);

        if (balance < -1 && newValue < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    // Minimum node
    public static AVLBinaryNode minimumNode(AVLBinaryNode root) {
        if (root.left == null) return root;
        else return minimumNode(root.left);
    }

    // Delete node
    public AVLBinaryNode deleteNode(AVLBinaryNode node, int value) {
        if (node == null) {
            System.out.println("Value not found in AVL");
            return node;
        }
        if (value < node.value) node.left = deleteNode(node.left, value);
        else if (value > node.value) node.right = deleteNode(node.right, value);
        else {
            if (node.left != null && node.right != null) {
                AVLBinaryNode temp = node;
                AVLBinaryNode minNodeForRight = minimumNode(temp.right);
                node.value = minNodeForRight.value;
                node.right = deleteNode(node.right, minNodeForRight.value);
            } else if (node.left != null) node = node.left;
            else if (node.right != null) node = node.right;
            else node = null;

        }
        // Case 2 - rotation required

        // System.out.println("1");
        // System.out.println(previous.value);

        // node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) return rotateRight(node);
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0) return rotateLeft(node);

        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void delete(int value) {
        root = deleteNode(root, value);
    }

    public void deleteAVL() {
        root = null;
    }
}
