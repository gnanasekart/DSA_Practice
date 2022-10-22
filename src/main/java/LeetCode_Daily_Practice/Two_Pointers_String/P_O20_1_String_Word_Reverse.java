package LeetCode_Daily_Practice.Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_O20_1_String_Word_Reverse {

/*
leetcode.com/problems/reverse-words-in-a-string-iii/

Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
*/

@Test
public void example1(){
    String s="Let's take LeetCode contest";
    String out ="s'teL ekat edoCteeL tsetnoc";
    Assert.assertEquals(wordReverse(s), out);
}

@Test
public void example2(){
    String s="God Ding";
    String out ="doG gniD";
    Assert.assertEquals(wordReverse(s), out);
}

@Test
public void example3(){
    String s="G D";
    String out ="G D";
    Assert.assertEquals(wordReverse(s), out);
}

@Test
public void example4(){
    String s="GD";
    String out ="DG";
    Assert.assertEquals(wordReverse(s), out);
}

@Test
public void example5(){
    String s="me   too";
    String out ="oot em";
    Assert.assertEquals(wordReverse(s), out);
}

@Test
public void example6(){
    String s="!Let's/ #take$ %LeetCode& (contest}";
    String out="/s'teL! $ekat# &edoCteeL% }tsetnoc(";
    Assert.assertEquals(wordReverse(s), out);
}
/*
1. check whether both the String length equals
2. Split the string to char string array
3. iterate every word and reverse its position
4. Concat the reverse word in a string with single space
5. return the conceited new string
 */

    //time=O(n)
    //space=O(1)
    private String wordReverse(String s){
        if(s.length()<=1) return s;

        String newstr=" ";
        String[] words = s.trim().split(" ");
        for(String word: words)//=> O(n)
            newstr+=" "+reverseWord(word);

        return newstr.trim();
    }

    public String reverseWord(String word){
        if(word.length()<=1) return word;
        int left=0, right=word.length()-1;
        char[] ch = word.trim().toCharArray();
        char c;

        while(left<right){//=>O(n)
            if(ch[left]>=33 && ch[right]<=126){
                c=ch[left];
                ch[left++]=ch[right];
                ch[right--]=c;
            }
        }
        return String.valueOf(ch);
    }

}
