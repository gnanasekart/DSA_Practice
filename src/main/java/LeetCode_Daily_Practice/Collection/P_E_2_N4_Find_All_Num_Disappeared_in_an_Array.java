package LeetCode_Daily_Practice.Collection;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class P_E_2_N4_Find_All_Num_Disappeared_in_an_Array {
    /*
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Given an array nums of n integers where nums[i] is in the range [1, n],
return an array of all the integers in the range [1, n] that do not appear in nums.

Constraints -
n == nums.length
1 <= n <= 105
1 <= nums[i] <= n

Follow up: Could you do it without extra space and in O(n) runtime?
You may assume the returned list does not count as extra space.
     */

    @Test
    public void example1() {
        int[] num = {4, 3, 2, 7, 8, 2, 3, 1};
        Assert.assertEquals(disappearedNumber(num), new ArrayList(Arrays.asList(5,6)));
    }

    @Test
    public void example2() {
        int[] num = {1, 1};
        Assert.assertEquals(disappearedNumber(num), Arrays.asList(2));
    }

    @Test
    public void example3() {
        int[] num = {4, 5, 6, 7, 8, 2, 3, 1};
        Assert.assertEquals(disappearedNumber(num), new ArrayList(Arrays.asList()));
    }


/*
using additional space
Pseudocode
base condition
- check if length<1
1. Create a hashset and add the array element into set
2. verify the value from 1 to n
3. remove the available element from the list
4. return the set
*/

    private List<Integer> disappearedNumber(int[] num) {
        if(num.length<1) Arrays.asList();
        Set<Integer> set =new HashSet<>();

        Arrays.stream(num).forEach(l -> set.add(l));
        for(int i=1; i<=num.length;i++){
            if(!set.remove(i))
                set.add(i);
        }
        return new ArrayList<>(set);
    }
}
