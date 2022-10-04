package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_LC_4_Search_Insert_Position {
//https://leetcode.com/problems/search-insert-position/
    @Test
    public void example1(){
        int[] nums={1,3,5,6};
        int target=5;
        Assert.assertEquals(insertPosition(nums, target), 2);
    }

    @Test
    public void example2(){
        int[] nums={1,3,5,6};
        int target=4;
        Assert.assertEquals(insertPosition(nums, target), 2);
    }

    @Test
    public void example3(){
        int[] nums={1,3,5,6};
        int target=2;
        Assert.assertEquals(insertPosition(nums, target), 1);
    }

    @Test
    public void example4(){
        int[] nums={1,3,5,6};
        int target=7;
        Assert.assertEquals(insertPosition(nums, target), 4);
    }

    private int insertPosition(int[] nums, int k) {
        int low=0, high=nums.length-1;
        while(low<=high){
           int mid = (low+high)/2;
            if(nums[mid]>k) high=mid-1;
            else if(nums[mid]==k) return mid;
            else low=mid+1;
        }
        return low;
    }
}
