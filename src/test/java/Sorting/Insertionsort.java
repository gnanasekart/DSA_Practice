package Sorting;

import org.testng.annotations.Test;

public class Insertionsort {
    //@Test
    public void example1() {
        int arr[] = {-2, 0, 12, -4, 13, 8, 11};
        insertionSort(arr);
    }

	@Test
	public void example2(){
		int arr[] = {2, 5, 7, 9, 1, 3, 4, 6, 8};
		insertionSort(arr);
	}

    private void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        for (int a : arr) System.out.print(a + " ");
    }
}