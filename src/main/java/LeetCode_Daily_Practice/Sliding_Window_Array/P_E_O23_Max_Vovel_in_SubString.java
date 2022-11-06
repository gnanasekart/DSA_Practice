package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class P_E_O23_Max_Vovel_in_SubString {
    /*
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
*/

    private int maxVovel(String s, int k) {
        if (s.length() < k) return 0;
        int maxi = 0, i=0;
        for (; i < s.length();i++) {
            for (int j = i + k; j < s.length(); j++,i++) {
                String sub = s.substring(i, j);
                maxi = Math.max(maxi, isvovel(sub));
            }
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
}
