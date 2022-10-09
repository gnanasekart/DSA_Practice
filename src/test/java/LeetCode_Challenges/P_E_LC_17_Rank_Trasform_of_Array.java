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

    @Test
    public void example2(){
        int[] nums={100, 100, 100};
        Assert.assertEquals(rankArrayValues(nums), new int[]{1,1,1});
    }

    @Test
    public void example3(){
        int[] nums={37,12,28,9,100,56,80,5,12};
        Assert.assertEquals(rankArrayValues(nums), new int[]{5,3,4,2,8,6,7,1,3});
    }
    private int[] rankArrayValues(int[] nums) {
//        int[] temp= new int[nums.length];
//        System.arraycopy(nums, 0, temp, 0, nums.length);

        //int[] temp = Arrays.copyOf(nums, nums.length);

        int[] temp = nums.clone();
        //O(N log N)
        Arrays.sort(temp);

        //O(n^2)
//        for (int i = 0; i < temp.length; i++) {
//            for (int j = i + 1; j < temp.length; j++) {
//                if (temp[i] < temp[j])
//                    continue;
//                else
//                    temp[i] = temp[i]+temp[j];
//                    temp[j] = temp[i]-temp[j];
//                    temp[i] = temp[i]-temp[j];
//            }
//        }

        Map<Integer, Integer> map =new HashMap<>();
        int count=0;
        for(int i: temp){
            if(!map.containsKey(i)) map.put(i, count+1);
            else map.put(i, map.get(i));
        }

        for(int i=0; i<temp.length; i++)
            nums[i]=map.get(nums[i]);

        return nums;
    }
}
