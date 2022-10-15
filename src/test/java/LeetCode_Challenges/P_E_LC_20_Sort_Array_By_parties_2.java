package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_LC_20_Sort_Array_By_parties_2 {
/*
Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
 */

    @Test
    public void example1(){
        int[] arr = {4,2,5,7};
        Assert.assertEquals(addTwo(arr), new int[]{4,5,2,7});
    }

    @Test
    public void example2(){
        int[] arr = {3,4};
        Assert.assertEquals(addTwo(arr), new int[]{4,3});
    }

    @Test
    public void example5(){
        int[] arr = {2,3};
        Assert.assertEquals(addTwo(arr), new int[]{2,3});
    }

    @Test
    public void example3(){
        int[] arr = {4,2,6,5,7,9};
        Assert.assertEquals(addTwo(arr), new int[]{4,5,2,7,6,9});
    }

    @Test
    public void example4(){
        int[] arr = {};
        Assert.assertEquals(addTwo(arr), new int[]{});
    }

    /*
    logic
    1. create a new array with same array size
    2. traversal entire loop and add the values into new array by following condition
        - if => value is even then add into new array and increase the index by 2
        - else => value is odd then add into new array and increase the index by 2
    3. return the new array value
     */

    private int[] addTwo(int[] arr) {
        if(arr.length==0) return new int[]{};
        int[] a = new int[arr.length];

        for(int i=0,j=1,k=0; i< arr.length;i++){
            if(arr[i]%2==0){
                a[k]=arr[i];
                k=k+2;
            }else{
                a[j]=arr[i];
                j=j+2;
            }
        }
        return a;
    }
    }

