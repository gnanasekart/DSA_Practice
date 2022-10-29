package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_M_O26_Max_Consecutive_1_III {
/*
    leetcode.com/problems/max-consecutive-ones-iii/
    Given a binary array nums and an integer k, return the maximum
    number of consecutive 1's in the array if you can flip at most k 0's.

    Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
*/
    @Test
    public void example1(){
        int[] num={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        Assert.assertEquals(maxOneTwoPointer(num, k), 6);
    }

    @Test
    public void example2(){
        int[] num={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=3;
        Assert.assertEquals(maxOneTwoPointer(num, k), 10);
    }

    @Test
    public void example3(){
        int[] num={0,0,1,1,0,1,1,1,1,0,1,1,1,0,1,1,0,0,0};
        int k=0;
        Assert.assertEquals(maxOne(num, k), 4);
    }

    @Test
    public void example4(){
        int[] num={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=8;
        Assert.assertEquals(maxOne(num, k), num.length);
    }

    @Test
    public void example5(){
        int[] num={1,1,1};
        int k=1;
        Assert.assertEquals(maxOne(num, k), 3);
    }

    @Test
    public void example6(){
        int[] num={0};
        int k=0;
        Assert.assertEquals(maxOne(num, k), 0);
    }

    @Test
    public void example7(){
        int[] num={0,0,0};
        int k=0;
        Assert.assertEquals(maxOne(num, k), 0);
    }

    /*
1. consider first iteration start with i=0 till the array end
2. if i==0 then decrement k and move next
3. in between k<0 then check for left value ==0
4. then increment k and left
5. get the maximum difference between left and right as max value
6. once reaches the end then return the max value
*/

    public int maxOneBF(int[] num, int k) {
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < num.length;i++) {
            int  zero=k;
            for(int j=i; j < num.length; j++) {
                if (num[j] == 1) continue;
                if (num[j] == 0) {
                    if(zero>0){
                        zero--;
                    }else break;
                }
                max=Math.max(max, i-j+1);
            }
        }
        return max;
    }

    public int maxOne1(int[] num, int k) {
        int max=0, zero=0;
        for (int i = 0, left=0; i < num.length; i++) {
            if (num[i] == 0) zero++;

            while(zero>k) {
                if(num[left++] == 0)
                    zero--;
            }
            max=Math.max(max, i-left+1);
        }
        return max;
    }

    public int maxOne(int[] num, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0, left = 0; i < num.length; i++) {
            if (num[i] == 0) k--;

            while (k < 0) {
                if (num[left] == 0)
                    k++;
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public int maxOneTwoPointer(int[] num, int k){
        int left=0, right=0, max=Integer.MIN_VALUE;
        int lastZeroIdx=-1;
        while(right<=num.length){
            if(num[right]==0){
                left=lastZeroIdx+1;
                lastZeroIdx=right;
            }
            max=Math.max(max, right-left+1);
            right++;
        }
        return max;
    }
}
