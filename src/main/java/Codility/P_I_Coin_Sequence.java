package Codility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_I_Coin_Sequence {
    /*
    There are N coins, each showing either heads or tails. We would like all the coins to form a sequence of
    alternating heads and tails. What is the minimum number of coins that must be reversed to achieve this?

Write a function:
Class Solution ( public int solution(int[] A);

that, given an array A consisting of N integers representing the coins, returns the minimum number of
coins that must be reversed. Consecutive elements of array A represent consecutive coins and
contain either 0 (heads) or a 1 (tail),

Examples:

1. Given array A =[1,0,1,0,1,1], the function should return 1. After reversing the sixth coin,
we achieve an alternating sequence of coins 1,0,1,0,1,0].

2. Given array A =[1,1,0,1,1], the function should return 2. After reversing the first and fifth coins,
we achieve an alternating sequence [0, 1, 0,1, 0].

3. Given array A = [0, 1, 0], the function should return 0. The sequence of coins is already alternating.

4. Given array A=(0, 1,1, 0] the function should return 2.
We can reverse the first and second coins to get the sequence: [1,0,1,0]

Assume that:

« N is an integer within the range [1.100];
« each element of array Ais an integer that can have one of the following values: 0, 1

In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
     */

    @Test
    public void ex1(){
        Assert.assertEquals(solution(new int[]{1,0,1,0,1,1}), 1);
    }

    @Test
    public void ex2(){
        Assert.assertEquals(solution(new int[]{1,1,0,1,1}), 2);
    }

    @Test
    public void ex3(){
        Assert.assertEquals(solution(new int[]{0,1,0}), 0);
    }

    @Test
    public void ex4(){
        Assert.assertEquals(solution(new int[]{0,1,1,0}), 2);
    }


    public static int solution(int[] A) {
        if (A.length > 0) {
            int count1 = 0;
            int count2 = 0;
            for (int index = 0; index < A.length; index++) {
                if (index % 2 == 0) {
                    if (A[index] == 1)
                        count1++;
                    if (A[index] == 0)
                        count2++;
                } else {
                    if (A[index] == 0)
                        count1++;
                    if (A[index] == 1)
                        count2++;
                }
            }
            return Math.min(count1, count2);
        }
        return 0;
    }
}