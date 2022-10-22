package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class P_E_LC_8_Move_Zero {

    /*https://leetcode.com/problems/move-zeroes/
    Given an integer array nums, move all 0's to the end of it while maintaining
    the relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array.

logic
1. consider two pointer left and right start from same place
2. start iteration with one pointer to check certain conditions
	- if => the value is zero means then increment the iteration
	- else if => the value is not zero means swap
	- else => increment on another pointer
3. then return the array

*/
    @Test
    public void example1() {
        int[] arr = {0, 1, 0, 3, 12};
        Assert.assertEquals(removeZero3(arr), new int[]{1, 3, 12, 0, 0});
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

    @Test
    public void example4() {
        int[] arr = {0, 0, 0, 0, 12};
        Assert.assertEquals(removeZero(arr), new int[]{12,0,0,0,0});
    }

    @Test
    public void example5() {
        int[] arr = {0, 0, 0};
        Assert.assertEquals(removeZero(arr), new int[]{0,0,0});
    }

    @Test
    public void example6() {
        int[] arr = {-3,0,-2,0,-1,0,0};
        Assert.assertEquals(removeZero(arr), new int[]{-3,-2,-1,0,0,0,0});
    }

    @Test
    public void example7() {
        int[] arr = {1,0};
        Assert.assertEquals(removeZero(arr), new int[]{1,0});
    }

    @Test
    public void example8() {
        int[] arr = {0,2};
        Assert.assertEquals(removeZero(arr), new int[]{2,0});
    }

    //time complexity - O(n)
    //space complexity - O(1) we're using inplace memory
    private int[] removeZero(int[] arr) {
        int left = 0, right = 0, temp;
        while (left < arr.length && right < arr.length) { //=> O(n)
            if (arr[right] == 0) right++; //=> O(1)
            else if (arr[right] != 0) {  //=> O(1)
                temp = arr[left];
                arr[left++] = arr[right];
                arr[right++] = temp;
            }else left++;   //=> O(1)
        }
        return arr;
    }

    private int[] removeZero2(int[] arr) {
        for(int i=0, j=0; i<arr.length; i++){//=> O(n)
            if(arr[i]!=0){  //=> O(1)
                int temp=arr[j];
                arr[j++]=arr[i];
                arr[i]=temp;
            }
        }
        return arr;
    }

    private int[] removeZero3(int[] nums) {
        int left=0,right=left+1 , k=right+1;
        int temp;

        while(left<nums.length-1)
        {
            if(nums[left]==0  ) {
                temp=nums[left];
                nums[left++]=nums[right];
                nums[right++]=temp;
            }
            else if(nums[right]!=0)
            {
                right++;
            }
            else
                left++;

        }

        return nums;
    }
}
