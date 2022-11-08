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
    public void ex1() {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        Assert.assertEquals(DuplicateZero(arr), new int[]{1, 0, 0, 2, 3, 0, 0, 4});
    }


    @Test
    public void ex2() {
        int[] arr = {1, 2, 3};
        Assert.assertEquals(DuplicateZero(arr), new int[]{1, 2, 3});
    }

    @Test
    public void ex3() {
        int[] arr = {1, 0, 1, 0, 1, 0, 1, 0, 1, 0};
        Assert.assertEquals(DuplicateZero(arr), new int[]{1, 0, 0, 1, 0, 0, 1, 0, 0, 1});
    }

    @Test
    public void ex4() {
        int[] arr = {0,0,0,0,0,0,0};
        Assert.assertEquals(DuplicateZero(arr), new int[]{0,0,0,0,0,0,0});
    }

    @Test
    public void ex5() {
        int[] arr = {0, 1};
        Assert.assertEquals(DuplicateZero(arr), new int[]{0, 0});
    }

    @Test
    public void ex6() {
        int[] arr = {1, 0, 0, 1, 0, 1, 0, 0};
        Assert.assertEquals(DuplicateZero(arr), new int[]{1, 0, 0, 0, 0, 1, 0, 0});
    }

    @Test
    public void ex7() {
        int[] arr = {0,1,7,6,0,2,0,7};
        Assert.assertEquals(DuplicateZero(arr), new int[]{0,0,1,7,6,0,0,2});
    }
    //[0,1,7,6,0,2,0,7]

    /*
-if length<=1return num
1. start from left and get the count of array occurrence
2. check with the condition count==num.length
3. if a num[i] is non zero digit means count 1
4. if num[i] is zero means count 2
5. once reach the end of condition replace the num[i] to num[num.length-1] index
6. if num[i] is non zero means replace
7. if num[i] is zero means replace num[i] and num[i-1]
8. once reach start point then stop the process
*/
    public int[] DuplicateZero(int[] arr) {
        //if (arr.length == 1) return new int[]{0};
        int right = 0, count = 0, left = 1, n = arr.length - 1;

        while (right < arr.length && left > 0) {

            while(count < arr.length) {
                if (arr[right++] != 0) {
                    count++;
                } else {
                    count += 2;
                }
                left = right-1;
            }

            if (arr[left] != 0) {
                arr[n--] = arr[left--];
            } else {
                arr[n--] = arr[left];
                arr[n--] = arr[left--];
            }
        }
        return arr;
    }
}
