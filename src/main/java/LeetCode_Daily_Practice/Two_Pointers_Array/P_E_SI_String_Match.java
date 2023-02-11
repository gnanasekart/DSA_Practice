package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_SI_String_Match {
    /*
    leetcode.com/problems/di-string-match/
    A permutation perm of n + 1 integers of all the integers in the range [0, n]
    can be represented as a string s of length n where:

Example 1:

Input: s = "IDID"
Output: [0,4,1,3,2]

s[i] == 'I' if perm[i] < perm[i + 1], and
s[i] == 'D' if perm[i] > perm[i + 1].
Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm,
return any of them.

Constraints:
1 <= s.length <= 10^5
s[i] is either 'I' or 'D'.
     */


    @Test
    public void ex1(){
        Assert.assertEquals(matchString("IDID"), new int[]{0,4,1,3,2});
    }

    @Test
    public void ex2(){
        Assert.assertEquals(matchString("III"), new int[]{0,1,2,3});
    }

    @Test
    public void ex3(){
        Assert.assertEquals(matchString("DDI"), new int[]{3,2,0,1});
    }

    private int[] matchString(String s) {
    int[] n = new int[s.length()+1];
    int left=0, right=s.length();
    for(int i=0; i<s.length(); i++){
        n[i]=(s.charAt(i)=='I')?left++:right--;
    }
    n[s.length()]=left;
    return n;
    }
}
