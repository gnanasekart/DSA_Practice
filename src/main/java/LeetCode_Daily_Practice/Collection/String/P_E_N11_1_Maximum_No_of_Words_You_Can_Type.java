package LeetCode_Daily_Practice.Collection.String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class P_E_N11_1_Maximum_No_of_Words_You_Can_Type {
    /*
    https://leetcode.com/problems/maximum-number-of-words-you-can-type/

There is a malfunctioning keyboard where some letter keys do not work.
All other keys on the keyboard work properly.

Given a string text of words separated by a single space (no leading or trailing spaces)
and a string brokenLetters of all distinct letter keys that are broken,
return the number of words in text you can fully type using this keyboard.

Constraints:
1 <= text.length <= 10^4
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
        Assert.assertEquals(typeWords(text, broken), 1);
    }

    @Test
    public void example7() {
        String text = "a b c d e";
        String broken = "abcde";
        Assert.assertEquals(typeWords(text, broken), 0);
    }

/*
pseudocode
1. convert the text into string array
2. pass every string into iteration and check for every word and char which contains broken letters
3. if present get the count
4. and finally check the difference between two string
     */

    private int typeWords1(String text, String broken) {

        String[] words = text.trim().split(" ");

        if (broken.isEmpty()) return words.length;

        List<String> set = new ArrayList<>();
        Arrays.stream(words).forEach(w -> set.add(w));
        for (char c : broken.toCharArray()) {
            for (String word : words) {
                if (word.contains(String.valueOf(c))) {
                    set.remove(word);
                    break;
                }
            }
        }
        return set.size();
    }

    private int typeWords(String text, String broken) {
        int count = 0;
        for (String word : text.split(" ")) {
            for (int i = 0; i < word.length(); i++) {
                if (broken.contains(word.charAt(i) + "")) {
                    count++;
                    break;
                }
            }
        }
        return text.split(" ").length - count;
    }
}
