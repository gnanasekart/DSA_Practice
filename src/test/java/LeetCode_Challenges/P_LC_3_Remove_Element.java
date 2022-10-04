package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_LC_3_Remove_Element {
    //leetcode.com/problems/remove-element/

    @Test
    public void example1(){
        int[] nums={0,1,2,2,3,0,4,2};
        int k=2;
        Assert.assertEquals(removeElement(nums, k), 5);
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
    private int removeElement(int[] nums, int k) {
        if(nums.length == 0) return 0;

        int index=0;
        for(int i=0; i<nums.length; i++)
          if(nums[i]!=k) nums[index++]=nums[i];
        return index;
    }
}
