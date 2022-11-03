package LeetCode_Daily_Practice.Collection;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class P_E_2_N3_Unique_Morse_Code_Words {
   /*
    leetcode.com/problems/unique-morse-code-words/description/

    International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:

            'a' maps to ".-",
            'b' maps to "-...",
            'c' maps to "-.-.", and so on.
    For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...".
    We will call such a concatenation the transformation of a word.
    Return the number of different transformations among all words we have.

    Constraints:
    1 <= words.length <= 100
    1 <= words[i].length <= 12
    words[i] consists of lowercase English letters.
*/
    @Test
    public void example1(){
        String[] s = {"gin","zen","gig","msg"};
        Assert.assertEquals(morseCode(s), 2);
    }

    @Test
    public void example2(){
        String[] s = {"a"};
        Assert.assertEquals(morseCode(s), 1);
    }

    @Test
    public void example3(){
        String[] s = {""};
        Assert.assertEquals(morseCode(s), 0);
    }

    @Test
    public void example4(){
        String[] s = {""};
        Assert.assertEquals(morseCode(s), 3);
    }

/*
PseudoCode
1. collect the morse code in map based on key from 1 to 26
2. get the word from words array
3. find the char value from map
4. concat the char value for all the char in string
5. Add the conceited code into set
6. return the size
*/

    private int morseCode(String[] s){
        if(s.length<1 ||s[0].length()<1) return 0;
        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
                ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Map<Character, String> codeMap = new HashMap();
        Set<String> set = new HashSet();
        for(char i=97; i<=122; i++)
            codeMap.put(i, code[i-97]);

        String encoding="";
        for(String word: s){
            encoding="";
            int j=0;
            while(j<word.length()){
                encoding+= codeMap.get(word.charAt(j++));
            }
            set.add(encoding);
        }
        return set.size();
    }
}
