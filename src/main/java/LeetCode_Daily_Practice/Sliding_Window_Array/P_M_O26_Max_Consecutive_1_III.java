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
        Assert.assertEquals(maxOne(num, k), 6);
    }

    @Test
    public void example2(){
        int[] num={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=3;
        Assert.assertEquals(maxOne(num, k), 10);
    }

    @Test
    public void example3(){
        int[] num={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=0;
        Assert.assertEquals(maxOne(num, k), 4);
    }

    //@Test
    public void example4(){
        int[] num={0,0,1,1,0,1,1,1,0,1,1,0,0,0,1,1};
        int k=3;
        Assert.assertEquals(maxOne(num, k), 4);
    }

    @Test
    public void example5(){
        int[] num={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=8;
        Assert.assertEquals(maxOne(num, k), num.length);
    }

    @Test
    public void example6(){
        int[] num={1,1,1,0,0,0,1,1,1,1,0};
        int k=10;
        Assert.assertEquals(maxOne(num, k), num.length);
    }

    @Test
    public void example7(){
        int[] num={1,1,1};
        int k=1;
        Assert.assertEquals(maxOne(num, k), 3);
    }

    @Test
    public void example8(){
        int[] num={0};
        int k=0;
        Assert.assertEquals(maxOne(num, k), 0);
    }

    @Test
    public void example9(){
        int[] num={0};
        int k=1;
        Assert.assertEquals(maxOne(num, k), 1);
    }

    /*
1. consider first iteration start with i=0 till the array end
2. if i==1 then continue or increment count
3. if i==0 then decrement k and move next
4. in between k<0 then check for left value ==0
5. then increment k and left
6. get the maximum difference between left and right as max value
6. once reaches the end then return the max value
*/

    private int left, max,i;
    public int maxOne(int[] num, int k) {
        int max=1;
        for (int i = 0, left=0; i < num.length; i++) {
            if (num[i] == 1) continue;
            if (num[i] == 0) k--;

            while (k < 0 && left<=i) {
                if(num[left] == 0)
                    k++;

                left++;
            }
            max=Math.max(max, i-left+1);
        }
        return max;
    }
}
