package LeetCode_Daily_Practice.Sliding_Window_String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class P_E_O23_Max_Vovel_in_SubString {
    /*
    leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
    Given a string s and a number k, find the maximum number of vowels in substring
    of size k.
    String: "workaattech"
    k: 3
*/

    @Test
    public void example1() {
        String s = "workaattech";
        int k = 3;
        Assert.assertEquals(maxVovelSW(s, k), 2);
    }

    @Test
    public void example5() {
        String s = "abciiidef";
        int k = 3;
        Assert.assertEquals(maxVovelSW(s, k), 3);
    }

    @Test
    public void example2() {
        String s = "wooorrrrk";
        int k = 4;
        Assert.assertEquals(maxVovel(s, k), 3);
    }

    @Test
    public void example3() {
        String s = "aeiouzaeiou";
        int k = 4;
        Assert.assertEquals(maxVovel(s, k), 4);
    }

    @Test
    public void example4() {
        String s = "sdfghjkl";
        int k = 3;
        Assert.assertEquals(maxVovel(s, k), 0);
    }

	/*
1. get each char of substring of k size
2. verify it is vovel
	- count vovel
	- if not continue
3. return the max count

"weallloveyou"
7
*/

    private int maxVovel(String s, int k) {
        if (s.length() < k) return 0;
        int maxi = 0, i=0, count=0;
        for(; i<k; i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u')
                count++;
        }
        maxi = Math.max(maxi, count);
        for (i=1; i < s.length()-k;i++) {
            char cc = s.charAt(i-1);
            char ss = s.charAt(i+k-1);
            if(cc=='a' || cc=='e' || cc=='i' || cc=='o' || cc=='u') count--;
            if(ss=='a' || ss=='e' || ss=='i' || ss=='o' || ss=='u') count++;
                maxi = Math.max(maxi, count);
        }
        return maxi;
    }

    private int maxVovelSW(String s, int k) {
        if (s.length() < k) return 0;
        int maxi = 0;int i=k;

        while(i<s.length()){
                String sub = s.substring(i-k+1, i);
                maxi = Math.max(maxi, isvovel(sub));
                i++;
            }
        return maxi;
    }

    public int isvovel(String str) {
        char[] ch = str.toCharArray();
        int left = 0;
        ArrayList<Character> list = new ArrayList(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int count = 0;

        while (left < ch.length) {
            if (list.contains(str.charAt(left++))) {
                count++;
            }
        }
        return count;
    }


    public int maxVowels(String s, int k) {
        String vowel="aeiou";
        if(s.length()==1 && vowel.indexOf(s.charAt(0))!=-1) return 1;
        if(s.length()==1 && vowel.indexOf(s.charAt(0))==-1) return 0;
        int count=0, Max=Integer.MIN_VALUE;//abciiidef
        int i=0;
        for(; i<k; i++){
            if(vowel.indexOf(s.charAt(i))!=-1)
                count++;
        }
        Max=count>Max?count:Max;
        System.out.println(Max);
        for(;i<s.length();i++){
            if(vowel.indexOf(s.charAt(i-k))!=-1) count--;
            if(vowel.indexOf(s.charAt(i))!=-1) count++;
            Max=count>Max?count:Max;
            System.out.println(Max);
        }
        return Max;
    }
}
