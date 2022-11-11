package LeetCode_Daily_Practice.String.Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class P_E_N8_2_Buddy_String {
    /*
    https://leetcode.com/problems/buddy-strings/

    Given two strings s and goal, return true if you can swap two letters in s
    so the result is equal to goal, otherwise, return false.

    Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j
    and swapping the characters at s[i] and s[j].

    For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

    Example 1:

    Input: s = "ab", goal = "ba"
    Output: true
    Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.

    Example 2:

    Input: s = "ab", goal = "ab"
    Output: false
    Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b',
    which results in "ba" != goal.

    Example 3:

    Input: s = "aa", goal = "aa"
    Output: true
    Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.

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


    public boolean buddyStrings(String ss, String goal) {
        //if(ss.equals(goal)) return true;
        char[] s = ss.toCharArray();
        char[] g = goal.toCharArray();

        boolean ispresent = false;
        int count = 0;
        Set<Character> sets = new HashSet();
        ArrayList<Integer> list = new ArrayList<>();
        int first = 0;
        for (int i = 0; i < ss.length(); i++) {
            if (s[i] != g[i]) {
                count++;
                if (count != 2) {
                    first = i;
                } else if (s[first] == g[i] && g[first] == s[i] && count == 2) {
                    ispresent = true;
                }
            } else if (s[i] == g[i]) {
                sets.add(s[i]);
            }
        }
        if (sets.size() < ss.length()) {
            ispresent = true;
        } else {
            ispresent = false;
        }

        return ispresent;
    }
}
