package LeetCode_Daily_Practice.Sliding_Window_String;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_M_Longest_substring_with_alteast_K_repeating_char {
        /*
Given a string s and an integer k, return the length of the longest substring of s
such that the frequency of each character in this substring is greater than or equal to k.

Constraints:
1 <= s.length <= 10^4
s consists of only lowercase English letters.
1 <= k <= 10^5
    */

    @Test
    public void ex1() {
        String s = "aaabb";
        int k = 3;
        Assert.assertEquals(longestKRepeatingChar(s, k), 3);
    }

    @Test
    public void ex2() {
        String s = "ababbc";
        int k = 2;
        Assert.assertEquals(longestKRepeatingChar(s, k), 5);
    }

    public int longestKRepeatingChar(String s, int k) {
        char[] chs = s.toCharArray();
        if (k > chs.length) return 0;

        int res = chs.length;

        while (res >= k) {
            int l = 0;
            int h = res - 1;

            int[] cnt = new int[26];
            for (int i = 0; i < res; i++)
                    cnt[chs[i] - 'a']++;

            while (h < chs.length) {
                boolean found = false;
                for (int i = 0; i < cnt.length; i++) {
                    if (cnt[i] == 0 || cnt[i] >= k) {
                        continue;
                    }
                    found = true;
                    break;
                }

                if (!found)
                    return res;

                cnt[chs[l++] - 'a']--;
                if (h + 1 < chs.length) {
                    cnt[chs[h + 1] - 'a']++;
                }
                ++h;
            }
            res--;
        }
        return 0;
    }
}