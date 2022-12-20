package HackerRank_Daily_Practice.String.Array.sherlock_anagram;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_M_Sherlock_Anagram {

    @Test
    public void ex1() {
        String s = "mom";
        Assert.assertEquals(skerlock(s), 2);
    }

    @Test
    public void ex2() {
        String s = "abba";
        Assert.assertEquals(skerlock(s), 4);
    }

    @Test
    public void ex3() {
        String s = "abcd";
        Assert.assertEquals(skerlock(s), 0);
    }

    @Test
    public void ex4() {
        String s = "cdcd";
        Assert.assertEquals(skerlock(s), 5);
    }

    @Test
    public void ex5() {
        String s = "kkkk";
        Assert.assertEquals(skerlock(s), 10);
    }


    /*
    1. use map
   2. get the sub array of char
   3. sort the char array
   4. store into the map
   5. for next value check if is already present
   6. if present means increase the count
   7. else move to next element
   8. return count

     */
    private int skerlockMap(String s) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char[] str = s.substring(i, j + 1).toCharArray();
                Arrays.sort(str);
                String key = new String(str);
                if (map.containsKey(key)) {
                    count += map.get(key);
                    map.put(key, map.getOrDefault(key, 0) + 1);
                } else {
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
        }
        return count;
    }

    private int skerlock(String s) {//mom
        int tot = 0, x=0;
        boolean flag=true;
        for (int i = 1; i < s.length(); i++) {
            int[] mainASCII = new int[26];
            for (int j = i; j >= 0; j--) {
                mainASCII[s.charAt(j) - 'a']++;
                for (int k = 0; k < j; k++) {
                    int[] inASCII = new int[26];
                    x = k;
                    int count = 0;
                    while (count <= i-j) {
                        inASCII[s.charAt(x++) - 'a']++;
                        count++;
                    }
                    flag = true;
                    for (int n = 0; n < 26; n++) {
                        if (mainASCII[n] != inASCII[n]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) tot++;
                }
            }
        }
        return tot;
    }
}
