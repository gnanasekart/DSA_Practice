package LeetCode_Daily_Practice.String.Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class P_E_N10_1_Keyboard_Row {
    /*

    leetcode.com/problems/keyboard-row/

Given an array of strings words, return the words that can be typed using letters of the
alphabet on only one row of American keyboard like the image below.

In the American keyboard:

the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".


String one = "qwertyuiop";
String two = "asdfghjkl";
String three = "zxcvbnm";

Constraints:
1 <= words.length <= 20
1 <= words[i].length <= 100
words[i] consists of English letters (both lowercase and uppercase).
*/

    @Test
    public void example1() {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        Assert.assertEquals(keyboard(words), new String[]{"Alaska", "Dad"});
    }

    @Test
    public void example2() {
        String[] words = {"omk"};
        Assert.assertEquals(keyboard(words), new String[]{});
    }

    @Test
    public void example3() {
        String[] words = {"adsdf", "sfd"};
        Assert.assertEquals(keyboard(words), new String[]{"adsdf", "sfd"});
    }

    @Test
    public void example4() {
        String[] words = {"a"};
        Assert.assertEquals(keyboard(words), new String[]{"a"});
    }

    @Test
    public void example5() {
        String[] words =
                {"a", "l", "G", "K", "d", "a", "l", "G", "K", "d", "a", "l", "G", "K", "d"};
        Assert.assertEquals(keyboard(words),
                new String[]{"a","l","G","K","d","a","l","G","K","d","a","l","G","K","d"});
    }

/*
pseudocode
1. check if words.length !< 1 return entry array
2. take the three keyboard lines into a strings
3. take every word and check the first char of word with keyword string
4. if the indexOf value != -1, then that string present here.
5. if not then move the index to next string
*/

    public String[] keyboard(String[] str) {
        if (str.length < 1) return str;

        String one = "qwertyuiop";
        String two = "asdfghjkl";
        String three = "zxcvbnm";
        boolean inthekeyboard = false;
        List<String> list = new ArrayList();
        for (String small : str) {
            String s = small.toLowerCase();
            if (one.indexOf(s.charAt(0)) != -1) {
                char[] ch = s.toCharArray();
                for (char a : ch) {
                    if (one.indexOf(a) != -1) {
                        inthekeyboard = true;
                    }else{
                        inthekeyboard = false;
                        break;
                    }
                }
            } else if (two.indexOf(s.charAt(0)) != -1) {
                char[] ch = s.toCharArray();
                for (char a : ch) {
                    if (two.indexOf(a) != -1) {
                        inthekeyboard = true;
                    }else{
                        inthekeyboard = false;
                        break;
                    }
                }
            } else if (three.indexOf(s.charAt(0)) != -1) {
                char[] ch = s.toCharArray();
                for (char a : ch) {
                    if (three.indexOf(a) != -1) {
                        inthekeyboard = true;
                    }else{
                        inthekeyboard = false;
                        break;
                    }
                }
            }
            if(inthekeyboard)
                list.add(small);
        }
        return list.toArray(new String[0]);
    }
}
