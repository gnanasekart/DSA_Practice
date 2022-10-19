package LeetCode_Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_O20_2_Intersection_Array_v2 {

    /*
https://leetcode.com/problems/intersection-of-two-arrays-ii/
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must appear as many times as it shows in both arrays
and you may return the result in any order.

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

    @Test
    public void example1(){
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        Assert.assertEquals(intersectArrayMaxAppear(nums1, nums2), new int[]{2,2});
    }

    @Test
    public void example2(){
        int[] nums1={4,9,5};
        int[] nums2={9,4,9,8,4};
        Assert.assertEquals(intersectArrayMaxAppear(nums1, nums2), new int[]{4,9});
    }

    @Test
    public void example3(){
        int[] nums1={4,9,5,3,2,1};
        int[] nums2={6,7,8};
        Assert.assertEquals(intersectArrayMaxAppear(nums1, nums2), new int[]{});
    }

    @Test
    public void example4(){
        int[] nums1={2,2,2,2,2,2,4};
        int[] nums2={1,4};
        Assert.assertEquals(intersectArrayMaxAppear(nums1, nums2), new int[]{4});
    }

/*
- check the condition for empty
- create an arraylist
- consider two pointers for both the array
- if both the array value matches then add into arraylist
- else increment one array pointer
- return the arraylist to array
*/

    private int[] intersectArrayMaxAppear(int[] n1, int[] n2){
        if(n1.length<1 && n2.length<1) return new int[]{};
        int left=0, right=0, i=1;;
        Arrays.sort(n1);
        Arrays.sort(n2);
        HashMap<Integer, Integer> map= new HashMap<>();
        int count=0;
        while( left<n1.length && right<n2.length){
            if(n1[left] < n2[right]){
                left++;
            }else if(n1[left] > n2[right]){
                right++;
            }else {
                if(!map.containsKey(n1[left])){
                    map.put(n1[left], map.getOrDefault(n1[left], 0)+1);
                    left=0;
                    right++;
                }else
                    left++;
            }
        }

        int[] arr=new int[map.size()];
        int j=0;
        for(Map.Entry<Integer, Integer> a: map.entrySet())
            arr[j++]=a.getKey();

        return arr;
    }
}
