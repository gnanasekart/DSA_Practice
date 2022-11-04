package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class P_E_O20_3_Triplets {
    /*
        https://leetcode.com/problems/number-of-arithmetic-triplets/

        You are given a 0-indexed, strictly increasing integer array nums and
        a positive integer diff. A triplet (i, j, k) is an arithmetic triplet
         if the following conditions are met:

         i < j < k,
       nums[j] - nums[i] == diff, and
        nums[k] - nums[j] == diff.
        Return the number of unique arithmetic triplets.

                Constraints:
                3 <= nums.length <= 200
                0 <= nums[i] <= 200
                1 <= diff <= 50
        nums is strictly increasing.
    */
    @Test
    public void example1() {
        int[] arr = {0, 1, 4, 6, 7, 10};
        int diff = 3;
        Assert.assertEquals(tripletTwoPointer(arr, diff), 2);
    }

    @Test
    public void example2() {
        int[] arr = {4, 5, 6, 7, 8, 9};
        int diff = 2;
        Assert.assertEquals(tripletHashSet(arr, diff), 2);
    }

    @Test
    public void example3() {
        int[] arr = {4, 5, 6, 7, 8};
        int diff = 1;
        Assert.assertEquals(tripletHashSet(arr, diff), 3);
    }

    /*
    1. consider three variable i,j,k for different loops
    2. start i from 0th indexed
    3. start j from i+1th place
        - if different between i-j is equal stop j at that index
        - else increment j position
            - start from k=i+2 index and find diff as i-k=2*diff
            - else k increment
    4. store the three index values in an array or count the occurrence
    5. return the number of occurrence

    */
    private int tripletBF(int[] arr, int diff) {
        if (arr.length < 3) return 0;

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1, k = j + 1;//this j, k act as another two for loop
            while (j < arr.length && k < arr.length) {
                if (arr[j] - arr[i] != diff) {
                    j++;
                } else if (arr[j] - arr[i] == diff) {
                    if (arr[k] - arr[i] != (diff * 2)) {
                        k++;
                    } else {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }

    private int tripletTwoPointer(int[] arr, int diff) {
        if (arr.length < 3) return 0;
        int count = 0;
        int left = 0, right = 0;
        for (int i = 0; i < arr.length; i++) {
            left = i + 1;
            right = arr.length - 1;
            while (left < right) {
                if ((arr[left] - arr[i] == diff) && arr[right] - arr[left] == diff) {
                    count++;
                    left++;
                    right--;
                } else if (arr[left] - arr[i] != diff) left++;
                else if ((arr[right] - arr[left] != diff)) right--;
                else {
                    left++;
                    right++;
                }
            }
        }
        return count;
    }

    public int tripletHashMap(int[] arr, int diff) {
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        Arrays.stream(arr).forEach(a -> map.put(a, 1));

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] + diff) && map.containsKey(arr[i] + 2 * diff))
                count++;
        }
        return count;
    }

    public int tripletHashSet(int[] arr, int diff) {
        int count = 0;
        Set<Integer> set = new HashSet<>();

        for (Integer a : arr) {
            if (set.contains(a + diff) && set.contains(a + 2 * diff))
                count++;

            set.add(a);
        }
        return count;
    }

//    public int tripletHashStream(int[] arr, int diff){
//        AtomicInteger count= new AtomicInteger();
//        HashMap<Integer,Integer> map=new HashMap<>();
//
//        Arrays.stream(arr).forEach(a -> map.put(a,1));
//
//        IntConsumer op = a -> {
//            if (map.containsKey(a + diff) && map.containsKey(a + 2 * diff))
//                count.getAndIncrement();
//        };
//        Arrays.stream(arr).map(a -> map.put(a,1)).forEach(op);
//        return (int)Arrays.stream(arr).map(a -> map.put(a,1))
//                .filter(ar -> (map.containsKey(ar + diff) && map.containsKey(ar + 2 * diff)))
//                .count();
//    }
}
