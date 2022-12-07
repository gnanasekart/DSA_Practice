package LeetCode_Daily_Practice.Sliding_Window_Grow_Shrink;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_O23_3_Minimum_Size_Subarray_Sum {
/*
leetcode.com/problems/minimum-size-subarray-sum/

Given an array of positive integers nums and a positive integer target,
return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
of which the sum is greater than or equal to target. If there is no such subarray,
return 0 instead.

Constraints:
1 <= target <= 10^9
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^4

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
        Assert.assertEquals(minSubarray(nums, k), 2);
    }

/*
logic
1. consider the two pointer grow and shrink method
2. two pointer points at same place
3. if sum < k value then one pointer move right direction and sum every index value
4. if sum >=k then left pointer decrement its value with sum
    - calculate the index different as min value
5. Again if the sum < k value then sum with right value until condition breaks
6. if min value is still in default value then return o
*/

    private int minSubarray(int[] nums, int k){

        int l=0, r=0, distance=Integer.MAX_VALUE, sum=0;

        while(l<nums.length){
            if(sum<k && r<nums.length) sum+=nums[r++];
            else if(sum>=k){
                sum-=nums[l];
                distance= Math.min(distance, r-l);
                l++;
            } else if (distance==Integer.MAX_VALUE) return 0;
             else break;
        }
        return distance;
    }
}
