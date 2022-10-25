package LeetCode_Daily_Practice.Expand_From_Center;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class P_O23_1_assessment_palindrome {

    @Test
    public void example1() {
        String s = "RAAR";
        Assert.assertEquals(isPalindromeGS(s), true);
    }

    @Test
    public void example2() {
        String s = "a";
        Assert.assertEquals(isPalindromeGS(s), true);
    }

    @Test
    public void example3() {
        String s = "madammadam";

        Assert.assertEquals(isPalindromeGS(s),true);
    }

    @Test
    public void example4() {
        String s = "";

        Assert.assertEquals(isPalindromeGS(s), false);
    }

	/*
1. get the string
2. pass the string to reverse the char
3. get the reverse string and check with original string
    if equal it is valid palindrome string then return true
    if not return false
*/

    private boolean isPalindrome(String s) {
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

    private boolean isPalindromeGS(String s){
        if(s.length()<1) return false;
        //s=radar
        int left=s.length()/2 - s.length()%2; //2-1 = 1
        int right=s.length()/2 + s.length()%2;//2+1 = 3

        if(left == right) left--;

        while(left>=0)
            if(s.charAt(left--) != s.charAt(right++)) return false;
        return true;
    }

    private boolean isPalindromeEvenOdd(String s){
        if(s.length()<1) return false;
        int left=0, right=0;

        if(s.length()%2==0){
            left=s.length()/2-1;
            right=s.length()/2;
        }else{
            left=s.length()/2-1;
            right=s.length()/2+1;
        }

        if(left == right) left--;

        while(left>=0)
            if(s.charAt(left--) != s.charAt(right++)) return false;
        return true;
    }
}
