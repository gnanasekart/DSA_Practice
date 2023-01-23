package LeetCode_Daily_Practice.Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_CM_Valid_Palindrome {
    /*
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
    removing all non-alphanumeric characters, it reads the same forward and backward.
    Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
    Constraints:
1 <= s.length <= 2 * 10^5
s consists only of printable ASCII characters.

     logic
            split the string into chararray
            iterate for every char and add =by checking as digit or char
            append the char
            copy the string into another string,
            reverse the string and compare by equals
        */

    @Test
    public void ex1(){
        String s = "A man, a plan, a canal: Panama";
        Assert.assertEquals(isPalindrome(s), true);
    }

    @Test
    public void ex2(){
        String s = "race a car";
        Assert.assertEquals(isPalindrome(s), false);
    }

    @Test
    public void ex3(){
        String s = " ";
        Assert.assertEquals(isPalindrome(s), true);
    }

    @Test
    public void ex4(){
        String s = "0P";
        Assert.assertEquals(isPalindrome(s), false);
    }

    public boolean isPalindrome1(String s) {
        if (s.isEmpty()) return true;
        StringBuffer sb = new StringBuffer();
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                sb.append(c);
            }
        }
        String org = sb.toString();
        return sb.reverse().toString().equals(org);
    }

    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        s=s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");
        int left=0, right=s.length()-1;
        while(left<=right){
            if(s.charAt(left++)!= s.charAt(right--))
                return false;
            }
        return true;
    }
}
