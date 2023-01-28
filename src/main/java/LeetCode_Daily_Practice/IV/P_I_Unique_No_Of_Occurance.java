package LeetCode_Daily_Practice.IV;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class P_I_Unique_No_Of_Occurance {
/*
Given an array of integers arr, return true if the number of
occurrences of each value in the array is unique or false otherwise.
Example 1:
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1.
No two values have the same number of occurrences.

Constraints:
1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000
*/

    @Test
    public void ex1(){
        int[] arr = {1,2,2,1,1,3};
        Assert.assertEquals(uniqueOccSet(arr), true);
    }

    @Test
    public void ex2(){
        int[] arr = {1,2};
        Assert.assertEquals(uniqueOcc(arr), false);
    }

    @Test
    public void ex3(){
        int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
        Assert.assertEquals(uniqueOcc(arr), true);
    }

    private boolean uniqueOcc(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(arr).forEach(i -> map.put(i, map.getOrDefault(i, 0)+1));
       // int[] value =map.values().stream().distinct().mapToInt(k -> k).toArray();

        Set<Integer> collect = map.values().stream().collect(Collectors.toSet());
        if(map.size()==collect.size())
            return true;
//        if(value.length==map.size())
//            return true;
        return false;
    }

    private boolean uniqueOccSet(int[] arr){
        Set<Integer> set = new HashSet<>();
        Arrays.sort(arr);
        int j=0;
        for(int i=0; i<arr.length; i++){
            j=i+1;
            while(j<arr.length && arr[i]==arr[j])
                j++;

            if(set.contains(j-i)){
                return false;
            }else{
                set.add(j-i);
                i=j-1;
            }
        }
        return true;
    }
}
