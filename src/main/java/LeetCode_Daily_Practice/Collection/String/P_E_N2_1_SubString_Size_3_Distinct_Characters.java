package LeetCode_Daily_Practice.Collection.String;

import org.testng.Assert;
import org.testng.annotations.Test;

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
Assert.assertEquals(distinctCharacters(s), 1);
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
}
