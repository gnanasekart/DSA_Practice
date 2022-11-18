package LeetCode_Daily_Practice.Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class P_E_O17_3_Merge_String_Alternatively {


/*
leetcode.com/problems/merge-strings-alternately/
You are given two strings word1 and word2. Merge the strings by adding letters
in alternating order, starting with word1. If a string is longer than the other,
append the additional letters onto the end of the merged string.

Return the merged string.

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

*/

    @Test
    public void example1() {
        String w1 = "abc";
        String w2 = "pqr";
        Assert.assertEquals(mergeStringsSB(w1, w2), "apbqcr");
    }

    @Test
    public void example2() {
        String w1 = "ab";
        String w2 = "pqrs";
        Assert.assertEquals(mergeStrings(w1, w2), "apbqrs");
    }

    @Test
    public void example3() {
        String w1 = "abcde";
        String w2 = "";
        Assert.assertEquals(mergeStrings(w1, w2), "abcde");
    }

    @Test
    public void example4() {
        String w1 = "z";
        String w2 = "";
        Assert.assertEquals(mergeStringsBF(w1, w2), "z");
    }

/*
logic
- create a new array with combining both array size
- Iterate a loop with new array size
- if the iteration value is even means add first array value
- else add second array value
- then append additional string to new array
- return new array
*/

    private String mergeStringsBF(String w1, String w2) {
        String str = "";
        for (int i = 0, j = 0; i < w1.length() + w2.length(); i++, j++) {
            if (i < w1.length()) {
                str += w1.charAt(i);
            }

            if (j < w2.length()) {
                str += w2.charAt(j);
            }
        }
        return str;
    }

    private String mergeStrings(String w1, String w2) {
        if (w1.isEmpty() && w2.isEmpty()) return w1;

        int i = 0, left = 0, right = 0;
        int l = w1.length() + w2.length();
        char[] cc = new char[l];
        while (i < l) {
            if (left < w1.length())
                cc[i++] = w1.charAt(left++);

            if (right < w2.length())
                cc[i++] = w2.charAt(right++);
        }
        return String.valueOf(cc);
    }

    //merge string using string buffer
    private String mergeStringsSB(String w1, String w2) {
        int i=0, j=0;
        StringBuilder sb = new StringBuilder();
        while(i<w1.length() && j<w2.length()){
            sb.append(w1.charAt(i++));
            sb.append(w2.charAt(j++));
        }

        while(i<w1.length()){
            sb.append(w1.charAt(i++));
            //if w1 is greater than w2
            //return sb.toString()+w1.substring(w2.length(), w1.length());
        }

        while(j<w2.length()) {
            sb.append(w2.charAt(j++));
            //if w1 is smaller than w2
            //return sb.toString()+w2.substring(w1.length(), w2.length());
        }
        return sb.toString();
    }
}
