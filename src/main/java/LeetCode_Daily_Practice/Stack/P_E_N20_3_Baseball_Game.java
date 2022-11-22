package LeetCode_Daily_Practice.Stack;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class P_E_N20_3_Baseball_Game {
    /*
    leetcode.com/problems/baseball-game/
    You are keeping the scores for a baseball game with strange rules.
    At the beginning of the game, you start with an empty record.
    You are given a list of strings operations, where operations[i] is the ith operation
    you must apply to the record and is one of the following:

    An integer x.
    Record a new score of x.
    '+'.
    Record a new score that is the sum of the previous two scores.
    'D'.
    Record a new score that is the double of the previous score.
    'C'.
    Invalidate the previous score, removing it from the record.
    Return the sum of all the scores on the record after applying all the operations.

    The test cases are generated such that the answer and all intermediate calculations
    fit in a 32-bit integer and that all operations are valid.

    Input: ops = ["5","2","C","D","+"]
    Output: 30
    Explanation:
    "5" - Add 5 to the record, record is now [5].
    "2" - Add 2 to the record, record is now [5, 2].
    "C" - Invalidate and remove the previous score, record is now [5].
    "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
    "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
    The total sum is 5 + 10 + 15 = 30.

    Constraints:

    1 <= operations.length <= 1000
    operations[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 10^4, 3 * 10^4].
    For operation "+", there will always be at least two previous scores on the record.
    For operations "C" and "D", there will always be at least one previous score on the record.
     */

    @Test
    public void example1(){
        String[] arr = {"5","2","C","D","+"};
        Assert.assertEquals(baseBall(arr), 30);
    }

    @Test
    public void example2(){
        String[] arr = {"5","-2","4","C","D","9","+","+"};
        Assert.assertEquals(baseBall(arr), 27);
    }

    @Test
    public void example3(){
        String[] arr = {"5","-2","4","C","D","9","+","+"};
        Assert.assertEquals(baseBall(arr), 27);
    }

/*
pseudocode
1. iterate every element from the array
2. check if the element is equals to following category
    - if it is C then pop from stack
    - if it is D then peek and push as push(peek *2)
    - if it is + then pop the sequence two values and add into it after sum
    if non of the item matches with above the push into stack
3. then pop the item from stack and sum the value.
 */

    private int first, second, sum;
    private int baseBallstack(String[] operations){
        Stack<Integer> st = new Stack<>();

        for(String ss: operations){
            if("C".equals(ss)) st.pop();
            else if("D".equals(ss)) st.push(st.peek() * 2);
            else if("+".equals(ss)){
                first = st.pop();
                second = st.pop();
                st.push(second);
                st.push(first);
                st.push(first+second);
            }else st.push(Integer.valueOf(ss));
        }
        while(!st.isEmpty()) sum+=st.pop();

        return sum;
    }

    //arrayList
    private int baseBall(String[] operations){
        ArrayList<Integer> st = new ArrayList<>();
        for(String ss: operations){
            if("C".equals(ss)) st.remove(st.size()-1);
            else if("D".equals(ss)) st.add(st.get(st.size()-1) * 2);
            else if("+".equals(ss)){
                first = st.get(st.size()-1);
                second = st.get(st.size()-2);
                st.add(first+second);
            }else st.add(Integer.valueOf(ss));
        }
        while(!st.isEmpty()) sum+=st.remove(st.size()-1);
        return sum;
    }
}
