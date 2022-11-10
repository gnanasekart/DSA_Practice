package LeetCode_Daily_Practice.String.Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class P_E_N10_2_Roman_Letters {
    /*
leetcode.com/problems/roman-to-integer/

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two ones added together.
12 is written as XII, which is simply X + II.
The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right.
However, the numeral for four is not IIII. Instead, the number four is written as IV.
Because the one is before the five we subtract it making four.
The same principle applies to the number nine, which is written as IX.
There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Constraints:
1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].

*/
    @Test
    public void example1() {
        String words = "III";
        Assert.assertEquals(romanLetters(words), 3);
    }

    @Test
    public void example2() {
        String words = "LVIII";
        Assert.assertEquals(romanLetters(words), 58);
    }

    @Test
    public void example3() {
        String words = "MCMXCIV";
        Assert.assertEquals(romanLetters(words), 1994);
    }

    @Test
    public void example4() {
        String words = "DCCXCIX";
        Assert.assertEquals(romanLetters(words), 799);
    }

    @Test
    public void example5() {
        String words = "MMMCMXCIX";
        Assert.assertEquals(romanLetters(words), 3999);
    }

/*
pseudocode
1. check the string length
2. consider two map with priority 1 and 2
3. Add the priority 1 map with subtract instances value
4. Add the priority 2 map with normal roman value
5. start check two char roman char from right to left
6. if does not exist in first map then check with second map
7. sum the replaced char to value
8. return the int
*/

    public int romanLetters1(String s) {
        if (s.length() < 1) return 0;

        Map<String, Integer> map = new HashMap();
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        char[] c = s.toCharArray();
        int sum = 0, j=1;
        String a, b;
        for(int i=0; i<s.length(); i++) {
            a = String.valueOf(c[i]);
            b = j<s.length() ? String.valueOf(c[j]) : "";
            if (map.containsKey(a + b)){
                sum += map.get(a + b);
                i++;
                j++;
            }else if (map.containsKey(a))
                sum += map.get(a);

            j++;
        }
        return sum;
    }

    public int romanLetters(String s) {
        if (s.length() < 1) return 0;

        Map<String, Integer> map = new HashMap();
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        char[] c = s.toCharArray();
        int sum = 0, i=0, j=1;
        String a, b;
        while(i<s.length()) {
            a = String.valueOf(c[i]);
            b = j < s.length() ? String.valueOf(c[j]) : "";
            if (map.get(a) >= map.get(b)) {
                sum += map.get(a);
            } else if (map.get(a) < map.get(b)) {
                int diff = map.get(b) - map.get(a);
                sum += diff;
                i++;
            }
        }
        return sum;
    }
}
