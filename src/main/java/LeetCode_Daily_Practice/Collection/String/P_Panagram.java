package LeetCode_Daily_Practice.Collection.String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class P_Panagram {
    /*

 A string is a panagram if it contains all letters of the English alphabet, ascii['a'-'z'].
 Given a list of strings, determine if each one is a panagram or not. Return "1" if true and "0" if false.

Example

pangram = ['pack my box with five dozen liquor jugs', 'this is not a pangram']

the string 'pack my box with five dozen liquor jugs' is a pangram , because it contains all the letters 'a' through 'z'
the string 'this is not a pangram' is not a pangram
Assemble a string of the two results,
Function Description Complete the function isPangram n the editor below.

isPangram has the following parameter(s):

  string pangram[n]:  an array of strings

Returns:
    string: a string where each position represents the results of a test. Use '1' for true and '0' for false.

Example
pangram = ['pack my box with five dozen liquor jugs', 'this is not a pangram']

the string 'pack my box with five dozen liquor jugs' is a pangram , because it contains all the letters 'a' through 'z'
the string 'this is not a pangram' is not a pangram
Assemble a string of the two results, in order.  The result is '10'.

Constraints

1 ≤ n ≤ 100
Each string pangram[i] (where 0 ≤ i < n) is composed of lowercase letters and spaces.
1 ≤ length of pangram[i] ≤ 105
 */

    @Test
    public void ex1(){
        String[] s = {"pack my box with five dozen liquor jugs", "this is not a pangram"};
        Assert.assertEquals(panagram(s), new int[]{1,0});
    }

    private int[] panagram(String[] s) {
    int i=0;
    int[] a = new int[s.length];
    for(String ss: s){
        String c = ss.trim().replaceAll(" ", "").toLowerCase();
        Set<Character> set = c.chars().mapToObj(aa -> (char)aa).collect(Collectors.toSet());
        if(set.size()==26){
            a[i++]=1;
        }else
            a[i++]=0;
    }
    return a;
    }

}
