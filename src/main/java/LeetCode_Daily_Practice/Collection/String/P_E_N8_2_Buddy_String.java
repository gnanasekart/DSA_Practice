package LeetCode_Daily_Practice.Collection.String;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashSet;
import java.util.Set;

public class P_E_N8_2_Buddy_String {
    /*
    https://leetcode.com/problems/buddy-strings/

    Given two strings s and goal, return true if you can swap two letters in s
    so the result is equal to goal, otherwise, return false.

    Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j
    and swapping the characters at s[i] and s[j].

    Constraints:
    1 <= s.length, goal.length <= 2 * 10^4
    s and goal consist of lowercase letters.
     */
    @Test
    public void ex1() {
        String s = "abcd";
        String goal = "badc";
        Assert.assertEquals(buddyStrings(s, goal), false);
    }

    @Test
    public void ex6() {
        String s = "abcd";
        String goal = "cbad";
        Assert.assertEquals(buddyStrings(s, goal), true);
    }

    @Test
    public void ex2() {
        String s = "aa";
        String goal = "aa";
        Assert.assertEquals(buddyStrings(s, goal), true);
    }

    @Test
    public void ex3() {
        String s = "ab";
        String goal = "ba";
        Assert.assertEquals(buddyStrings(s, goal), true);
    }

    @Test
    public void ex4() {
        String s = "ab";
        String goal = "ab";
        Assert.assertEquals(buddyStrings(s, goal), false);
    }

    @Test
    public void ex5() {
        String s = "a";
        String goal = "ab";
        Assert.assertEquals(buddyStrings(s, goal), false);
    }

    /*
    pseudocode
    1. check for condition if s and goal length
    2. check if any one string is empty
    3. if both the string is equals means
        - check if it is distinct by adding the char in to set
        - compare the size of set and string length and return true if less or false if equals
    4. if both the string is not equals
        - get the index of two different occurrence char and cross verify
        - if count different occurrence is > 2 count means return false
    5. return the status

     */
    public boolean buddyStrings(String ss, String goal) {
        if(ss.length() != goal.length()) return false;
        if(ss.isEmpty() || goal.isEmpty()) return false;

        int count=0, first=0;
        char[] s = ss.toCharArray();
        char[] g = goal.toCharArray();

        boolean ispresent = false;
        Set<Character> set = new HashSet();
        if(ss.equals(goal)){
            for(char c : s) set.add(c);
            if(set.size()<ss.length()) ispresent=true;
        }else{
            for(int i=0; i<ss.length(); i++){
                if(s[i]!=g[i]){
                    if (++count < 2) first = i;
                    else if (s[first] == g[i] && g[first] == s[i] && count == 2) ispresent = true;
                    else ispresent=false;
                }
            }
        }
        return ispresent;
    }
}
