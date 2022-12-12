package LeetCode_Daily_Practice.Sorting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Insertion_Sort {

    @Test
    public void ex1(){
        int[] arr = {5,2,7,1,8,9};
        Assert.assertEquals(insertionSort(arr), new int[]{1,2,5,7,8,9});
    }

    @Test
    public void ex2(){
        int[] arr = {-3, 7, -1, 5, 0, 3, 6};
        Assert.assertEquals(insertionSort(arr), new int[]{-3,-1,0,3,5,6,7});
    }

    @Test
    public void ex3(){
        int[] arr = {3,6,2,1,-7};//3,2,6
        Assert.assertEquals(insertionSort(arr), new int[]{-7,1,2,3,6});
    }

    private int[] insertionSort(int[] arr) {
        int i=0, j=0, temp=0;
        for (i = 0; i < arr.length-1; i++) {
            if(arr[i]>arr[i+1]){
                temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
            for(j=i+1; j>0; j--){
                if(arr[j]<arr[j-1]){
                    temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
        return arr;
    }
}
