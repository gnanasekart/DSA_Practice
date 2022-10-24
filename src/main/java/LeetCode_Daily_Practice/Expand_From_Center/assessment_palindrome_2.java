package LeetCode_Daily_Practice.Expand_From_Center;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
https://leetcode.com/problems/valid-palindrome-ii
Given a string s, return true if the s can be palindrome
after deleting at most one character from it.

Constraints:
1 <= s.length <= 10^5
s consists of lowercase English letters.
 */
public class assessment_palindrome_2 {
    /*
    leetcode.com/problems/valid-palindrome-ii/
    Given a string s, return true if the s can be palindrome after deleting at most one character from it.
     */

    @Test
    public void example1() {
        String s = "aba";
        Assert.assertEquals(isPalindrome(s),true);
    }

    @Test
    public void example2() {
        String s = "abca";
        Assert.assertEquals(isPalindrome(s),true);
    }

    @Test
    public void example3() {
        String s = "abc";
        Assert.assertEquals(isPalindrome(s),false);
    }
    @Test
    public void example4() {
        String s = "abccbda";
        Assert.assertEquals(isPalindrome(s),true);
    }
    @Test
    public void example5() {
        String s = "acd";
        Assert.assertEquals(isPalindrome(s),false);
    }
    @Test
    public void example6() {
        String s = "bba";
        Assert.assertEquals(isPalindrome(s),true);
    }
    @Test
    public void example7() {
        String s = "ccc";
        Assert.assertEquals(isPalindrome(s),true);
    }
/*
1. first concat the string from 0 to left and right to length - validate
    second concat the string from 0 to left and right to length and validate
2. if the validation returns palindrome then return true
3. else return false validation
*/
  //approach 1
    private boolean isPalindrome1(String s) {
        if(s.length()<2) return true;
        if(palindrome(s)) return true;
        boolean ispal=false;
        int left=0, right=s.length()-1;

        while(left<s.length() && right>0){
            while(left<right){
                String str="", str1="";
                if(s.charAt(left) == s.charAt(right)){
                    left++;
                    right--;
                    ispal=true;
                }else{
                    str+=s.substring(0, left+1)+s.substring(right+1,s.length());
                    str1+=s.substring(0, left)+s.substring(right,s.length());
                    if (palindrome(str) || palindrome(str1)) return true;
                    else ispal=false;
                }
            }
            left++;
            right++;
        }
        return ispal;
    }

    //approach 2
    private boolean isPalindrome(String s) {
        if(s.length()<2) return true;
        if(palindrome(s)) return true;
         int left=0, right=1;
        while (left < s.length() && right<=s.length()) {
            String str = "", str1="";
            str += s.substring(0, left++) + s.substring(right++, s.length());
            if (palindrome(str) || palindrome(str1)) return true;
        }
        return false;
    }

        private boolean palindrome(String s){
            if(s.isEmpty()) return false;
            int left=s.length()/2 - s.length()%2;
            int right=s.length()/2 + s.length()%2;

            if(left == right) left--;

            while(left>=0)
                if(s.charAt(left--) != s.charAt(right++)) return false;
            return true;
        }
}
