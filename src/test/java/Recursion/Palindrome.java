package Recursion;

import org.testng.annotations.Test;

public class Palindrome {

    @Test
    public void example1(){
        String s = "hello";
        System.out.println(isPalindrome(s));
    }

    @Test
    public void example2(){
        String s = "madam";
        System.out.println(isPalindrome(s));
    }

    private boolean isPalindrome(String s) {
        if(s.length()==0 || s.length()==1) return true;

        if(s.charAt(0) == s.charAt(s.length()-1))
            return isPalindrome(s.substring(1,s.length()-1));

        return false;
    }
}
