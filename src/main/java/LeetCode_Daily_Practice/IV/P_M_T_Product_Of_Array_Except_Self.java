package LeetCode_Daily_Practice.IV;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_M_T_Product_Of_Array_Except_Self {
    /*
    Given an integer array nums, return an array answer such that answer[i] is equal
    to the product of all the elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

Follow up: Can you solve the problem in O(1) extra space complexity?
(The output array does not count as extra space for space complexity analysis.)

     */

    @Test
    public void ex1() {
        int[] nums = {1, 2, 3, 4};
        Assert.assertEquals(productArray(nums), new int[]{24, 12, 8, 6});
    }

    @Test
    public void ex2() {
        int[] nums = {-1, 1, 0, -3, 3};
        Assert.assertEquals(productArray(nums), new int[]{0, 0, 9, 0, 0});
    }

    @Test
    public void ex3() {
        int[] nums = {5, 1, 4, 2};
        Assert.assertEquals(productArray(nums), new int[]{8, 40, 10, 20});
    }

    //time=O(n)
//space=O(n)
    private int[] productArray1(int[] nums) {
        int[] pre = new int[nums.length];//O(n)
        int[] suf = new int[nums.length];//O(n)
        pre[0] = 1;
        suf[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++)//O(n)
            pre[i] = pre[i - 1] * nums[i - 1];

        for (int i = nums.length - 2; i >= 0; i--)//O(n)
            suf[i] = suf[i + 1] * nums[i + 1];

        for (int i = 0; i < nums.length; i++)//O(n)
            nums[i] = pre[i] * suf[i];
        return nums;
    }

    private int[] productArray(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = 1;
        for (int i = 1; i < nums.length; i++)
            pre[i] = pre[i - 1] * nums[i - 1];
        int temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            pre[i] = temp * pre[i];
            temp = temp * nums[i];
        }
        return pre;
    }
}
