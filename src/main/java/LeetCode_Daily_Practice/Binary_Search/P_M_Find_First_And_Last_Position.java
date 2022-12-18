package LeetCode_Daily_Practice.Binary_Search;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Stack;

public class P_M_Find_First_And_Last_Position {
    /*
     * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
     *
     * Find first and last position of element in Sorted Array
     *
     * Given an array of integers nums sorted in non-decreasing order, find the starting and ending
     * position of given target value.
     *
     * If target is not found in the array return [-1,-1].
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     * Constraints:

    0 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9
    nums is a non-decreasing array.
    -10^9 <= target <= 10^9
     *
     *
     */


    @Test
    public void example1() {
        //Positive Test Data
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
       Assert.assertEquals(searchRange(nums,target), new int[]{3,4});
    }

    @Test
    public void example2() {
        //Edge Case Test Data
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        Assert.assertEquals(searchRange2Pointer(nums,target), new int[]{-1,-1});
    }

    @Test
    public void example3() {
        //Negative Test Data
        int[] nums = {2};
        int target = 2;
        Assert.assertEquals(searchRange(nums,target), new int[]{0,0});
    }

    @Test
    public void example4() {
        //Negative Test Data
        int[] nums = {1,2,3};
        int target = 2;
        Assert.assertEquals(searchRange(nums,target), new int[]{1,1});
    }

    @Test
    public void example5() {
        //Negative Test Data
        int[] nums = {3,3,3};
        int target = 3;
        Assert.assertEquals(searchRange(nums,target), new int[]{0,2});
    }

    @Test
    public void example6() {
        //Negative Test Data
        int[] nums = {1,2,3};
        int target = 1;
        Assert.assertEquals(searchRange(nums,target), new int[]{0,0});
    }

    @Test
    public void example7() {
        //Negative Test Data
        int[] nums = {3,3,3,3,3};
        int target = 3;
        Assert.assertEquals(searchRange(nums,target), new int[]{0,4});
    }
    /*
     * --- Pseudo Code ---
     *
     * Since O(log n) is required, Binary Search algorithm must be implemented.
     *
     * 1. Create variables, left, right and mid and assign values accordingly.
     * 2. Create output array and add values -1,-1 by default (Since it has to be default value)
     * 3. While left is less than or equal to right
     * 		3a. Calculate mid with left+((right-left)/2)
     * 		3b. When nums[mid] is less than target, left=mid+1;
     * 		3c. When nums[mid] is greater than target, right=mid-1;
     * 		3d. Else if nums[mid] == target
     * 			3da. While nums[left] !=target increment it
     * 			3db. While nums[right] !=target decrement it
     * 			3dc. Return left and right as output[0] and output[1]
     * 				3da and 3db are done since there might be instances where target could be available multiple
     * 					times in the given array
     * 4. Edge case: When nums
     *
     *
     */

    public int[] searchRange1(int[] nums, int target) {

        int left=0, right=nums.length-1, mid=0;
        int[] arr = new int[]{-1,-1};
        while(left<=right){
            mid=left+(right-left)/2;//2 ,4
            if(nums[mid]<target) left=mid+1; //3
            else if(nums[mid]>target) right=mid-1; //4
            else{
                while(nums[left]!=target) left++;
                while(nums[right]!=target) right--;

                arr[0]=left;
                arr[1]=right;
                break;
            }
        }
        return arr;
    }

    //recursion
    public int[] searchRange(int[] nums, int target) {
        return searchRange(nums, target, 0, nums.length-1);
    }

    public int[] searchRange(int[] nums, int target, int start, int end){
        int[] output = {-1,-1};
        if(start==end){
            if(nums[start]!=target) return output;
            else return new int[]{start, end};
        }

        int mid=(end+start)/2;
        if(nums[mid]>target)
           return searchRange(nums, target, start, mid);
        else if(nums[mid]<target)
            return searchRange(nums, target, mid+1, end);
        else {
            int[] first = searchRange(nums, target, start, mid);
            int[] second = searchRange(nums, target, mid + 1, end);
            if(first[0] == -1){
                return second;
            }else if(second[0]==-1)
                return first;
            else{
                output[0]=first[0];
                output[1]=second[0];
            }
        }
        return output;
    }

    //stack and arraylist
    public int[] searchRangeStack(int[] nums, int target) {
        ArrayList<Integer> a =new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int std = -2;
        int ret[] = new int[2];
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != target) st.push(nums[i]);
            else a.add(i);
        }
        if(st.size() == nums.length){
            ret[0] = -1;
            ret[1] = -1;
        }
        else{
            ret[0] = a.get(0);
            ret[1] = a.get(a.size()-1);
        }
        return ret;
    }

    public int[] searchRange2Pointer(int[] nums, int target) {
        int[] output = {-1,-1};
        int left=0, right= nums.length-1;
        while(left<=right){
            if(nums[left]==target){
                output[0]=left;
                break;
            }
            left++;
        }

        while(right>=0){
            if(nums[right]==target){
                output[1]=right;
                break;
            }
            right--;
        }
        return output;
    }
}
