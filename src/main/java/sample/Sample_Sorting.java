package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

public class Sample_Sorting {

    @Test //+ve
    public void example1() {
        String s = "egg";
        String t = "add";
        Assert.assertEquals(isomorphic(s, t), true);
    }

    @Test //edge
    public void example2() {
        String s = "a";
        String t = "b";
        Assert.assertEquals(isomorphic(s, t), true);
    }

    @Test
    public void example3() {
        String s = "foo";
        String t = "bar";
        Assert.assertEquals(isomorphic(s, t), false);
    }

    @Test
    public void example4() {
        String s = "badc";
        String t = "baba";
        Assert.assertEquals(isomorphic(s, t), false);
    }

    @Test
    public void example5() {
        String s = "paper";
        String t = "title";
        Assert.assertEquals(isomorphic(s, t), true);
    }

    public boolean isomorphicMP(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap();//egg , add
        HashMap<Character, Character> map2 = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else map.put(s.charAt(i), t.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            if (map2.containsKey(t.charAt(i))) {
                if (map2.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            } else {
                map2.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }

    public boolean isomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] a1 = new int[256];
        int[] a2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (a1[s.charAt(i)] != 0) {
                if (a1[(s.charAt(i))] != t.charAt(i))
                    return false;
            }else a1[s.charAt(i)] = t.charAt(i);
        }

        for (int i = 0; i < s.length(); i++) {
            if (a2[t.charAt(i)] != 0) {
                if (a2[(t.charAt(i))] != s.charAt(i))
                    return false;
            }else a2[t.charAt(i)] = s.charAt(i);
        }
        return true;
    }

    public boolean isomorphica(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] a1 = new int[256];
        int[] a2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (a1[s.charAt(i)] != 0) {
                if (a1[(s.charAt(i))] != t.charAt(i))
                    return false;
            }else a1[s.charAt(i)] = t.charAt(i);
        }

        for (int i = 0; i < s.length(); i++) {
            if (a2[t.charAt(i)] != 0) {
                if (a2[(t.charAt(i))] != s.charAt(i))
                    return false;
            }else a2[t.charAt(i)] = s.charAt(i);
        }
        return true;
    }
}
