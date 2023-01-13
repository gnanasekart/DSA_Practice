package LeetCode_Daily_Practice.String.Array;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
Given two strings of lowercase alphabets and a value k, the task is to find if two strings are K-anagrams of each other or not.
Two strings are called k-anagrams if following two conditions are true.

Both have same number of characters.
Two strings can become anagram by changing at most k characters in a string.
 */

public class Two_String_K_Anagram {
    @Test
    public void ex1(){
        String str1 = "anagram";
        String str2 = "grammar";
        int k = 2;
        Assert.assertEquals(KAnagram(str1, str2, k), true);
    }

    private boolean KAnagram(String str1, String str2, int k) {
        if(str1.length() != str2.length())
            return false;
        int[] a = new int[26];
        int[] b = new int[26];
        for(int i=0; i<str1.length(); i++){
            a[str1.charAt(i) - 'a']++;
            b[str2.charAt(i)-'a']++;
        }
        int count=0;
        for (int i=0; i<26; i++){
            if(a[i]>b[i]){
                count+=Math.abs(a[i]-b[i]);
            }
        }
        return count<=k;
    }
}
