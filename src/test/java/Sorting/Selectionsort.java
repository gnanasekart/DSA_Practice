package Sorting;

import org.testng.annotations.Test;

public class Selectionsort
{
	/*
	 * Find the lowest and swap
		Run time comp - O(n^2)

	 * Steps
		1. take the pivot
		2. Find the lowest on the right side array
		3. Swap with the lowest
		4. Continue step 2 and 3 for next pivot
	 */
	//@Test
	public void example1() {
		int arr[]= {-2, 0, 12, -4, 13, 8, 11};
		selectionSort(arr);
	}

	@Test
	public void example3(){
		int arr[]= {5,7,4,3,8,6,1,9,2};
		selectionSort(arr);
	}
	
	//@Test
	public void example2() {
		int arr[]= {4, 5, -6, 2, 1, -18};
		selectionSort(arr);
	}

	//time comp - O(n^2)
	//Space comp - O(1)
	private void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i=0; i<n; i++){
			int mini = i;
			for (int j=i+1; j<n; j++){
				if(arr[mini] > arr[j]) {
					mini = j;
				}
			}
			int temp = arr[mini]; 
			arr[mini] = arr[i];
			arr[i] = temp; 
			System.out.print(arr[i]+" ");
		}
	}
}