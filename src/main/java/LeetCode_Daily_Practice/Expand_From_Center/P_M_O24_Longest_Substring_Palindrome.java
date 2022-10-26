package LeetCode_Daily_Practice.Expand_From_Center;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_M_O24_Longest_Substring_Palindrome {
/*
leetcode.com/problems/longest-palindromic-substring/
Given a string s, return the longest palindromic substring in s.
A string is called a palindrome string if the reverse of that string
 is the same as the original string.
 Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.
 */
    @Test
    public void example1() {
        String s = "babad";
        Assert.assertEquals(longestPalindrome(s), "bab");
    }

    @Test
    public void example2() {
        String s = "wooorrrrk";
        Assert.assertEquals(LongestSubStringPal(s), "rrrr");
    }

    //@Test
    public void example3() {
        String s = "m1a1m";
        Assert.assertEquals(LongestSubStringPal(s), "m1a1m");
    }

    @Test
    public void example4() {
        String s = "a";
        Assert.assertEquals(LongestSubStringPal(s), "a");
    }

    @Test
    public void example5() {
        String s = "aacabdkacaa";
        Assert.assertEquals(LongestSubStringPal(s), "aca");
    }

    @Test
    public void example6() {
        String s = "cdbb";
        Assert.assertEquals(longestPalindrome(s), "bb");
    }

    @Test
    public void example7() {
        String s = "aeiou";
        Assert.assertEquals(LongestSubStringPal(s), "a");
    }

    @Test
    public void example8() {
        String s = "bb";
        Assert.assertEquals(LongestSubStringPal(s), "bb");
    }

    @Test
    public void example9() {
        String s = "abb";
        Assert.assertEquals(LongestSubStringPal(s), "bb");
    }

    @Test
    public void example10() {
        String s = "bbb";
        Assert.assertEquals(LongestSubStringPal(s), "bbb");
    }
/*
1. check if str.length<1 then return str
2. consider two pointer from left=0 and right=left+1;
3. create helper method to check palindrome
4. if substring between left and right is palindrome then return substring of left and right
5. else increment in right side
6. if reaches the end of iteration, then increment left
7. then revisit from left to right

k	    	    5	4		3			2
right= k-1	    4	3	4	2	3	4	1	2	3	4
left=right-k+1	0	0	1	0	1	2	0	1	2	3


*/

    //brute force approach with while loop
    private String LongestSubStringPal(String str) {
        if (str.length() < 1) return "";
        int k = str.length(), right = 0, left = 0;
        String sub = "";
        while (left < str.length()) {
            right = k - 1;
            left = right - k + 1;
            while (right < str.length()) {
                sub = str.substring(left++, right++ + 1);
                if (isPalindrome(sub)) return sub;
            }
            k--;
        }
        return "";
    }
    private boolean isPalindrome(String s) {
        int left = s.length() / 2 - s.length() % 2;
        int right = s.length() / 2 + s.length() % 2;

        if (left == right) left--;

        while (left >= 0)
            if (s.charAt(left--) != s.charAt(right++)) return false;
        return true;
    }
//-----------------------------------------------------------------------

    //LC solution
    private int start, end;

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(start, start + end);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (end < k - j - 1) {
            start = j + 1;
            end = k - j - 1;
        }
    }
}