package HackerRank_Daily_Practice.String.Array.AnagramPalindrom;

import io.cucumber.java.sl.In;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class AnagramPalindrome {


    @Test
    public void ex() {
        Assert.assertEquals(gameOfThrones("aaabbbb"), "YES");
    }

    @Test
    public void ex1() {
        Assert.assertEquals(gameOfThrones("aabbccdd"), "YES");
    }

    @Test
    public void ex2() {
        Assert.assertEquals(gameOfThronesMap("cdcdcdcdeeeef"), "YES");
    }

    @Test
    public void ex3() {
        Assert.assertEquals(gameOfThronesMap("cdefghmnopqrstuvw"), "NO");
    }

    public static String gameOfThrones(String s) {
        int[] hash = new int[26];
        for (char ch : s.toCharArray())
            hash[ch - 'a']++;

        int odd = 0;
        for (int i = 0; i < 26; i++)
            if (hash[i] % 2 != 0)
                if (odd > 0)
                    return "NO";
                else
                    odd++;
        return "YES";
    }

    public static String gameOfThronesMap(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        int odd = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                if (odd > 0)
                    return "NO";
                else odd++;
            }
        }
        return "YES";
    }

}
