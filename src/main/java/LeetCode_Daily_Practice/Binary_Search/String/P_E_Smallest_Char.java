package LeetCode_Daily_Practice.Binary_Search.String;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_Smallest_Char {
    /*
     * PROBLEM STATEMENT
     *
     * Leetcode - 744
     *
     * Given a character array letters that is sorted in non-decreasing order
     * and a target character target, return the smallest character in the array
     * that is larger than target.
     *
     * Note that letters wrap around
     *
     * For example, if target == 'z' and letters ==['a','b'], the answer is 'a'.
     *
     *
     *
     */
    @Test
    public void example1() {
        //Positive Test Data
        char[] letters = {'c','f','j'};
        char target = 'a';
        char expected = 'c';
        Assert.assertEquals(expected,smallestLetterLargerThanTarget(letters,target));

    }

    @Test
    public void example2() {
        //Edge Case Test Data
        char[] letters = {'c','f','j'};
        char target = 'c';
        char expected = 'f';
        Assert.assertEquals(expected,smallestLetterLargerThanTarget(letters,target));
    }

    @Test
    public void example3() {
        //Negative Test Data
        char[] letters = {'a','a','a','a','a','a','a','a','a','b','b','b','b','b','b','b','b','b','c','c','c','c','c','c','c','c','d','d','d','d','d','d','d','d'};
        char target = 'b';
        char expected = 'c';
        Assert.assertEquals(expected,smallestLetterLargerThanTarget(letters,target));
    }

    //c f j
    private char smallestLetterLargerThanTarget(char[] letters, char target) {
        int left=0, right=letters.length-1, mid=0;
        while(left<=right){
            mid=(right+left)/2;//

            int diff=letters[mid]-target;

            if(diff>0) right=mid-1;
            else left=mid+1;
        }
        if(left>letters.length-1) return letters[0];
        return letters[left];
    }
}
