package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class P_E_LC_23_Largest_num_atleast_Twise_Of_Other {
/*
leetcode.com/problems/largest-number-at-least-twice-of-others/

You are given an integer array nums where the largest integer is unique.

Determine whether the largest element in the array is at least twice as
much as every other number in the array. If it is, return the index of the largest element,
 or return -1 otherwise.

Example 1:
Input: nums = [3,6,1,0]
Output: 1
Explanation: 6 is the largest integer.
For every other number in the array x, 6 is at least twice as big as x.
The index of value 6 is 1, so we return 1.
 */

    @Test
    public void example1(){
        int[] nums = {3,6,1,0};
        Assert.assertEquals(twiceNumber(nums), 1);
    }

    @Test
    public void example2(){
        int[] nums = {3,6};
        Assert.assertEquals(twiceNumber(nums), 1);
    }

    @Test
    public void example3(){
        int[] nums = {3};
        Assert.assertEquals(twiceNumber(nums), 0);
    }

    @Test
    public void example4(){
        int[] nums = {};
        Assert.assertEquals(twiceNumber(nums),-1);
    }

    @Test
    public void example5(){
        int[] nums = {1,2,3,4,5,6,6,7,8,9};
        Assert.assertEquals(twiceNumber(nums), -1);
    }

    @Test
    public void example6(){
        int[] nums = {1,2,3,4};
        Assert.assertEquals(twiceNumber(nums),-1);
    }

    @Test
    public void example7(){
        int[] nums = {0,2,0,1};
        Assert.assertEquals(twiceNumber(nums),1);
    }

    @Test
    public void example8(){
        int[] nums = {0,0,2,1};
        Assert.assertEquals(twiceNumber1(nums),1);
    }

/*
logic
0. if value is less than 2 then return array index

1. traversal each element to find the max value and its index value by math max method
2. check the condition in iteration for every value in array
	- if => largest number is >= 2*x value then
		return index value
	- else => largest number is < 2*x value then
		return -1

*/

    //my solution
    private int twiceNumber1(int[] nums) {
        if (nums.length == 0) return -1;
        int[] arr = nums.clone();
        int iValue = 0, i = 0, j = 1;
        //find max index value
        while (j < nums.length) {
            if (nums[i] < nums[j]) {
                iValue = Math.max(iValue, j);
                i++;
            }
            j++;
        }
        //find the largest value by sorting
        for (int a = 0; i < arr.length; i++) {
            for (int b = 0; b < nums.length; b++) {
                if (arr[a] < arr[b]) {
                    arr[a] = arr[a] + arr[b];
                    arr[b] = arr[a] - arr[b];
                    arr[a] = arr[a] - arr[b];
                }
            }
        }
        int largestValue = arr[0];

        for (int k = 0; k < nums.length; k++)
            if ((iValue!=k)&&((2 * nums[k])>largestValue)) return -1;

        return iValue;
    }

    //better brute force solution
    private int twiceNumber(int[] nums) {
        if (nums.length == 0) return -1;
        int iValue=-1, largestValue=0;
        for(int i=0; i<nums.length; i++){
            if(largestValue<nums[i]){
                largestValue=nums[i];
                iValue=i;
            }
        }

        for (int k = 0; k < nums.length; k++)
            if ((iValue!=k)&&((2 * nums[k])>largestValue)) return -1;

        return iValue;
    }
}

