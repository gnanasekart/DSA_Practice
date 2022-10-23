package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class assessment_Minimum_Size_Subarray_Sum {
/*
leetcode.com/problems/minimum-size-subarray-sum/

Given an array of positive integers nums and a positive integer target,
return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
of which the sum is greater than or equal to target. If there is no such subarray,
return 0 instead.

Constraints:
1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104

Follow up: If you have figured out the O(n) solution,
try coding another solution of which the time complexity is O(n log(n)).
 */


    @Test
    public void example1(){
        int[] nums={2,3,1,2,4,3};
        int k=7;
        Assert.assertEquals(minSubarray(nums, k), 2);
    }

    @Test
    public void example2(){
        int[] nums={1,4,4};
        int k=1;
        Assert.assertEquals(minSubarray(nums, k), 1);
    }

    @Test
    public void example3(){
        int[] nums={1,1,1,1,1,1,1,1};
        int k=11;
        Assert.assertEquals(minSubarray(nums, k), 0);
    }

    @Test
    public void example4(){
        int[] nums={1,2,3,4,5};
        int k=11;
        Assert.assertEquals(minSubarray(nums, k), 3);
    }

    @Test
    public void example5(){
        int[] nums={5,1,3,5,10,7,4,9,2,8};
        int k=15;
        Assert.assertEquals(minSubarray(nums, k), 3);
    }

/*
0. check for single number occurance
		- if present return count as 1
            - else move to next condition
1. consider sliding window
2. sum the first and second value and match with target
	- if it matchs then capture the array
	- else iterate the pointer
3. return the arrays length
*/
    private int minSubarray(int[] nums, int k){

        int l=0, r=0, distance=0, sum=0;
        while(l<nums.length){
            if(sum<k && r<nums.length)
                sum+=nums[r++];
            else if(sum>=k){
                sum-=nums[l];
                distance=r-l;
                l++;
            }else break;
        }
        return distance;
    }
}
