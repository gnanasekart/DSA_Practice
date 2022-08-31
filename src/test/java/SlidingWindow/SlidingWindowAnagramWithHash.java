package SlidingWindow;

import java.util.HashMap;

import org.junit.Test;

public class SlidingWindowAnagramWithHash {
    @Test
    public void example1() {
        String s = "cbaebabacd";
        String p = "abc";
        //anagramWith2pointer(s, p);
        anagramWithSlidingWindow(s, p);
    }

    @Test
    public void example2() {
        String s = "cb";
        String p = "abc";
        anagramWith2pointer(s, p);
        anagramWithSlidingWindow(s, p);
    }

    @Test
    public void example3() {
        String s = "cbb";
        String p = "abc";
        anagramWith2pointer(s, p);
        anagramWithSlidingWindow(s, p);
    }

    // using 2pointer concept
    private void anagramWith2pointer(String s, String p) {
        int sCount = s.length(), pCount = p.length();

        if (p.length() > s.length())
            new RuntimeException("No inputs matches");

        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> pMap = new HashMap<Character, Integer>();

        for (int i = 0; i < pCount; i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        for (int i = 0; i < sCount - pCount; i++) {
            for (int j = i; j < pCount + i; j++) {
                sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0) + 1);
            }
            if (pMap.equals(sMap)) {
                System.out.println("matches");
            }
            sMap.clear();
        }
    }

    //time comp = O(N)
    //space comp = O(m+n) => O(2m) => O(m)
    private void anagramWithSlidingWindow(String s, String p) {
        int sCount = s.length(), pCount = p.length();

        if (p.length() > s.length())
            new RuntimeException("No inputs matches");

        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> pMap = new HashMap<Character, Integer>();

        for (int i = 0; i < pCount; i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        for (int j = 0; j < sCount; j++) {
            sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0) + 1);

            if (j >= pCount) {
                char ch = s.charAt(j - pCount);

                //inside sMap if it is one occurence means it will remove
                //if it is more than once then it will -1 occurance
                if (sMap.get(ch) == 1) {
                    sMap.remove(ch);
                } else {
                    sMap.put(ch, sMap.get(ch) - 1);
                }
            }

            if(j>=pCount && sMap.equals(pMap)){
                System.out.println("matches");
            }
        }
    }
}