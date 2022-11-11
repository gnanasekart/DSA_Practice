package LeetCode_Daily_Practice.Collection;

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

    public static Map<String, Integer> getMap() {
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
        return map;
    }

/*
pseudocode
1. check the string length
2. consider two pointer and condition as value should be less than i and j
3. Add the map with subtract instances value and roman values
4. start check two char roman char from left to right
    i=0 < s.length() && j=1 < s.length()
    check s.charAt(i)+s.charAt(j) containsKey in map
5. if it does not exist in map then check with single exist
    else s.charAt(i) containsKey in map
6. sum the char to value
7. return the int
*/

    public int romanLetters1(String s) {
        if (s.length() < 1) return 0;

        Map<String, Integer> map = getMap();

        char[] c = s.toCharArray();
        int sum = 0, j = 1;
        String a, b;
        for (int i = 0; i < s.length(); i++) {
            a = String.valueOf(c[i]);
            b = j < s.length() ? String.valueOf(c[j]) : "";
            if (map.containsKey(a + b)) {
                sum += map.get(a + b);
                i++;
                j++;
            } else if (map.containsKey(a))
                sum += map.get(a);

            j++;
        }
        return sum;
    }

    /*
Pseudocode
1. check the string length
2. consider two pointer and condition as value should be less than i and j
3. Add the map with subtract instances value and roman values
4. start check two char roman char from left to right
    i=0 < s.length() && j=1 < s.length()
5. if j<s.length() means take a single char from string
    Append if condition pass
    return empty else condition fail
6. sum the values based on condition
     if ch[i]>ch[j] means sum+=ch[i]
     else if ch[i]<ch[j] means sum+=ch[j]-ch[i], increment both index
     else sum+=ch[i]
7. return sum value

     */

    //pattern 1 without subtraction instances
    public int romanLetters2(String s) {
        if (s.length() < 1) return 0;

        //in this concept no need for subtraction instances from map
        Map<String, Integer> map = getMap();

        char[] c = s.toCharArray();
        int sum = 0, i = 0, j = 1;
        String a, b;
        while (i < s.length()) {
            a = String.valueOf(c[i]);
            b = j < s.length() ? String.valueOf(c[j]) : "";
            if (map.containsKey(b) && map.get(a) > map.get(b)) {
                sum += map.get(a);
            } else if (map.containsKey(b) && map.get(a) < map.get(b)) {
                sum += map.get(b) - map.get(a);
                i++;
                j++;
            } else {
                sum += map.get(a);
            }
            i++;
            j++;
        }
        return sum;
    }


    //pattern 2 without subtraction instances
    public int romanLetters3(String s) {
        if (s.length() < 1) return 0;
        int sum = 0;
        //in this concept no need for subtraction instances from map
        Map<String, Integer> map = getMap();

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 &&
                    map.get(String.valueOf(s.charAt(i))) < map.get(String.valueOf(s.charAt(i + 1)))) {
                sum -= map.get(String.valueOf(s.charAt(i)));
            } else {
                sum += map.get(String.valueOf(s.charAt(i)));
            }
        }
        return sum;
    }

    //pattern with ASCII array
    public int romanLetters(String s) {
        if (s.length() < 1) return 0;
        int sum = 0, currentInd = 0, prev = 0, result = 0;

        int[] arr = new int['A' + 26];
        arr['I'] = 1;
        arr['V'] = 5;
        arr['X'] = 10;
        arr['L'] = 50;
        arr['C'] = 100;
        arr['D'] = 500;
        arr['M'] = 1000;

        for (int i = 0; i < s.length(); i++) {
            currentInd = arr[s.charAt(i)];
            result += prev > currentInd ? -currentInd : currentInd;
            prev = currentInd;
        }
        return result;
    }

    public int romanToInt(String s) {
        int len = s.length();
        int res = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == 'I') res += 1;
            if (s.charAt(i) == 'V') {
                res += 5;
                if (i != 0 && s.charAt(i - 1) == 'I') {
                    res -= 1;
                    i--;
                }
            }
            if (s.charAt(i) == 'X') {
                res += 10;
                if (i != 0 && s.charAt(i - 1) == 'I') {
                    res -= 1;
                    i--;
                }
            }
            if (s.charAt(i) == 'L') {
                res += 50;
                if (i != 0 && s.charAt(i - 1) == 'X') {
                    res -= 10;
                    i--;
                }
            }
            if (s.charAt(i) == 'C') {
                res += 100;
                if (i != 0 && s.charAt(i - 1) == 'X') {
                    res -= 10;
                    i--;
                }
            }
            if (s.charAt(i) == 'D') {
                res += 500;
                if (i != 0 && s.charAt(i - 1) == 'C') {
                    res -= 100;
                    i--;
                }
            }
            if (s.charAt(i) == 'M') {
                res += 1000;
                if (i != 0 && s.charAt(i - 1) == 'C') {
                    res -= 100;
                    i--;
                }
            }
        }
        return res;
    }

}
