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
        Assert.assertEquals(tag(arr), true);
    }

    @Test
    public void ex5(){
        int[] arr = {-1,-2,-3,1,4,10};
        Assert.assertEquals(tag(arr), 14);
    }

    private long tag(int[] val) {
        int evenSum = 0,oddSum=0,posOddVal=Integer.MAX_VALUE, minOddValue=Integer.MAX_VALUE;

        for (int i = 0; i < val.length; i++) {
            if (val[i] % 2 == 0)
                evenSum = Math.max(evenSum+val[i],evenSum);
            else {
                oddSum = Math.max(oddSum+val[i],oddSum);
                minOddValue=Math.min(minOddValue,val[i]);
                posOddVal=val[i]>0 && val[i]<posOddVal?val[i]:posOddVal;
            }
        }
        if(oddSum%2==1){
            if(minOddValue>0)oddSum-=minOddValue;
            else  oddSum=Math.max(oddSum+minOddValue,oddSum-posOddVal);
        }
        return Math.max(evenSum+oddSum,evenSum);
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
