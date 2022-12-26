package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class P_M_N29_1_Rotate_Array {
/*
https://leetcode.com/problems/rotate-array
Given an array, rotate the array to the right by k steps, where k is non-negative.
Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:k=k%l;
k=l-k
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Constraints:

1 <= nums.length <= 10^5
-231 <= nums[i] <= 2^31 - 1
0 <= k <= 10^5

Follow up:

Try to come up with as many solutions as you can.
There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?

 */
    @Test
    public void ex() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Assert.assertEquals(rotate1(nums, k), new int[]{5,6,7,1,2,3,4});
    }

    @Test
    public void ex12() {
        int[] nums = {-1,-100,3,99};
        int k = 2;
        Assert.assertEquals(rotate1(nums, k), new int[]{3,99,-1,-100});
    }

    @Test
    public void ex11() {
        int[] nums = {1, 2, 3};
        int k = 6;
        Assert.assertEquals(rotate2(nums, k), new int[]{1,2,3});
    }

    //BF
    public int[] rotate1(int[] nums, int k) {
        int n=nums.length, temp=0;
        if(nums.length==0) return nums;
        for(int i=0; i<k; i++){
            int j=k-2;
            temp=nums[k-1];
            while(j>=0){
                nums[--k]=nums[j--];
            }
            nums[0]=temp;
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public void rotate(int[] nums, int k) {
        while(k>0){
            int temp=nums[nums.length-1];
            for(int i=nums.length-1; i>=0; i++) {
                nums[i] = nums[i - 1];
            }
            nums[0]=temp;
            k--;
        }

    }

    public int[] rotate2(int[] nums, int k){
        int n=nums.length, left=0, right=0;
        int[] old = nums.clone();
        k=k%n;
        while(left<n){
            right=(left+k)%n;
            nums[right]=old[left++];
            right++;
        }
        return nums;
    }

    public int[] rotate3(int[] nums, int k){
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);

        return nums;
    }
    public int[] reverse(int[] nums, int i, int l){
        while(i<l){
            int temp = nums[i];
            nums[i++]=nums[l];
            nums[l--]=temp;
        }
        return nums;
    }
}
