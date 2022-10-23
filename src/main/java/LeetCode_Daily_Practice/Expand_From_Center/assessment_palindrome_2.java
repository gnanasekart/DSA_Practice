package LeetCode_Daily_Practice.Expand_From_Center;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
https://leetcode.com/problems/valid-palindrome-ii
Given a string s, return true if the s can be palindrome
after deleting at most one character from it.

Constraints:
1 <= s.length <= 105
s consists of lowercase English letters.
 */
public class assessment_palindrome_2 {

    @Test
    public void example1() {
        String s = "aba";
        Assert.assertEquals(palindrome(s), true);
    }

    @Test
    public void example2() {
        String s = "abca";
        Assert.assertEquals(palindrome(s), true);
    }

    @Test
    public void example3() {
        String s = "abc";
        Assert.assertEquals(palindrome(s),false);
    }

    @Test
    public void example4() {
        String s = "a";
        Assert.assertEquals(palindrome(s), true);
    }

    @Test
    public void example5() {
        String s = "deeee";
        Assert.assertEquals(palindrome(s), true);
    }

/*
1. consider two pointer from left and right
2. if start equals to end char means start++ and end--
            3. if not concat the string 0 to left and right to end.length()-1
            4. concat the string and validate as palindrome
	- if palindrome return true
            - else false
*/
    private boolean palindrome(String s){
        int left=0, right=s.length()-1;
        if(isPalindrome(s)){
            return true;
        }
        String str="";
        boolean ispal=false;

        while(left<s.length() && right>0){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else if(s.charAt(left)!=s.charAt(right)){
                str+=s.substring(0,left)+s.substring(right,s.length());
                if(isPalindrome(str)){
                    return true;
                }else return false;
            }
        }
        return ispal;
        }

        private boolean isPalindrome(String s) {
       // if(s.length()<2) return true;
            int left = 0, right = s.length()-1 ;
            boolean ispal = false;
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                    ispal = true;
                } else
                    break;
            }
            return ispal;
        }
}
