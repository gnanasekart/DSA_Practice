package LeetCode_Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_O21_3_Merge_Sort_Array {
/*
    https://leetcode.com/problems/merge-sorted-array/

    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
    and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.

    The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
    To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
    and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

    Constraints:

    nums1.length == m + n
    nums2.length == n
    0 <= m, n <= 200
    1 <= m + n <= 200
    -109 <= nums1[i], nums2[j] <= 109
*/

    @Test
    public void example1(){
        int[] nums1={1,2,3,0,0,0};
        int m=3;
        int[] nums2={2,5,6};
        int n=3;
        Assert.assertEquals(sortAndMerge(nums1,m,nums2,n), new int[]{1,2,2,3,5,6});
    }

    @Test
    public void example2(){
        int[] nums1={-3,0,1,6,0,0};
        int m=4;
        int[] nums2={-1,7};
        int n=2;
        Assert.assertEquals(sortAndMerge(nums1,m,nums2,n), new int[]{-3,-1,0,1,6,7});
    }

    @Test
    public void example3(){
        int[] nums1={0};
        int m=0;
        int[] nums2={1};
        int n=1;
        Assert.assertEquals(sortAndMerge(nums1,m,nums2,n), new int[]{1});
    }

    @Test
    public void example4(){
        int[] nums1={1};
        int m=1;
        int[] nums2={};
        int n=0;
        Assert.assertEquals(sortAndMerge(nums1,m,nums2,n), new int[]{1});
    }


    private int[] sortAndMerge(int[] nums1, int m, int[] nums2, int n){

        int k=m+n-1, i=m-1, j=n-1;
        while(i>=0 && j>=0){
            if(nums1[i]==nums2[j])
                nums1[k--]=nums2[j--];
            else if(nums1[i]>nums2[j])
                nums1[k--]=nums1[i--];
            else
                nums1[k--]=nums2[j--];
        }

        while(j>=0)
            nums1[k--]=nums2[j--];
        return nums1;
    }
}
