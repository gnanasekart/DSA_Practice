package LeetCode_Daily_Practice.Collection.Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class P_E_N4_2_Find_All_Num_Disappeared_in_an_Array {
    /*
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Given an array nums of n integers where nums[i] is in the range [1, n],
return an array of all the integers in the range [1, n] that do not appear in nums.

Constraints -
n == nums.length
1 <= n <= 10^5
1 <= nums[i] <= n

Follow up: Could you do it without extra space and in O(n) runtime?
You may assume the returned list does not count as extra space.
     */

    @Test
    public void example1() {
        int[] num = {4, 3, 2, 7, 8, 2, 3, 1};
        Assert.assertEquals(disappearedNumberBySorting(num), new ArrayList(Arrays.asList(5, 6)));
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
        if (num.length < 1) Arrays.asList();
        Set<Integer> set = new HashSet<>();
        Arrays.stream(num).forEach(l -> set.add(l));

        for (int i = 1; i <= num.length; i++) {
            if (!set.remove(i))
                set.add(i);
        }
        return new ArrayList<>(set);
    }

    private List<Integer> disappearedNumberNegValue(int[] num) {
        for (int i : num) {
            if (num[Math.abs(i) - 1] > 0)
                num[Math.abs(i) - 1] *= -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0)
                list.add(i + 1);
        }
        return list;
    }

    private List<Integer> disappearedNumberBySorting(int[] num) {
    List<Integer> list = new ArrayList<>();
    int temp=0;

        for (int i = 0; i < num.length; i++) {
            while((num[i] != i+1) && (num[i]!=num[num[i]-1])){
               temp=num[i];
               num[i]=num[num[i]-1];
               num[temp-1]=temp;
            }
        }
        for (int i = 0; i < num.length; i++) {
            if(num[i]!=i+1)
                list.add(i+1);
        }
    return list;    
    }
}
