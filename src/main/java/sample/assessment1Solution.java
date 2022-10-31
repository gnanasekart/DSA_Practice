package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class assessment1Solution {

    /*
    https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
    No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.
    Given an integer n, return a list of two integers [A, B] where:
    A and B are No-Zero integers.
    A + B = n
    The test cases are generated so that there is at least one valid solution.
    If there are many valid solutions you can return any of them.
     */
    @Test
    public void example1() {
        int n =1010;
        Assert.assertEquals(sumoftwo(n), new int[]{11,999});
    }

    @Test
    public void example2() {
        int n = 11;
        Assert.assertEquals(sumoftwo(n), new int[]{2, 9});
    }

    @Test
    public void example3() {
        int n = 100;
        Assert.assertEquals(sumoftwo(n), new int[]{1, 99});
    }
/*
logic-
1. considering two for loop
2. first loop with start iterating from i = n-1 to i from larger to small
3. second loop iterate from 1 to n smaller to larger
4. sum both the i and j value
5. return both the value if equals to target
*/

    public int[] sumoftwo(int n) {
        if (n < 2) return new int[]{0, 1};
        int i = 0;
        while (i < n) {
            boolean A = isZero(i);
            boolean B = isZero(n-i);
            if (!A && !B){
                if (i + (n - i) == n)
                    break;
            }
            i++;
        }
        return new int[]{i, n - i};
    }

    public boolean isZero(int n) {
        while (n > 0) {
            if (n%10 == 0)
                return true;
            n=n/10;
        }
        return false;
    }
}
