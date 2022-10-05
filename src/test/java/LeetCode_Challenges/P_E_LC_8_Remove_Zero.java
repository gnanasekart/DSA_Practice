package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_LC_8_Remove_Zero {

    //https://leetcode.com/problems/move-zeroes/

    @Test
    public void example1() {
        int[] arr = {0, 1, 0, 3, 12};
        Assert.assertEquals(removeZero(arr), new int[]{1, 3, 12, 0, 0});
    }

    @Test
    public void example2() {
        int[] arr = {};
        Assert.assertEquals(removeZero(arr), new int[]{});
    }

    @Test
    public void example3() {
        int[] arr = {0};
        Assert.assertEquals(removeZero(arr), new int[]{0});
    }

    private int[] removeZero(int[] arr) {
        int left = 0, right = 0;
        while (left < arr.length && right < arr.length) {
            if (arr[right] == 0) right++;
            else if (arr[right] != 0) {
                int temp = arr[left];
                arr[left++] = arr[right];
                arr[right++] = temp;
            }else left++;
        }
        return arr;
    }
}
