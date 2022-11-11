package LeetCode_Daily_Practice.Collection.String;

import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.HashMap;


public class P_T_O30_Anagram {

    @Test
    public void example1(){
        int[] a = {2,7,11,15};
        int target=9;
        Assert.assertEquals(twoSum(a, target), new int[]{2,7});
    }

    @Test
    public void example2(){
        String a = "anagram";
       String b = "nagaram";
        Assert.assertEquals(anagram(a, b), true);
    }

    //https://leetcode.com/problems/valid-anagram/

    private boolean anagramHashMap(String a, String b){

            HashMap<Character, Integer> map1 = new HashMap<>();
            HashMap<Character, Integer> map2 = new HashMap<>();
            for(int i=0; i<a.length(); i++){
                map1.put(a.charAt(i), map1.getOrDefault(a.charAt(i), 0)+1);
                map2.put(b.charAt(i), map2.getOrDefault(b.charAt(i), 0)+1);
            }

            return false;
    }
    private boolean anagram(String a, String b) {
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(char c: aa){
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char d: bb){
            map2.put(d, map2.getOrDefault(d, 0)+1);
        }

//--------------------------------------------------------------------------
       // String a = "anagram";
       // String b = "nagaram";
        int[] c = new int[26];
        for (int i = 0; i < a.length(); i++) {
            c[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            c[b.charAt(i) - 'a']--;
        }

        int total = 0;
        for (int i : c) {
            total += Math.abs(i);
        }

        System.out.println(total);
        return false;
    }

    private int[] twoSum(int[] a, int target) {
        int i=0, need=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(i=0; i<a.length; i++){
            map.put(i, a[i]);
            need = target-map.get(i);
            if(map.containsValue(need)){
                break;
            }
        }
        return new int[]{need, map.get(i)};
    }
}
