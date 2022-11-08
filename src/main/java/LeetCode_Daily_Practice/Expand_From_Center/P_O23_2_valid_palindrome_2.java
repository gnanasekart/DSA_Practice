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
public class P_O23_2_valid_palindrome_2 {
    //P_E_N6_5_Valid_Palindrome_II
/*
Given a string s, return true if the s can be palindrome after deleting
at most one character from it.

Constraints:
1 <= s.length <= 10^5
s consists of lowercase English letters.

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
        Assert.assertEquals(isPalindrome1(s),true);
    }
    @Test
    public void example5() {
        String s = "acd";
        Assert.assertEquals(isPalindrome(s),false);
    }
    @Test
    public void example6() {
        String s = "deeee";
        Assert.assertEquals(isPalindrome(s),true);
    }
    @Test
    public void example7() {
        String s = "ccc";
        Assert.assertEquals(isPalindrome(s),true);
    }

    @Test
    public void example8() {
        String s = "bba";
        Assert.assertEquals(isPalindromBF(s),true);
    }
/*
1. first concat the string from 0 to left and right to length - validate
    second concat the string from 0 to left and right to length and validate
2. if the validation returns palindrome then return true
3. else return false validation
*/
  //brute force approach
private boolean isPalindromBF(String s) {
    if(s.length()<2) return true;
    for(int left=0, right=s.length()-1; left<right; ){
        if(s.charAt(left) == s.charAt(right)){
            left++; right--;
        }else return palindrome(s, left+1, right) || palindrome(s, left, right-1);
    }
    return true;
}

  //approach 1
    private boolean isPalindrome1(String s) {
        if(s.length()<2) return true;
        int left=0, right=s.length()-1;

            while(left<right){
                if(s.charAt(left) == s.charAt(right)){
                    left++; right--;
                }else return palindrome(s, left+1, right) || palindrome(s, left, right-1);
            }
        return true;
    }

    //approach 2 - inprogress
    private boolean isPalindrome(String s) {
    int left=s.length()/2 - s.length()%2;
    int right=s.length()/2 + s.length()%2;
    boolean ispal=false;
    while(left>=0 && right<s.length()){
        if(s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }else if(s.charAt(left--) != s.charAt(right++)){
            while(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                ispal=true;
            }
        }
        return ispal;
    }
//    while(s.charAt(left) == s.charAt(right)){
//        left--;
//        right++;
//    }
//    if(s.charAt(left) != s.charAt(right)){
//        if(left<right) {
//            while(s.charAt(left--) == s.charAt(right++)) {
//                continue;
//            }
//        }
//    }

        return false;
    }

        public boolean palindrome(String s, int left, int right){
            while(left<right)
                if(s.charAt(left++) != s.charAt(right--))
                    return false;
            return true;
        }
}
