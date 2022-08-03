package Data_Structure_sorting;
public class Selectionsort
{
// index =  0  1  2  3  4

// array =  4  3  5  2  1

public static void sort(int[] arr)
{
int n = arr.length;
for (int i=0; i<n-1; i++)
{
int mini = i;
for (int j=i+1; j < n; j++)
{
if(arr[j] < arr[mini])   //arr[1] < arr[0] = 3 < 4
{
mini = j; //j=1
int temp = arr[mini]; //temp = arr[1] = temp = 3
arr[mini] = arr[i]; // arr[1] = 4
arr[i] = temp; // arr[0] = 3
}//  3 4 5 2 1 
}}}

public static void printing(int[] arr)
{
for (int i=0; i<arr.length; i++)
{
System.out.print(arr[i]+" ");
}
System.out.println();
}

public static void main(String[] args)
{
int[] arr = {4, 3, 5, 2, 1};
Selectionsort.printing(arr);
Selectionsort.sort(arr);
Selectionsort.printing(arr);
}
}