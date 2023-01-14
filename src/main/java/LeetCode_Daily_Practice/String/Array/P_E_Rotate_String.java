package LeetCode_Daily_Practice.String.Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_Rotate_String {

    /*

    Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
    A shift on s consists of moving the leftmost character of s to the rightmost position.
    For example, if s = "abcde", then it will be "bcdea" after one shift.

    Constraints:
    1 <= s.length, goal.length <= 100
    s and goal consist of lowercase English letters.

abcde
eabcd
deabc
cdeab
bcdea
abcde

     */

    @Test
    public void ex1(){
        Assert.assertEquals(rotate("abcde", "bcdea"), true);
    }

    @Test
    public void ex2(){
        Assert.assertEquals(rotate("abcde", "abced"), false);
    }

    @Test
    public void ex3(){
        Assert.assertEquals(rotate("ab", "ba"), true);
    }


    private boolean rotate(String s, String exp){
        if(s.equals(exp)) return true;
        for(int i=0; i<s.length(); i++){
            StringBuilder sb = new StringBuilder(s);
            sb= sb.append(s.charAt(0));
            s = sb.substring(1, sb.length());
            if(s.equals(exp)){
                return true;
            }
        }
        return false;
    }

    private boolean rotate2(String s, String exp){
        //Using (s+s) we can get all combination of rotated string
        return (s.length()==exp.length() && (s+s).contains(exp));
    }
}
