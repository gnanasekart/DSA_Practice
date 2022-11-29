package LeetCode_Daily_Practice.Sliding_Window_String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_M_N5_5_Long_SubString_Without_Repeat_Char {
    /*
    https://leetcode.com/problems/longest-substring-without-repeating-characters/
    Given a string s, find the length of the longest substring without repeating characters.

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Constraints:
0 <= s.length <= 5 * 10^4
s consists of English letters, digits, symbols and spaces.

*/
    @Test
    public void ex2() {
        String s = "";
        Assert.assertEquals(nonrepeatString(s), 0);
    }

    @Test
    public void ex3() {
        String s = "aba";
        Assert.assertEquals(nonrepeatString(s), 2);
    }

    @Test
    public void ex4() {
        String s = "aaa";
        Assert.assertEquals(nonrepeatString(s), 1);
    }

    @Test
    public void ex5() {
        String s = "a#a%a";
        Assert.assertEquals(nonrepeatString(s), 3);
    }

    @Test
    public void ex6() {
        String s = "a# %a";
        Assert.assertEquals(nonrepeatString(s), 4);
    }

    @Test
    public void ex1() {
        String s = "abcabcbb";
        Assert.assertEquals(lengthOfLongestSubString(s), 3);
    }

    @Test
    public void ex7() {
        String s = "abcaabcdba";
        Assert.assertEquals(nonrepeatString(s), 4);
    }

    @Test
    public void ex8() {
        String s = "abcdefghcc";
        Assert.assertEquals(nonrepeatString(s), 8);
    }


    /*
    base condition
    - check if the string is less than 1 means return 0
    - if string length is 1 means return 1

    1. start from max length value of i
    2. add the substring into set and compare the set length==substring length
    3. if equals return string
    4. else duplicate found then move to next substring
    */

    public int nonrepeatString(String s) {
        if (s.length() < 1) return 0;
        if (s.length() == 1) return 1;

        int max = Integer.MIN_VALUE;
        Set<Character> set = new HashSet();
        int count = 0, left = 0, right = 0;
        String sub = "";

        for (int i = s.length(); i >= 0; i--) {
            right = i - 1;//8-1

            while (right < s.length() && left < s.length()) {
                left = right - i + 1;//7-8+1
                sub = s.substring(left, right + 1);//0, 7

                for (char c : sub.toCharArray())
                    set.add(c);

                if (set.size() == sub.length() && sub.length() >= max) {
                    max = Math.max(max, sub.length());
                }
                set.clear();
                right++;
            }
        }
        return max;
    }

    //time O(2n)
    //space O(n)
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) return 0;
        if (s.length() == 1) return 1;

        int max = Integer.MIN_VALUE;
        int left = 0, right = 0, len = 0;

        Set<Character> set = new HashSet();

        while (right < s.length()) {

            if (set.contains(s.charAt(right)))
                set.remove(s.charAt(left++));
            else set.add(s.charAt(right++));

            len = right - left;
            max = len > max ? len : max;

        }
        return max;
    }

    public int lengthOfLongestSubString1(String s) {
        if(s.length()<1) return 0;
        int index=0, max=Integer.MIN_VALUE;
        String sb="";
        String ans = sb+s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            index=ans.indexOf(s.charAt(i));
            if(index==-1){
                ans+=s.charAt(i);
                max=Math.max(max, ans.length());
            }else{
                ans=ans.substring(index+1)+s.charAt(i);
            }
        }
        return max;
    }


    //debug
      public int lengthOfLongestSubString(String s) {

            int left = 0, right = 0, len = 0, max= Integer.MIN_VALUE;

            Map<Character, Integer> map = new HashMap();

            while (right < s.length()) {
                if (map.containsKey(s.charAt(right))) {
                    left = Math.max(map.get(s.charAt(right)) + 1, left);
                }
                max = Math.max(max, right-left+1);
                map.put(s.charAt(right),map.getOrDefault(s.charAt(right), 0)+ right+1);
                right++;
            }
            return max;
        }
    }
