package Sorting;

import Tree.BinaryHeap.HeapNode;
import org.testng.annotations.Test;

public class HeapSort {

    @Test
    public void example1() {
        int[] arr = {2, 7, 3, 1, 4, 8, 9};
        sort(arr);
        printArray(arr);
    }

    //time - O(nlogn)
    //space - O(1)
    private void sort(int[] arr) {
        BinaryHeap bt = new BinaryHeap(arr.length);
        for (int i = 0; i < arr.length; i++) //--> O(n)
            bt.insertInHeap(arr[i]);//--> O(logn)
        for (int i = 0; i < arr.length; i++)//--> O(n)
            arr[i] = bt.extractHeadOfHeap();//--> O(logn)
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + "  ");
    }
}
