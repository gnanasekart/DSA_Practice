package LeetCode_Daily_Practice.Stack;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class P_E_N26_2_Make_The_String_Great {
    /*
    https://leetcode.com/problems/make-the-string-great/

    Given a string s of lower and upper case English letters.
    A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
    0 <= i <= s.length - 2
    s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
    To make the string good, you can choose two adjacent characters that make the string bad and remove them.
    You can keep doing this until the string becomes good.

    Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

    Notice that an empty string is also good.

    Constraints:
    1 <= s.length <= 100
    s contains only lower and upper case English letters.
*/

    @Test
    public void ex1(){
        String s = "leEeetcode";
        Assert.assertEquals(makeGood(s), "leetcode");
    }

    @Test
    public void ex2(){
        String s = "abBAcC";
        Assert.assertEquals(makeGood(s), "");
    }

    @Test
    public void ex3(){
        String s = "s";
        Assert.assertEquals(makeGood(s), "s");
    }

    @Test
    public void ex4(){
        String s = "kkdsFuqUfSDKK";
        Assert.assertEquals(makeGood(s), "kkdsFuqUfSDKK");
    }

    @Test
    public void ex5(){
        String s = "pP";
        Assert.assertEquals(makeGood(s), "");
    }

    @Test
    public void ex6(){
        String s = "pPp";
        Assert.assertEquals(makeGood(s), "p");
    }


/*
1. convert the string to charArray
2. insert the char if stack empty and also if peek and char are also equal
3. else peek the char to uppercase and compare with next char
    if matches then pop
4. else push into stack
5. once loop complete break the loop
6. create string buffer and append the char from stack
*/


    public String makeGood(String s) {
        if(s.length()==2 && s.charAt(0)==Character.toUpperCase(s.charAt(1)))
            return "";

        char[] c = s.toCharArray();

        Stack<Character> st = new Stack();

        for(char cc: c){
            if(st.isEmpty()) st.push(cc);
            else if(cc == st.peek()) st.push(cc);
            else if(Character.toUpperCase(st.peek())==cc) st.pop();
            else if(Character.toUpperCase(cc)==st.peek()) st.pop();
            else st.push(cc);
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
            sb.insert(0, st.pop());

        return sb.toString();
    }


    public String makeGood1(String s) {
        if(s.length() < 2) return s;
        Stack<Character> stack = new Stack<>();
        int i=0;
        while(i<s.length()){
            if(!stack.isEmpty() && Math.abs(stack.peek()-s.charAt(i))==32) {
                stack.pop();
            } else stack.push(s.charAt(i));
            i++;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }

}
