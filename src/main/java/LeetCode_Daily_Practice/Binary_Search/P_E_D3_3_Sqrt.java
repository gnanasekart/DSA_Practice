package LeetCode_Daily_Practice.Binary_Search;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_D3_3_Sqrt {
    /*
    https://leetcode.com/problems/sqrtx/
    Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
     The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

Constraints:
0 <= x <= 2^31 - 1

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer.
2 is returned.

     */

    @Test
    public void ex1() {
        int a = 4;
        Assert.assertEquals(sqroot(a), 2);
    }

    @Test
    public void ex2() {
        int a = 8;
        Assert.assertEquals(sqroot(a), 2);
    }

    @Test
    public void ex3() {
        int a = 29;
        Assert.assertEquals(mySqrt(a), 5);
    }

    @Test
    public void ex4() {
        int a = 1;
        Assert.assertEquals(sqroot(a), 1);
    }

    @Test
    public void ex5() {
        int a = 0;
        Assert.assertEquals(sqroot(a), 0);
    }
    //

    @Test
    public void ex6() {
        int a = 2147395599;
        Assert.assertEquals(mySqrt(a), 46339);
    }

    private int sqroot1(int a) {
        int low=1, high=a, ans=0, mid=0;

        while(low<=high){
            mid=(low+high)/2;
            if(mid<=a/mid){
                low=mid+1;
                ans=mid;
            }else if(mid>a/mid){
                high=mid-1;
            }
        }
        return ans;
    }

    private int sqroot2(int a) {
        int low=1, high=a, ans=0, mid=0;
        while(low<=high){
            mid=(high+low)/2;
            if(mid*mid<=a){
                low=mid+1;
                ans=mid;
            }else if(mid*mid>a){
                high=mid-1;
            }
        }
        return ans;
    }

    private int sqroot(int a) {
        if(a<=1) return a;
        int low=1, high=a/2, ans=0, mid=1;
        while(low<=high){
            mid=low+(high-low)/2;

            if(mid==a/mid) return mid;
            else if(mid<a/mid) low=mid+1;
            else if(mid>a/mid) high=mid-1;
        }
        return high;
    }

    //buteforce
    public int mySqrt(int a) {
        if(a<=1) return a;
        int ans=0;
        for(int i=1; i<=a/2; i++){
            if(!(i<=a/i)){
                break;
            }else ans=i;
        }
        return ans;
    }
}
