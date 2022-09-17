package Recursion;

import org.testng.annotations.Test;

public class StringReplace {

    @Test
    public void example1(){
        String s1 = "Welcome to the interview, All the best to the test";
        String s2 = "to";
        System.out.println(replaceFirstMethod(s1, s2));
    }

    @Test
    public void example2(){
        String s1 = "Welcome to the interview, All the best to the test";
        String s2 = "too";
        System.out.println(NonReplaceMethod(s1, s2));
    }
/*
1. base/break point = (!s1.contains(s2))
2. recursive = first occurance s2 in s1 by using indexOf method and repeat recursive
 */
    private String NonReplaceMethod(String s1, String s2) {
        if(!s1.contains(s2)) return s1;
        int index = s1.indexOf(s2);

        return NonReplaceMethod(s1.substring(0, index-1) + s1.substring((index+s2.length()), s1.length()), s2);
    }

    private String replaceFirstMethod(String s1, String s2) {
        if(!s1.contains(s2)) return s1;
        return replaceFirstMethod(s1.replaceFirst(s2, ""), s2);
    }
}
