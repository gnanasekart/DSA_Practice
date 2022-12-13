package LeetCode_Daily_Practice.Sorting;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class P_M_D10_4_Merge_Intervals {
    /*
    https://leetcode.com/problems/merge-intervals/

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.
Constraints:
1 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^4
     */

    @Test
    public void ex1(){
        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
        Assert.assertEquals(merge(nums), new int[][] {{1,6},{8,10},{15,18}});
    }

    @Test
    public void ex2(){
        int[][] nums = {{1,4},{15,18}};
        Assert.assertEquals(merge(nums), new int[][] {{1,5}});
    }

    @Test
    public void ex3(){
        int[][] nums = {{1,4}};
        Assert.assertEquals(merge(nums), new int[][] {{1,4}});
    }

    @Test
    public void ex4(){
        int[][] nums = {{1,2},{3,6},{8,10},{15,18}};
        Assert.assertEquals(merge(nums), new int[][] {{1,2},{3,6},{8,10},{15,18}});
    }
//{{1,3},{2,6},{8,10},{15,18}}
    public int[][] merge(int[][] arr) {
        ArrayList<ArrayList<Integer> > list = new ArrayList<ArrayList<Integer> >();
        for(int i=0; i<arr.length-1; i++){
            if(arr[i][1]>=arr[i+1][0]){
                list.add(new ArrayList<Integer>());
                list.get(i).add(arr[i][0], arr[i+1][1]);
            } else if(arr[i][1] < arr[i+1][0]){
                list.add(new ArrayList<Integer>());
                list.get(i).add(arr[i+1][0], arr[i+1][1]);
            }
        }
        System.out.println(list);
        return new int[][]{};
    }
}
