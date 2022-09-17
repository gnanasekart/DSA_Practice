package Recursion;

import org.testng.annotations.Test;

public class RemoveSubString {
    //Given two string s and t
    // find the max no of times that one can recursively remove t from s

    @Test
    public void example1(){
        String s = "aabcbc";
        String t = "abc";
        //output = 2
        System.out.println(replaceString(s, t));
    }

    @Test
    public void example2(){
        String s = "abababaaba";
        String t = "ababa";
        //output = 2
        System.out.println(replaceString(s, t));
    }

    private int replaceString(String s, String t) {


        return 1;
    }
}
