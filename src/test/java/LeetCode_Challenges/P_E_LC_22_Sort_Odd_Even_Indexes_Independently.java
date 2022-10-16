package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class P_E_LC_22_Sort_Odd_Even_Indexes_Independently {
/*
https://leetcode.com/problems/sort-even-and-odd-indices-independently/

You are given a 0-indexed integer array nums.
Rearrange the values of nums according to the following rules:

Sort the values at odd indices of nums in non-increasing order.
For example, if nums = [4,1,2,3] before this step, it becomes [4,3,2,1] after.
The values at odd indices 1 and 3 are sorted in non-increasing order.
Sort the values at even indices of nums in non-decreasing order.
For example, if nums = [4,1,2,3] before this step, it becomes [2,1,4,3] after.
The values at even indices 0 and 2 are sorted in non-decreasing order.
Return the array formed after rearranging the values of nums.

Input: nums = [4,1,2,3]
Output: [2,3,4,1]
Explanation:
First, we sort the values present at odd indices (1 and 3) in non-increasing order.
So, nums changes from [4,1,2,3] to [4,3,2,1].
Next, we sort the values present at even indices (0 and 2) in non-decreasing order.
So, nums changes from [4,1,2,3] to [2,3,4,1].
Thus, the array formed after rearranging the values is [2,3,4,1].
 */

    @Test
    public void example1(){
        int[] arr = {4,1,2,3};
        Assert.assertEquals(sortindexes(arr), new int[]{2,3,4,1});
    }

    @Test
    public void example2(){
        int[] arr = {2,1};
        Assert.assertEquals(sortindexes(arr), new int[]{2,1});
    }

    @Test
    public void example5(){
        int[] arr = {6,1,4,3,2,5};
        Assert.assertEquals(sortindexes(arr), new int[]{2,5,4,3,6,1});
    }

    @Test
    public void example3(){
        int[] arr = {};
        Assert.assertEquals(sortindexes(arr), new int[]{});
    }

    @Test
    public void example6(){
        int[] arr = {36,45,32,31,15,41,9,46,36,6,15,16,33,26,27,31,44,34};
        Assert.assertEquals(sortindexes(arr), new int[]{9,46,15,45,15,41,27,34,32,31,33,31,36,26,36,16,44,6});
    }

    /*
    logic
    for odd index sort array, similar for even by changing the index from odd to even
    1. Create a temp array with length
    2. get the odd position values in new array
    3. sort the new array values
    4. place the sorted array into existing array at odd position
    5. fill the array with zero to add even value in new temp array
    6. return odd sorted array
     */

    private int[] sortindexes(int[] arr) {
    try {
        if (arr.length == 2) return arr;
        int l = arr.length;
        int[] a = new int[l];

        //odd value sort
        for (int i = 1, j = 0; i < l; j++) {
            a[j] = arr[i];
            i = i + 2;
        }
        Arrays.sort(a);

        //insert in odd position
        for (int i = 1, j = a.length - 1; i < l; j--) {
            arr[i] = a[j];
            i = i + 2;
        }
        Arrays.fill(a,0);

        //even value sort
        for (int i = 0, j = 0; i < l; j++) {
            a[j] = arr[i];
            i = i + 2;
        }
        Arrays.sort(a);

        //insert in even position
        for (int i = 0, j = l/2; i < l; j++) {
            arr[i] = a[j];
            i = i + 2;
        }
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
        return arr;
    }
}

