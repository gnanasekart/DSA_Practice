package LeetCode_Daily_Practice.Sorting;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

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
        int[][] nums = {{1,3},{8,10},{2,6},{15,18}};
        Assert.assertEquals(merge2p(nums), new int[][] {{1,6},{8,10},{15,18}});
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
        //Arrays.sort(arr, (a,b) -> a[0]-b[0]);
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]) return 1;
                else if(o1[0]<o2[0]) return -1;
                return 0;
            }
        });
        ArrayList<int[]> list = new ArrayList();

        int start = arr[0][0];
        int end = arr[0][1];

        for(int i=1; i<arr.length; i++){
            if(arr[i][0]<=end){
                end=Math.max(end, arr[i][1]);
            }else {
                list.add(new int[]{start, end});
                start=arr[i][0];
                end=arr[i][1];
            }
        }
        list.add(new int[]{start, end});
       return list.toArray(new int[0][0]);
    }

    public int[][] mergeIntervalStack(int[][] arr){
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0],b[0]));

        Stack<int[]> stack = new Stack<>();
        stack.add(arr[0]);
        for (int i=1; i<arr.length; i++){
            int start2 = arr[i][0];
            int end2= arr[i][1];

            int[] stackarr = stack.pop();

            int start1=stackarr[0];
            int end1=stackarr[1];
            int end = Math.max(end1, end2);
            if(end1>=start2){
                stack.add(new int[]{start1, end});
                //stack.add(arr[i]);
            }else{
                stack.add(stackarr);
                stack.add(arr[i]);
            }
        }
        return stack.toArray(new int[0][0]);
    }

    public int[][] merge2p(int[][] arr){
        Arrays.sort(arr, (a,b) -> a[0]-b[0]);
        int j=0;
        for(int i=0; i<arr.length; i++){
            if(arr[j][1]>=arr[i][0])
                arr[j]=new int[]{arr[j][0], Math.max(arr[i][1], arr[j][1])};
            else
                arr[++j]=arr[i];
        }
        return Arrays.copyOfRange(arr, 0, j+1);
    }
}
