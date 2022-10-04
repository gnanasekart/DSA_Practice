package LeetCode_Practice;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shortest_Completing_Word {
    /*
    Given a string licensePlate and an array of strings words, find the shortest completing word in words.
    A completing word is a word that contains all the letters in licensePlate.
    Ignore numbers and spaces in licensePlate, and treat letters as case-insensitive.
    If a letter appears more than once in licensePlate,
    then it must appear in the word the same number of times or more.

    For example, if licensePlate = "aBc 12c",
    then it contains letters 'a', 'b' (ignoring case), and 'c' twice.
    Possible completing words are "abccdef", "caaacab", and "cbca".

    Return the shortest completing word in words. It is guaranteed an answer exists.
    If there are multiple shortest completing words, return the first one that occurs in words.

    Example 1:

    Input: licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]
    Output: "steps"
    Explanation: licensePlate contains letters 's', 'p', 's' (ignoring case), and 't'.
    "step" contains 't' and 'p', but only contains 1 's'.
    "steps" contains 't', 'p', and both 's' characters.
    "stripe" is missing an 's'.
    "stepple" is missing an 's'.
     Since "steps" is the only word containing all the letters, that is the answer.
     */

    // @Test
    public void example1() {
        String licensePlate = "1s3 456";
        String[] words = {"looks", "pest", "stew", "show"};
        completingWord(licensePlate, words);
    }

    @Test
    public void example2() {
        String licensePlate = "1s3 PSt";
        String[] words = {"step", "steps", "stripe", "stepple"};
        completingWord(licensePlate, words);
    }

    /*
    1. convert to lowercase
    2. replace all except a-z
    3. char-count - collect in map
    4. match occurrence count for words in array list
    5. out of this find the min size.
     */
    private void completingWord(String licensePlate, String[] words) {

        String letter = licensePlate.toLowerCase().replaceAll("[^a-z]", "");

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < letter.length(); i++) {
            map.put(letter.charAt(i), map.getOrDefault(letter.charAt(i), 0) + 1);
        }

        List<String> resultList = new ArrayList<>();
        int minLength = 0;
        String result = "";

        //Adding words in to map
        for (int i = 0; i < words.length; i++) {
            boolean bmatches = true;
            Map<Character, Integer> wordMap = new HashMap<>();
            for (int j = 0; j < words[i].length(); j++) {
                wordMap.put(words[i].charAt(j), wordMap.getOrDefault(words[i].charAt(j), 0) + 1);
            }
            //System.out.println(wordMap);
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() != wordMap.get(entry.getKey())) {
                    bmatches = false;
                    break;
                }
            }
            //if only all matches then push to list
            if (bmatches) {
                if (minLength > words[i].length()) {
                    result = words[i];
                    minLength = words[i].length();
                }
                resultList.add(words[i]);
            }
        }

//        int minivalue = 0;
//        for (int i = 1; i < resultList.size(); i++) {
//            if (resultList.get(i - 1).length() > resultList.get(i).length()) minivalue = 1;
//        }
        System.out.println(resultList);
    }
}
