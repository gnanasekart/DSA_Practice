package LeetCode_Daily_Practice.Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_N6_5_Valid_Palindrome_II {
    /*
 leetcode.com/problems/valid-palindrome-ii/
Given a string s, return true if the s can be palindrome after deleting
at most one character from it.

Constraints:
1 <= s.length <= 10^5
s consists of lowercase English letters.

*/
    
    @Test
    public void ex(){
        String s = "aba";
        Assert.assertEquals(validPal(s), true);
    }



    @Test
    public void ex1(){
        String s = "abca";
        Assert.assertEquals(validPal(s), true);
    }

    @Test
    public void ex2(){
        String s = "abc";
        Assert.assertEquals(validPal(s), false);
    }
    private boolean validPal(String s) {
        return false;
    }

}
