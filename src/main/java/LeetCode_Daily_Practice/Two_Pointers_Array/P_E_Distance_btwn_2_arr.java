package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class P_E_Distance_btwn_2_arr {
    /*
    https://leetcode.com/problems/find-the-distance-value-between-two-arrays/

    Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.
    The distance value is defined as the number of elements arr1[i] such that there
    is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.

        Input: arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
        Output: 2
        Explanation:
        For arr1[0]=4 we have:
        |4-10|=6 > d=2
        |4-9|=5 > d=2
        |4-1|=3 > d=2
        |4-8|=4 > d=2
        For arr1[1]=5 we have:
        |5-10|=5 > d=2
        |5-9|=4 > d=2
        |5-1|=4 > d=2
        |5-8|=3 > d=2
        For arr1[2]=8 we have:
        |8-10|=2 <= d=2
        |8-9|=1 <= d=2
        |8-1|=7 > d=2
        |8-8|=0 <= d=2

    Constraints:

    1 <= arr1.length, arr2.length <= 500
    -1000 <= arr1[i], arr2[j] <= 1000
    0 <= d <= 100
    */

    @Test
    public void ex() {
        int[] arr1 = {4, 5, 8}, arr2 = {10, 9, 1, 8};
        int d = 2;
        Assert.assertEquals(findTheDistanceValue(arr1, arr2, d), 2);
    }

    @Test
    public void ex1() {
        int[] arr1 = {1, 4, 2, 3}, arr2 = {-4, -3, 6, 10, 20, 30};
        int d = 3;
        Assert.assertEquals(findTheDistanceValue(arr1, arr2, d), 2);
    }

    @Test
    public void ex2() {
        int[] arr1 = {2, 1, 100, 3}, arr2 = {-5, -2, 10, -3, 7};
        int d = 6;
        Assert.assertEquals(findTheDistanceValue(arr1, arr2, d), 1);
    }

    public int findTheDistanceValue1(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0, j = 0, count = arr1.length;

        TreeSet<Integer> ts = new TreeSet<>();

        while (i < arr1.length && j < arr2.length) {
            if (Math.abs(arr1[i] - arr2[j]) <= d) {
                i++;
                count--;
            } else if (arr1[i] > arr2[j]) j++;
            else if (arr1[i] < arr2[j]) i++;
        }
        return count;
    }

    //O(nlogn)
    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
        int count = 0;
        TreeSet<Integer> tree = new TreeSet<>();
        for (int number : arr2) {
            tree.add(number);
        }
        for (int i = 0; i < arr1.length; i++) {
            int leftValue = arr1[i] - d;
            int rightValue = arr1[i] + d;
            Set<Integer> set = tree.subSet(leftValue, rightValue + 1);
            if (set.isEmpty())
                count += 1;
        }
        return count;
    }

    // Brute force O(n^2)
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = arr1.length;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    count -= 1;
                    break;
                }
            }
        }
        return count;
    }
}

