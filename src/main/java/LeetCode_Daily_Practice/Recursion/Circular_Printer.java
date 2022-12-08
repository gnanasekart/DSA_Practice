package LeetCode_Daily_Practice.Recursion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Circular_Printer {
    /*
    It is a circular printer wheel with the letters A through Z in sequence. It
wraps so A and Z are adjacent. The printer has a pointer that is initially
at 'A'. Moving from any character to any adjacent character takes 1
second. It can move in either direction. Given a string of letters, what is
the minimum time needed to print the string? (Note: Assume that
printing does not take any time. Only consider the time it takes for the
pointer to move.)
A company has invented a new type of printing technology—a circular
printer that looks like this:
s = "BZA"
Total time
to print “BZA”

= 1+ 2 + 1 = 4 seconds

First, move the pointer from 'A' to 'B' (1 second), then from 'B' to 'Z' (2
seconds), and finally from 'Z' to 'A' (1 second). So the minimum time
needed to print "BZA" is 4 seconds.
     */

    @Test
    public void ex1(){
        String s ="BZA";
        Assert.assertEquals(printer(s), 4);
    }

    @Test
    public void ex2(){
        String s ="AAA";
        Assert.assertEquals(printer(s), 0);
    }

    @Test
    public void ex3(){
        String s ="AMA";
        Assert.assertEquals(printer(s), 4);
    }

    public static int printer(String s) {
        int minTime = 0, p1=0;
        return recursion(s,p1,minTime);
    }

    public static int recursion(String s, int p1, int minTime){
        if(p1==s.length()) return minTime;
        int currDiff = 0;
        currDiff = (p1==0) ? s.charAt(p1) - 'A' : Math.abs(s.charAt(p1) - s.charAt(p1-1));
        minTime += (currDiff>13) ? (26-currDiff) : currDiff;
        p1++;
        return recursion(s,p1,minTime);
    }
}
