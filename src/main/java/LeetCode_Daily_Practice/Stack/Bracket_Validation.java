package LeetCode_Daily_Practice.Stack;

public class Bracket_Validation {

    /*
    Given a string of brackets, the task is to find an index k which decides the number of opening brackets is equal to the number of closing brackets.
The string must be consists of only opening and closing brackets i.e. ‘(‘ and ‘)’.

An equal point is an index such that the number of opening brackets before it is equal to the number of closing brackets from and after.
     */

    static int findIndex(String str)
    {
        int len = str.length();
        int open[] = new int[len+1];
        int    close[] = new int[len+1];
        int index = -1;

        open[0] = 0;
        close[len] = 0;
        if (str.charAt(0)=='(')
            open[1] = 1;
        if (str.charAt(len-1) == ')')
            close[len-1] = 1;

        // Store the number of opening brackets
        // at each index
        for (int i = 1; i < len; i++)
        {
            if ( str.charAt(i) == '(' )
                open[i+1] = open[i] + 1;
            else
                open[i+1] = open[i];
        }

        // Store the number of closing brackets
        // at each index
        for (int i = len-2; i >= 0; i--)
        {
            if ( str.charAt(i) == ')' )
                close[i] = close[i+1] + 1;
            else
                close[i] = close[i+1];
        }

        // check if there is no opening or closing
        // brackets
        if (open[len] == 0)
            return len;
        if (close[0] == 0)
            return 0;

        // check if there is any index at which
        // both brackets are equal
        for (int i=0; i<=len; i++)
            if (open[i] == close[i])
                index = i;

        return index;
    }

    // Driver Method
    public static void main(String[] args)
    {
        String str = "(()))(()()())))";
        System.out.println(findIndex(str));
    }
}
