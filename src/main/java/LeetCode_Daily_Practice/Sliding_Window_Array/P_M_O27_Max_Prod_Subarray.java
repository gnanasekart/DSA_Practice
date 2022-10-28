package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_M_O27_Max_Prod_Subarray {
    /*
    leetcode.com/problems/maximum-product-subarray/

    Given an integer array nums, find a contiguous non-empty subarray
    within the array that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.
A subarray is a contiguous subsequence of the array.

Constraints:
1 <= nums.length <= 2 * 10^4
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     */

    @Test
    public void example1(){
        int[] num={2,3,-2,4};
        Assert.assertEquals(prodSubArray(num), 6);
    }

    @Test
    public void example2(){
        int[] num={-2,0,-1};
        Assert.assertEquals(prodSubArray(num), 0);
    }

    @Test
    public void example3(){
        int[] num={1,2,1,2,1,2,0,1,2};
        Assert.assertEquals(prodSubArray(num), 8);
    }

    @Test
    public void example4(){
        int[] num={10,10,10,10,10,10,10,10,10,10};
        Assert.assertEquals(prodSubArray(num), 2147483647);
    }

    @Test
    public void example5(){
        int[] num={-1};
        Assert.assertEquals(prodSubArray(num), -1);
    }

    @Test
    public void example6(){
        int[] num={-1, -2};
        Assert.assertEquals(prodSubArray(num), 2);
    }
/*
1. consider two loop i=length
        2. second loop j=(i-1)-i+1 till the end of length
        3. check the condition if sum >= 0
        4. sum every loop and store the sum in max value
        5. return the max value of sum which is less than 2^32
*/
private int prodSubArray(int[] num){
        if(num.length==1) return num[0];
        int sum=1, max=0;

        for(int i=1, j=i; i< num.length; i++){
            //for(int j=num.length-i; j<num.length-1; j++){

                while(j>=0){
                    sum=sum*num[j--];
                }
                max=Math.max(max, sum);
            sum=1;
            }



        if(max < 2147483647){
        return max;
        }
        return 2147483647;
        }
}