package LeetCode_Daily_Practice.Sorting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Selection_Sort {

    @Test
    public void ex1(){
        int[] arr = {5,2,7,1,8,9};
        Assert.assertEquals(selectionSort(arr), new int[]{1,2,5,7,8,9});

    }

    private int[] selectionSort(int[] arr) {
        int pivot=0, temp=0, i=0, j=0;
        for (i = 0; i < arr.length; i++) {
            pivot=i;
            for (j = i+1; j < arr.length; j++) {
                if(arr[pivot]>arr[j]){
                    pivot=j;
                }
            }
            if(pivot!=i){
                temp = arr[pivot];
                arr[pivot]=arr[i];
                arr[i]=temp;
            }
        }
        return arr;
    }
}
