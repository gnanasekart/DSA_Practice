package LeetCode_Daily_Practice.Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_String_arth_Operators {
    /*
    There is a programming language with only four operations and one variable X:

++X and X++ increments the value of the variable X by 1.
--X and X-- decrements the value of the variable X by 1.
Initially, the value of X is 0.

Given an array of strings operations containing a list of operations,
return the final value of X after performing all the operations.

Constraints:

1 <= operations.length <= 100
operations[i] will be either "++X", "X++", "--X", or "X--".

     */

    @Test
    public void ex(){
        Assert.assertEquals(validOperators(new String[]{"--X", "X++", "X++"}), 1);
    }

    @Test
    public void ex1(){
        Assert.assertEquals(validOperators(new String[]{"++X","++X","X++"}), 3);
    }

    @Test
    public void ex2(){
        Assert.assertEquals(validOperators(new String[]{"X++","++X","--X","X--"}), 0);
    }

    private int validOperators1(String[] operations) {
        int X = 0;

        for(String s: operations){
            if(s.contains("+")){
                int a=s.equals("++X")?++X : X++;
            }else if(s.contains("-")){
                int b=s.equals("--X")?--X : X--;
            }
        }
        return X;
    }

    private int validOperators(String[] operations) {
        int X=0;
        for (int i = 0; i < operations.length; i++) {
            if(operations[i].charAt(1)=='+') X++;
            else X--;
        }

        return X;
    }
}
