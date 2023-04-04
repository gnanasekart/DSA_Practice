package LeetCode_Daily_Practice.String.Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_Repeat_SubString_Pattern {
    /*

    https://leetcode.com/problems/repeated-substring-pattern
Given a string s, check if it can be constructed by taking a substring of it
and appending multiple copies of the substring together.
Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.

Constraints:

1 <= s.length <= 10^4
s consists of lowercase English letters.

Approach :
1. The substring that will be repeated should repeat at least 2 times
   otherwise every string will be considered as a repeated substring.
2. Since the number of repetitions is between n times (size of the
   string) to 2 times so the size of a valid repeating substring
   would lie between[ 1, n / 2 ].
3. A substring of size ” i ” will only be a repeated substring if
   size % i == 0.
4. Now following which we have two methods whether current substring
   of size suppose k is a repeated substring or not

     */
    @Test
    public void ex1() {
        Assert.assertEquals(subStringpattern("abab"), true);
    }

    @Test
    public void ex2() {
        Assert.assertEquals(subStringpattern("aba"), true);
    }

    @Test
    public void ex3() {
        Assert.assertEquals(subStringpattern("abcabcabcabc"), true);
    }

    @Test
    public void ex4() {
        Assert.assertEquals(subStringpattern("abac"), false);
    }


    private boolean subStringpattern(String s) {
        String str = "";

        for (int i = 1; i < s.length()/2; i++) {
            if (s.length() % 2 == 0) {
                str = s.substring(0, i);
                int j = i;
                while (j < s.length() && s.substring(j, j + i).equals(str)) {
                    j += i;
                }
                if (j == s.length())
                    return true;
            }
        }
        return false;
    }
}
