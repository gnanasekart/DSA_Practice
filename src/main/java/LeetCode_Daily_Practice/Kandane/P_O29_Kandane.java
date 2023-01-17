package LeetCode_Daily_Practice.Kandane;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_O29_Kandane {

    /*
    Kadane Algorithm;
	1. algorithm to solve maximum sum subarray
	2. Complexity
		a. Time Complexity- O[N]
		b. Space Complexity- O[1]
	3. condition - If the sum is less than or zero, reset window sum as 0

    Kandane Algorithm - conditions
	1.Initializing maximum as 0 and currentMaximum as 0
	2.Loop 0 to end of the length
	3.If currentMaximum length is less than zero, reset currentMaximum as 0
	4.If currentMaximum is greater than or equal to zero, add the current index value to currentMaximum
	5.Assign maximum with max of maximum and currentMaximum


	https://leetcode.com/problems/maximum-subarray/description/
	Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Constraints:

1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4


Follow up: If you have figured out the O(n) solution, try coding another solution using
the divide and conquer approach, which is more subtle.
     */

    @Test
    public void example1(){
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        Assert.assertEquals(KandeneAlgo1(arr), 6);
    }

    @Test
    public void example2(){
        int[] arr = {-2,-1};
        Assert.assertEquals(KandeneAlgo1(arr), -1);
    }

    @Test
    public void example3(){
        int[] arr = {-1};
        Assert.assertEquals(KandeneAlgo1(arr), -1);
    }

    @Test
    public void example4(){
        int[] arr = {0};
        Assert.assertEquals(KandeneAlgo1(arr), 0);
    }

    @Test
    public void example5(){
        int[] arr = {1};
        Assert.assertEquals(KandeneAlgo1(arr), 1);
    }

    @Test
    public void example6(){
        int[] arr = {5,4,-1,7,8};
        Assert.assertEquals(KandeneAlgo1(arr), 23);
    }

    private int KandeneAlgo(int[] arr) {
        int sum=0, max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];

            if(sum<0) sum=0;

            if(sum>0)
                max=sum>max?sum:max;
        }
        return max==Integer.MIN_VALUE?arr[0]:max;
    }

    private int KandeneAlgo1(int[] arr) {
        int max=Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
           arr[i]=Math.max(arr[i], arr[i]+arr[i-1]);
           max=Math.max(arr[i], max);
        }
        return max;
    }

    public int maxSubArray1(int[] nums) {
        // if(nums.length<=1) return nums[0];
        int sum=0, start=0, maxSum=0;

        for(int end=0; end<nums.length; end++){
            sum+=nums[end];

            if(sum>maxSum) maxSum=sum;

            while(sum<0) sum=sum-nums[start++];
        }
        return maxSum;
    }

    public int maxSubArray(int[] nums) {

        int l=0, r=0, sum=0, maxsum=nums[0];
        while (l<=r && r<nums.length){
            int left=nums[l], right=nums[r];
            if(right>sum+right){
                l=r;
                sum=right;
            }else {
                sum+=right;
            }
            if(maxsum<sum){
                maxsum=sum;
            }
            r++;
        }
        return maxsum;
    }
}
