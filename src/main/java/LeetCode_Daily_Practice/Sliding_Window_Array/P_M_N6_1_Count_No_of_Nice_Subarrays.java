package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class P_M_N6_1_Count_No_of_Nice_Subarrays {
    /*
    leetcode.com/problems/count-number-of-nice-subarrays/
Given an array of integers nums and an integer k. A continuous subarray is called nice
if there are k odd numbers on it.
Return the number of nice sub-arrays.

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

Constraints:
1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
     */
    @Test
    public void ex(){
        int[] nums = {1,1,2,1,1};
        int k=3;
        Assert.assertEquals(countnicesubarray(nums, k), 2);
    }

    @Test
    public void ex1(){
        int[] nums = {2,4,6};
        int k=1;
        Assert.assertEquals(countnicesubarray(nums, k), 0);
    }

    @Test
    public void ex2(){
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k=2;
        Assert.assertEquals(countnicesubarray(nums, k), 16);
    }

    public int countnicesubarray(int[] nums, int k) {
        int m=0, count=0;
        for(int i=0; i<nums.length; i++){
                count=0;
            for(int j=i; j<nums.length; j++){
                if(nums[j]%2!=0){
                    count++;
                }
                if(count==k){
                    m++;
                }
            }
        }
        return m;
    }

    public int countnicesubarrayPrefixSum(int[] nums, int k) {
        int count=0, sum=0,j=0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i]%2==1 ? 1 : 0;
        }

       // map.put(0,1);


        while(j< nums.length){
            sum+=nums[j++];
            if(sum==k) count++;
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }


//    public int minSubArrayLen(int[] nums, int target) {
//        int sum=0, min=Integer.MAX_VALUE, arrlen=0;
//        int left=0, right=0;
//
//        while(right<nums.length){
//            sum+=nums[right++];
//            while(sum>=target){
//                sum+=nums[right++];
//            }
//
//            min=right-left+1;
//
//            while(right<nums.length){
//                sum-=nums[left];
//                sum+=nums[right];
//                if(sum>=target){
//                    arrlen=right-left+1;
//                    min=Math.min(min, arrlen);
//                }
//            }
//
//        }
//        return min==Integer.MAX_VALUE ? 0 : min;
//    }


}
