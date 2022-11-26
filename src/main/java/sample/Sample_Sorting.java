package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Sample_Sorting {


    @Test
    public void example1(){
        int[] arr = {9,2,3,6,5,6,2,1,9};
        Assert.assertEquals(sortArray(arr), new int[]{1,2,2,3,5,6,6,9,9});
    }

    @Test
    public void example2(){
        int[] arr = {3,7,8,9,1,2,3,3,3,0};
        Assert.assertEquals(sortArray(arr), new int[]{0,1,2,3,3,3,3,7,8,9});
    }


    @Test
    public void example3(){
        int[] arr = {-4,-2,4,6,-1,0};
        Assert.assertEquals(sortArray(arr), new int[]{-4,-2,-1,0,4,6});
    }

    @Test
    public void example4(){
        int[] arr = {2,2,2,2};
        Assert.assertEquals(sortArray(arr), new int[]{2,2,2,2});
    }

    @Test
    public void example5(){
        int[] arr = {1};
        Assert.assertEquals(sortArray(arr), new int[]{1});
    }

    @Test
    public void example6(){
        int[] arr = {};
        Assert.assertEquals(sortArray(arr), new int[]{});
    }

    @Test
    public void example7(){
        int[] arr = {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9};
        Assert.assertEquals(sortArray(arr), new int[]{1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,4,4,4,4,4,5,5,5,5,5,6,6,6,6,6,7,7,7,7,7,8,8,8,8,8,9,9,9,9,9});
    }
/*
logic
1. assume to use two iteration to compare two values in array
2. first iteration use one value
3. second iteration use another value
4. compare each value as value 1 < 2
5. then swap the values once condition correct
6. iteration will continue until the loop end
7. once loop end reach then the value are in sorteded order

*/

    public int[] sortArray(int[] arr){

        if(arr.length < 1) return new int[]{};

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]>arr[j]){
//                    int temp=arr[i];
//                    arr[i]=arr[j];
//                    arr[j]=temp;

                    arr[i]=arr[i]+arr[j];
                    arr[j]=arr[i]-arr[j];
                    arr[i]=arr[i]-arr[j];
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {3,5,8,1,2,0,6,4};

        int[] arr1 = {};

        Arrays.sort(arr);
        System.out.println(arr);
        int[] prod = new int[3];
        int last = arr.length-1;

            int p1 = arr[0]*arr[1];
            int p2 = arr[last-1]*arr[last-2];

            if(p1 > p2){
                prod[0]=arr[0];
                prod[1]=arr[1];
            }else if(p2>p1){
                prod[0]=arr[last-1];
                prod[1]=arr[last-2];
            }
        prod[2]=arr[last];
    }
}
