package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class P_O22_3_Min_Diff_Bw_High_Low_K_Scores {
/*
leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/

You are given a 0-indexed integer array nums, where nums[i] represents the score
of the ith student. You are also given an integer k.

Pick the scores of any k students from the array so that the difference between
 the highest and the lowest of the k scores is minimized.
Return the minimum possible difference.
    */

    @Test
    public void example1(){
        int[] arr = {9,4,1,7};
        int k=2;
        Assert.assertEquals(kScoreWS(arr, k), 2);
    }

    @Test
    public void example2(){
        int[] arr = {90};
        int k=1;
        Assert.assertEquals(kScoreWS(arr, k), 0);
    }

    @Test
    public void example3(){
        int[] arr = {8,4,0,1,3,5,7,8};
        int k=3;
        Assert.assertEquals(kScoreWS(arr, k), 4);
    }

    @Test
    public void example4(){
        int[] arr = {87063,61094,44530,21297,95857,93551,9918};
        int k=6;
        Assert.assertEquals(kScoreWS(arr, k), 74560);
    }

/*
1. consider two pointer from left to right
2. check condition for value > 1
3. find the difference between two index and get the min value
4. return min value

3. sort the array and find the difference between two index an get the min value
4. return the min value
*/


    private int kScoreWS(int[] arr, int k){
        if(k<=1) return 0;

        Arrays.sort(arr);
        int min=Integer.MAX_VALUE;

        int p1=k-1;
        while(p1<arr.length) {
            min= Math.min(min, arr[p1] - arr[p1-k+1]);
            p1++;
        }
        return min;
    }

    private int kScoreWS1(int[] arr, int k){
        int i=0, min=Integer.MAX_VALUE;
        while(i<arr.length)
            min=Math.min(min, Math.abs((arr.length-k+1) - arr[i++]));

        return min;
    }
}
