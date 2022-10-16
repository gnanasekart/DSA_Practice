package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_LC_23_Largest_num_atleast_Twise_Of_Other {
/*
https://leetcode.com/problems/sort-even-and-odd-indices-independently/

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
        int[] arr = {3,6,1,0};
        Assert.assertEquals(largestnumberTwise(arr), 1);
    }

    @Test
    public void example2(){
        int[] arr = {1,2,3,4};
        Assert.assertEquals(largestnumberTwise(arr), -1);
    }

    @Test
    public void example4(){
        int[] arr = {4,1,2,3};
        Assert.assertEquals(largestnumberTwise(arr), new int[]{2,3,4,1});
    }

    @Test
    public void example5(){
        int[] arr = {6,1,4,3,2,5};
        Assert.assertEquals(largestnumberTwise(arr), new int[]{2,5,4,3,6,1});
    }

    @Test
    public void example3(){
        int[] arr = {};
        Assert.assertEquals(largestnumberTwise(arr), -1);
    }

    /*
    logic

     */

    private int largestnumberTwise(int[] arr) {

        return 1;
    }
    }

