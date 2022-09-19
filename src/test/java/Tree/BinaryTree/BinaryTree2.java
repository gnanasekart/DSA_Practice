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

    void insert(String value) {
        if (!isFull()) {
            arr[lastUsedIndex + 1] = value;
            System.out.println("Array inserted");
            lastUsedIndex++;
        } else System.out.println("Array Full");
    }
}
