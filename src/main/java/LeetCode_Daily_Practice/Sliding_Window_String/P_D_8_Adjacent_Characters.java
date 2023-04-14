package LeetCode_Daily_Practice.Sliding_Window_String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class P_D_8_Adjacent_Characters {
    /*
   For each word in a list of words, if any two adjacent characters are equal, change one of them.
   Determine the minimum number of substitutions so the final string contains no adjacent equal characters.

Example

words = ['add', 'boook', 'break']

'add': change one d (1 change)
'boook': change the middle o (1 change)
'break': no changes are necessary (0 changes)

The return array is [1,1,0].

Function Description

Complete the function minimalOperations in the editor below.
minimalOperations has the following parameter(s):

    string words[n]:  an array of strings

Returns:
    int[n]: each element i is the minimum substitutions for words[i]

Constraints

1 ≤ n ≤ 100
2 ≤ length of words[i] ≤ 10^5
Each character of words[i] is in the range ascii[a-z].

     */

    @Test
    public void ex1() {
        String[] s = {"add", "boook", "break"};
        Assert.assertEquals(adjancentChar(s), new int[]{1, 1, 0});
    }

    @Test
    public void ex2() {
        String[] s = {"ab", "aa", "aaa", "aba"};
        Assert.assertEquals(adjancentChar(s), new int[]{0, 1, 1, 0});
    }

    @Test
    public void ex3() {
        String[] s = {"'aaaaaaaaa"};
        Assert.assertEquals(adjancentChar(s), new int[]{4});
    }

    /*
    logic
1. get every string from word array
2. start loop to check i and i+1 value is equals means get the match count
3. get the count and return it as count/2 else return 0
     */


    private int[] adjancentChar(String[] words) {
        int left = 0, right = 0, count = 1;
        int[] res = new int[words.length];
        for (String word : words) {
            for (int i = 1; i < word.length(); i++)
                if (word.charAt(i) == word.charAt(i - 1))
                    count++;

            if (count > 1)
                res[right] = count / 2;
            right++;
            count = 1;
        }
        return res;
    }

    public int[] minimalOperations(String[] words) {
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (s == null || s.isEmpty()) {
                result[i] = 0;
                continue;
            }
            int count = 0;
            char[] chars = words[i].toCharArray();
            int cc = 1;
            for (int j = 1; j < chars.length; j++) {
                if (chars[j] == chars[j - 1]) {
                    // count the number of times current character repeats
                    cc++;
                    if (j == chars.length - 1) {
                        // special case when last character is repeating
                        count = count + cc / 2;
                    }
                } else {
                    count = count + cc / 2;
                    cc = 1;
                }
            }
            result[i] = count;
        }
        return result;
    }
}
