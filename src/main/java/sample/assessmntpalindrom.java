package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class assessmntpalindrom {

    @Test
    public void example1() {
        String s = "RADAR";
        Assert.assertEquals(isPalindrome(s), true);
    }

    @Test
    public void example2() {
        String s = "a";
        Assert.assertEquals(isPalindrome(s), true);
    }

    @Test
    public void example3() {
        String s = "madammadam";

        Assert.assertEquals(isPalindrome(s),true);
    }

    @Test
    public void example4() {
        String s = "";

        Assert.assertEquals(isPalindrome(s), false);
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


    private boolean isPalindrome1(String s) {
        if (s.length() < 2)
            return true;
        if(s.length()<1)
            return false;
        boolean ispal = false;

        if(reverseWord(s).equals(s)){
            return true;
        }
        return false;
    }


    public String reverseWord(String word){
        char[] ch = word.trim().toCharArray();
        char c;
        int left=0, right=word.length()-1;
        while(left<right){
            if(ch[left]>=65 && ch[right]<=90 && ch[left]>=90 && ch[right]<=122){
                c=ch[left];
                ch[left++]=ch[right];
                ch[right--]=c;
            }
        }
        return String.valueOf(ch);
    }
}
