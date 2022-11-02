package LeetCode_Daily_Practice.Collection;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_E_2_N2_Contains_Duplicate_II {
    /*
    leetcode.com/problems/contains-duplicate-ii/

Given an integer array nums and an integer k, return true if there are two distinct indices i and j
in the array such that nums[i] == nums[j] and abs(i - j) <= k.
Constraints:
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
0 <= k <= 10^5
*/
    @Test
    public void example1() {
        int[] s = {1, 2, 3, 1};
        int k = 3;
        Assert.assertEquals(containsDuplicateHM(s, k), true);
    }

    @Test
    public void example2() {
        int[] s = {1, 0, 1, 1};
        int k = 1;
        Assert.assertEquals(containsDuplicateHM(s, k), true);
    }

    @Test
    public void example3() {
        int[] s = {1, 2, 3, 1, 2, 3};
        int k = 2;
        Assert.assertEquals(containsDuplicateHM(s, k), false);
    }

    @Test
    public void example4() {
        int[] s = {-3, -2, -6, -1, -2};
        int k = 5;
        Assert.assertEquals(containsDuplicateHM(s, k), true);
    }

    @Test
    public void example5() {
        int[] s = {3, 3};
        int k = 0;
        Assert.assertEquals(containsDuplicateHM(s, k), false);
    }

    @Test
    public void example6() {
        int[] s = {3};
        int k = 0;
        Assert.assertEquals(containsDuplicateHM(s, k), false);
    }

/*
PseudoCode
1. consider two pointers
2. one pointer in for loop move for every indexes
3. another pointer on i+1
4. check for condition (nums[i]==nums[j] && Math.abs(i-j)<=k)
5. if the condition pass then return true
6. else return false

*/

    private boolean containsDuplicate(int[] s, int k) {
        if (s.length < 2) return false;
        int j = 0;
        for (int i = 0; i < s.length - 1; i++) {
            j = i + 1;
            while (j < s.length) {
                if (s[i] == s[j++]) {
                    if (Math.abs(i - j) <= k) {
                        return true;
                    }
                }
                j++;
            }
        }
        return false;
    }

    private boolean containsDuplicateHM(int[] s, int k) {
        if (s.length < 2) return false;
        int j=0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<s.length; i++){
            if(map.containsKey(s[i])){
                j=map.get(s[i]);
                if(s[i]==s[j] && Math.abs(j-i) <= k) return true;
                else map.put(s[i], i);
            }else map.put(s[i], i);
        }
        return false;
    }
}
