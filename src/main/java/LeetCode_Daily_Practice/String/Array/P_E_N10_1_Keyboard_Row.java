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
        Assert.assertEquals(findWords(words), new String[]{"Alaska", "Dad"});
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

    public String[] findWords2(String[] words) {
        List<String> result = new ArrayList<>();
        String[] levels = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (String word : words) {
            for (String level : levels) {
                int lettersCount = word.length();
                for (int k = 0; k < word.length(); k++) {
                    char c = Character.toLowerCase(word.charAt(k));
                    if (level.indexOf(c) < 0) {
                        break;
                    }
                    lettersCount--;
                }
                if (lettersCount == 0) {
                    result.add(word);
                    break;
                }
            }
        }
        return result.toArray(new String[0]);
    }

    public String[] findWords1(String[] words) {
        String s1 = "qwertyuiopQWERTYUIOP";
        String s2 = "asdfghjklASDFGHJKL";
        String s3 = "zxcvbnmZXCVBNM";
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            int count1=0,count2=0,count3=0,len=words[i].length();
            for(int j=0;j<len;j++){
                if(s1.contains(Character.toString(words[i].charAt(j))))
                    count1++;
                else if(s2.contains(Character.toString(words[i].charAt(j))))
                    count2++;
                else if(s3.contains(Character.toString(words[i].charAt(j))))
                    count3++;
                if(count1==len || count2==len || count3==len)
                    list.add(words[i]);
            }
        }
        String ans[] = new String[list.size()];
        list.toArray(ans);
        return ans;
    }

    public String[] findWords(String[] words) {
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            String s = words[i].toLowerCase();
            if(s.matches("[qwertyuiop]*") || s.matches("[asdfghjkl]*") || s.matches("[zxcvbnm]*")){
                ans.add(words[i]);
            }
        }
        return ans.toArray(new String[0]);
    }
}