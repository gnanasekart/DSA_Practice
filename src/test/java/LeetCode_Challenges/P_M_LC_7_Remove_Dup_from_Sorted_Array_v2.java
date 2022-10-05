package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class P_M_LC_7_Remove_Dup_from_Sorted_Array_v2 {
//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
    //input = 0,0,1,1,1,1,2,3,3

    @Test
    public void example2() {
        int[] arr = {0, 0, 1, 1, 1};
        int k = 4;
        Assert.assertEquals(DupArray(arr), k);
    }

    @Test
    public void example3() {
        int[] arr = {};
        int k = 0;
        Assert.assertEquals(DupArray(arr), k);
    }

    @Test
    public void example4() {
        int[] arr = {0, 0};
        int k = 2;
        Assert.assertEquals(DupArray(arr), k);
    }

    @Test
    public void example5() {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 5;
        Assert.assertEquals(DupArray(arr), k);
    }

    @Test
    public void example1() {
        int[] arr = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int k = 7;
        //output={0,0,1,1,2,3,3};
        Assert.assertEquals(DupArray1(arr), k);
    }

    private int DupArray(int[] arr) {
        if (arr.length == 0) return 0;
        int index=1, count=0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]==arr[i-1]){
                count++;
                if(count<2)
                    arr[index++]=arr[i];
            }else {
                count = 0;
                arr[index++] = arr[i];
            }
        }
    return index;
    }


    private int DupArray1(int[] arr) {
        if (arr.length == 0) return 0;
      boolean dup = false;
      int index=1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]) {
                if (!dup) {
                    arr[index++] = arr[i];
                    dup = true;
                }
            }else{
                arr[index++] = arr[i];
                dup = false;
            }
        }
    return index;
    }

}



