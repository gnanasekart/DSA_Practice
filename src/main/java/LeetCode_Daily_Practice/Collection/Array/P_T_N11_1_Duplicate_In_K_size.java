package LeetCode_Daily_Practice.Collection.Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class P_T_N11_1_Duplicate_In_K_size {
    /*
    Given an array and a positive number k, check whether the array contains
    any duplicate elements within the range k. If k is more than the array’s size,
    the solution should check for duplicates in the complete array.

nums[] = { 5, 6, 8, 2, 4, 6, 9 }
k = 4

Output: Duplicates found

(element 6 repeats at distance 4 which is <= k)

     */

    @Test
    public void example1() {
        int[] num = { 5, 6, 8, 2, 4, 6, 9 };
        int k=4;
        Assert.assertEquals(duplicate(num, k), true);
    }

    public boolean duplicate(int[] num, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < num.length; i++) {
            if (map.containsKey(num[i])) {
                int first = map.get(num[i]);
                int diff = first - i;
                if (diff <= k)
                    return true;
            } else
                map.put(num[i], i);
        }
        return false;
    }

    public void duplicateBF(int[] num, int k) {
        boolean duplicatefound = false;
        for (int i = 0; i < num.length; i++) {
            for (int j = 1; j < num.length; j++) {
                if (num[i] == num[j] && i != j && j - i <= k) {
                    System.out.println(num[i] + " " + "duplicate found");
                }
            }
        }
    }
}
