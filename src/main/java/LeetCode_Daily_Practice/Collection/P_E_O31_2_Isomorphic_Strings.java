package LeetCode_Daily_Practice.Collection;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_E_O31_2_Isomorphic_Strings {
    /*
https://leetcode.com/problems/isomorphic-strings/
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving
the order of characters.
No two characters may map to the same character, but a character may map to itself.

Constraints:
1 <= s.length <= 5 * 10^4
t.length == s.length
s and t consist of any valid ascii character.

*/

    @Test
    public void example1() {
        String s = "egg";
        String t = "add";
        Assert.assertEquals(isomorphic1(s, t), true);
    }

    @Test
    public void example2() {
        String s = "foo";
        String t = "bar";
        Assert.assertEquals(isomorphic(s, t), false);
    }

    @Test
    public void example3() {
        String s = "paper";
        String t = "title";
        Assert.assertEquals(isomorphic(s, t), true);
    }

    @Test
    public void example4() {
        String s = "1231@";
        String t = "aabcd";
        Assert.assertEquals(isomorphic(s, t), false);
    }

    @Test
    public void example5() {
        String s = "aa";
        String t = "bb";
        Assert.assertEquals(isomorphic(s, t), true);
    }

    @Test
    public void example6() {
        String s = " ";
        String t = "-";
        Assert.assertEquals(isomorphic(s, t), true);
    }

    @Test
    public void example7() {
        String s = "bbbaaaba";
        String t = "aaabbbba";
        Assert.assertEquals(isomorphic(s, t), false);
    }

    @Test
    public void example8() {
        String s = "geg";
        String t = "adg";
        Assert.assertEquals(isIsomorphic(s, t), false);
    }

    @Test
    public void example9() {
        String s = "badc";
        String t = "baba";
        Assert.assertEquals(isomorphic(s, t), false);
    }

    /*
1. get the digit occurrence in map
2. get the count which occur more than once
3. calculate the value and sum
4. return the sum value
*/

    private boolean isomorphic1(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Object, Integer> map1 = new HashMap();
        Map<Object, Integer> map2 = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }

        int[] a = new int[s.length()];
        int[] b = new int[t.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                return false;
            } else {
                a[i] = map1.get(s.charAt(i));
                b[i] = map2.get(t.charAt(i));
            }
        }
        if (Arrays.toString(a).equals(Arrays.toString(b)))
            return true;
        else
            return false;
    }

    private boolean isomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map1 = new HashMap();
        Map<Character, Character> map2 = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (map1.containsKey(s.charAt(i)) || map2.containsKey(t.charAt(i))) {
                Character ch1 = map1.get(s.charAt(i));
                Character ch2 = map2.get(t.charAt(i));
                if (ch1 == t.charAt(i) || ch2 == s.charAt(i)) {
                    map1.put(s.charAt(i), t.charAt(i));
                    map2.put(t.charAt(i), s.charAt(i));
                } else return false;
            } else {
                map1.put(s.charAt(i), t.charAt(i));
                map2.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        int[] sMap = new int[26];
        int[] tMap = new int[26];
        char sChar, tChar;

        for (int i = s.length() - 1; i >= 0; i--) {
            sChar = s.charAt(i);
            tChar = t.charAt(i);

            if (sMap[sChar-'a'] != tMap[tChar-'a']){
                return false;
            }

            sMap[sChar-'a'] = i + 1;
            tMap[tChar-'a'] = i + 1;
        }
        return true;
    }
}
