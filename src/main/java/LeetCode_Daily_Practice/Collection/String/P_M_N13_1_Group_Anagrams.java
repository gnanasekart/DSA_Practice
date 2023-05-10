package LeetCode_Daily_Practice.Collection.String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class P_M_N13_1_Group_Anagrams {
    /*
leetcode.com/problems/group-anagrams/

Given an array of strings strs, group the anagrams together.
You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

Constraints:
1 <= strs.length <= 10^4
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
*/

    @Test
    public void ex1() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Assert.assertEquals(groupAnagram(strs), Arrays.asList(List.of(List.of("bat")),
                List.of(List.of("nat"), List.of("tan")),
                List.of(List.of("ate"), List.of("eat"), List.of("tea"))));
    }

    @Test
    public void ex2() {
        String[] strs = {""};
        Assert.assertEquals(groupAnagram(strs), Arrays.asList(("")));
    }

    @Test
    public void ex3() {
        String[] strs = {"a"};
        Assert.assertEquals(groupAnagram(strs), Arrays.asList(("a")));
    }

    @Test
    public void ex4() {
        String[] strs = {"one, two, three, four, five, six"};
        Assert.assertEquals(groupAnagram(strs), Arrays.asList(List.of("one"),List.of("two"),
                List.of("three"),List.of("four"), List.of("five"), List.of("six")));
    }

/*
pseudoCode
1. create a hashmap with String key and Arraylist as value
2. consider each string from the string array
3. Get first string and convert to array and sort the array
4. add the sorted string as key and sort the string and compare with key and
add the real string which matches with key
5. return the values as List<List<String>>;
*/

    //with Arrays.sort()
    public List<List<String>> groupAnagram1(String[] strs) {

        if (strs.length < 1) return Arrays.asList(List.of());
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            List<String> list = map.getOrDefault(new String(c), new ArrayList<>());
            list.add(str);
            map.put(new String(c), list);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    //without Arrays.sort()
    public List<List<String>> groupAnagram2(String[] strs) {

        if (strs.length < 1) return Arrays.asList(List.of());;
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();

        for (String str : strs) {
            Map<Character, Integer> hmap = new HashMap<>();
            for(char c: str.toCharArray()){
                    hmap.put(c, hmap.getOrDefault(c, 0)+1);
                }

            List<String> list = map.getOrDefault(hmap, new ArrayList<>());
            list.add(str);
            map.put(hmap, list);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    //without sort
    public List<List<String>> groupAnagram(String[] strs) {

        if (strs.length < 1) return Arrays.asList(List.of());
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        Map<Character, Integer> hmap = new HashMap<>();

        for (String str : strs) {
            int[] arr = new int[26];
            for(char c: str.toCharArray()){
                arr[c-'a']++;
                hmap.put(c, hmap.getOrDefault(String.valueOf(arr), 0)+1);
            }

            List<String> list = map.getOrDefault(hmap, new ArrayList<>());
            list.add(str);
            map.put(hmap, list);
        }
        //System.out.println(map.values().stream().collect(Collectors.toList()));
        return map.values().stream().collect(Collectors.toList());
    }
}
