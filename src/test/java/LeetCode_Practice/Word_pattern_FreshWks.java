package LeetCode_Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class Word_pattern_FreshWks {

	/*
	 	String[] ch = {"abb", "abc", "xyz", "xyy"};
		String pattern = "mnn";
		output in list = ["xyy", "abb"];

		Ans- xyy and abb have same char at index 1 and 2 like the pattern

		String[] ch = {"abb", "abc", "xyz", "xyy"};
		String pattern = "mno";
		output = ["abc", "xyz"];

		Ans- xyz and abc have all distinct char, 

		String[] ch = {"abb", "abc", "xyz", "xyy"};
		String pattern = "aba";
		output = [];

		Ans- pattern have same char at index 0 and 2 like the pattern, no word in dictionary follows the patterns.	 
	 */

    @Test
    public void example1() {
        String ch = "abb abc xyz xyy";
        String pattern = "mnn";
        //output in list = ["xyy", "abb"];
        System.out.println(getAllMatches(ch, pattern));
//		System.out.println(wordPattern(ch, pattern));
    }

    //@Test
    public void example2() {
        String[] ch = {"abb", "abc", "xyz", "xyy"};
        String pattern = "mno";
        //output = ["abc", "xyz"];
        //wordPattern(ch, pattern);
    }

    //@Test
    public void example3() {
        String[] ch = {"abb", "abc", "xyz", "xyy"};
        String pattern = "aba";
        //output = [];
        //wordPattern(ch, pattern);
        //wordPatternASCII(ch, pattern);
    }

    private boolean wordPatternASCII(String str, String pattern) {
        int petLen = pattern.length();
        int strlen = str.length();

        if (strlen != petLen) return false;
        char[] ch = new char[26];

        for (int i = 0; i < strlen; i++) {
//            if (ch[pattern.charAt(i) - 'a'] == 0 && ch[pattern.charAt(i) - 'a'] != str.charAt(i))
//				ch[pattern.charAt(i) - 'a'] = str.charAt(i);
            if (ch[pattern.charAt(i) - 'a'] == 0) {
                for (int j = 0; j < ch.length; j++) {
                    if (ch[j] == str.charAt(i)) return false;
                }
                ch[pattern.charAt(i) - 'a'] = str.charAt(i);
            } else if (ch[pattern.charAt(i) - 'a'] != str.charAt(i)) return false;
        }
        return true;
    }

    private List<String> getAllMatches(String str, String pattern) {
        List<String> list = new ArrayList<>();
        for (String s : str.split(" "))
            if (wordPatternASCII(s, pattern)) list.add(s);
        return list;
    }

	/*
	 * Psuedo code
		1. create 2 map
		2. Map the string as key to the pattern as value
		3. Map the pattern as key to the string as key
		4. compare both
			a. if there is no entry on both -> create entry for both
			b. if there is an entry in one of these -> compare both
			c. if either one does not match -> return false
	 */

    private boolean wordPattern(String ch, String pattern) {
        Map<Character, String> charmap = new HashMap<Character, String>();
        Map<String, Character> wordmap = new HashMap<String, Character>();

        String[] words = ch.trim().split(" ");
        if (pattern.length() != words.length) return false;

        int i = 0;
        while (i < words.length) {
            char c = pattern.charAt(i);
            String word = words[i++];

            if (!charmap.containsKey(c) && !wordmap.containsKey(word)) {
                charmap.put(c, word);
                wordmap.put(word, c);
            } else if (charmap.containsKey(c) && !word.equals(charmap.get(c)))
                return false;
            else if (wordmap.containsKey(word) && c != wordmap.get(word))
                return false;
        }
        return true;
    }
}