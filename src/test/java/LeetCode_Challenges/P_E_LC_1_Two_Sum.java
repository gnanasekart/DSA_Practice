package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;
public class P_E_LC_1_Two_Sum {
//https://leetcode.com/problems/two-sum/
    @Test
    public void example1(){
        int[] num={2,7,11,15};
        int target=9;
       // Assert.assertEquals(two_Sum_BF(num, target), new int[] {0,1});
        Assert.assertEquals(two_Sum_TwoPointer(num, target), new int[] {0,1});
    }

    @Test
    public void example2(){
        int[] num={3,2,4};
        int target=6;
        // Assert.assertEquals(two_Sum_BF(num, target), new int[] {0,1});
        Assert.assertEquals(two_Sum_TwoPointer(num, target), new int[] {1,2});
    }

    private int[] two_Sum_BF(int[] nums, int target) {
        boolean bMatch =false;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    bMatch=true;
                    return new int[] {i,j};
                }
            }
        }
        if(!bMatch)
            throw new RuntimeException("there is no match");
        return null;
    }

    private int[] two_Sum_TwoPointer(int[] nums, int target) {
        boolean bMatch=false;
        int left=0, right=nums.length-1;
        while(left < right){
            int sum=nums[left]+nums[right];
            if(sum==target){
                bMatch=true;
                break;
            }else if(sum<target) left++;
            else right--;

            Math.abs(nums[0]-target);
        }
        if(!bMatch) throw new RuntimeException("not found");

        return new int[]{left, right};
    }
}
