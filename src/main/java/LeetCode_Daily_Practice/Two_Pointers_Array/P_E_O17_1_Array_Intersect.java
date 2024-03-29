package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class P_E_O17_1_Array_Intersect {

    /*
    leetcode.com/problems/intersection-of-two-arrays/
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must be unique, and you may return the result in any order.
*/

    @Test
    public void example1(){
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        Assert.assertEquals(targetArray(nums1, nums2), new int[]{2});
    }

    @Test
    public void example2(){
        int[] nums1={1,2,3,4,5};
        int[] nums2={2,2,4,4,5,5,6,6};
        Assert.assertEquals(targetArray(nums1, nums2), new int[]{2,4,5});
    }

    @Test
    public void example3(){
        int[] nums1={1,2};
        int[] nums2={2,2};
        Assert.assertEquals(targetArray(nums1, nums2), new int[]{2});
    }

    @Test
    public void example4(){
        int[] nums1={1};
        int[] nums2={2,2};
        Assert.assertEquals(targetArray(nums1, nums2), new int[]{});
    }

    @Test
    public void example5(){
        int[] nums1={};
        int[] nums2={2,2};
        Assert.assertEquals(targetArray(nums1, nums2), new int[]{});
    }

    @Test
    public void example6(){
        int[] nums1={4,7,9,7,6,7};
        int[] nums2={5,0,0,6,1,6,2,4,9};
        Assert.assertEquals(targetArray(nums1, nums2), new int[]{4,6,9});
    }

/*
logic
1. validate empty array and return array/empty
2. create new array any one array memory length
3. Assign one pointer i variable to nums1 array - fast mover
4. Assign another pointer j variable to nums2 array - slow mover
5. traverse slow mover first index with fast mover index
	- matches found => get the value, increment both
	- if left < right means left++
	- else right++
6. Again continue the 5th step for another traversal to identity till all element
7. return the newly created array
*/

    public int[] intersectionBruteForce(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet();

        for(int itr = 0; itr < nums1.length; itr++){
            for(int jtr = 0; jtr < nums2.length; jtr++){
                if(nums1[itr] == nums2[jtr]){
                    set.add(nums1[itr]);
                    break;
                }
            }
        }

        int[] arr = new int[set.size()];
        int jtr = 0;
        for (int itr : set)
            arr[jtr++] = itr;

        return arr;
    }

    //time = O(n)+O(n) = O(2n) = O(n)
    //space = O(n) - based on set size
    private int[] targetArraySet(int[] nums1, int[] nums2){
        if(nums1.length <0 || nums2.length <0) return new int[]{};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet();

        int left=0, right=0, index=0;
        while(left<nums1.length && right<nums2.length ){      //=>O(n)
            if(nums1[left] == nums2[right]){
                set.add(nums2[right++]);
                left++;
            }else if(nums1[left] < nums2[right]) left++;
            else right++;
        }
        return set.stream().mapToInt(n -> n).toArray();
    }

    //without hashset
    private int[] targetArray(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int left=0, right=0, prev=Integer.MIN_VALUE;
        while(left<nums1.length && right<nums2.length){
            if(nums1[left]==prev){
                left++;
                continue;
            }
            if(nums2[right]==prev){
                right++;
                continue;
            }

            if(nums1[left]==nums2[right]){
                list.add(nums1[left]);
                prev=nums1[left];
                left++;
                right++;
                continue;
            }

            if(nums1[left]<nums2[right]){
                left++;
                continue;
            }

            if(nums1[left] > nums2[right]){
                right++;
                continue;
            }
        }

        return list.stream().mapToInt(n->n).toArray();
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=Arrays.stream(nums1).mapToObj(n -> n).collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).mapToObj(n -> n).collect(Collectors.toSet());
        set1.retainAll(set2);
        return set1.stream().mapToInt(n -> n).toArray();
    }
}
