package HackerRank_Daily_Practice.String.Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_Circular_Printer {
    /*
     *
     * A company has invented a new type of printing technology - a circular printer that looks like this.
     *
     * It is a circular printer wheel with the letters A through Z in sequence. It wraps so A and Z are
     * adjacent. The printer has a pointer that is initially at 'A'. Moving from any character to any
     * adjacent character takes 1 second. It can move in either direction.
     *
     * Given a string of letters, what is the minimum time needed to print the string?
     * Note: Assume that printing does not take any time. Only consider the time it takes for the pointer
     * to move.
     *
     * Example:
     * s = "BZA"
     * Total time to print : 1+2+1 = 4 seconds.
     *
     */

    @Test
    public void example1() {
        //Positive Test Data
        String s = "BZA";
        int expectedTime = 4;
        Assert.assertEquals(expectedTime, circularPattern(s));
    }

    @Test
    public void example2() {
        //Edge Case Test Data
        String s = "AZGB";
        int expectedTime = 13;
        Assert.assertEquals(expectedTime, circularPattern(s));
    }

    @Test
    public void example3() {
        //Negative Test Data
        String s = "ZNMD";
        int expectedTime = 23;
        Assert.assertEquals(expectedTime, circularPattern(s));
    }

    /*
     * --- Pseudo Code ---
     *
     * DS: ASCII
     *
     * example: AZGB
     *
     * 1. Create two int variables diff and sum
     * 2. Convert given String into charArray
     * --Loop Starts--
     * 3. Traverse till length of given char array
     * 4. If first element, subtract the ascii of element from 'A' and assign it to diff --> 'Z'-'A'
     * 5. else, subtract the ascii of element from previous element --> 'N' - 'Z'
     * 6. Calculate Math.abs of diff (Since there could be negative)
     * 7. As the pattern is circular and as we have to calculate minimum moves,
     * 		7a. If diff is >13 (half the number of alphabets), subtract it from 26 (max no of alphabets).
     * 8. sum += diff;
     * --Loop Ends--
     *
     */


    private int circularPattern(String s) {
        int count=0, val=0, sum=0;
        char[] c=s.toCharArray();
        for(int i=0; i<s.length(); i++){
            if(i==0)
                val = c[i]-'A';
            else
                val=Math.abs(c[i]-c[i-1]);
            count= val>13?26-val: val;
            sum+=count;
        }
        return sum;

    }
}
