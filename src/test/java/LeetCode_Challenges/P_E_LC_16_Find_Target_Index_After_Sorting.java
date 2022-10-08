package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_E_LC_16_Find_Target_Index_After_Sorting {
    //https://leetcode.com/problems/find-target-indices-after-sorting-array/
    @Test
    public void example1(){
        int[] nums={1,2,5,2,3};
        int k=2;
        Assert.assertEquals(findSortedArrTarget(nums, k).toArray(), new int[]{1,2});
    }

    private List<Integer> findSortedArrTarget(int[] nums, int k) {
        //Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j])
                    continue;
                 else {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int l = 0; l < nums.length; l++)
            if (nums[l] == k) list.add(l);
        return list;
    }
}
