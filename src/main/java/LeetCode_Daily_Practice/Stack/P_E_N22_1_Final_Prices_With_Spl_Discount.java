package LeetCode_Daily_Practice.Stack;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class P_E_N22_1_Final_Prices_With_Spl_Discount {
    /*
    https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/

You are given an integer array prices where prices[i] is the price of the ith item in a shop.

There is a special discount for items in the shop.
If you buy the ith item, then you will receive a discount equivalent to prices[j]
where j is the minimum index such that j > i and prices[j] <= prices[i].
Otherwise, you will not receive any discount at all.

Return an integer array answer where answer[i] is the final price you will pay for
the ith item of the shop, considering the special discount.

Example1
Input: prices = [8,4,6,2,3]
Output: [4,2,4,2,3]

4<=8 = 8-4 = 4
2<=4 = 4-2 = 2
2<=6 = 6-2 = 4

For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4,
therefore, the final price you will pay is 8 - 4 = 4.

For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2,
 therefore, the final price you will pay is 4 - 2 = 2.
For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2,
    therefore, the final price you will pay is 6 - 2 = 4.
For items 3 and 4 you will not receive any discount at all.

Constraints:
1 <= prices.length <= 500
1 <= prices[i] <= 1000

*/

    @Test
    public void example1() {
        int[] prices = {8, 4, 6, 2, 3};
        Assert.assertEquals(discount(prices), new int[]{4, 2, 4, 2, 3});
    }

    @Test
    public void example2() {
        int[] prices = {10, 1, 1, 6};
        Assert.assertEquals(discount(prices), new int[]{9, 0, 1, 6});
    }

    @Test
    public void example3() {
        int[] prices = {2, 4, 4, 3, 1, 9};
        Assert.assertEquals(discount(prices), new int[]{1, 0, 1, 2, 1, 9});
    }

    @Test
    public void example4() {
        int[] prices = {2, 4, 4, 3, 1, 1};
        Assert.assertEquals(discount(prices), new int[]{1, 0, 1, 2, 0, 1});
    }

    @Test
    public void example5() {
        int[] prices = {2};
        Assert.assertEquals(discount(prices), new int[]{2});
    }

    @Test
    public void example6() {
        int[] prices = {2, 4, 6, 8, 9};
        Assert.assertEquals(discount(prices), new int[]{2, 4, 6, 8, 9});
    }

    @Test
    public void example7() {
        int[] prices = {8, 7, 4, 2, 8, 1, 7, 7, 10, 1};
        Assert.assertEquals(discount(prices), new int[]{1, 3, 2, 1, 7, 0, 0, 6, 9, 1});
    }

/*
1. consider two for loop
2. first loop i =0
3. second loop j=i+1
4. check for condition p[j]<=p[i]
		p[i] = calculate p[i]-p[j];
		then increment i and j
	else increment j and compare the same
5. return input array
*/

    public int[] discount(int[] p) {
        if (p.length <= 1) return p;

        for (int i = 0; i < p.length; i++) {
            for (int j = i + 1; j <= p.length - 1; j++) {
                if (p[j] <= p[i]) {
                    p[i] = p[i] - p[j];
                    break;
                } else {
                    continue;
                }
            }
        }
        return p;
    }

    public int[] discounts(int[] p) {
        if (p.length <= 1) return p;

        Queue<Integer> q = new ArrayDeque();
        return p;
    }

}
