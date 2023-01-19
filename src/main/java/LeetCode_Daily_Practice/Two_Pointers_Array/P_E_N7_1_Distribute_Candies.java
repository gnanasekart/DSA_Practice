package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class P_E_N7_1_Distribute_Candies {
    /*
    https://leetcode.com/problems/distribute-candies/

Alice has n candies, where the ith candy is of type candyType[i].
Alice noticed that she started to gain weight, so she visited a doctor.

The doctor advised Alice to only eat n / 2 of the candies she has (n is always even).
Alice likes her candies very much, and she wants to eat the maximum number of different
types of candies while still following the doctor's advice.

Given the integer array candyType of length n, return the maximum number of different
types of candies she can eat if she only

Input: candyType = [1,1,2,2,3,3]
Output: 3
Explanation: Alice can only eat 6 / 2 = 3 candies.
Since there are only 3 types, she can eat one of each type.
input: candyType = [6,6,6,6]
Output: 1
Explanation: Alice can only eat 4 / 2 = 2 candies.
Even though she can eat 2 candies, she only has 1 type.
length = 2 to maximum

Constrains
n == candyType.length
2 <= n <= 10^4
n is even.
-10^5 <= candyType[i] <= 10^5
*/

    @Test
    public void ex1() {
        int[] type = {1, 1, 2, 2, 3, 3};
        Assert.assertEquals(candyType(type), 3);
    }

    @Test
    public void ex2() {
        int[] type = {6, 6, 6, 6};
        Assert.assertEquals(candyType(type), 1);
    }

    @Test
    public void ex3() {
        int[] type = {1, 1};
        Assert.assertEquals(candyType(type), 1);
    }

    @Test
    public void ex4() {
        int[] type = {1, 2, 3, 4};
        Assert.assertEquals(candyType(type), 2);
    }

    @Test
    public void ex5() {
        int[] type = {1, 1, 3, 4};
        Assert.assertEquals(candyType(type), 2);
    }

    @Test
    public void ex6() {
        int[] type = {100000,0,100000,0,100000,0,100000,0,100000,0,100000,0};
        Assert.assertEquals(candyType(type), 2);
    }


/*
1. check if length value is <= 1
2. collect the occurrence of candy
3. compare the occurrence is < to candy type length to return the min value
*/

    public int candyTypeSet(int[] type) {
        if (type.length < 1) return 0;
        Set<Integer> set = Arrays.stream(type).mapToObj(i -> i).collect(Collectors.toSet());
        return set.size() < type.length/2 ? set.size() : type.length/2;
    }

    public int candyTypeArray(int[] type){
        Arrays.sort(type);
        int right=0, count=1;
        while(right<type.length-2){
            if(type[right] != type[right+1])
                count++;
            right++;
        }
        return count < type.length/2 ? count : type.length/2;
    }

    public int candyType(int[] type){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < type.length; i++) {
            map.put(type[i], i);
        }
        return map.size() < type.length/2 ? map.size() : type.length/2;
    }
}
