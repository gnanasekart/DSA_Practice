package LeetCode_Daily_Practice.IV;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_CI_E_Climbing_Stairs {
    /*

    You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:

1 <= n <= 45

     */

    @Test
    public void ex1(){
        int n = 3;
        Assert.assertEquals(climbStairs(n), 3);
    }

    @Test
    public void ex2(){
        int n = 5;
        Assert.assertEquals(climbStairs(n), 8);
    }

    @Test
    public void ex3(){
        int n =44;
        Assert.assertEquals(climbStairs(n), 1134903170);
    }

    private int climbStairs1(int n) {

        if(n<=1) return 1;

       int res = climbStairs(n-1)+climbStairs(n-2);
        //System.out.println(res);
        return res;

    }

    private int climbStairs(int n) {
        int[] dp = new int[n+1];

        dp[1]=1;
        dp[2]=2;

        for(int i=3; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];

    }
}

