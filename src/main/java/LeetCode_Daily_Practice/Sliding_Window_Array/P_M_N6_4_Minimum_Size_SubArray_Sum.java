package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class P_M_N6_4_Minimum_Size_SubArray_Sum {
    /*
   https://leetcode.com/problems/minimum-size-subarray-sum/
Given an array of positive integers nums and a positive integer target,
return the minimal length of a subarray whose sum is greater than or equal to target.
If there is no such subarray, return 0 instead.

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Constraints:
1 <= target <= 10^9
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^4

*/

    @Test
    public void ex(){
        int[] nums = {2,3,1,2,4,3};
        int k=7;
        Assert.assertEquals(minSubArraySum(nums, k), 2);
    }

    @Test
    public void ex1(){
        int[] nums = {1,4,4};
        int k=4;
        Assert.assertEquals(minSubArraySum(nums, k), 1);
    }

    @Test
    public void ex2(){
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k=2;
        Assert.assertEquals(minSubArraySum(nums, k), 16);
    }

    public int minSubArraySum(int[] nums, int target) {
        int sum=0, min=Integer.MAX_VALUE, arrlen=0;
        for(int i=0; i<nums.length; i++){
            sum=0;
            for(int j=i; j<nums.length; j++){
                sum+=nums[j];
                if(sum>=target){
                    arrlen=j-i+1;
                    min=Math.min(min, arrlen);
                    break;
                }
            }
        }
        return min==Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];

            while(sum>=target){
                min = Math.min(min, i-l+1);
                sum = sum-nums[l++];
            }
        }
        return min== Integer.MAX_VALUE?0:min;
    }

    public int minSubArrayLen1(int k, int[] nums) {
        int l=0, r=0, distance=Integer.MAX_VALUE, sum=0;
        while(l<nums.length){
            if(sum<k && r<nums.length)
                sum+=nums[r++];
            else if(sum>=k){
                sum-=nums[l];
                distance= Math.min(distance, r-l);
                l++;
            } else if (distance==Integer.MAX_VALUE) {
                return 0;
            } else break;
        }
        return distance;
    }
}
