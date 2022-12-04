package LeetCode_Daily_Practice.Binary_Search;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_D3_1_Binary_Search {
    /*
    leetcode.com/problems/binary-search/
    Given an array of integers nums which is sorted in ascending order,
    and an integer target, write a function to search target in nums.
    If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.

Constraints:
1 <= nums.length <= 10^4
-10^4 < nums[i], target < 10^4
All the integers in nums are unique.
nums is sorted in ascending order.
     */

    @Test
    public void ex1() {
        int[] a = {-1, 0, 3, 5, 9, 12};
        int k = 9;
        Assert.assertEquals(binar(a, k), 4);
    }

    @Test
    public void ex2() {
        int[] a = {2,5,5,5,9};
        int k = 9;
        Assert.assertEquals(binar(a, k), 4);
    }

    @Test
    public void ex3() {
        int[] a = {2,5,5,5,9};
        int k = 3;
        Assert.assertEquals(binar(a, k), -1);
    }

    private int binar(int[] arr, int k) {

        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k)
                return mid;
            else if (arr[mid] < k)
                low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}