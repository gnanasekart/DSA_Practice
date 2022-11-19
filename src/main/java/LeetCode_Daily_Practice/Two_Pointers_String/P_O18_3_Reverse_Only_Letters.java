package LeetCode_Daily_Practice.Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_O18_3_Reverse_Only_Letters {
    /*
    https://leetcode.com/problems/reverse-only-letters/
    Given a string s, reverse the string according to the following rules:

    All the characters that are not English letters remain in the same position.
    All the English letters (lowercase or uppercase) should be reversed.
    Return s after reversing it.

    Example 1:

    Input: s = "ab-cd"
    Output: "dc-ba"

    Constraints:
    1 <= s.length <= 100
    s consists of characters with ASCII values in the range [33, 122].
    s does not contain '\"' or '\\'.

    */
    @Test
    public void example1(){
        String s="ab-cd";
        Assert.assertEquals(reverseLetter(s), "dc-ba");
    }

    @Test
    public void example2(){
        String s="a-bC-dEf-ghIj";
        Assert.assertEquals(reverseLetter(s), "j-Ih-gfE-dCba");
    }

    @Test
    public void example3(){
        String s="Test1ng-Leet=code-Q!";
        Assert.assertEquals(reverseLetter(s), "Qedo1ct-eeLg=ntse-T!");
    }

    @Test
    public void example4(){
        String s="!@#d#@!";
        Assert.assertEquals(reverseLetter(s), "!@#d#@!");
        Character.isAlphabetic('a');
    }

    @Test
    public void example5(){
        String s="!#@!";
        Assert.assertEquals(reverseLetter(s), "!#@!");
    }

/*
logic-
- check if string is less than 1
- create new array with same size
- first copy the special char into same position
- then read the char from left and assign from right in new array
- finally return new array
*/

    private String reverseLetterBF(String str){
        char[] ch = str.toCharArray();
        int i=0, j=str.length()-1;
        char temp;
        String ss = "abcdefghijklmnopqrstuvwxyzQWERTYUIOPASDFGHJKLZXCVBNM";
        while(i<j){
            if(!ss.contains(String.valueOf(ch[i]))) i++;
            else if(!ss.contains(String.valueOf(ch[j]))) j--;
            else{
                temp = ch[i];
                ch[i]= ch[j];
                ch[j] = temp;
                i++;j--;
            }
        }
        return String.valueOf(ch);
    }

    //time=O(n)
    //space=O(n) new char array created
    private String reverseLetter(String s){
        int left=0, right=s.length()-1;
        char[] c = s.toCharArray();
        char temp;
        while(left<right){
            if(isalpha(c[left]) && (isalpha(c[right]))){
                temp=c[left];
                c[left++]=c[right];
                c[right--]=temp;
            }else if(!isalpha(c[left])){
                left++;
                continue;
            }else
                right--;
            continue;
        }
        return new String(c);
    }

    //instead of Character.isAlphabetic() method
    public boolean isalpha(char c){
        if(c>='a' && c<='z' && c>='A' && c<='Z'){
            return true;
        }
        return false;
    }
    }

