package LeetCode_Daily_Practice.Collection;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class P_E_N9_1_Uncommon_Word_from_2_String {
    /*

    https://leetcode.com/problems/uncommon-words-from-two-sentences/

A sentence is a string of single-space separated words where each word consists only of lowercase letters.
A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

Constraints:

1 <= s1.length, s2.length <= 200
s1 and s2 consist of lowercase English letters and spaces.
s1 and s2 do not have leading or trailing spaces.
All the words in s1 and s2 are separated by a single space.
*/

    @Test
    public void ex1() {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        Assert.assertEquals(uncommonWords(s1, s2), new String[]{"sweet", "sour"});
    }

    @Test
    public void ex2() {
        String s1 = "apple apple";
        String s2 = "banana";
        Assert.assertEquals(uncommonWords(s1, s2), new String[]{"banana"});
    }

    @Test
    public void ex3() {
        String s1 = "Gnana Sekar";
        String s2 = "Sekar Gnana";
        Assert.assertEquals(uncommonWords(s1, s2), new String[]{});
    }

    @Test
    public void ex4() {
        String s1 = "this";
        String s2 = "sour";
        Assert.assertEquals(uncommonWords(s1, s2), new String[]{"this", "sour"});
    }

    @Test
    public void ex5() {
        String s1 = "a b c d e";
        String s2 = "e s a f b";
        Assert.assertEquals(uncommonWords(s1, s2), new String[]{"c", "s", "d", "f"});
    }

    /*
    pseudocode
    1. check the length should be < 1
    2. split the string using single space to array of string
    3. adding the both string into map with occurrence
    4. get the string with value less than 2 as uncommon words
    5. return the list

    */
    public String[] uncommonWordsMap(String s1, String s2) {

        if (s1.length() < 1 || s2.length() < 1) return new String[]{};
        Map<String, Integer> map = new HashMap();
        List<String> list = new ArrayList<>();
        for (String one : s1.split(" "))
            map.put(one, map.getOrDefault(one, 0) + 1);

        for (String two : s2.split(" "))
            map.put(two, map.getOrDefault(two, 0) + 1);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                list.add(entry.getKey());//here we can use set also
        }
        return list.toArray(new String[0]);
    }

    //string builder
    public String[] uncommonWordsSB(String s1, String s2) {

        if (s1.length() < 1 || s2.length() < 1) return new String[]{};
        Map<String, Integer> map = new HashMap();
        List<String> list = new ArrayList<>();
        for (String one : s1.split(" "))
            map.put(one, map.getOrDefault(one, 0) + 1);

        for (String two : s2.split(" "))
            map.put(two, map.getOrDefault(two, 0) + 1);
        StringBuilder sb = new StringBuilder();

        for(String s : map.keySet()){
            if(map.get(s)==1){
                sb=sb.append(s+" ");
            }
        }
        if(sb.toString().equals(""))
            return new String[]{};
        return sb.toString().trim().split(" ");
    }

    //map in stream
    public String[] uncommonWords(String s1, String s2) {
        if (s1.length() < 1 || s2.length() < 1) return new String[]{};
        String[] s = (s1+" "+s2).split(" ");
        List<String> list = new ArrayList<>();


       Map<String, Long> map = Arrays.stream(s)
               .collect(Collectors.groupingBy(key -> key, Collectors.counting()));
       for(String k :map.keySet())
           if(map.get(k)==1)
               list.add(k);

       return list.toArray(new String[0]);
    }
}
