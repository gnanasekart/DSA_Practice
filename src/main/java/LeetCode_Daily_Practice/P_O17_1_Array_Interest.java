package LeetCode_Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_O17_1_Array_Interest {

    /*
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must be unique and you may return the result in any order.
Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

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

    //time = O(n)+O(n) = O(2n) = O(n)
    //space = O(n) - based on set size
    private int[] targetArray(int[] nums1, int[] nums2){
        if(nums1.length <0 || nums2.length <0) return new int[]{};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet();

        int left=0, right=0, index=0;
        while(left<nums1.length && right<nums2.length ){      //=>O(n)
            if(nums1[left] == nums2[right]){
                set.add(nums2[right++]);
                left++;
            }else if(nums1[left] < nums2[right])
                left++;
            else right++;
        }

        int[] arr = new int[set.size()];
        for(Integer a: set)    //=>  O(n)
            arr[index++]=a;

        return arr;
    }
}
