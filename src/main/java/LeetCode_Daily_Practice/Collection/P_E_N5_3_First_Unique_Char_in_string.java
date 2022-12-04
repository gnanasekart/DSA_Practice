package LeetCode_Daily_Practice.Collection;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class P_E_N5_3_First_Unique_Char_in_string {

  /*
    leetcode.com/problems/first-unique-character-in-a-string/
    Given a string s, find the first non-repeating character in it and return its index.
    If it does not exist, return -1.
    Constraints:
    1 <= s.length <= 10^5
    s consists of only lowercase English letters.
*/

    @Test
    public void ex1(){
        String s = "leetcode";
        Assert.assertEquals(nonrepeating(s), 0);
    }

    @Test
    public void ex2(){
        String s = "loveleetcode";
        Assert.assertEquals(nonrepeating(s), 2);
    }

    @Test
    public void ex3(){
        String s = "love";
        Assert.assertEquals(nonrepeating(s), 0);
    }

    @Test
    public void ex4(){
        String s = "llllll";
        Assert.assertEquals(nonrepeating(s), -1);
    }

    @Test
    public void ex5(){
        String s = "e";
        Assert.assertEquals(nonrepeating(s), 0);
    }


    //Brute force
    public int nonrepeating(String s){
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if(i!=j && s.charAt(i)==s.charAt(j)){
                    break;
                } else if (j==s.length()-1) {
                    return i;
                }
            }
        }
        return -1;
    }

    /*
1. start the char from i=0
2. get the i index value and concat the string and check for consist
3. if it consists or return index
4. else it returns -1
*/
//Using IndexOf
    public int nonrepeatingIndexOf(String s){
        if(s.length()<1) return -1;
        if(s.length()==1) return 0;
        String str = "";
        for(int i=0; i<s.length(); i++){
            str+= s.substring(0,i)+s.substring(i+1, s.length());
            int ind = str.indexOf(s.charAt(i));
            str = "";
            if(ind!=-1)
                continue;
            else
                return i;
        }
        return -1;
    }

    /*
    pseudocode
    - check for length is less than 1
    - check for length is equal to 1
    1. In first loop collect all char to map with occurrence
    2. In second loop check for first map value as 1 and return i value
    3. if not found then return -1
    */

    public int nonrepeatingHashMap(String s){
        if(s.length()<1) return -1;
        if(s.length()==1) return 0;

        int[] len = new int[s.length()];
        Map<Character, Integer> map = new HashMap();
        for(char c:s.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);

        for(int i=0; i<len.length; i++) {
            len[i] = map.get(s.charAt(i));
            if (len[i] == 1)
                return i;
        }
        return -1;
    }

    //Using LastIndexOf and indexOf
    public int nonrepeatingLastIndexOf(String s){
        int min = Integer.MAX_VALUE;
        int index=0;
        for(char c: s.toCharArray()){
            index=s.indexOf(c);
            if(index!=-1 && index == s.lastIndexOf(c)){
                min = index < min ? index:min;
            }
        }
        return min==Integer.MAX_VALUE ? -1: min;
    }

    //using ASCII
    public int nonrepeatingASCII(String s){
       int[] ch = new int[26];
        for(char c: s.toCharArray())
            ch[c - 'a']++;

        for(int c=0; c<ch.length; c++) {
            if (ch[c] == 1)
                return c;
        }
        return -1;
    }
}