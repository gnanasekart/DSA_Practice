package LeetCode_Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class P_O18_2_N_Double_Exist {
    /*
    leetcode.com/problems/check-if-n-and-its-double-exist/
    Given an array arr of integers, check if there exist two indices i
    and j such that :

    i != j
    0 <= i, j < arr.length
    arr[i] == 2 * arr[j]

    Example 1:

    Input: arr = [10,2,5,3]
    Output: true
    Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]

    Constraints:

    2 <= arr.length <= 500
    -103 <= arr[i] <= 103

    */
    @Test
    public void example1(){
        int[] arr={10,2,5,3};
        Assert.assertEquals(nDoubleExist(arr), true);
    }

    @Test
    public void example2(){
        int[] arr={10,2};
        Assert.assertEquals(nDoubleExist(arr), false);
    }

    @Test
    public void example3(){
        int[] arr={6,3,5,3};
        Assert.assertEquals(nDoubleExist(arr), true);
    }

    @Test
    public void example4(){
        int[] arr={1,2,3,4,5,10};
        Assert.assertEquals(nDoubleExist(arr), true);
    }

    @Test
    public void example5(){
        int[] arr={-10,12,-20,-8,15};
        Assert.assertEquals(nDoubleExist(arr), true);
    }

    @Test
    public void example6(){
        int[] arr={-2,0,10,-19,4,6,-8};
        Assert.assertEquals(nDoubleExist(arr), false);
    }

/*
logic-
- check if the array is less than 2 length exist or not
- traversal every array and store the value as i*2 in hashtable
- then again iterate the array to check key from hashtable match with array value
	- if matches means then return the response
	- else return default response
*/

    private boolean nDoubleExist(int[] arr){
        if(arr.length<2) return false;
        boolean isDouble=false;

        Map<Integer, Integer> map = new HashMap();
        for(int a: arr) map.put((2*a), a);

        int i=0;
        while(i<arr.length)
            if(map.containsKey(arr[i++]))
                return true;

        return isDouble;
    }
}