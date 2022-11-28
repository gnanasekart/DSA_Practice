package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class P_E_O25_1_Two_String_Arr_are_Equal {
    /*
    leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
    Given two string arrays word1 and word2, return true if the two arrays
    represent the same string, and false otherwise.
    A string is represented by an array if the array elements concatenated
    in order forms the string.
*/
    @Test
    public void ex1(){
        String[] w1 = {"a", "cb"};
        String[] w2 = {"ab", "c"};
        Assert.assertEquals(stringconcat(w1, w2), false);
    }

    @Test
    public void ex2(){
        String[] w1 = {"abc", "d", "defg"};
        String[] w2 = {"abcddefg"};
        Assert.assertEquals(stringconcat(w1, w2), true);
    }

    @Test
    public void ex3(){
        String[] w1 = {"abc"};
        String[] w2 = {"a"};
        Assert.assertEquals(stringconcat(w1, w2), false);
    }

    @Test
    public void ex4(){
        String[] w1 = {"abcd", "efg"};
        String[] w2 = {"a","b","c"," ","de","fg"," "};
        Assert.assertEquals(stringconcat(w1, w2), true);
    }

    @Test
    public void ex5(){
        String[] w1 = {"abc"};
        String[] w2 = {"c","ba"};
        Assert.assertEquals(stringconcat(w1, w2), false);
    }

    @Test
    public void ex6(){
        String[] w1 = {"a"};
        String[] w2 = {"a"};
        Assert.assertEquals(stringconcat(w1, w2), true);
    }

    private boolean stringconcatBF(String[] w1, String[] w2){
        if(w1.length<1 || w2.length<1) return false;
        int left=0;
        String s1="", s2="";

        for(String s: w1)
            if(s!="" && s!=" ") s1+=s;

        for(String s: w2)
            if(s!="" && s!=" ") s2+=s;

        if(s1.equals(s2) && s1.length() == s2.length())
            return true;
        else return false;
    }

    // LC Solution
    private boolean stringconcat(String[] w1, String[] w2){

        return String.join("", w1).equals(String.join("", w2));
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder sb = new StringBuilder();
        for(String w1: word1) sb.append(w1);

        StringBuilder sb1 = new StringBuilder();
        for(String w2: word2) sb1.append(w2);

        if(sb.toString().equals(sb1.toString())) return true;
        else return false;
    }
}
