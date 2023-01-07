package LeetCode_Daily_Practice.Binary_Search;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class P_E_First_Bad_version {
    /*
    You are a product manager and currently leading a team to develop a new product.
    Unfortunately, the latest version of your product fails the quality check.
    Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad.
Implement a function to find the first bad version. You should minimize the number of calls to the API.

Constraints:

1 <= bad <= n <= 231 - 1

     */

    @Test
    public void ex1() {
        int n=5;
        int firstBadIndex=4;
        Assert.assertEquals(badVersion(n, firstBadIndex), 4);
    }


    public boolean isBadVersion(int x, int first){
        if(x<first) return false;
        else return true;
    }

    private int badVersion(int n, int first) {
        int left=1, right=n, mid=0;
        while(left<=right){
            mid = left+(right-left)/2;
            if(isBadVersion(mid, first)==false) left=mid+1;
            else right = mid-1;
        }
        return left;
    }
}

