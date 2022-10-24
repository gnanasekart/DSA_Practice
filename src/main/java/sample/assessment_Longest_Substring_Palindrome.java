package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class assessment_Longest_Substring_Palindrome {
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
    public void example1(){
        String s = "babad";
        Assert.assertEquals(LongestSubStringPal(s), "bab");
    }

    @Test
    public void example2(){
        String s = "wooorrrrk";
        Assert.assertEquals(LongestSubStringPal(s), "rrrr");
    }

    //@Test
    public void example3(){
        String s = "m1a1m";
        Assert.assertEquals(LongestSubStringPal(s), "1a1");
    }

    @Test
    public void example4(){
        String s = "a";
        Assert.assertEquals(LongestSubStringPal(s), "a");
    }

    @Test
    public void example5(){
        String s = "aacabdkacaa";
        Assert.assertEquals(LongestSubStringPal(s), "aca");
    }

    @Test
    public void example6(){
        String s = "cdbb";
        Assert.assertEquals(longestPalindrome(s), "bb");
    }

    @Test
    public void example7(){
        String s = "ac";
        Assert.assertEquals(LongestSubStringPal(s), "a");
    }

    @Test
    public void example8(){
        String s = "bb";
        Assert.assertEquals(LongestSubStringPal(s), "bb");
    }

    @Test
    public void example9(){
        String s = "abb";
        Assert.assertEquals(LongestSubStringPal(s), "bb");
    }

    @Test
    public void example10(){
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
*/

    private String LongestSubStringPal(String str){
        if(str.length()<1) return "";
        int len=str.length(), left=0, right=len;
        String sub="";
        while (left<str.length()) {
            while (right<=str.length()) {
                sub = str.substring(left, right);
                if (isPalindrome(sub)) return sub;
                else {
                    left++;
                    right++;
                }
            }
            len--;
            left=0;
            right=len;
        }
        return "";
    }

    private boolean isPalindrome(String s){
        int left=s.length()/2 - s.length()%2;
        int right=s.length()/2 + s.length()%2;

        if(left == right) left--;

        while(left>=0)
            if(s.charAt(left--) != s.charAt(right++)) return false;
        return true;
    }

}
