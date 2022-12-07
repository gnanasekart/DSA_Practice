package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

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

    @Test
    public void ex(){
        int[] nums = {4,5,0,-2,-3,1};
        int k=5;
        Assert.assertEquals(subarraysDivByK(nums, k), 7);
    }

    public int subArraySum(int[] nums, int k){
        int sum=0, count=0, reminder=0, mod=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<nums.length;i++){
            sum+=nums[i];
            reminder=sum%k;//4,4,4,2,4,0

            if(reminder<0)
                reminder=reminder+k;

            if(map.containsKey(reminder))
                count+=map.get(reminder);

            map.put(reminder, map.getOrDefault(reminder, 0)+1);
        }
        return count;
    }

    public int subarraysDivByK(int[] nums, int k) {

        int sum = 0;
        int[] arr = new int[k];
        arr[0] = 1;  // Initially sum is zero . So , we are incrementing 0th index value.

        for(int num: nums){
            sum += num;
            if(sum < 0)
                arr[((sum%k + k)%k)]++;     // if sum is negative take it's positive modulo value
            else
                arr[(sum%k)]++;
        }

        int ans = 0;
        for(int x : arr){
            ans += ((x)*(x-1))/2;     // calculating result from prefix moded values
        }
        return ans;
    }
}
