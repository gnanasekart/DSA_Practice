package LeetCode_Daily_Practice.Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class P_M_N5_2_Find_All_Anagram_In_String {
    /*
    https://leetcode.com/problems/find-all-anagrams-in-a-string/
Given two strings s and p, return an array of all the start indices of p's anagrams in s.
You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.
*/
    @Test
    public void ex1() {
        String s = "cbaebabacd";
        String p = "abc";
        Assert.assertEquals(anagram(s, p), Arrays.asList(0, 6));
    }

    @Test
    public void ex2() {
        String s = "abab";
        String p = "ab";
        Assert.assertEquals(anagram(s, p), Arrays.asList(0, 1, 2));
    }

    @Test
    public void ex3() {
        String s = "abab";
        String p = "c";
        Assert.assertEquals(anagram(s, p), Arrays.asList());
    }

    @Test
    public void ex4() {
        String s = "a";
        String p = "a";
        Assert.assertEquals(anagram(s, p), Arrays.asList(0));
    }

    @Test
    public void ex5() {
        String s = "abcdefgh";
        String p = "aabcdefgh";
        Assert.assertEquals(anagram(s, p), Arrays.asList());
    }

/*
pseudocode
base condition
- if both string length < 1 return 0
- s length should not less than p length
brute force
1. consider two loop i=0
2. second loop j=k+i, so loop between i to k
3. check it is anagram or not
4. if it is anagram add the i value in list
5. continue the i value increment
*/

    //BF
    private List<Integer> anagram1(String s, String p) {
        if (s.length() < 1 || p.length() < 1) return Arrays.asList();
        if (s.length() < p.length()) return Arrays.asList();

        String str = "";
        List<Integer> list = new ArrayList<>();
        int i = 0;
            for (int j = p.length() + i; j <= s.length(); j++, i++) {
                str = s.substring(i, j);
                if (isAnagram(str, p))
                    list.add(i);
                str="";
            }
        return list;
    }

    public boolean isAnagram(String s, String p){
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(pp);
        return Arrays.equals(ss, pp)? true:false;
    }

/*
sliding window
1. consider two pointers
2. right = k and left = right-k; and increment right for every subarray
3. check it is anagram
*/

    //BF
    private List<Integer> anagram(String s, String p) {
        List<Integer> list = new ArrayList<>();

        int k = p.length(), right = k, left = right - k;
        String str = "";
        while (left < right && right<=s.length()) {
            str=s.substring(left, right++);
            if (isAnagram(str, p)) {
                list.add(left);
            }
            str="";
            left++;
        }
        return list;
    }

}
