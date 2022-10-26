package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_O17_Two_Sum {

    @Test
    public void example1(){
        int[] arr = {2,3,5,6,9};
        int target=15;
        Assert.assertEquals(addTwo(arr, target), new int[]{3,4});
    }

    @Test
    public void example2(){
        int[] arr = {2};
        int target=15;
        Assert.assertEquals(addTwo(arr, target), new int[]{});
    }

    @Test
    public void example3(){
        int[] arr = {2,3,5,7,9};
        int target=12;
        Assert.assertEquals(addTwo(arr, target), new int[]{2,3});
        //1,4 2,3
    }

    @Test
    public void example4(){
        int[] arr = {2,3,5,7,9};
        int target=20;
        Assert.assertEquals(addTwo(arr, target), new int[]{0,0});
        //1,4 2,3
    }

    //time = O(n^2)
    //space = O(n) it create new int when for loop valid
    //for first index
    private int[] addTwo1(int[] arr, int target) {
        if (arr.length < 2) return new int[]{};

        int i = 0, j = 0;
        for (i = 0; i < arr.length; i++) {
            for (j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (sum == target)
                    return new int[]{i,j};
            }
        }
        return new int[]{i,j};
    }

    /*
    logic
    1. check the input array is empty or less < 2 then return empty
    2. create an array to store new index values
    3. traversal in for loop to sum to different index values
        - if => sum is equal to target then get the index values
        - iterate the loop
    4. return the final executed values
     */

    //for all cases
    private int[] addTwo(int[] arr, int target) {
        if (arr.length < 2) return new int[]{};

        int[] a = new int[2];
        int i = 0, j = 0;
        for (i = 0; i < arr.length; i++) {
            for (j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (sum == target) {
                    a[0]=i;
                    a[1]=j;
                }
            }
        }
        return a;
    }
}
