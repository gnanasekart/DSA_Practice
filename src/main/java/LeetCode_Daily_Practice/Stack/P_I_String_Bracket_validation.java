package LeetCode_Daily_Practice.Stack;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class P_I_String_Bracket_validation {

   @Test
   public void ex(){
       String input = "class X { def fun(): chararray = [1,2,3] for (i=0;i<1;i++) {print 'abc' + (i)}}";
       Assert.assertEquals(isBalanced(input), true);
   }

        public static boolean isBalanced(String input) {
            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < input.length(); i++) {
                char current = input.charAt(i);
                if (current == '{' || current == '[' || current == '(')
                    stack.push(current);
                if (current == '}' || current == ']' || current == ')') {
                    if (stack.isEmpty())
                        return false;

                    char last = stack.peek();
                    if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
                        stack.pop();
                     else return false;
                }
            }
            return stack.isEmpty();
        }
    }
