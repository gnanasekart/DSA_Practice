package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class P_E_LC_24_Contains_Duplicate {
/*
leetcode.com/problems/contains-duplicate/

Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.
Example 1:
Input: nums = [1,2,3,1]
Output: true
 */

    @Test
    public void example1(){
        int[] nums = {1,2,3,1};
        Assert.assertEquals(twiceNumber(nums), true);
    }

    @Test
    public void example2(){
        int[] nums = {1,2,3,4};
        Assert.assertEquals(twiceNumber(nums), false);
    }

    @Test
    public void example3(){
        int[] nums = {3};
        Assert.assertEquals(twiceNumber(nums), false);
    }

    @Test
    public void example4(){
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        Assert.assertEquals(twiceNumber(nums),true);
    }

    @Test
    public void example5(){
        int[] nums = {};
        Assert.assertEquals(twiceNumber(nums), false);
    }

    @Test
    public void example6(){
        int[] nums = {-2,-1,-1,-2};
        Assert.assertEquals(twiceNumber(nums),true);
    }

    @Test
    public void example7(){
        int[] nums = {1,0,0,2};
        Assert.assertEquals(twiceNumber(nums),true);
    }

/*
logic
1. Assume a default boolean value is false
2. traversal loop to check two values are equal

3. otherwise traversal single loop with while loop
4. increase the count and check the condition as two values matches
    if matches return true and break the loop so we found
4. return true if count more than 1
5. else return flase count is 1

*/

    private boolean twiceNumber(int[] nums){
        boolean isTwice=false;
        int k=0;
        while(k<nums.length){
            for(int i=k+1; i<nums.length; i++)
                if(nums[k]==nums[i]) {
                    isTwice=true;
                    break;
                }
            k++;
        }
        return isTwice;
    }
}

