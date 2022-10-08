package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class P_E_LC_17_Rank_Trasform_of_Array {
    //https://leetcode.com/problems/rank-transform-of-an-array/
    @Test
    public void example1(){
        int[] nums={40,10,20,30};
        Assert.assertEquals(rankArrayValues(nums), new int[]{4,1,2,3});
    }

    private int[] rankArrayValues(int[] nums) {
//        int[] temp= new int[nums.length];
//        System.arraycopy(nums, 0, temp, 0, nums.length);

        int[] temp = Arrays.copyOf(nums, nums.length);

        for (int i = 0; i < temp.length; i++) {
            for (int j = i + 1; j < temp.length; j++) {
                if (temp[i] < temp[j])
                    continue;
                else
                    temp[i] = temp[i]+temp[j];
                    temp[j] = temp[i]-temp[j];
                    temp[i] = temp[i]-temp[j];
            }
        }

        Map<Integer, Integer> map =new HashMap<>();
        for(int n=0; n<temp.length; n++)
            map.put(temp[n], n+1);

        for(int i=0; i<temp.length; i++)
            nums[i]=map.get(nums[i]);

        return nums;
    }
}
