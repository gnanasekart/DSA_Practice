package LeetCode_Daily_Practice.Collection;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class P_E_N2_3_Majority_Element {
    /*
    leetcode.com/problems/contains-duplicate-ii/

Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
 You may assume that the majority element always exists in the array.
Constraints:
n == nums.length
1 <= n <= 5 * 10^4
-10^9 <= nums[i] <= 10^9
*/

    @Test
    public void example1() {
        int[] s = {3, 2, 3};
        Assert.assertEquals(majorityElement(s), 3);
    }

    @Test
    public void example2() {
        int[] s = {2, 2, 1, 1, 1, 2, 2};
        Assert.assertEquals(majorityElement(s), 2);
    }

    @Test
    public void example3() {
        int[] s = {-9, -8, -7, -6, -5, -4, -5, -7, -8, -8};
        Assert.assertEquals(majorityElement(s), -8);
    }

    @Test
    public void example4() {
        int[] s = {3, 3, 4};
        Assert.assertEquals(majorityElement(s), 3);
    }

    //@Test
    public void example5() {
        int[] s = {3, 2, 3};
        Assert.assertEquals(majorityElement(s), 3);
    }


/*
PseudoCode
1. get the no of occurrence by hash table
2. get the max value
3. return the key of max value
*/

    private int majorityElement(int[] s) {
        if (s.length < 1) return 0;
        int max = Integer.MIN_VALUE;
        int key = 0;
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < s.length; i++) {
            map.put(s[i], map.getOrDefault(s[i], 0) + 1);

            if (map.get(s[i]) > max){
                max=map.get(s[i]);
                key=s[i];
            }
        }
        return key;
    }
}
