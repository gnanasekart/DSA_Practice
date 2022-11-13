package LeetCode_Daily_Practice.String.Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_N9_2_Fair_Candy_Swap {
    /*
leetcode.com/problems/fair-candy-swap/

Alice and Bob have a different total number of candies. You are given two integer arrays
aliceSizes and bobSizes where aliceSizes[i] is the number of candies of the ith box of candy
that Alice has and bobSizes[j] is the number of candies of the jth box of candy that Bob has.

Since they are friends, they would like to exchange one candy box each so that after
the exchange, they both have the same total amount of candy. The total amount of candy
a person has is the sum of the number of candies in each box they have.

Return an integer array answer where answer[0] is the number of candies in the box
that Alice must exchange, and answer[1] is the number of candies in the box that Bob
must exchange. If there are multiple answers, you may return any one of them.
It is guaranteed that at least one answer exists.

Constraints:
1 <= aliceSizes.length, bobSizes.length <= 10^4
1 <= aliceSizes[i], bobSizes[j] <= 10^5
Alice and Bob have a different total number of candies.
There will be at least one valid answer for the given input.
*/

    @Test
    public void ex1() {
        int[] a = {1, 1};//2, 4 = 6/a[i].length = 3    //   3-2 = 1,   4-2 = 2
        int[] b = {2, 2};
        Assert.assertEquals(candyBox(a, b), new int[]{1, 2});
    }

    @Test
    public void ex2() {
        int[] a = {1, 2};//3,5 = 8/2 = 4  // 4-3=1, 5-3 =2
        int[] b = {2, 3};
        Assert.assertEquals(candyBox(a, b), new int[]{1, 2});
    }

    @Test
    public void ex3() {
        int[] a = {2};//2, 4 = 6/2 = 3 // 3-2 = 1,   3-0 = 3
        int[] b = {1, 3};
        Assert.assertEquals(candyBox(a, b), new int[]{2, 3});
    }

    @Test
    public void ex4() {
        int[] a = {1, 2, 5};
        int[] b = {2, 4};
        Assert.assertEquals(candyBox(a, b), new int[]{1, 2});
    }

    public int[] candyBox1(int[] aa, int[] bb) {
        if (aa.length < 1 || bb.length < 1) return new int[]{};
        int suma = 0, sumb = 0, diff = 0;
        for (int a : aa) suma += a;
        for (int b : bb) sumb += b;

        for (int i = 0; i < aa.length; i++) {
            for (int j = 0; j < bb.length; j++) {
                if (suma - aa[i] + bb[j] == sumb - bb[j] + aa[i])
                    return new int[]{aa[i], bb[j]};
            }
        }
        return null;
    }

    public int[] candyBox(int[] A, int[] B) {
        int sa = 0, sb = 0;
        for (int i = 0; i < A.length; i++)
            sa += A[i];
        for (int i = 0; i < B.length; i++)
            sb += B[i];
        int diff = (sa - sb) / 2;
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < B.length; j++)
                if (A[i] - B[j] == diff)
                    return new int[]{A[i], B[j]};
        return null;
    }
}
