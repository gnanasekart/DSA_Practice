package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

//https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/

public class P_O22_1_minimum_recolor_to_get_k_black_block {
    @Test
    public void example2() {
       String s = "WBBWWBBWBW";
        int k = 7;
        Assert.assertEquals(changeColor(s, k), 3);
    }

    @Test
    public void example1() {
        String s = "WBWBBBW";
        int k = 2;
        Assert.assertEquals(changeColor(s, k), 0);
    }

    /*
1. first iteration count the W occurrence between i and k value
2. consider it as first min value
3. second iteration to consider value between k to array length
4. if i-k position are matches with condition then decrement
5. then increment if i position matches
6. return the minimum value

    */
    private int changeColor(String block, int k){
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
}
