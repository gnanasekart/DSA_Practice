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
        while(n>0){
            if(n%10==0)
                return true;
            n=n/10;
        }
        return false;
    }

    /*
    Js Script
    solution 1

    var getNoZeroIntegers = function(n) {

    let int1 = n-1;
    let int2 = 1;

    const hasZero = int => int.toString().includes('0');

    while(hasZero(int1) || hasZero(int2)){
        int1=int1-1;
        int2=int2+1;
    }
    return [int1, int2];
    };

    solution 2

    var getNoZeroIntegers = function(n) {
        let initcheck = n-1;

        if(!initcheck.toString().includes('0')){
            return [initcheck, 1];
        }else{
            let result=[n,0];
            while(result[1] !== n){
                result[0]--;
                result[1]++;
                if(!result[1].isString().includes('0') && !result[0].isString().includes('0')){
                    return result;
                }
            }
        }
    }

    solution 3

    var getNoZeroIntegers = function(n) {
    for(let i = 0; i < n; i++) {
        if(!i.toString().includes('0') && !(n - i).toString().includes('0')) {
            return [i, n - i];
        }
    }
    return [];
};
     */
}
