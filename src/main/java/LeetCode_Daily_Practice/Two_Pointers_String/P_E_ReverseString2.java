package LeetCode_Daily_Practice.Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_ReverseString2 {
    /*
    leetcode.com/problems/reverse-string-ii/description/
    Given a string s and an integer k, reverse the first k characters for every 2k characters
    counting from the start of the string.
If there are fewer than k characters left, reverse all of them. If there are less than 2k but
greater than or equal to k characters, then reverse the first k characters and leave the other as original.

 Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
     */
    @Test
    public void ex() {
        Assert.assertEquals(reverseStr("abcdefg", 2), "bacdfeg");
    }

    @Test
    public void ex1() {
        Assert.assertEquals(reverseStr("abcd", 2), "bacd");
    }


    //time - O(n^2)
    //space - O(n)
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i += 2 * k) {
            start = i;
            end = Math.min(i + k - 1, s.length() - 1);

            while (start < end) {
                char t = ch[start];
                ch[start++] = ch[end];
                ch[end--] = t;
            }
        }
        return new String(ch);
    }
}
