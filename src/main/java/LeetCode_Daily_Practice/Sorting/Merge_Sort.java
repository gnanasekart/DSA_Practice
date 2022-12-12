package LeetCode_Daily_Practice.Sorting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Merge_Sort {
    @Test
    public void ex1(){
        int[] arr = {5,2,7,1,8,9};
        Assert.assertEquals(mergeSort(arr), new int[]{1,2,5,7,8,9});
    }

    @Test
    public void ex2(){
        int[] arr = {-3, 7, -1, 5, 0, 3, 6};
        Assert.assertEquals(mergeSort(arr), new int[]{-3,-1,0,3,5,6,7});
    }

    @Test
    public void ex3(){
        int[] arr = {3,6,2,1,-7};
        Assert.assertEquals(mergeSort(arr), new int[]{-7,1,2,3,6});
    }

    @Test
    public void ex4(){
        int[] arr = {5,6,3,1,7,2,4};
        Assert.assertEquals(mergeSort(arr), new int[]{1,2,3,4,5,6,7});
    }

    public int[] mergeSort(int[] arr){
        int[] merged = mergeDivid(arr, 0, arr.length-1);
        return merged;
    }

    public int[] mergeDivid(int[] arr, int start, int end) {
        int mid=0;
        if (start == end) {
            int[] n = new int[1];
            n[0] = arr[0];
            return n;
        } else if (start < end) {
            mid = (start + end) / 2;
            mergeDivid(arr, start, mid);
            mergeDivid(arr, mid + 1, end);
        }
        return merge(arr, start, mid, end);
    }

    public int[] merge(int[] input, int start, int mid, int end){
        int temp[] = new int[end-start+1];

        int leftArrayIndex = start, rightArrayIndex = mid+1, tempArrayIndex = 0;

        while( leftArrayIndex <= mid && rightArrayIndex <= end){
            if(input[leftArrayIndex] < input[rightArrayIndex])
                temp[tempArrayIndex++] = input[leftArrayIndex++];
            else
                temp[tempArrayIndex++] = input[rightArrayIndex++];
        }

        while(leftArrayIndex <= mid)
            temp[tempArrayIndex++] = input[leftArrayIndex++];

        while(rightArrayIndex <= end)
            temp[tempArrayIndex++] = input[rightArrayIndex++];


        for(int i =start; i<=end;i++){
            input[i] = temp[i-start];
        }

        return temp;
    }





//    public int[] mergeDivid(int[] arr, int start, int end){
//        if(start==end){
//            int[] n = new int[1];
//            n[0]=arr[0];
//            return n;
//        }
//
//        int mid=(start+end)/2;
//        int[] first = mergeDivid(arr, start, mid);
//        int[] second = mergeDivid(arr, mid+1, end);
//
//        return merged(first, second);
//    }
//
//    private int[] merged(int[] first, int[] second) {
//
//        int[] sorted = new int[first.length+second.length];
//        int i=0, j=0, k=0;
//        for(i=0, j=0; i<first.length && j<second.length; i++, j++, k++){
//            if(first[i]<second[j]){
//                sorted[k]=first[i];
//            }else
//                sorted[k]=second[j];
//        }
//
//        if(i==first.length){
//            while(j<second.length){
//                sorted[k]=second[j];
//            }
//        }
//
//        if(j==second.length){
//            while(i<first.length){
//                sorted[k]=first[i];
//            }
//        }
//
//        return sorted;
//    }
}
