package LeetCode_Daily_Practice.Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class P_O21_2_Vovel_Reverse {
    /*
    leetcode.com/problems/reverse-vowels-of-a-string/

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases,
more than once.
Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters
  */

    @Test
    public void example1() {
        String words = "hello";
        Assert.assertEquals(reverseVovel(words), "holle");
    }

    @Test
    public void example2() {
        String words = "leetcode";
        Assert.assertEquals(reverseVovel(words), "leotcede");
    }

    @Test
    public void example3() {
        String words = "d";
        Assert.assertEquals(reverseVovel(words), "d");
    }

    @Test
    public void example4() {
        String words = "#$%^e*(a";
        Assert.assertEquals(reverseVovel(words), "#$%^a*(e");
    }

    @Test
    public void example5() {
        String words = "aeiouAEIOU";
        Assert.assertEquals(reverseVovel(words), "UOIEAuoiea");
    }

    /*
    1. convert the string to char array
    2. consider two pointer from both the end
    3. if both the end matches with vovel then increment both
    4. if left != right then left increment
    5. else right increment
    6. then return the char ch to string
    */
    private String reverseVovel(String word) {

        if (word.length() < 2) return word;

        char[] ch = word.toCharArray();
        int start = 0, end = word.length() - 1;

        ArrayList<Character> list = new ArrayList(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char c;

        while (start < end) {
            if ((list.contains(ch[start])) && (list.contains(ch[end]))) {
                c = ch[start];
                ch[start++] = ch[end];
                ch[end--] = c;
            } else if (!(list.contains(ch[start])) && ((list.contains(ch[end]))))
                start++;
            else end--;
        }
        return String.valueOf(ch);
    }
}
