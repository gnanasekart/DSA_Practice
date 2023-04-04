package LeetCode_Daily_Practice.IV;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_M_I_Coin_Change2 {
    /*
    You are given an integer array coins representing coins of different denominations and
    an integer amount representing a total amount of money.
    Return the number of combinations that make up that amount. If that amount of money
    cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1
     */

    @Test
    public void ex1(){
        int amount = 5;
        int[] coins = {1,2,5};
        Assert.assertEquals(coins(amount, coins), 4);
    }

    public static int coins(int amt, int[] coins){
        int[] arr = new int[amt+1];
        arr[0]=1;
        for (int c: coins){
            for (int i = c; i<=amt; i++) {
                arr[i]=arr[i]+arr[i-c];
            }
        }
        return arr[amt];
    }
}
