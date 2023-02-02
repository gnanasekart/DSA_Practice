package LeetCode_Daily_Practice.Binary_Search;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class P_E_D3_2_Search_Insert_Position {
    /*
    leetcode.com/problems/search-insert-position/
    Given a sorted array of distinct integers and a target value, return the index
    if the target is found. If not, return the index where it would be if it were inserted in order.
    You must write an algorithm with O(log n) runtime complexity.

    Constraints:
    1 <= nums.length <= 10^4
    -10^4 <= nums[i] <= 10^4
    nums contains distinct values sorted in ascending order.
    -10^4 <= target <= 10^4
     */

    @Test
    public void ex1() {
        int[] a = {1, 3, 5, 6};//0,1  0,0
        int k = 2;
        Assert.assertEquals(searchBuildin(a, k), 1);
    }

    @Test
    public void ex2() {
        int[] a = {1, 3, 5, 6};
        int k = 5;
        Assert.assertEquals(searchBuildin(a, k), 2);
    }

    @Test
    public void ex3() {
        int[] a = {1, 3, 5, 6};
        int k = 7;
        Assert.assertEquals(searchBuildin(a, k), 4);
    }

    @Test
    public void ex4() {
        int[] a = {1};
        int k = 2;
        Assert.assertEquals(searchBuildin(a, k), 1);
    }


    private int searchInsertPosition(int[] arr, int k) {
        int left = 0, right = arr.length - 1, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] < k)
                left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    private int searchBuildin(int[] arr, int k) {
        int index = Arrays.binarySearch(arr, k);
        int value = (index < 0) ? (-(index) + (-1)) : index;
        return value;
    }
}
