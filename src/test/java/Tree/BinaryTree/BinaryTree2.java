package Tree.BinaryTree;

public class BinaryTree2 {
    String[] arr;
    int lastUsedIndex;

    public BinaryTree2(int size) {
        arr = new String[size + 1];
        this.lastUsedIndex = 0;
        System.out.println("Blank Tree of size " + size + " has been created");
    }

    boolean isFull() {
        if (lastUsedIndex == arr.length - 1) return true;
        else return false;
    }

    //insert
    void insert(String value) {
        if (!isFull()) {
            arr[lastUsedIndex + 1] = value;
            System.out.println("Array inserted");
            lastUsedIndex++;
        } else System.out.println("Array Full");
    }

    //time comp O(n)
    //space comp O(n)
    //preOrder traversal
    void preorder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        System.out.print(arr[index] + " ");
        preorder(index * 2);//---> n/2
        preorder(index * 2 + 1);//--->n/2
    }

    //time comp O(n)
    //space comp O(n)
    //inOrder traversal
    void inOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        inOrder(index * 2);//---> n/2
        System.out.print(arr[index] + " ");
        inOrder(index * 2 + 1);//--->n/2
    }

    //time comp O(n)
    //space comp O(n)
    //postOrder traversal
    void postOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        postOrder(index * 2);//---> n/2
        postOrder(index * 2 + 1);//--->n/2
        System.out.print(arr[index] + " ");
    }

    void levelOrdertraversal(){
        for (int i = 1; i <= lastUsedIndex; i++) {//---> O(n)
            System.out.print(arr[i]+" ");
        }
    }

    //time comp O(n)
    //space comp O(1)
    // Search method
    public int search(String value) {
        for (int i = 1; i<=lastUsedIndex; i++) {
            if (arr[i] == value) {
                System.out.println(value+" exists at the location: " + i);
                return i;
            }
        }
        System.out.println("The value does not exist in BT");
        return -1;
    }

    //time comp O(n)
    //space comp O(1)
    // Delete Method
    public void delete(String value) {
        int location = search(value);
        if (location == -1) {
            return;
        } else {
            arr[location] = arr[lastUsedIndex];
            lastUsedIndex--;
            System.out.println("The node successfully deleted");
        }
    }

    // Delete BT

    public void deleteBT() {
        try {
            arr = null;
            System.out.println("The BT has been successfully deleted");

        } catch (Exception e){
            System.out.println("There was an error deleting the tree");
        }
    }


}
