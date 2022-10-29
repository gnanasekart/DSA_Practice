package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;
/*
https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B',
representing the color of the ith block. The characters 'W' and 'B'
denote the colors white and black, respectively.

You are also given an integer k, which is the desired number of consecutive black blocks.

In one operation, you can recolor a white block such that it becomes a black block.

Return the minimum number of operations needed such that there is at
least one occurrence of k consecutive black blocks.
 */


public class P_E_O22_1_minimum_recolor_to_get_k_black_block {
    @Test
    public void example2() {
       String s = "WBBWWBBWBW";
        int k = 7;
        Assert.assertEquals(changeColor1(s, k), 3);
    }

    @Test
    public void example1() {
        String s = "BWBWBBBW";
        int k = 2;
        Assert.assertEquals(minimumRecolors(s, k), 0);
    }

    /*
1. first iteration count the W occurrence between i and k value
2. consider it as first min value
3. second iteration to consider value between k to array length
4. if i-k position are matches with condition then decrement
5. then increment if i position matches
6. return the minimum value

    */
    private int changeColor1(String block, int k){
        int count=0, min=block.length(), right=0;

        while(right<k)
            if (block.charAt(right++) == 'W')
                count++;
            min=Math.min(min, count);
            for(;right<block.length();right++){
                if(block.charAt(right-k)=='W') count--;
                if(block.charAt(right)=='W') count++;
                min= Math.min(min, count);
            }
    return min;
    }

    public int changeColor(String blocks, int k) {
        int n = blocks.length(), minOps = Integer.MAX_VALUE, flips = 0, count = 0, i = 0;
        for(int j = 0; j < n; ++j) {
            if(blocks.charAt(j) == 'W') {
                flips++;
                count++;
            } else if(blocks.charAt(j) == 'B') {
                count++;
            }
            if(count == k) {
                minOps = Math.min(minOps, flips);
                if(blocks.charAt(i) == 'W') {
                    flips--;
                    count--;
                } else count--;
                i++;
            }
        }
        return minOps;
    }

    public int minimumRecolors(String blocks, int k) {

        int result=Integer.MAX_VALUE;
        int n=blocks.length();
        //i+k-1   ->  Maintain Window of Size k
        for(int i=0;i+k-1<n;i++){
            int requiredBlackBlock=0;
            //Get the currentWindow requiredBlackBlock
            for(int j=i;j<=i+k-1;j++){
                if(blocks.charAt(j)== 'W')
                    requiredBlackBlock++;
            }
            //if requiredBlackBlock = 0 -> return 0
            if(requiredBlackBlock==0)
                return 0;
            // Keep min requiredBlackBlock in result
            result=Math.min(result,requiredBlackBlock);
        }
        return result;
    }
}
