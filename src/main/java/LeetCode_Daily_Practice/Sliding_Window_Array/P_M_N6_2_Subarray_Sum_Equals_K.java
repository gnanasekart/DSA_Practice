package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class P_M_N6_2_Subarray_Sum_Equals_K {
    /*
    https://leetcode.com/problems/subarray-sum-equals-k/
Given an array of integers nums and an integer k, return the total number of subarrays
whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.

Constrains
1 <= nums.length <= 2 * 10^4
-1000 <= nums[i] <= 1000
-10^7 <= k <= 10^7

     */

    @Test
    public void ex1() {
        int[] nums = {1, 1, 1};
        int k = 2;
        Assert.assertEquals(subarraySum(nums, k), 2);
    }

    @Test
    public void ex2() {
        int[] nums = {1, 2, 3};
        int k = 3;
        Assert.assertEquals(subarraySum(nums, k), 2);
    }


    @Test
    public void ex3() {
        int[] nums = {1, 2, 3};
        int k = 0;
        Assert.assertEquals(subarraysum(nums, k), 0);
    }


    @Test
    public void ex4() {
        int[] nums = {-5, -4, -3, -2, -1, 0, 1, 2};
        int k = 2;
        Assert.assertEquals(subarraysum(nums, k), 2);
    }

    @Test
    public void ex5() {
        int[] nums = {1};
        int k = 1;
        Assert.assertEquals(subarraysum(nums, k), 1);
    }

    public int subarraysum1(int[] num, int k) {
        if (num.length < 1) return 0;
        int count = 0, sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum=0;
            for (int j = i; j < num.length; j++) {
                if (i == j) {
                    sum = num[i];
                }
                if (sum == k) {
                    count++;
                }
                sum += num[i];
            }
        }
        return count;
    }


    public int subarraySum(int[] arr, int target){
        int count=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0, key=0, value=0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            key=sum-target;
            if(map.containsKey(key)){
                value=map.get(key);
                count+=value;
            }else{
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }

        return count;
    }


    public int subarraysum(int[] num, int k) {

        Map<Integer, Integer> map = new HashMap();
        int sum = 0, count = 0;

        map.put(0, 1);
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
            int check = sum-k;
            if (map.containsKey(check)) {
                count += map.get(check);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
