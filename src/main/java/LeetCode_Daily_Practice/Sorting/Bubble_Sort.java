package LeetCode_Daily_Practice.Sorting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Bubble_Sort {
    @Test
    public void ex1(){
        int[] arr = {5,2,7,1,8,9};
        Assert.assertEquals(bubbleSort(arr), new int[]{1,2,5,7,8,9});
    }

    @Test
    public void ex2(){
        int[] arr = {-3, 7, -1, 5, 0, 3, 6};
        Assert.assertEquals(bubbleSort(arr), new int[]{-3,-1,0,3,5,6,7});
    }

    private int[] bubbleSort(int[] arr) {

        int i=0, j=0, temp=0;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
}
