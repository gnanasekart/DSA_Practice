package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P_LC_2_Remove_Dup_from_Sorted_Array {
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    //0,0,1,1,1,2,2,3,3,4

    @Test
    public void example1(){
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int k = 5;
        Assert.assertEquals(DupArray(arr), k);
    }

    @Test
    public void example2(){
        int[] arr = {0,0,1,1,1};
        int k = 2;
        Assert.assertEquals(DupArray(arr), k);
    }

    @Test
    public void example3(){
        int[] arr = {};
        int k = 0;
        Assert.assertEquals(DupArray(arr), k);
    }

    @Test
    public void example4(){
        int[] arr = {0,0};
        int k = 1;
        Assert.assertEquals(DuparrayStream(arr), k);
    }

    private int DupArray(int[] arr) {

        if(arr.length==0) return 0;
        int index=1;

        for (int i = 1; i < arr.length; i++)
            if(arr[i] != arr[i-1])
                arr[index++]=arr[i];
        return index;
    }

    private int DuparrayStream(int[] arr){
       return (int) Arrays.stream(arr).distinct().count();

    }
}
