package Data_Structure_sorting;
public class Bubblesort
{

	public static void sort(int arr[])
	{
		int n = arr.length;
		for( int i = 0; i < n-1; i++)
		{
			for (int j = 0; j < n-i-1; j++)
			{if(arr[j]>arr[j+1])
			{
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1]=temp;
			}
			}
		}
	}

	public static void printsort(int arr[])
	{
		for (int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	/*
public void st(int arr[])
{
int n = arr.length;
for( int i = 0; i < n-1; i++)
{
for (int j = 0; j < n-i-1; j++)
{
int temp = arr[j];
arr[j] = arr[j+1];
arr[j+1]=temp;
}
}
}

public void ps(int arr[])
{
for (int i=0; i<arr.length; i++)
{
System.out.print(arr[i]+" ");
}
System.out.println();
}
	 */
	public static void main(String[] args)
	{
		Bubblesort bs = new Bubblesort();
		int arr[] = {4, 5, 1, 3, 2};
		Bubblesort.sort(arr);
		Bubblesort.printsort(arr);

		//bs.st(arr);
		//bs.ps(arr);


	}
}