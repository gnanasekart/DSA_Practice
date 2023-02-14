package LeetCode_Daily_Practice.Sliding_Window_String;

import java.util.Arrays;

public class No_Of_Char_Remove_to_make_Anagram {

    //O(n) + O(n) => O(2n) => O(n)
    public static int main(String[] args)
    {
        String s = "steps";
        String t = "steka";
        int count1[] = new int[26];

        for (int i=0; i<s.length(); i++)
            count1[s.charAt(i)-'a']++;

       for(int i=0; i<t.length(); i++){
           if(count1[t.charAt(i)-'a']>0)
               count1[t.charAt(i)-'a']--;
           else count1[t.charAt(i) - 'a']++;
       }

        return Arrays.stream(count1).sum();
    }
}
