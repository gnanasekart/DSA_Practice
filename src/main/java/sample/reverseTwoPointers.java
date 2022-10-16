package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class reverseTwoPointers {

    @Test
    public void example1(){
        int[] arr={1,2,3,4,5};
        int[] out={5,4,3,2,1};
        Assert.assertEquals(reverseArray(arr), out);
    }

    @Test
    public void example2(){
        int[] arr={1,2,3};
        int[] out={3,2,1};
        Assert.assertEquals(reverseArray(arr), out);
    }

    @Test
    public void example3(){
        int[] arr={1,2};
        int[] out={2,1};
        Assert.assertEquals(reverseArray(arr), out);
    }

    @Test
    public void example4(){
        int[] arr={1};
        int[] out={1};
        Assert.assertEquals(reverseArray(arr), out);
    }

    @Test
    public void example5(){
        int[] arr={};
        int[] out={};
        Assert.assertEquals(reverseArray(arr), out);
    }

/*
1. take two pointers left and right
2. check both pointer is less than array length
3. then swap until condition fails

*/

private int[] reverseArray(int[] arr){
        if(arr.length<2) return arr;

        int left=0, right=arr.length-1;

        while(left<right){
            arr[left]= arr[left]+arr[right];
            arr[right]=arr[left]-arr[right];
            arr[left]=arr[left++]-arr[right--];
        }
        return arr;
    }
}
