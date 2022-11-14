package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class P_A_M_O30_Two_Sum {

/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    logic-
            1. consider two pointer left and right
2. left will be slow pointer and right will be fast pointer
3. right will sum with left pointer and match with target
4. if match with target then return left+1 and right+1
            5. else right increment until array length
6. left increment for every right loop complete

*/
    @Test
    public void example1(){
        int[] n ={2,7,11,15};
        int target=9;
        Assert.assertEquals(targetSum(n, target), new int[]{1,2});
    }

    @Test
    public void example2(){
        int[] n ={2,3,4};
        int target=6;
        Assert.assertEquals(targetSum(n, target), new int[]{1,3});
    }

    @Test
    public void example5(){
        int[] n ={1,2,3,4,5,6,7,8,9};
        int target=6;
        Assert.assertEquals(targetSum(n, target), new int[]{2,4});
    }

    @Test
    public void example7(){
        int[] n ={5, 25, 75};
        int target=100;
        Assert.assertEquals(targetSum(n, target), new int[]{2,3});
    }

    //brute force
    public int[] twoSum(int[] num, int target) {
        int[] arr = new int[2];
        for(int i=0; i<num.length;i++){
            for(int j=i+1; j<num.length; j++)
                if(num[i]+num[j] == target)
                    return new int[]{i+1, j+1};
        }
        return arr;
    }

    public int[] targetSum(int[] num, int target) {
        int  right=num.length-1, left=0,sum=0;

            while(left<right){
                sum=num[left]+num[right];
                if(sum==target){
                    return new int []{left+1, right+1};
                }else if(sum<target){
                    left++;
                }else
                    right--;
            }
        return new int []{};
    }

    public int[] targetSum1(int[] num, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int i=0;
        while(i<num.length){
            if(!map.containsKey(target-num[i])){
                map.put(num[i], i);
            }else
                return new int[]{map.get(target-num[i]) +1, i+1};
            i++;
        }
        return new int[]{};
    }
}
