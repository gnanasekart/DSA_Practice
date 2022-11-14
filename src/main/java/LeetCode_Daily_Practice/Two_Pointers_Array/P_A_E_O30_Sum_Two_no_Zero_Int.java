package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_A_E_O30_Sum_Two_no_Zero_Int {

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
        Assert.assertEquals(twoNoZeroIntegers(n), new int[]{11,999});
    }

    @Test
    public void example2() {
        int n = 11;
        Assert.assertEquals(twoNoZeroIntegers(n), new int[]{2, 9});
    }

    @Test
    public void example3() {
        int n = 100;
        Assert.assertEquals(twoNoZeroIntegers(n), new int[]{1, 99});
    }
/*
logic-
1. considering two for loop
2. first loop with start iterating from i = n-1 to i from larger to small
3. second loop iterate from 1 to n smaller to larger
4. sum both the i and j value
5. return both the value if equals to target
*/

    //using contains
    public int[] twoNoZeroIntegers1(int n) {
        if(n<2) return new int[]{};
        int sum=0;
        for(int i=1; i<n; i++){
            if(!String.valueOf(i).contains("0") && !String.valueOf(n-i).contains("0")){
                sum = i + n-i;
                if(sum==n){
                    return new int[] {i, n-i};
                }
            }
        }
        return new int[] {};
    }

    //using while loop
    public int[] twoNoZeroIntegers2(int n) {
        if(n<2) return new int[]{};
        int sum=0;
        for(int i=1; i<n; i++){
            if(!contains(i) && !contains(n-i)){
                sum = i + n-i;
                if(sum==n)
                    return new int[] {i, n-i};
            }
        }
        return new int[] {};
    }

    public int[] twoNoZeroIntegers(int n) {
        if(n<2) return new int[]{};
        n--;
        int i=1;
        while(contains(i)==true || contains(n)==true){
            i++;
            n--;
        }
        return new int[]{i ,n};
    }

    public boolean contains(int n){
        while(n!=0){
            if(n%10==0)
                return true;
            n=n/10;
        }
        return false;
    }
}
