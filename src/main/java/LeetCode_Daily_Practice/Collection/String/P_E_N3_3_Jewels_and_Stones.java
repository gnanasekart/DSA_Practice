package LeetCode_Daily_Practice.Collection.String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class P_E_N3_3_Jewels_and_Stones {
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
        Assert.assertEquals(UniqueStonesRegex(j, s), 3);
    }

    @Test
    public void example2() {
        String j = "aAbC";
        String s = "aAAbbbb";
        Assert.assertEquals(UniqueStonesRegex(j, s), 7);
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

    private int uniqueStonesBF(String j, String s) {
        int count=0;
        for (int i = 0; i < j.length(); i++) {
            for (int k = 0; k < s.length(); k++) {
                if(j.charAt(i) == s.charAt(k))
                    count++;
            }
        }
        return count;
    }

    private int uniqueStones(String j, String s) {
        if (j.length() < 1 || s.length() < 1) return 0;
        if (j.length() == 1 && j.charAt(0) == s.charAt(0)) return 1;

        Map<Character, Integer> map = new HashMap();

        int i = 0, sum = 0, l = 0;
        while (i < s.length())
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i++), 0) + 1);

        while (l < j.length()) {
            if (map.containsKey(j.charAt(l)))
                sum += map.get(j.charAt(l));
            l++;
        }
        return sum;
    }

    //using indexOf
    private int uniqueStonesIndexOf(String j, String s) {
        int num=0;
        for(Character st : s.toCharArray()){
            //if(j.indexOf(st) != -1)
              if(j.contains(st.toString()))
                  num++;
        }
        return num;
    }

    private int UniqueStonesASCII(String j, String s){
        int[] ch = new int[58];
       for(char c: j.toCharArray()){
           ch[c-'A']++;
       }
       int count=0;
       for(char st: s.toCharArray()){
           if(ch[st-'A'] != 0){
               count++;
           }
       }
       return count;
    }

    private int UniqueStonesReplace(String j, String s){
        String stonec = s;

        for(Character jj: j.toCharArray()){
            stonec.replace(jj.toString(), "");
        }
        return s.length()-j.length();
    }

    private int UniqueStonesRegex(String j, String s){
        int count = s.replaceAll("[^"+j+"]", "").length();
        return count;
    }
}
