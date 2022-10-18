package LeetCode_Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_O18_1_Reverse_Prefix_Word {

    /*
leetcode.com/problems/reverse-prefix-of-word/

Given a 0-indexed string word and a character ch, reverse the segment of word
 that starts at index 0 and ends at the index of the first occurrence
of ch (inclusive). If the character ch does not exist in word, do nothing.

For example, if word = "abcdefd" and ch = "d", then you should reverse
the segment that starts at 0 and ends at 3 (inclusive). The resulting string
will be "dcbaefd".
Return the resulting string.

Example 1:

Input: word = "abcdefd", ch = "d"
Output: "dcbaefd"
Explanation: The first occurrence of "d" is at index 3.
Reverse the part of word from 0 to 3 (inclusive),
the resulting string is "dcbaefd".

Constraints:

1 <= word.length <= 250
word consists of lowercase English letters.
ch is a lowercase English letter.
*/

    @Test
    public void example1(){
        String word="abcdefd";
        char ch='d';
        Assert.assertEquals(prefixReverse(word, ch), "dcbaefd");
    }

    @Test
    public void example2(){
        String word="abcdefd";
        char ch='l';
        Assert.assertEquals(prefixReverse(word, ch), "abcdefd");
    }

    @Test
    public void example3(){
        String word="d";
        char ch='d';
        Assert.assertEquals(prefixReverse(word, ch), "d");
    }

    @Test
    public void example4(){
        String word="abcdefd";
        char ch=' ';
        Assert.assertEquals(prefixReverse(word, ch), "");
    }

    @Test
    public void example5(){
        String word="abcefd";
        char ch='d';
        Assert.assertEquals(prefixReverse(word, ch), "dfecba");
    }

/*
Logic
- Check the condition if ch or word is empty
- traverse every char in string to identify the first occurrence of char
- if first occurrence is available get the substring between 0 to i+1
	- pass the substring to get reverse order and concat with remaining string
	- if no char found then return string
- return the entire string after reverse
*/

    private String prefixReverse(String w, char ch){
        if(ch==' ') return "";

        int i=0;
        String str="", sub="";

        while(i<w.length()){
            if(w.charAt(i)==ch){
                sub=w.trim().substring(0, i+1);
                str+=stringReverse(sub)+w.substring(i+1, w.length());
                return str;
            }
            i++;
        }
        return w;
    }

    public String stringReverse(String str){
        char[] c = str.toCharArray();
        int left=0, right=str.length()-1;
        char temp;
        while(left<str.length() && right>0)
        {
            if(left<right){
                temp=c[left];
                c[left]=c[right];
                c[right]=temp;
            }
            left++;
            right--;
        }
        return new String(c);
    }
}
