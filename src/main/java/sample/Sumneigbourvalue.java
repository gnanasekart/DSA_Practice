package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sumneigbourvalue {

    @Test
    public void example1(){
        int[] arr = {1,2,3,4,5};
        Assert.assertEquals(addIndex(arr), new int[]{3,5,7,9});
    }

    @Test
    public void example2(){
        int[] arr = {-4,-2,0,2,4};
        Assert.assertEquals(addIndex(arr), new int[]{-6,0,6});
    }

    @Test
    public void example3(){
        int[] arr = {1,1,1,1};
        Assert.assertEquals(addIndex(arr), new int[]{2,2,2});
    }
    @Test
    public void example4(){
        int[] arr = {1,1,1,1};
        int w = 3;
        Assert.assertEquals(addIndex1(arr, w), new int[]{3,3});
    }

    @Test
    public void example5(){
        int[] arr = {1};
        Assert.assertEquals(addIndex(arr), new int[]{0});
    }

    @Test
    public void example6(){
        int[] arr = {};
        Assert.assertEquals(addIndex(arr), new int[]{});
    }

    @Test
    public void example7(){
        int[] arr = {0};
        Assert.assertEquals(addIndex(arr), new int[]{});
    }

    @Test
    public void example8(){
        int[] arr = {-2, -1};
        Assert.assertEquals(addIndex(arr), new int[]{});
    }

    private int[] addIndex(int[] arr) {
        if(arr.length==0) return new int[]{};

        int[] a = new int[arr.length-1];
        for(int i=0; i<a.length; i++){
            int sum=arr[i]+arr[i+1];
            a[i]=sum;
        }
        return a;
    }

    private int[] addIndex1(int[] arr, int w) {
        int[] a = new int[(arr.length - w)+1];
        for(int i=0; i<a.length;i++){
            int sum=arr[i]+arr[i+1]+arr[i+2];
            a[i]=sum;
        }
        return a;
    }

/*
(n-m+1)*m => n*m complexity
logic
1. create an array with size array-1
2. assume to use one iteration to sum add one index with adjacent index in array
3. use two/three values using one loop and store the sum value in new array
4. once loop end reach then return the value

*/


}
