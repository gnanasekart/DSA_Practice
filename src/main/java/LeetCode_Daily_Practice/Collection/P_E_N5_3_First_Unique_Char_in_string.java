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
    1 <= s.length <= 105
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

    /*
1. start the char from i=0
2. get the i index value and concat the string and check for consist
3. if it consists or return index
4. else it returns -1
*/

    public int nonrepeatingBF(String s){
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

    public int nonrepeating(String s){
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
}
