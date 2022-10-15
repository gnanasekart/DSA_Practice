package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class twoSum {

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

    private int[] addTwo(int[] arr, int target) {
        if (arr.length < 2) {
            return new int[]{};
        }

        int i = 0, j = 0;
        for (i = 0; i < arr.length; i++) {
            for (j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (sum == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{i,j};
    }

    private int[] addTwolastindex(int[] arr, int target) {
        if (arr.length < 2) {
            return new int[]{};
        }
        int[] a = new int[2];
        int i = 0, j = 0;
        for (i = 0; i < arr.length; i++) {
            for (j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (sum == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{i,j};
    }
}
