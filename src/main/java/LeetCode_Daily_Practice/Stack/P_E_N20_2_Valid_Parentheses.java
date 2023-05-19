package LeetCode_Daily_Practice.Stack;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Stack;

public class P_E_N20_2_Valid_Parentheses {
    /*
    https://leetcode.com/problems/valid-parentheses/
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.
    An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

    Constraints:
    1 <= s.length <= 10^4
    s consists of parentheses only '()[]{}'.
     */

    @Test
    public void example1(){
        String s = "()";
        Assert.assertEquals(validParentheses(s), true);
    }

    @Test
    public void example2(){
        String s = "()[]{}";
        Assert.assertEquals(validParentheses(s), true);
    }

    @Test
    public void example3(){
        String s = "(]";
        Assert.assertEquals(validParentheses(s), false);
    }

    @Test
    public void example4(){
        String s = "{[()]}";
        Assert.assertEquals(validParentheses(s), true);
    }

    @Test
    public void example5(){
        String s = "(";
        Assert.assertEquals(validParentheses(s), false);
    }

    @Test
    public void example6(){
        String s = "(){}}{";
        Assert.assertEquals(validParentheses(s), false);
    }


    private boolean validParentheses(String s) {
        if(s.length()<2) return false;

        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> st = new Stack();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Character cc = 0;
        for(Character c: s.toCharArray()){
            if( map.containsKey(c) && !st.isEmpty() && st.peek() == map.get(c)){
                st.pop();
            }else
                st.push(c);
        }
        return st.isEmpty();
    }
}
