package LeetCode_Daily_Practice.Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_M_HR_Reverse_Words_in_a_String {
    /*

    https://leetcode.com/problems/reverse-words-in-a-string/description/

    Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words.
The returned string should only have a single space separating the words. Do not include any extra spaces.

Constraints:

1 <= s.length <= 10^4
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
     */


    @Test
    public void ex1(){
        String s = "the sky is blue";
        Assert.assertEquals(reverseWords(s), "blue is sky the");
    }

    @Test
    public void ex2(){
        String s = "  hello world  ";
        Assert.assertEquals(reverseWords(s), "world hello");
    }

    @Test
    public void ex3(){
        String s = "a good   example";
        Assert.assertEquals(reverseWords(s), "example good a");
    }

    /*
     1. split the string with space
     2. get the word in reverse order and concat the word with same reference variable
    */

    private String reverseWords(String s) {

        String[] str = s.split("\\s+");
        StringBuffer sb = new StringBuffer();
        for(int i=str.length-1; i>=0; i--){
            if(!str[i].contains(" ")){
                sb.append(str[i]+" ");
            }
        }
        s = sb.toString().trim();
        return s;
    }
}
