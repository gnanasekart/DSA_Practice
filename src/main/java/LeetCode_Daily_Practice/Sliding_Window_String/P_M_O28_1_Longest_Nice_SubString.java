package LeetCode_Daily_Practice.Sliding_Window_String;

import java.util.HashSet;
import java.util.Set;

public class P_M_O28_1_Longest_Nice_SubString {
    /*
    https://leetcode.com/problems/longest-nice-substring/

     */

    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<Character>();
        for (char c: chars)
            set.add(c);
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(Character.toUpperCase(chars[i])) && set.contains(Character.toLowerCase(chars[i])))
                continue;
            String sub1 = longestNiceSubstring(s.substring(0, i));
            String sub2 = longestNiceSubstring(s.substring(i+1));
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        return s;
    }
}
