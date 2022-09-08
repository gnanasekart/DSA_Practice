package Data_Structure_sorting;

import org.testng.annotations.Test;

public class Mergesort
{
	@Test
	public void example1() {
		int arr[]= {-2, 0, 12, -4, 13, 8, 11};
		merge(arr);
	}
	
	int[] arr;
	int[] temparr;

	public void merge(int[] arr)
	{
		this.arr = arr;
		this.temparr = new int[arr.length];
		doMerge(0, arr.length-1);
	}

	public void doMerge(int low, int high)
	{
		if(low < high)
		{
			int middle = low + (high - low)/2;
			doMerge(low, middle);
			doMerge(middle+1, high);
			merge(low, middle, high);
		}
	}

	//   0  1  2  3

	//   4  1  7  3

	public void merge(int low, int middle, int high)
	{
		for (int a = low; a<= high; a++)
		{
			temparr[a] = arr[a];
			int i = low;
			int j = middle + 1;
			int k = low;
			while(i <= middle && j <= high)
			{
				if(temparr[i] <= temparr[j])
				{
					arr[k] = temparr[i];
					i++;
				}else{
					arr[k] = temparr[j];
					j++;
				}
				k++;
			}
			while (i <= middle)
			{
				arr[k] = temparr[i];
				k++;
				i++;										   
			}
		}
	}
}