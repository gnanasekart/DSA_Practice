package LeetCode_Daily_Practice.Sorting;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_E_D10_3_Find_Target_Indexes_After_sorting {
/*
https://leetcode.com/problems/find-target-indices-after-sorting-array/

You are given a 0-indexed integer array nums and a target element target.

A target index is an index i such that nums[i] == target.

Return a list of the target indices of nums after sorting nums in non-decreasing order.
If there are no target indices, return an empty list. The returned list must be sorted in increasing order.

Constraints:

1 <= nums.length <= 100
1 <= nums[i], target <= 100
*/

    @Test
    public void ex1(){
        int target=2;
        int[] nums = {1,2,5,2,3};
        Assert.assertEquals(targetIndicesValue(nums, target), new int[]{1,2});
    }


    @Test
    public void ex2(){
        int target=3;
        int[] nums = {1,2,5,2,3};
        Assert.assertEquals(people(nums, target), new int[]{3});
    }

    @Test
    public void ex3(){
        int target=5;
        int[] nums = {1,2,5,2,3};
        Assert.assertEquals(targetIndices(nums, target), new int[]{4});
    }

    @Test
    public void ex4(){
        int target=2;
        int[] nums = {1};
        Assert.assertEquals(people(nums, target), new int[]{});
    }

    @Test
    public void ex5(){
        int target=2;
        int[] nums = {2,2,2,2,2};
        Assert.assertEquals(targetIndices(nums, target), new int[]{0,1,2,3,4});
    }
/*
1. sort the nums array using bubble sort
2. check every element with target element
3. if matches then add into list
4. then return the list
*/
    public int[] people(int[] nums, int target){
        int temp=0, j=0, k=0;
        for(j=0; j<nums.length; j++){
            for(k=0; k<nums.length-1-j; k++){
                if(nums[k]>nums[k+1]){
                    temp=nums[k];
                    nums[k]=nums[k+1];
                    nums[k+1]=temp;
                }
            }
        }

        ArrayList<Integer> list= new ArrayList();
        for(int i=0; i<nums.length; i++){
            if(nums[i]==target){
                list.add(i);
            }
        }

        return list.stream().mapToInt(a-> a).toArray();
    }
    //0,1,2,3,4
    //1,2,2,3,5

    //binary search
    public List<Integer> targetIndices(int[] nums, int target) {

        ArrayList<Integer>ans=new ArrayList<>();
        Arrays.sort(nums);
        int start=0, end=nums.length-1;

        while(start<=end){
            int mid=(start+end)/2;

            if(nums[mid]==target){
                int left=mid-1;
                while(left>=0&&nums[left]==target){
                    left--;
                }
                int right=left+1;
                while(right<nums.length&&nums[right]==target){
                    ans.add(right);
                    right++;
                }
                return ans;
            }

            if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }

    //{1,2,5,2,3} => 1,2,2,3,5
    public int[] targetIndicesValue(int[] nums, int target) {
        int lesser=0, eql=0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]<target) lesser++;//1
            else if(nums[i]==target) eql++;//2
        }
        for(int i=0; i<eql; i++)//0<=2
            list.add(lesser++);

        return list.stream().mapToInt(i -> i).toArray();
    }
}
