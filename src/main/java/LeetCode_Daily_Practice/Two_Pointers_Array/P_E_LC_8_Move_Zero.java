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
        Assert.assertEquals(RemoveZeroes1(arr), new int[]{1, 3, 12, 0, 0});
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
        Assert.assertEquals(RemoveZeroes1(arr), new int[]{12,0,0,0,0});
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

    /*
    Two pointers
    1. left and right starts from 0
    2. left slow pointer and right fast pointer
    3. ar[right] == 0 skip swap and right++
    4. if arr[right]!=0 swap and increment two pointers
    5. else arr[left]!=0 then increment left
    6. return the array
     */
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

    /*
    1. looping from 0 to len
    2. start assign the arr value != 0th value to first index and increment
    3. once after non-zero values inserted
    4. start assigning zero for remaining space from the previously left index
    5. return array
     */
    private int[] removeZero2(int[] arr) {
        int j=0;
        for(int i=0; i<arr.length; i++) {//=> O(n)
            if(arr[i]!=0)
                arr[j++]=arr[i];
        }
        while(j<arr.length)
            arr[j++]=0;

        return arr;
    }

    /*
    1. start iterating in for loop
    2. if the i value is arr[i]!=0 then swap the i and j value
    3. else increment only i value
     */

    public void RemoveZeroes(int[] nums) {

        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    /*
    1. start with two pointers
    2. left =0 and right=1
    3. if a[left]==0 and a[right]!=0 means swap the values
    4. continue with above flow check if a[left]!=0 then left increment
    5. increment right for every iteration till the length
     */
    public int[] moveZeroes(int[] nums) {
        int left=0, right=1;
        while( right<nums.length) {
            if (nums[left] == 0 && nums[right] != 0) {
                int temp = nums[right];
                nums[right]=nums[left];
                nums[left]=temp;
            }

            if(nums[left]!=0){
                left++;
            }
            right++;
        }
        return nums;
    }

    public int[] RemoveZeroes1(int[] nums) {
        int c=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                c++;
            }else if(c>0){
                nums[i-c]=nums[i];
                nums[i]=0;
            }
        }
        return nums;
    }
}
