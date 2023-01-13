package LeetCode_Daily_Practice.String.Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_Check_If_a_Word_Occurs_As_Prefix {
    /*

    leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
Given a sentence that consists of some words separated by a single space, and a searchWord,
check if searchWord is a prefix of any word in sentence.

Return the index of the word in sentence (1-indexed) where searchWord is a prefix of this word.
If searchWord is a prefix of more than one word, return the index of the first word (minimum index).
If there is no such word return -1.
A prefix of a string s is any leading contiguous substring of s.

Input: sentence = "i love eating burger", searchWord = "burg"
Output: 4
Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.

Constraints:

1 <= sentence.length <= 100
1 <= searchWord.length <= 10
sentence consists of lowercase English letters and spaces.
searchWord consists of lowercase English letters.


     */
    @Test
    public void ex1() {
        String sen = "i love eating burger";
        String searchWord = "burg";
        Assert.assertEquals(prefixContains(sen, searchWord), 4);
    }

    @Test
    public void ex2() {
        String sen = "this problem is an easy problem";
        String searchWord = "prob";
        Assert.assertEquals(prefixContains(sen, searchWord), 2);
    }

    @Test
    public void ex3() {
        String sen = "i am tired";
        String searchWord = "you";
        Assert.assertEquals(prefixContains(sen, searchWord), -1);
    }

    @Test
    public void ex4() {
        String sen = "love errichto jonathan dumb";
        String searchWord = "dumb";
        Assert.assertEquals(prefixContains(sen, searchWord), 4);
    }

    @Test
    public void ex5() {
        String sen = "hello from the other side";
        String searchWord = "they";
        Assert.assertEquals(prefixContains(sen, searchWord), -1);
    }

    private int prefixContains1(String sent, String searchWord) {

        String[] sen = sent.split(" ");
        int len = searchWord.length();
        for (int i = 0; i < sen.length; i++) {
            if (sen[i] != " " && (sen[i].length() >= len) && (sen[i].substring(0, len).equals(searchWord)))
               return i + 1;
        }
        return -1;
    }

    private int prefixContains(String sent, String searchWord) {
        String[] sen = sent.split(" ");
        for (int i = 0; i < sen.length; i++) {
            if (sen[i].indexOf(searchWord)==0)
                return i + 1;
        }
        return -1;
    }
}

