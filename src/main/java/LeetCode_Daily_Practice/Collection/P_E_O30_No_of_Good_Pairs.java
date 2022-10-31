package LeetCode_Daily_Practice.Collection;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_E_O30_No_of_Good_Pairs {

    /*
leetcode.com/problems/number-of-good-pairs/

Given an array of integers nums, return the number of good pairs.
A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Example 1:
Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

Constraints:
1 <= nums.length <= 100
1 <= nums[i] <= 100
*/

    @Test
    public void example1() {
        int[] num={1,2,3,1,1,3};
        Assert.assertEquals(goodPairs(num), 4);
    }

    @Test
    public void example2() {
        int[] num={1,1,1,1};
        Assert.assertEquals(goodPairs(num), 6);
    }

    @Test
    public void example3() {
        int[] num={1,2,3};
        Assert.assertEquals(goodPairs(num), 0);
    }

    @Test
    public void example4() {
        int[] num={1,2,3,1,2,3};
        Assert.assertEquals(goodPairs(num), 3);
    }

    @Test
    public void example5() {
        int[] num={5,4,5,4,3,2,1,4};
        Assert.assertEquals(goodPairs(num), 4);
    }

/*
1. get the digit occurrence in map
2. get the count which occur more than once
3. calculate the value and sum
4. return the sum value
*/

    private int goodPairs(int[] nums){
        if(nums.length < 1) return 0;
        int sum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(n -> map.put(n, map.getOrDefault(n, 0)+1));

        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if(m.getValue()>1){
                int n=m.getValue();
                sum+=(n*(n-1))/2;
            }
        }
        return sum;
    }
}