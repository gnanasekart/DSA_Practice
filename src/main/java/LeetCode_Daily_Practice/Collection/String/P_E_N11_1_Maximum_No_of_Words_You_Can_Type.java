package LeetCode_Daily_Practice.Collection.String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class P_E_N11_1_Maximum_No_of_Words_You_Can_Type {
    /*
    https://leetcode.com/problems/maximum-number-of-words-you-can-type/

There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.

Given a string text of words separated by a single space (no leading or trailing spaces) and a string brokenLetters of all distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard.

Constraints:
1 <= text.length <= 104
0 <= brokenLetters.length <= 26
text consists of words separated by a single space without any leading or trailing spaces.
Each word only consists of lowercase English letters.
brokenLetters consists of distinct lowercase English letters.
*/

    @Test
    public void example1() {
        String text = "hello world";
        String broken = "ad";
        Assert.assertEquals(typeWords(text, broken), 1);
    }

    @Test
    public void example2() {
        String text = "leet code";
        String broken = "lt";
        Assert.assertEquals(typeWords(text, broken), 1);
    }

    @Test
    public void example3() {
        String text = "leet code";
        String broken = "e";
        Assert.assertEquals(typeWords(text, broken), 0);
    }

    @Test
    public void example4() {
        String text = "leet code";
        String broken = "a";
        Assert.assertEquals(typeWords(text, broken), 2);
    }

    @Test
    public void example5() {
        String text = "leet code";
        String broken = "";
        Assert.assertEquals(typeWords(text, broken), 2);
    }

    @Test
    public void example6() {
        String text = "l";
        String broken = "aeiou";
        Assert.assertEquals(typeWords(text, broken), 0);
    }

    @Test
    public void example7() {
        String text = "a b c d e";
        String broken = "abcde";
        Assert.assertEquals(typeWords(text, broken), 0);
    }

/*
pseudocode
1.



     */

    private int typeWords(String text, String broken) {
        int count = 0;
        String[] words = text.trim().split(" ");
        if (broken.isEmpty()) return words.length;
        Set<String> set = new HashSet();
        for (String word : words) {
            for (char c : broken.toCharArray())
                if ((text.indexOf(c) != -1) && !word.contains(String.valueOf(c))) {
                    set.add(word);
                    //break;
                }
        }
        return set.size();
    }
}
