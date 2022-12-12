package LeetCode_Daily_Practice.Sorting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_D_10_Height_Check {
    /*
    A school is trying to take an annual photo of all the students. The students are asked to stand
    in a single file line in non-decreasing order by height. Let this ordering be represented by the
    integer array expected where expected[i] is the expected height of the ith student in line.

You are given an integer array heights representing the current order that the students are standing in.
 Each heights[i] is the height of the ith student in line (0-indexed).

Return the number of indices where heights[i] != expected[i].

Example 1:

Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation:
heights:  [1,1,4,2,1,3]
expected: [1,1,1,2,3,4]
Indices 2, 4, and 5 do not match.
     */

    @Test
    public void ex1(){
        int[] arr = {1,1,4,2,1,3};
        Assert.assertEquals(heightChecker(arr), 3);
    }

    @Test
    public void ex2(){
        int[] arr = {5,1,2,3,4};
        Assert.assertEquals(heightChecker(arr), 5);
    }

    @Test
    public void ex3(){
        int[] arr = {1,2,3,4,5};
        Assert.assertEquals(heightChecker(arr), 0);
    }

    @Test
    public void ex4(){
        int[] arr = {1};
        Assert.assertEquals(heightChecker(arr), 0);
    }

    public int heightChecker(int[] h) {
        int[] input = h.clone();
        int i=0, j=0, temp=0, count=0;
        for(i=0; i<h.length; i++){
            for(j=0; j<h.length-1; j++){
                if(h[j]>h[j+1]){
                    temp=h[j];
                    h[j]=h[j+1];
                    h[j+1]=temp;
                }
            }
        }

        for(int k=0; k<h.length; k++){
            if(input[k]!=h[k])
                count++;
        }
        return count;
    }
}
