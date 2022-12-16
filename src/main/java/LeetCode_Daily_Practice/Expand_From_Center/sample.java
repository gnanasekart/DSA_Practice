package LeetCode_Daily_Practice.Expand_From_Center;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class sample {
/*
{ 3, 6, 2, 8, 7, 6, 5, 9 } and k = 2

find the number of x elements in the array such that its x+k also present

-ve number
k>0
n=1 to x

 */
    @Test
    public void ex1(){
       int[] arr= { 3, 6, 2, 8, 7, 6, 5, 9 };
       int k=2;
        Assert.assertEquals(arraw(arr, k), 5);
}

    private int arraw(int[] arr, int k) {
      //  new ArrayList<>(arr.length);
        List<Integer> list = Arrays.stream(arr).mapToObj(i -> i).collect(Collectors.toList());//o(n)
        int count=0;
        for(int i=0; i<arr.length; i++){//o(n)
            if(list.contains(arr[i]+k)){
                count++;
            }
        }
        return count;
    }

    @Test
    public void ex2(){
        int[][] arr= {{1,3},{2,2},{3,1}};
        int k=4;
        Assert.assertEquals(maximumUnits(arr, k), 8);
    }

    @Test
    public void ex3(){
        int[][] arr= {{5,10},{2,5},{4,7},{3,9}};
        int k=10;
        Assert.assertEquals(maximumUnits(arr, k), 91);
    }

    public int maximumUnits(int[][] box, int truckSize) {
        int sum=0, j=0, k=0, count=0;

        for(int[] bx: box){
            j=bx[0];
            k=bx[1];
            count=0;
            if(truckSize==0){
                return sum;
            } else {
                if(truckSize-j<0) {
                    while(truckSize>0) {
                        truckSize--;
                        count++;
                    }
                    sum+=count*k;
                }else if(truckSize-j>0){
                    truckSize-=j;
                    sum+=j*bx[1];
                }
            }
        }
        return sum;
    }
    }
