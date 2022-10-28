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

    //@Test
    public void example4(){
        int[] num={10,10,10,10,10,10,1,10,10,10,0,10,10,10};
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

    @Test
    public void example7(){
        int[] num={2,3,-2,8};
        Assert.assertEquals(prodSubArray(num), 8);
    }

    @Test
    public void example8(){
        int[] num={0, 2};
        Assert.assertEquals(prodSubArray(num), 2);
    }
/*
1. consider two loop i=length
        2. second loop j=(i-1)-i+1 till the end of length
        3. check the condition if sum >= 0
        4. sum every loop and store the sum in max value
        5. return the max value of sum which is less than 2^32
*/
        private int prodSubArray1(int[] num){
                if(num.length==1) return num[0];
                int sum=1, max=Integer.MIN_VALUE;
                for(int i=0; i<num.length; i++){
                    for(int j=i; j<num.length; j++){
                        sum=sum*num[j];
                        System.out.println(sum);
                        max=Math.max(max, sum);
                    }
                    sum=1;
                }
                return max;
        }

    private int prodSubArray(int[] num) {
        if(num.length==1) return num[0];
        int sum=1, max=Integer.MIN_VALUE, right=0, left=0;

        for(int k=num.length; k>0; k--) {
            right = k - 1;
            left = right - k + 1;
            while(right < num.length) {
                if (left <= right) {
                    sum *= num[left++];
                    max = sum > max ? sum : max;
                }else {
                    right++;
                    sum = 1;
                    left = right - k + 1;
                }
            }
        }
        return max;
    }



    private int prodSubArray2(int[] num){
        if(num.length==1) return num[0];
        int sum=1, max=Integer.MIN_VALUE, value=0, left=0;
        for(int i=0; i<num.length; i++){
                sum=sum*num[i];
                value=sum;
                max = sum>max ? sum : max;
                left=0;
                while(left<i && value!=0){
                    if(num[left]!=0)
                        value=value/num[left++];
                    max=value>max ? value:max;
            }
        }
        return max;
    }
}