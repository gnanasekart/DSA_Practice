package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class P_E_O18_2_N_Double_Exist {
    /*
    leetcode.com/problems/check-if-n-and-its-double-exist/
    Given an array arr of integers, check if there exist two indices i and j such that :

    i != j
    0 <= i, j < arr.length
    arr[i] == 2 * arr[j]

    Example 1:

    Input: arr = [10,2,5,3]
    Output: true
    Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]

    Constraints:
    2 <= arr.length <= 500
    -10^3 <= arr[i] <= 10^3
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

    @Test
    public void example7(){
        int[] arr={0,0};
        Assert.assertEquals(nDoubleExist(arr), true);
    }

/*
logic-
- check if the array is less than 2 length exist or not
- traversal every array and store the value as i*2 in hashtable
- then again iterate the array to check key from hashtable match with array value
	- if matches means then return the response
	- else return default response
*/

    public boolean nDoubleExistBruteForce(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j && arr[i] == 2 * arr[j])
                    return true;

        return false;
    }
//to avoid odd number we're using a%2==0 and a/2
    //time = O(n)+O(n) => O(n)
    //space = O(n) = based on map
    private boolean nDoubleExist(int[] arr){
        if(arr.length<2) return false;
        Map<Integer, Integer> map = new HashMap();
        for(int a: arr) { // => O(n)
            if(map.containsKey(a*2) || (map.containsKey(a/2) && a%2==0)){
                return true;
            }else
                map.put(a, 1);
        }
        return false;
    }

    public boolean nDoubleExistHashset1(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i * 2) || (i % 2 == 0 && set.contains(i / 2)))
                return true;

            set.add(i);
        }
        return false;
    }

    public boolean nDoubleExistHashset2(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if(set.contains(i))
                return true;

            set.add(i*2);

            if(i%2==0)
                set.add(i/2);
        }
        return false;
    }

}