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

    @Test
    public void example3(){
        String s = "m1a1m";
        Assert.assertEquals(LongestSubStringPal(s), "1a1");
    }

    @Test
    public void example4(){
        String s = "a";
        Assert.assertEquals(LongestSubStringPal(s), "a");
    }

    //@Test
    public void example5(){
        String s = "a232f";
        Assert.assertEquals(LongestSubStringPal(s), "232");
    }

    @Test
    public void example6(){
        String s = "cdbb";
        Assert.assertEquals(LongestSubStringPal(s), "bb");
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
        Assert.assertEquals(LongestSubStringPal(s), "bb");
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
        if(str.length()<2) return str;

        int len=str.length()-1, left=0, right=len;
        String sub="";
        while (left<str.length() && right<=str.length()) {
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

    public boolean isPalindrome(String s){
        if(s.length()<2) return true;
        int left = 0, right = s.length()-1 ;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                return true;
            } else break;
        }
    return false;
    }


//    private String LongestSubStringPal1(String str){
//        if(str.length()<1) return "";
//        if(str.length()<2) return str;
//        if(str.length()==2) {
//            if(str.charAt(0)==str.charAt(1)){
//                return str;
//            }else return String.valueOf(str.charAt(0));
//        }
//
//        int left=0, right=0;
//        String sub="";
//        while(left < str.length()){
//            right=left+2;
//            while(left<right && right <=str.length()){
//                sub=str.substring(left, right);
//
//                if(isPalindrome(sub)) return sub;
//                else if(!(isPalindrome(sub))) right++;
//            }
//            left++;
//        }
//        return "";
//    }
}
