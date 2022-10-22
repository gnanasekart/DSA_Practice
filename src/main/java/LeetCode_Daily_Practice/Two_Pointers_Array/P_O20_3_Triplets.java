package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_O20_3_Triplets {
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
    public void example1(){
        int[] arr={0,1,4,6,7,10};
        int diff=3;
        Assert.assertEquals(triplet(arr, diff), 2);
    }

    @Test
    public void example2(){
        int[] arr={4,5,6,7,8,9};
        int diff=2;
        Assert.assertEquals(triplet(arr, diff), 2);
    }

    @Test
    public void example3(){
        int[] arr={4,5,6,7,8};
        int diff=1;
        Assert.assertEquals(triplet(arr, diff), 3);
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
    private int triplet(int[] arr, int diff){
        if(arr.length<3) return 0;

        int count=0;
        for(int i=0; i<arr.length; i++) {
            int j=i+1, k=j+1;
            while (j<arr.length && k<arr.length) {
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
}
