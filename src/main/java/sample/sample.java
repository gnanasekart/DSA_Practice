package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class sample {

    @Test
    public void main1() {
       int arr1[] = {11, 1, 13, 21, 3, 7};
       int arr2[] = {11, 3, 7, 1};
       Assert.assertEquals(isasubset(arr1, arr2), true);
    }

    @Test
    public void main2() {
        int arr1[] = {1, 2, 3, 4, 5, 6};
        int arr2[] = {1,2,4};
        Assert.assertEquals(isasubset(arr1, arr2), true);
    }

    @Test
    public void main3() {
        int arr1[] = {10, 5, 2, 23, 19};
        int arr2[] = {19, 5, 3};
        Assert.assertEquals(isasubset(arr1, arr2), false);
    }

    public boolean isasub(int[] arr1, int[] arr2)//-> int array not int type
     {  StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr1.length; i++) {
            stringBuilder.append(arr1[i]).append(" ");
        }
        String arr1str = stringBuilder.toString();

        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = 0; i < arr2.length; i++) {
            stringBuilder2.append(arr2[i]).append(" ");
        }
        String arr2str = stringBuilder2.toString();

        for(String c: arr2str.trim().split(" ")){
            if(arr1str.indexOf(c)<0){
                return false;
            }
        }
//        if(arr1str.contains(arr2str))
//            return true;
//        else
            return true;
    }

    public boolean isasubset(int[] arr1, int[] arr2) {
        Set<Integer> set1 = Arrays.stream(arr1).mapToObj(a -> a).collect(Collectors.toSet());
        for(int a: arr2){
            if(!set1.contains(a))
                return false;
        }
        return true;
    }
}