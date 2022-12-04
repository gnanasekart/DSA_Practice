package BinarySearch;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Kth_Missing_Positive_Int {

    /*
    Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
    Return the kth positive integer that is missing from this array.
    Example 1:

    Input: arr = [2,3,4,7,11], k = 5
    Output: 9
    Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...].
    The 5th missing positive integer is 9.

Linear approach
  0   1   2   3   4
| 1 | 3 | 7 | 9 | 11 |
  L

   R
 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 |
k= 5   4   4   3   2   1   1   0

     */

    @Test
    public void example1() {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(missingInteger(arr, k));
    }

    @Test
    public void example2() {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 5;
        System.out.println(missingInteger(arr, k));
    }

    @Test
    public void example3() {
        int[] arr = {1, 3, 5, 6};
        int k = 7;
        System.out.println(missingInteger(arr, k));
    }

    private int missingInteger1(int[] arr, int k) {
        int low = 1, high = arr.length - 1;
        if (k <= 1) return 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] - mid > k) high = mid - 1;
            else low = mid + 1;
        }
        return low + k;
    }

    public int missingInteger(int[] arr, int k) {
//        int i=1;
//        while(k>0){
//            if( == i){
//                k--;
//            }
//            i++;
//        }
        return 1;

    }

    @Test
    public void example() {
        String[] arr = {"h", "e", "l", "l", "o"};
        String[] out = {"o", "l", "l", "e", "h"};
        recursionS(arr);
        Assert.assertEquals(arr, out);
        //Assert.assertEquals(recursionS(arr), out);
    }

    public void recursionS(String[] arr) {

         reverseString(arr, 0);
    }

    public void reverseString(String[] arr, int i) {
        int left = i, right = arr.length - left - 1;
        String temp = "";
        if (left > arr.length/2) {
            return ;
        }
            right = arr.length - left - 1;
            temp = arr[left];
            arr[left++] = arr[right];
            arr[right] = temp;
            reverseString(arr, left);
    }


}