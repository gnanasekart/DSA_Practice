package Data_Structure_sorting;
public class Insertionsort
{
public static void sort(int[] arr)
{
int n = arr.length;

for (int i = 1; i < n; i++)
{
for (int j = i; j > 0; j--)
{
 if (arr[j] > arr[j-1])
{
 int temp = arr[j];
 arr[j] = arr[j-1];
 arr[j-1] = temp;
}}}}

public static void printing(int[] arr)
{
for(int i=0; i < arr.length; i++)
{
System.out.print(arr[i]+" ");
}
}

public static void main(String[] args)
{
int arr[] = {6, 2, 1, 5, 4};
Insertionsort.sort(arr);
Insertionsort.printing(arr);
}
}