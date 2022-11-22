package LeetCode_Daily_Practice.Stack;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P_E_N20_1_Backspace_String_Compare {
    /*
    Given two strings s and t,
    return true if they are equal when both are typed into empty text editors.
    '#' means a backspace character.
    Note that after backspacing an empty text, the text will continue empty.

    Constraints:
    1 <= s.length, t.length <= 200
    s and t only contain lowercase letters and '#' characters.
     */

    @Test
    public void example1() {
        String s = "ab#c", t = "ad#c";
        Assert.assertEquals(backSpace(s, t), true);
    }

    @Test
    public void example2() {
        String s = "ab##", t = "c#d#";
        Assert.assertEquals(backSpace(s, t), true);
    }

    @Test
    public void example3() {
        String s = "a#c", t = "b";
        Assert.assertEquals(backSpace(s, t), false);
    }

    @Test
    public void example4() {
        String s = "#a#c", t = "a##c";
        Assert.assertEquals(backSpace(s, t), true);
    }

    @Test
    public void example5() {
        String s = "#", t = "a";
        Assert.assertEquals(backSpace(s, t), false);
    }

    @Test
    public void example6() {
        String s = "y#fo##f", t = "y#f#o##f";
        Assert.assertEquals(backSpace(s, t), true);
    }

    private boolean backSpaceStack(String s, String t) {

        if(s.length()<1 && t.length() <1) return false;

        Stack<Character> st1 = new Stack<>();
        for(char c: s.toCharArray())
            if(c =='#' && !st1.isEmpty()) st1.pop();
            else if(c !='#') st1.push(c);
        Stack<Character> st2 = new Stack<>();
        for(char c: t.toCharArray())
            if(c =='#' && !st2.isEmpty()) st2.pop();
            else if(c !='#') st2.push(c);

    return Arrays.equals(st1.toArray(), st2.toArray());
    }

    private boolean backSpace(String s, String t) {

        if(s.length()<1 && t.length() <1) return false;

        List<Character> st1 = new ArrayList<>();
        for(char c: s.toCharArray())
            if(c =='#' && !st1.isEmpty()) st1.remove(st1.size()-1);
            else if(c !='#') st1.add(c);

        List<Character> st2 = new ArrayList<>();
        for(char c: t.toCharArray())
            if(c =='#' && !st2.isEmpty()) st2.remove(st2.size()-1);
            else if(c !='#') st2.add(c);

        return Arrays.equals(st1.toArray(), st2.toArray());
    }
}