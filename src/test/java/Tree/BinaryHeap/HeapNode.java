package Tree.BinaryHeap;

public class HeapNode {
    int arr[];
    int sizeofArray;

    HeapNode(int size) {
        arr = new int[size + 1];
        this.sizeofArray = 0;
        System.out.println("Created Successfully");
    }

    public boolean isEmpty() {
        if (sizeofArray == 0) return true;
        else return false;
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Empty array");
            return null;
        }
        return arr[1];
    }

    public int sizeOfBP() {
        return sizeofArray;
    }

    public void levelOrder() {
        for (int i = 1; i <= sizeofArray; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

    // Heapify for Insert
    public void heapifyBottomToTop(int index, String heapType) {
        int parent = index / 2;
        if (index <= 1) return;

        if (heapType == "Min") {
            if (arr[index] < arr[parent]) {
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
            }
        } else if (heapType == "Max") {
            if (arr[index] > arr[parent]) {
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
            }
        }
        heapifyBottomToTop(parent, heapType);
    }

    public void insert(int value, String typeHeap) {
        arr[sizeofArray + 1] = value;
        sizeofArray++;
        heapifyBottomToTop(sizeofArray, typeHeap);
        System.out.println("Inserted " + value + " successfully in Heap");
    }

    // heapifyTopToBottom
    public void heapifyTopToBottom(int index, String heapType) {
        int left = index * 2;
        int right = index * 2 + 1;
        int swapChild = 0;
        if (sizeofArray < left) return;

        if (heapType == "Max") {
            if (sizeofArray == left) {
                if (arr[index] < arr[left]) {
                    int tmp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = tmp;
                }
                return;
            } else {
                if (arr[left] > arr[right]) swapChild = left;
                else swapChild = right;

                if (arr[index] < arr[swapChild]) {
                    int tmp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = tmp;
                }
            }
        } else if (heapType == "Min") {
            if (sizeofArray == left) {
                if (arr[index] > arr[left]) {
                    int tmp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = tmp;
                }
                return;
            } else {
                if (arr[left] < arr[right]) swapChild = left;
                else swapChild = right;

                if (arr[index] > arr[swapChild]) {
                    int tmp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = tmp;
                }
            }
        }
        heapifyTopToBottom(swapChild, heapType);
    }

    public int extractHeadOfBP(String heapType) {
        if (isEmpty()) return -1;
        else {
            int extractedValue = arr[1];
            arr[1] = arr[sizeofArray];
            sizeofArray--;
            heapifyTopToBottom(1, heapType);
            return extractedValue;
        }
    }

    // delete
    public void deleteBH() {
        arr = null;
        System.out.println("BH has been successfully deleted");
    }
}
