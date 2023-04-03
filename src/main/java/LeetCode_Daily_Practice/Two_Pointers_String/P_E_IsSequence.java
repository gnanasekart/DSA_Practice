package LeetCode_Daily_Practice.Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_IsSequence {
    /*
    https://leetcode.com/problems/is-subsequence/description/
    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting
some (can be none) of the characters without disturbing the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true
*/

    @Test
    public void ex(){
        Assert.assertEquals(isSeq("abc", "ahbqdc"), true);
    }

    @Test
    public void ex1(){
        Assert.assertEquals(isSeq("abc", "ahbqdc"), true);
    }

    private boolean isSeq(String s, String t) {
        int i=0, j=0;

        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else j++;
        }
        return i==s.length();
    }
}
