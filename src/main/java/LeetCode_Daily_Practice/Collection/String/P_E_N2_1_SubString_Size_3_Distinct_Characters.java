package LeetCode_Daily_Practice.Collection.String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class P_E_N2_1_SubString_Size_3_Distinct_Characters {
    /*
    https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/

A string is good if there are no repeated characters.
Given a string s, return the number of good substrings of length three in s.
Note that if there are multiple occurrences of the same substring,
every occurrence should be counted.
A substring is a contiguous sequence of characters in a string.
Constraints:
1 <= s.length <= 100
s consists of lowercase English letters.
*/

@Test
public void example1(){
String s = "xyzzaz";
Assert.assertEquals(countGoodSubstrings(s), 1);
}

@Test
public void example2(){
String s = "aababcabc";
Assert.assertEquals(distinctCharacters(s), 4);
}

@Test
public void example3(){
String s = "aaabbbccc";
Assert.assertEquals(distinctCharacters(s), 0);
}

@Test
public void example4(){
String s = "aa";
Assert.assertEquals(distinctCharacters(s), 0);
}

/*
PseudoCode
1. consider two pointer Left=0, right=0
2. check for condition right<substring.length()
3. add every char into set
4. check set size is equal to substring length
5. if it matches the condition then increment count
6. else move to next substring by increment left+1 and right=left
7. return the count
*/

    //brute force
    private int distinctCharacters(String s){
        int k=3, right=0, count=0;
        if(s.length()<3) return 0;

        Set<Character> set = new HashSet();
        for(int i=0; i<=s.length()-k; i++){
            right=i;
            while(right<i+k)
                set.add(s.charAt(right++));
            if(set.size()==3) count++;
            set.clear();
        }
        return count;
    }

    public int countGoodSubstrings(String s) {
        int res = 0, start = 0, end = 3;

        if(s.length() < 3) return 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0 ; i < 3; i++) {
            char c  = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        if(map.size() == 3) res++;

        while(end<s.length()) {
            char e = s.charAt(end);
            char st= s.charAt(start);

            map.put(st, map.get(st) - 1);
            if(map.get(st) == 0)
                map.remove(st);

            map.put(e, map.getOrDefault(e ,0) + 1);

            if(map.size() == 3) res++;

            start++;
            end++;
        }
        return res;
    }

    public int countGoodSubstrings1(String s) {
        int nextIndex[]=new int[128];
        int r=0, l=0;
        int count=0;
        int res=0;
        int n=s.length();
        for(r=0;r<n;r++){
            l=Math.max(nextIndex[s.charAt(r)],l);
            count=r-l+1;
            nextIndex[s.charAt(r)]=r+1;
            if(count>=3){
                res++;
                count=0;
            }
        }
        return res;
    }
}
