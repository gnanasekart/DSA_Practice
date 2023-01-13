package HackerRank_Daily_Practice.Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P_I_Discount_Tags {

    @Test
    public void ex1(){
        int[] arr = {2,3,6,10,1,1};
        Assert.assertEquals(tags(arr), false);
    }

    @Test
    public void ex2(){
        int[] arr = {2,3,6,-5,10,1,1};
        Assert.assertEquals(tags(arr), true);
    }

    @Test
    public void ex4(){
        int[] arr = {2,3,6,10,1};
        Assert.assertEquals(tags(arr), true);
    }

    @Test
    public void ex3(){
        int[] arr = {2,6,10,1,1};
        Assert.assertEquals(tags(arr), true);
    }

    private boolean tags(int[] arr) {
        return Arrays.stream(arr).sum()%2==0 ? true:false;
    }


    //not all pass
    private int findMinusingKandane(int[] nums) {
        if(nums.length==0)
            throw new RuntimeException("Empty array");
        if(nums.length==1) return nums[0];
        int windowSum=nums[0], maxSum=nums[0];
        for (int i=1;i<nums.length;i++){
            if(nums[i]<0)nums[i]=0;
            windowSum= Math.max(windowSum+nums[i],nums[i]);
            if(windowSum%2==0){
                maxSum=Math.max(maxSum,windowSum);
            }


        }
        return maxSum;
    }

    public int findMaxEvenSum(int[] array){
        int total = 0;

        for (int i=0; i < array.length; ++i) {
            total += array[i];
        }

        if (total % 2 == 0) {
            return total;
        }

        // otherwise iterate over the array and remove the smallest odd
        // number from the sum
        int lastOdd = 0;

        for (int i=0; i < array.length; ++i) {
            if (array[i] % 2 == 1 && (lastOdd == 0 || array[i] < lastOdd)) {
                total += lastOdd;
                total -= array[i];
                lastOdd = array[i];
            }
        }

        return total;
    }
}
