package LeetCode_Daily_Practice.Binary_Search;

import org.testng.annotations.Test;

public class P_M_Find_Single_Element_In_Sorted_Array {
    /*
     * PROBLEM STATEMENT
     *
     * Leetcode - 540
     *
     * You are given a sorted array consisting of only integers where
     * every element appears exactly twice, except for one element which
     * appears exactly once.
     *
     * Return the single element that appears only once.
     *
     * Your solution must run in (log n) runtime complexity.
     *
     */

    @Test
    public void example1() {
        //Positive Test Data
        int[] nums = {1,1,2,3,3,4,4,8,8};
        int expected = 2;
        singleElement(nums);
    }

    @Test
    public void example2() {
        //Edge Case Test Data
        int[] nums = {3,3,7,7,10,11,11};
        int expected = 10;
        System.out.println(singleElement(nums));
    }

    @Test
    public void example4() {
        //Edge Case Test Data
        int[] nums = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,11,11,12,12,13,13,14,14,15,15,16,16,17,17,18,18,19,19,20,20,21,21,22,22,23,23,24,25,25};
        int expected = 1;
        singleElement(nums);
    }


    private int singleElement1(int[] nums) {
        int left=0, right=nums.length-1, mid=0;
        boolean b1 = false, b2 = false;

        while(left<=right){
            mid=(right+left)/2;
            if(mid%2==0 && mid!=nums.length-1){
                b1= nums[mid]==nums[mid+1];
                b2 = nums[mid]==nums[mid-1];
            }else if(mid%2==1 && mid!=nums.length-1){
                b1= nums[mid]==nums[mid-1];
                b2 = nums[mid]==nums[mid+1];
            }

            if(b1) left=mid+1;
            else if(b2) right=mid-1;
            else return nums[mid];
        }
        return -1;
    }
    private int singleElement(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int m = (l + h) / 2;
            if (nums[m] == nums[m ^ 1]) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return nums[h];
    }

    public int singleNonDuplicate(int[] nums) {

        int left=0, right=nums.length-1, mid=0;

        while(left<right){
            mid=left+(right-left)/2;
            if(mid-1>=0 && nums[mid]==nums[mid-1]){
                if(mid%2==1){
                    left=mid+1;
                }else right = mid-1;
            }
            else if(mid+1<nums.length && nums[mid]==nums[mid+1]){
                if(mid%2==1){
                    right=mid-1;
                }else left=mid+1;
            }else return nums[mid];
        }
        return nums[right];
    }

}
