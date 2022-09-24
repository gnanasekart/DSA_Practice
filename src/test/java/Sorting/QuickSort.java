package Sorting;

import org.testng.annotations.Test;

public class QuickSort {

    @Test
    public void example() {
        int[] arr = {10, 3, 2, 7, 7, 5, 8, 4, 1, 2, 9, 7, 8, 11};
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    static int partition(int[] array, int start, int end) {
        int pivot = end;
        int i = start - 1;
        for (int j = start; j <= end; j++) {//---> O(n)
            if (array[j] <= array[pivot]) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        return i;
    }

    //time - O(nLogn)
    //space - O(n)
    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = partition(array, start, end);//---> O(n)
            quickSort(array, start, pivot - 1);//---> T(n/2)
            quickSort(array, pivot + 1, end);//---> T(n/2)
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) System.out.print(array[i] + "  ");
    }
}
