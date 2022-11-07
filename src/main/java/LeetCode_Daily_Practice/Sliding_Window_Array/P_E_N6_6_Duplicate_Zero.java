package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_N6_6_Duplicate_Zero {
    /*
https://leetcode.com/problems/duplicate-zeros/
Given a fixed-length integer array arr, duplicate each occurrence of zero,
shifting the remaining elements to the right.
Note that elements beyond the length of the original array are not written.
Do the above modifications to the input array in place and do not return anything.

Input: arr = [1,0,2,3,0,4,5,0]
Output: [1,0,0,2,3,0,0,4]
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]


Constraints:
1 <= arr.length <= 10^4
0 <= arr[i] <= 9

*/
    
    @Test
    public void ex(){
        int[] s = {1,0,2,3,0,4,5,0};
        Assert.assertEquals(duplicateZero(s), new int[]{1,0,0,2,3,0,0,4});
    }



    @Test
    public void ex1(){
        int[] s = {1,2,3};
        Assert.assertEquals(duplicateZero(s), new int[]{1,2,3});
    }


    private int[] duplicateZero(int[] s) {
        return new int[]{1};
    }

}
