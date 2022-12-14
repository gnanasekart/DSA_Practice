package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_LC_3_Remove_Element {
    /*leetcode.com/problems/remove-element/
Given an integer array nums and an integer val, remove all occurrences
of val in nums in-place. The relative order of the elements may be changed.
Since it is impossible to change the length of the array in some languages,
you must instead have the result be placed in the first part of the array nums.
More formally, if there are k elements after removing the duplicates,
then the first k elements of nums should hold the final result.
It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying
the input array in-place with O(1) extra memory.
     */

    @Test
    public void example1(){
        int[] nums={0,1,2,2,3,0,4,2};
        int k=2;
        Assert.assertEquals(removeElement1(nums, k), 5);
    }

    @Test
    public void example2(){
        int[] nums={0,1};
        int k=2;
        Assert.assertEquals(removeElement(nums, k), 2);
    }

    @Test
    public void example3(){
        int[] nums={};
        int k=2;
        Assert.assertEquals(removeElement(nums, k), 0);
    }

    @Test
    public void example4(){
        int[] nums={3,2,2,3};
        int k=2;
        Assert.assertEquals(removeElement1(nums, k), 2);
    }

    @Test
    public void example5(){
        int[] nums={3,2,2,3};
        int k=1;
        Assert.assertEquals(removeElement1(nums, k), 4);
    }

/*
logic -
1. check the array length not to be zero
2. iterate every index and compare with k value
3, if k values not matches then swap to new index from 0
4. if k value matches means does not swap
5. return the new index value
 */

    //time - O(n)
    //space - O(1) by using existing memory
    private int removeElement(int[] nums, int k) {
        if(nums.length == 0) return 0;
        int left=0, right=0;

        while(left<nums.length){ //=> O(n)
            if(nums[left]!=k)   //=> O(1)
                nums[right++]=nums[left];
            left++;
        }
        return right;
    }

    private int removeElement2(int[] nums, int k) {
        if(nums.length == 0) return 0;

        int index=nums.length;
        for(int i=0; i<index; i++)//O(n)
          if(nums[i]==k) {
              nums[i--] = nums[--index];
          }
        return index;
    }

//3 2 2 3
    private int removeElement1(int[] nums, int k) {
        int left=0, right=nums.length-1;
        while(left<=right){
            if(nums[left]==k && nums[right]==k){
                right--;
            }else if(nums[left]==k && nums[right]!=k){
                nums[left++]=nums[right--];
            }else{
                left++;
            }
        }
        return left;
    }
}
