package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_M_HR_Container_With_Most_Water {
    /*

https://leetcode.com/problems/container-with-most-water/
    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints
     of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

    Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 In this case, the max area of water (blue section) the container can contain is 49.

Constraints:

n == height.length
2 <= n <= 10^5
0 <= height[i] <= 10^4

     */

    @Test
    public void ex1(){
        int[] arr = {1,8,6,2,5,4,8,3,7};
        Assert.assertEquals(maxAreaBF(arr), 49);
    }

    @Test
    public void ex2(){
        int[] arr = {1,1};
        Assert.assertEquals(maxAreaBF(arr), 1);
    }

    @Test
    public void ex3(){
        int[] arr = {1,2,1};
        Assert.assertEquals(maxAreaBF(arr), 2);
    }

    /*
 1. start with first iteration i=0 and j=i+1
     calculate the difference between two bar by identifying the min value as bar
     calculate the min value with no of bars
     identify the max value among the bars
 */
    public int maxAreaBP(int[] h) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j <= h.length - 1; j++) {
                int val = Math.min(h[i], h[j]);
                max = Math.max(max, val * (j - i));

            }
        }
        return max;
    }

    /*
    1. start with two pointers
    2. left =0 and right=1
    3. when left<right means increment both index
    4. if left>=right means identify the min value between left and right index value
    5. calculate the min value with two bar different index
    6.
    */
    public int maxAreaBF(int[] h) {

//        int max = Integer.MIN_VALUE;
//        int left = 0, right = h.length - 1, val = 0;
//        while (right < h.length && left < h.length) {
//            if (h[left] < h[right]) {
//                //left++;
//                right++;
//            } else {
//                while (right < h.length) {
//                    val = Math.min(h[left], h[right]);
//                    max = Math.max(max, val * (right - left));
//                    System.out.println(max + " " + right + " " + left);
//                    right++;
//                }
//            }
//            left++;
//        }

        int max = Integer.MIN_VALUE;
        int left = 0, right = 1, val = 0;
        while (right < h.length && left < h.length) {
            if (h[left] < h[right]) {
                //left++;
                right++;
            } else {
                while (right < h.length) {
                    val = Math.min(h[left], h[right]);
                    max = Math.max(max, val * (right - left));
                    System.out.println(max + " " + right + " " + left);
                    right++;
                }
            }
            left++;
        }
        return max;
    }
}
