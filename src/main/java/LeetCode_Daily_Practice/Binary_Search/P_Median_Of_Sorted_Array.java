package LeetCode_Daily_Practice.Binary_Search;

import org.testng.annotations.Test;

public class P_Median_Of_Sorted_Array {
    /*

     */

    @Test
    public void example1() {
        //Positive Test Data
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedian(nums1,nums2));
    }

    @Test
    public void example2() {
        //Edge Case Test Data
        int[] nums1 = {1,3};
        int[] nums2 = {2,4};
        System.out.println(findMedian(nums1,nums2));
    }

    @Test
    public void example3() {
        //Negative Test Data
        int[] nums1 = {1,3,5,6,7,8};
        int[] nums2 = {2,4};
        System.out.println(findMedian(nums1,nums2));
    }

    private double findMedian(int[] nums1, int[] nums2) {
        int left=0,right=0;
        int m=nums1.length,n=nums2.length;
        double[] output = new double[m+n];
        int index=0;
        while(left<m || right<n){
            if(left>=m)
                output[index] = nums2[right++];
            else if (right>=n)
                output[index] = nums1[left++];
            else if(nums1[left]<nums2[right])
                output[index] = nums1[left++];
            else
                output[index] = nums2[right++];
            index++;
        }
        int mid = output.length/2;
        if(output.length%2==1)
            return output[mid];
        else
            return (output[mid]+ output[mid-1])/2;
    }
}
