package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P_E_1_Meeting_Room {
    /*
    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
    determine if a person could attend all meetings.

    leng - 1 to 100
arr = [0 to 100]
     */

    @Test
    public void example1() {
        int[][] arr = {{0,30},{5,10},{15,20}};
        Assert.assertEquals(meeting(arr), false);
    }

    @Test
    public void example2() {
        int[][] arr = {{0,2},{3,10},{5,10},{12,20},{21,22}};
        Assert.assertEquals(meeting(arr), false);
    }

    @Test
    public void example3() {
        int[][] arr = {{12,20},{3,10},{21,22},{0,2}};
        Assert.assertEquals(meeting(arr), true);
    }

    @Test
    public void example4() {
        int[][] arr = {{0,0}};
        Assert.assertEquals(meeting(arr), false);
    }

    @Test
    public void example5() {
        int[][] arr = {{0,4}};
        Assert.assertEquals(meeting(arr), true);
    }

    @Test
    public void example6() {
        int[][] arr = {{0,4},{5,10}};
        Assert.assertEquals(meeting(arr), true);
    }

    @Test
    public void example7() {
        int[][] arr = {{0,5},{5,10}};
        Assert.assertEquals(meeting(arr), false);
    }

    @Test
    public void example8() {
        int[][] arr = {{7,10},{2,4}};
        Assert.assertEquals(meeting(arr), true);
    }

    /*
    1. sort the array based on first index value
    2. compare the first/previous array start and end time
    is lesser than next array start time
    3. if the time is lesser means return true
    4. else return false
     */

    private boolean meeting(int[][] arr) {
        Arrays.sort(arr, (a,b) -> a[0]-b[0]);
        int i=0;
        while(i<arr.length-1){
            if(!(arr[i][0]<arr[i+1][0] && arr[i][1]<arr[i+1][0])){
                return false;
            }
            i++;
        }
        return true;
    }
}
