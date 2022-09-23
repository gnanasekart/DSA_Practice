package Sorting;

import org.testng.annotations.Test;

public class Insertionsort
{
	@Test
	public void example1() {
		int arr[]= {-2, 0, 12, -4, 13, 8, 11};
		insertionSort(arr);
	}

	private void insertionSort(int[] arr) {
		int n = arr.length;

		for(int i=0; i<n; i++){
			int pivot = arr[i];
			int j=i-1;
			
			while(j>=0 && arr[j]>pivot) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=pivot;
		}
		for(int a: arr) {
			System.out.print(a+" ");
		}
	}
}