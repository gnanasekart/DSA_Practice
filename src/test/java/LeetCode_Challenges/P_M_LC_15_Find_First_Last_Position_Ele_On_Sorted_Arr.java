package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class P_M_LC_15_Find_First_Last_Position_Ele_On_Sorted_Arr {
    //leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

    @Test
    public void example1(){
        int[] nums={5,7,7,8,8,10};
        int k=8;
        Assert.assertEquals(findTarget(nums, k), new int[]{3,4});
    }

    @Test
    public void example2(){
        int[] nums={5,7,7,8,8,10};
        int k=6;
        Assert.assertEquals(findTargetList(nums, k), new int[]{-1,-1});
    }

    @Test
    public void example3(){
        int[] nums={};
        int k=1;
        Assert.assertEquals(findTarget(nums, k), new int[]{-1,-1});
    }

    @Test
    public void example4(){
        int[] nums={1};
        int k=1;
        Assert.assertEquals(findTargetList(nums, k), new int[]{0,0});
    }

    private int[] findTarget(int[] nums, int k) {
        int[] arr = new int[]{-1, -1};

        arr[0]=search(nums, k, true);
        arr[1]=search(nums, k, false);
        return arr;
    }
    public int search(int[] nums, int k, boolean b){
        int low = 0, high = nums.length-1, res=-1;

        while(low<=high){
            int mid=low+((high-low)/2);
            if(nums[mid]==k){
                res=mid;
                if(b) high=mid-1;
                else low=mid+1;
            } else if (nums[mid]<k) low=mid+1;
            else high=mid-1;
        }
        return res;
    }

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }

        int[] res = new int[2];

        if (list.isEmpty()) {
            res[0] = -1;
            res[1] = -1;
        } else {
            res[0] = list.get(0);
            res[1] = list.get(list.size() - 1);
        }
        return res;
    }

    private int[] findTargetList(int[] nums, int target){
        ArrayList<Integer> list = new ArrayList();
        for(int i=0; i<nums.length; i++){
            if(nums[i]==target) list.add(i);
        }

        int[] arr = new int[]{-1, -1};
        if(list.isEmpty()) return arr;
        else{
            arr[0]=list.get(0);
            arr[1]=list.get(list.size()-1);
        }
        return arr;
    }
}
