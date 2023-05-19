package LeetCode_Daily_Practice.String.Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class P_E_String_Matching_in_an_Array {
    /*
    String Matching in an Array
    leetcode.com/problems/string-matching-in-an-array/
    Given an array of string words, return all strings in words that is a substring of another word.
    You can return the answer in any order.
A substring is a contiguous sequence of characters within a string

Example 1:

Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.

Constraints:
1 <= words.length <= 100
1 <= words[i].length <= 30
words[i] contains only lowercase English letters.
All the strings of words are unique.
     */

    @Test
    public void ex1() {
        String[] sen = {"mass","as","hero","superhero"};
        List<String> output = Arrays.asList("as", "hero");
        Assert.assertEquals(matchingString(sen), output);
    }

    @Test
    public void ex2() {
        String[] sen = {"leetcode","et","code"};
        List<String> output = Arrays.asList("et","code");
        Assert.assertEquals(matchingString(sen), output);
    }

    @Test
    public void ex3() {
        String[] sen = {"blue","green","bu"};
        List<String> output = Arrays.asList();
        Assert.assertEquals(matchingString(sen), output);
    }
    @Test
    public void ex4() {
        String[] sen = {"mass","as","hero","superhero"};
        List<String> output = Arrays.asList("as", "hero");
        Assert.assertEquals(matchingString(sen), output);
    }

    @Test
    public void ex5() {
        String[] sen = {"leetcoder","leetcode","od","hamlet","am"};
        List<String> output = Arrays.asList("leetcode","od","am");
        Assert.assertEquals(matchingString(sen), output);
    }

    private List<String> matchingString1(String[] words) {

        if(words.length<=1) return new ArrayList<>();
        Set<String> set = new TreeSet<>();
        for(String str : words)
            for(String str1 : words)
                if(!str.equals(str1) && str1.contains(str)) set.add(str);
        return new ArrayList<>(set);
    }

    private List<String> matchingString(String[] words) {
       String s =  String.join(" ", words);
       List<String> list= new ArrayList<>();
        for(String str : words){
            int first = s.indexOf(str);
            int end = s.lastIndexOf(str);
            if(first != end)
                list.add(str);
        }
        return list;
    }
}
