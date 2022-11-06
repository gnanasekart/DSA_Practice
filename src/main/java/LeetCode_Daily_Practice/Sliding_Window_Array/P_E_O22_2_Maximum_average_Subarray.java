package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;
/*
https://leetcode.com/problems/maximum-average-subarray-i/
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value
and return this value. Any answer with a calculation error less than 10^-5 will be accepted.

Constraints:
n == nums.length
1 <= k <= n <= 10^5
-10^4 <= nums[i] <= 10^4
 */
public class P_E_O22_2_Maximum_average_Subarray {
    @Test
    public void example1() {
        int[] arr = {1, 5, 2, 3, 7, 1};
        int k = 3;
        Assert.assertEquals(sumvalue1(arr, k), 12);
    }

    @Test
    public void example2() {
        int[] arr = {1,2,3,4};
        int k = 2;
        Assert.assertEquals(sumvalue(arr, k), 7);
    }

    @Test
    public void example3() {
        int[] arr = {1,12,-5,-6,50,3};
        int k = 4;
        Assert.assertEquals(sumvalue1(arr, k), 12.75000);
    }

    @Test
    public void example4() {
        int[] arr = {-3,-1,0,2,3,4};
        int k = 3;
        Assert.assertEquals(sumvalue1(arr, k), 9);
    }

    @Test
    public void example5() {
        int[] arr = {7,4,5,8,8,3,9,8,7,6};
        int k = 7;
        Assert.assertEquals(sumvalueBF(arr, k), 7.00000);
    }
    /*
    1. Start with two pointer array
    2. start from i to i+3 and get the sum value
    3. store the sum into max value
    4. subtract the last value i-1 subsequence
        then return max value
    */
    private int sumvalue(int[] arr, int k) {
        int left = 0, right = 0;
        int sum = 0, max = 0;
        while (left < arr.length) {
            if (left <= k) {
                sum = 0;
                while (left < k + right)
                    sum += arr[left++];
            }else
                left++;

            right++;
            left = right;
            max = Math.max(max, sum);
            }
        return max;
    }

    private double sumvalue1(int[] arr, int k) {
        double max=Double.MAX_VALUE, newmax=0.0;
        int i=0;
        while(i<k){
            newmax+=arr[i++];
        }
        i=k;
        max = newmax/k;
        while(i<arr.length){
//            newmax=newmax-arr[i-k];//8-1=7
//            newmax=newmax+arr[i++];//7+3=10

            newmax= ((newmax-arr[i-k]) + arr[i++]);
            max = Math.max(max, newmax/k);
        }
        return max;
    }

    private double sumvalueBF(int[] arr, int k) {
        double max=Double.MAX_VALUE, newmax=0.0;

        for (int i = 0; i < k; i++) {
            newmax+=arr[i];
        }
        max=newmax;
        int p=k;
        for (int i = p; i < arr.length; i++) {
            newmax=newmax-arr[i-k]+arr[i];
            max=newmax>max? max:newmax;
        }
        return newmax/k;
    }
}
