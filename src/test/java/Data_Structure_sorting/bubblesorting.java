package Data_Structure_sorting;
/* worst in time complex, here there are two for loop to calculate and required full iteration for entire sorting
*/
public class bubblesorting
{
public static void main(String[] args)
{
int[] arr = {20, 35, -15, 7, 55, 1, -22};

//lastUnsortedIndex = lui
for(int lui = arr.length - 1; lui > 0; lui--)
{
for (int i = 0; i < lui; i++)
{
if(arr[i] > arr[i+1])
{
swap(arr, i, i+1);
}
}
}
for(int i=0; i<arr.length;i++)
{	
System.out.println(arr[i]);
}
}

public static void swap(int[] arr, int i, int j)
{
if(i==j)
{
return;
}
int temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
}
}