package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class P_E_Sq_of_Sorted_Array {

    /*
    https://leetcode.com/problems/squares-of-a-sorted-array/
    Given an integer array nums sorted in non-decreasing order, return an array of the squares of
    each number sorted in non-decreasing order.
Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

    Constraints:

1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums is sorted in non-decreasing order.


Follow up: Squaring each element and sorting the new array is very trivial,
could you find an O(n) solution using a different approach?
     */
    @Test
    public void ex1() {
        Assert.assertEquals(sqsort(new int[]{-4, -1, 0, 3, 10}), new int[]{0, 1, 9, 16, 100});
    }

    //Input: nums = [-7,-3,2,3,11]
    //Output: [4,9,9,49,121]

    @Test
    public void ex2() {
        Assert.assertEquals(sqsort(new int[]{-7, -3, 2, 3, 11}), new int[]{4, 9, 9, 49, 121});
    }

    //O(n log n)
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            nums[i] = nums[i] * nums[i];
        Arrays.sort(nums);
        return nums;
    }

    //O(n)
    private int[] sqsort(int[] ints) {
        int[] a = new int[ints.length];
        int low = 0, high = ints.length - 1;
        for (int i = ints.length - 1; i >= 0; i--) {
            int ab = Math.abs(ints[low]);
            int bc = Math.abs(ints[high]);
            if (ab > bc)
                a[i] = ints[low] * ints[low++];
            else
                a[i] = ints[high] * ints[high--];
        }
        return a;
    }
}