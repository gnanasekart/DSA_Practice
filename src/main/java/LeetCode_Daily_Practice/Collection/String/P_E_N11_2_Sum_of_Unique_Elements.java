package LeetCode_Daily_Practice.Collection.String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_E_N11_2_Sum_of_Unique_Elements {
   /*
    https://leetcode.com/problems/sum-of-unique-elements/

    You are given an integer array nums. The unique elements of an array are the elements that
    appear exactly once in the array.

    Return the sum of all the unique elements of nums.

    Constraints:
            1 <= nums.length <= 100
            1 <= nums[i] <= 100
*/

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 2};
        Assert.assertEquals(uniqueSum(nums), 4);
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 1, 1};
        Assert.assertEquals(uniqueSum(nums), 0);
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 4, 5};
        Assert.assertEquals(uniqueSum(nums), 15);
    }

    @Test
    public void example4() {
        int[] nums = {1};
        Assert.assertEquals(uniqueSum(nums), 1);
    }

    @Test
    public void example5() {
        int[] nums = {1, 11, 100};
        Assert.assertEquals(uniqueSum(nums), 112);
    }

/*
1. Add the array value into hashmap and get the count
2. check every value which matches value ==1
3. then get the key and sum it
4. return the key
*/

    public int uniqueSum1(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        Arrays.stream(nums).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));
        int sum = 0;
        for (Integer m : map.keySet()) {
            if (map.get(m) == 1) sum += m;
        }
        return sum;
    }

    public int uniqueSum(int[] nums) {
        String s = nums.toString();
        int sum=0;

        int[] a = new int[101];

        for(int i=0; i<a.length; i++) {
            a[nums[i]]++;
        }

        for(int x=0; x<a.length; x++ ) {
            if(a[x]==1)
                sum=+x;
        }
        return sum;
    }
}
