package LeetCode_Daily_Practice.Collection.String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class P_E_N1_1_Most_Common_Char {
    /*
https://leetcode.com/problems/find-common-characters/

Given a string array words, return an array of all characters that show up
 in all strings within the words (including duplicates). You may return the answer in any order.

Constraints:
1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.
*/

    @Test
    public void example1() {
        String[] s = {"bella", "label", "roller"};
        Assert.assertEquals(commonChar(s), Arrays.asList("e", "l", "l"));
    }

    @Test
    public void example2() {
        String[] s = {"cool", "lock", "cook"};
        Assert.assertEquals(commonChar(s), Arrays.asList("c", "o"));
    }

    @Test
    public void example3() {
        String[] s = {"acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"};
        Assert.assertEquals(commonChar(s), Arrays.asList());
    }
/*
pseudocode
1. get every word from string array
2. check the occurrence of every char in other string
3. get the count of char frequent occurrence of all char
4. get the most frequent occurrence >= s.length
5. get the char and store in arraylist
6. return the list
*/

    private List<String> commonChar(String[] words) {
        if (words.length < 1 || words[0].length() < 1) return Arrays.asList("");
        int i = 0, tempValue = 0;
        List<String> list = new ArrayList();
        Map<String, Integer> map1 = new HashMap();
        Map<String, Integer> map2 = new HashMap();
        Map<String, Integer> temp = new HashMap();

        i = 0;
        while (i < words[0].length()) {
            map1.put(String.valueOf(words[0].charAt(i)), map1.getOrDefault(String.valueOf(words[0].charAt(i)), 0) + 1);
            i++;
        }
        int min= Integer.MAX_VALUE;
        for (int j = 1; j < words.length; j++) {
            i = 0;

            while (i < words[j].length()) {
                map2.put(String.valueOf(words[j].charAt(i)), map2.getOrDefault(String.valueOf(words[j].charAt(i)), 0) + 1);
                i++;
            }

            for (Map.Entry<String, Integer> map : map1.entrySet()) {
                if (map2.containsKey(map.getKey())) {
                    tempValue = map1.get(map.getKey()) > map.getValue() ? map1.get(map.getKey()) : map.getValue();
                    //min=Math.min(tempValue, min);
                    temp.put(map.getKey(), min);
                }
            }
            map1.clear();
            map1.putAll(temp);
            temp.clear();
            map2.clear();
        }

        for (Map.Entry<String, Integer> m : map1.entrySet()) {
            while (m.getValue() > 0) {
                list.add(m.getKey());
                map1.put(m.getKey(), m.getValue() - 1);
            }
        }
        return list;
    }
}




