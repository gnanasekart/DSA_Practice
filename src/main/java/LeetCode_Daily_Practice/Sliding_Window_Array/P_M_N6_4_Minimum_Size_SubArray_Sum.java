package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

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
        Assert.assertEquals(minSubArrayLen(nums, k), 2);
    }

    @Test
    public void ex1(){
        int[] nums = {2,4,6};
        int k=1;
        Assert.assertEquals(minSubArrayLen(nums, k), 0);
    }

    @Test
    public void ex2(){
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k=2;
        Assert.assertEquals(minSubArrayLen(nums, k), 16);
    }

    public int minSubArrayLen(int[] nums, int target) {
        int sum=0, min=Integer.MAX_VALUE, arrlen=0;
        for(int i=0; i<nums.length; i++){
            sum=0;
            for(int j=i; j<nums.length; j++){

                sum+=nums[j];
                if(sum>=target){
                    arrlen=j-i+1;
                    min=Math.min(min, arrlen);
                    System.out.println(min);
                    break;
                }
            }
        }
        return min==Integer.MAX_VALUE ? 0 : min;
    }
}