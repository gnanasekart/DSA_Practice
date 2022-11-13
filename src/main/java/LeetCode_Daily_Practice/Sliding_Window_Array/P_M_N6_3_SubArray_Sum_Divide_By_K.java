package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_M_N6_3_SubArray_Sum_Divide_By_K {
    /*
    https://leetcode.com/problems/subarray-sums-divisible-by-k/
Given an integer array nums and an integer k, return the number of non-empty subarrays
that have a sum divisible by k.
A subarray is a contiguous part of an array.

Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

Constraints:
1 <= nums.length <= 3 * 10^4
-10^4 <= nums[i] <= 10^4
2 <= k <= 10^4
     */

    @Test
    public void ex(){
        int[] nums = {4,5,0,-2,-3,1};
        int k=5;
        Assert.assertEquals(subArrayDividK(nums, k), 7);
    }

    @Test
    public void ex1(){
        int[] nums = {5};
        int k=9;
        Assert.assertEquals(subArrayDividK(nums, k), 0);
    }

    @Test
    public void ex2(){
        int[] nums = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
        int k=3;
        Assert.assertEquals(subArrayDividK(nums, k), 0);
    }


    public int subArrayDividK(int[] nums, int k) {
        int sum=0, count=0;
        for(int i=0; i<nums.length; i++){
            sum=0;
            for(int j=i; j<nums.length; j++){
                sum+=nums[j];

                if(sum%k==0){
                    System.out.println( sum);
                    count++;
                }
            }
        }
        return count;
    }

}
