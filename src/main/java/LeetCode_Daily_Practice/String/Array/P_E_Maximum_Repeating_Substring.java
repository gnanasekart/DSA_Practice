package LeetCode_Daily_Practice.String.Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_Maximum_Repeating_Substring {

    /*

    For a string sequence, a string word is k-repeating if word concatenated k times is a substring of sequence.
    The word's maximum k-repeating value is the highest value k where word is k-repeating in sequence.
    If word is not a substring of sequence, word's maximum k-repeating value is 0.

Given strings sequence and word, return the maximum k-repeating value of word in sequence.
Example 1:

Input: sequence = "ababc", word = "ab"
Output: 2
Explanation: "abab" is a substring in "ababc"

Constraints
1 <= sequence.length <= 100
1 <= word.length <= 100
sequence and word contains only lowercase English letters.

     */

    @Test
    public void ex() {
        String sequence = "ababc", word = "ab";
        Assert.assertEquals(repatingSubString(sequence, word), 2);
    }

    @Test
    public void ex1() {
        String sequence = "ababc", word = "ba";
        Assert.assertEquals(repatingSubString(sequence, word), 1);
    }

    @Test
    public void ex2() {
        String sequence = "ababc", word = "ac";
        Assert.assertEquals(repatingSubString(sequence, word), 0);
    }

    @Test
    public void ex3() {
        String sequence = "c", word = "c";
        Assert.assertEquals(repatingSubString(sequence, word), 1);
    }

    @Test
    public void ex4() {
        String sequence = "a", word = "c";
        Assert.assertEquals(repatingSubString(sequence, word), 0);
    }


    private int repatingSubString2(String sequence, String word) {
        int k=0;
        String c = word;
        while (sequence.indexOf(c)!=-1){
            c=c+word;
            k++;
        }
        return k;
    }


    private int repatingSubString(String sequence, String word) {
        int k=0;
        String c = word;
        while (sequence.contains(c)==true){
            c=c+word;
            k++;
        }
        return k;
    }


    private int repatingSubString1(String sequence, String word) {

        if (!sequence.contains(word)) return 0;

        int count = 0, wlen = word.length();//2

        int ind = sequence.indexOf(word);//0
        wlen = ind + wlen;//2
        String s = sequence.substring(ind, wlen);//ab

        while (wlen < sequence.length()) {
            if (s.equals(word)) {
                count++;
                ind = sequence.indexOf(word, wlen);

                if(ind==-1) break;
                System.out.println(count);
            }
            wlen = ind + wlen;
        }
        return count;
    }
}
