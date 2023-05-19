package LeetCode_Daily_Practice.Collection.String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class P_E_O30_1_Most_Common_Word {
    /*
https://leetcode.com/problems/most-common-word/description/

Given a string paragraph and a string array of the banned words banned,
return the most frequent word that is not banned. It is guaranteed there is
at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.

Example 1:
Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does),
so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case-sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.

Constraints:
1 <= paragraph.length <= 1000
paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
0 <= banned.length <= 100
1 <= banned[i].length <= 10
banned[i] consists of only lowercase English letters.
*/

    @Test
    public void example1() {
        String str = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] s = {"hit"};
        Assert.assertEquals(commonWord(str, s), "ball");
    }

    @Test
    public void example2() {
        String str = "a.";
        String[] s = {};
        Assert.assertEquals(commonWord(str, s), "a");
    }

    @Test
    public void example3() {
        String str = "a, a, a, a, b,b,b,c, c";
        String[] s = {"a"};
        Assert.assertEquals(commonWord(str, s), "b");
    }
/*
logic
1. split the string with special char and convert to lower cases
2. remove the special char
3. get the words in map with occurrence count and avoid white spaces
4. remove the banded words from map
5. get the max count word
6. then return the string
*/

    private String commonWord(String para, String[] words) {
        if (para.length() < 1) return para;
        final int[] max = {Integer.MIN_VALUE};
        final String[] maxWord = {""};

        String[] parawords = para.toLowerCase().split("[!?',;. ]");

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : parawords) {
            if (!s.isEmpty()) {
                s.trim().replaceAll("[!?',;. ]", "");
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        List<String> list = Arrays.asList(words);
        Arrays.stream(words).forEach(word -> map.remove(word));


        //Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getValue();
        for (Map.Entry<String, Integer> entry : map.entrySet()){
           if(entry.getValue()> max[0]){
               max[0] = entry.getValue();
               maxWord[0] = entry.getKey();
           }
        }

//        List l = map.entrySet().stream().filter(entry -> entry.getValue() > max[0])
//                .map(entry -> {
//                    max[0] = entry.getValue();
//                    maxWord[0] = entry.getKey();
//                    return maxWord[0];
//                }).distinct().collect(Collectors.toList());
//        System.out.println(l.toString());
//        return l.get(0).toString();
        return maxWord[0];
    }
}


