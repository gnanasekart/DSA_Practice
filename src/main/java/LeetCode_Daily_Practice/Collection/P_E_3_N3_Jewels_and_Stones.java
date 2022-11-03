package LeetCode_Daily_Practice.Collection;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class P_E_3_N3_Jewels_and_Stones {
    /*
    https://leetcode.com/problems/jewels-and-stones/description/

You're given strings jewels representing the types of stones that are jewels,
and stones representing the stones you have. Each character in stones is a type of stone you have.
You want to know how many of the stones you have are also jewels.
Letters are case-sensitive, so "a" is considered a different type of stone from "A".

Constraints:
1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.
*/

    @Test
    public void example1() {
        String j = "aA";
        String s = "aAAbbbb";
        Assert.assertEquals(uniqueStones(j, s), 3);
    }

    @Test
    public void example2() {
        String j = "aAbC";
        String s = "aAAbbbb";
        Assert.assertEquals(uniqueStones(j, s), 7);
    }

    @Test
    public void example3() {
        String j = "z";
        String s = "ZZ";
        Assert.assertEquals(uniqueStones(j, s), 0);
    }

    @Test
    public void example4() {
        String j = "a";
        String s = "a";
        Assert.assertEquals(uniqueStones(j, s), 1);
    }

/*
PseudoCode
1. collect the char occurrence from stone strings store in hashmap/ASCII
2. check the jewels char is present in hashmap/ASCII
3. sum the count of particular char
4. return the sum value
*/

    private int uniqueStones(String j, String s) {
        if (j.length() < 1 || s.length() < 1) return 0;
        if (j.length() == 1 && j.charAt(0) == s.charAt(0)) return 1;

        Map<Character, Integer> map = new HashMap();

        int i = 0, sum = 0, l = 0;
        while (i < s.length()) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i++), 0) + 1);
        }

        while (l < j.length()) {
            if (map.containsKey(j.charAt(l))) {
                sum += map.get(j.charAt(l));
            }
            l++;
        }
        return sum;
    }
}
