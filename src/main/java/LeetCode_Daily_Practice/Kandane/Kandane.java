package LeetCode_Daily_Practice.Kandane;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Kandane {

    /*
    Kadane Algorithm;
	1. algorithm to solve maximum sum subarray
	2. Complexity
		a. Time Complexity- O[N]
		b. Space Complexity- O[1]
	3. condition - If the sum is less than or zero, reset window sum as 0

    Kandane Algorithm - conditions
	1.Initializing maximum as 0 and currentMaximum as 0
	2.Loop 0 to end of the length
	3.If currentMaximum length is less than zero, reset currentMaximum as 0
	4.If currentMaximum is greater than or equal to zero, add the current index value to currentMaximum
	5.Assign maximum with max of maximum and currentMaximum
     */

    @Test
    public void example1(){
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        Assert.assertEquals(KandeneAlgo1(arr), 6);
    }

    private int KandeneAlgo(int[] arr) {
        int sum=0, max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];

            if(sum<0) sum=0;

            if(sum>0)
                max=sum>max?sum:max;
        }
        return max;
    }

    private int KandeneAlgo1(int[] arr) {
        int max=Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
           arr[i]=Math.max(arr[i], arr[i]+arr[i-1]);
           max=Math.max(arr[i], max);
        }
        return max;
    }
}
