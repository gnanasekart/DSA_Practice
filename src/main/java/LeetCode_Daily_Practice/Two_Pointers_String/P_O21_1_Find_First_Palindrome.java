package LeetCode_Daily_Practice.Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_O21_1_Find_First_Palindrome {
/*
    https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
    Given an array of strings words, return the first palindromic string in the array.
    If there is no such string, return an empty string "".

    A string is palindromic if it reads the same forward and backward.

            Constraints:

            1 <= words.length <= 100
            1 <= words[i].length <= 100
    words[i] consists only of lowercase English letters.
*/

    @Test
    public void example1(){
        String[] words={"abc","car","ada","racecar","cool"};
        Assert.assertEquals(palindromic(words), "ada");
    }

    @Test
    public void example2(){
        String[] words={"notapalindrome","racecar"};
        Assert.assertEquals(palindromic(words), "racecar");
    }

    @Test
    public void example3(){
        String[] words={"def","ghi"};
        Assert.assertEquals(palindromic(words), "");
    }

    @Test
    public void example4(){
        String[] words={"d", "dd", "ee"};
        Assert.assertEquals(palindromic(words), "d");
    }

    @Test
    public void example5(){
        String[] words={"dd"};
        Assert.assertEquals(palindromic(words), "dd");
    }

    @Test
    public void example6(){
        String[] words={"knywrurkwbrtpalvuuzbczcwzpdqibcwwyflwiddixemsrwblupyerjgvcpavdjfhmujitcsmdbvhxw","ovkeowhqvwlndtpxdnimgietvjsqydbuuwmxkfxxgn","damomwtjugmsrfyvytaheg","bngqatscosdakdwjz","jwzcowuantgqlzjrzgpapcugxvviltrhmcwijtpqapmxjfcilrsmsbeffphcxmaozlczncoxxjmuqijhidxqinhywrtah","ujvoejixvaioikkwzxgtmkchckrigfejjpheiiehpjjefgirkchckmtgxzwkkioiavxijeovju","kacjvcouuigbhydrryaperxvjetwsycmnlkxujaqngjhhotqskclquklxsozfryfxwiksstmropcdvhgsnosgvltqo","qrbsdxxolwzmyltproznfgyydxkkejwdiwpvfzvjoxqvwguoerhclytzvolymbxummwsoqtttyttik","tkekt","esrshrlfoihhjrouleucwpeubygivoatrfraphgwpvtkanwu","kwzrfelynncvsrwvaukiinhjdydmlimggjldhflygemzwnjizzlsuqwahsufwmwhfjkjpngdfsudyavtogoaqzknpew","sdgpcnvsbzxhyjt"};
        Assert.assertEquals(palindromic(words), "ujvoejixvaioikkwzxgtmkchckrigfejjpheiiehpjjefgirkchckmtgxzwkkioiavxijeovju");
    }
/*
1. Check the condition for empty array
2. Traversal every word from words array
3. check the particular word is palidrome or not
4. if palindromic found then return word
5. else return emtry string
*/
    private String palindromic(String[] words){

        if(words.length <1 ) return "";
        int i=0;
        String word = null;
        while(i<words.length) {
            if (words[i].length() < 2)
                return words[i];
            else {
                word = words[i++];
                String revWord = reverseWord(word);
                if (revWord.equals(word))
                    return word;
            }
        }
        return "";
    }

    public String reverseWord(String word){
        char[] ch = word.trim().toCharArray();
        char c;
        int left=0, right=word.length()-1;
        while(left<right){//=>O(n)
            if(ch[left]>=95 && ch[right]<=122){
                c=ch[left];
                ch[left++]=ch[right];
                ch[right--]=c;
            }
        }
        return String.valueOf(ch);
    }

    //best solution
    public String firstPalindrome(String[] words) {
        for(String s : words){
            if(isIt(s))return s;
        }
        return "";
    }
    public boolean isIt(String word){
        for(int i = 0; i < word.length()/2; i++){
            if(word.charAt(i) != word.charAt(word.length()-1-i))
                return false;
        }
        return true;
    }
}
