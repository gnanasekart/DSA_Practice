package LeetCode_Daily_Practice.Collection.Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class P_E_N3_2_Unique_Morse_Code_Words {
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
        Assert.assertEquals(morseCodeHashMap(s), 2);
    }

    @Test
    public void example2(){
        String[] s = {"a"};
        Assert.assertEquals(morseCodeStream(s), 1);
    }

    @Test
    public void example3(){
        String[] s = {""};
        Assert.assertEquals(morseCodeStream(s), 0);
    }

    //@Test
    public void example4(){
        String[] s = {""};
        Assert.assertEquals(morseCodeStream(s), 3);
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

    String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
                ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    //using HashMap and Set
    private int morseCodeMap_Set(String[] s){
        if(s.length<1 ||s[0].length()<1) return 0;
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

    //using Set
    private int morseCodeSet(String[] s){
        if(s.length<1 ||s[0].length()<1) return 0;
        Set<String> set = new HashSet();
        String encoding="";
        for(String word: s){
            encoding="";
            int j=0;
            while(j<word.length())
                encoding+= code[word.charAt(j++)];
            set.add(encoding);
        }
        return set.size();
    }

    private int morseCodeStream(String[] words){
        if(words.length<1 ||words[0].length()<1) return 0;

        return (int)Arrays.stream(words)
                        .map(word -> word.chars().mapToObj(ch -> code[ch - 'a'])
                        .collect(Collectors.joining()))
                        .distinct().count();
    }

    private int morseCodeHashMap(String[] s){
        if(s.length<1 ||s[0].length()<1) return 0;

        Map<String, Integer> map = new HashMap<>();
        String encoding="";
        for(String word: s){
            encoding="";
            int j=0;
            while(j<word.length())
                encoding+= code[word.charAt(j++)-'a'];

            map.put(encoding, 1);

            //for arraylist
//            if(!list.contains(encoding))
//                list.add(encoding);
        }
        return map.size();
    }
}
