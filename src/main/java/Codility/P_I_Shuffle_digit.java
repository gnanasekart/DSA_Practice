package Codility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_I_Shuffle_digit {
    /*
    There is a company that has a very creative way of managing its accounts. Every time they want to
    write down a number, they shuffle its digits in the following way: they alternatively write one digit
    from the front of the number and one digit from the back, then the second digit from the front and the
    second from the back, and so on until the length of the shuffled number is the same as that of the original.

Write a function
class Solution { public int solution (int A); }

that, given a positive integer A, returns its shuffled representation.
For example, given A = 123456 the function should return 162534.
Given A = 130 the function should return 103.

Assume that:
A is an integer within the range [0..100,000,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

     */

    @Test
    public void ex1(){
        Assert.assertEquals(shuffle(123456), 162534);
    }

    @Test
    public void ex2(){
        Assert.assertEquals(shuffle(130), 103);
    }


    public static int shuffle1(int A) {
        String strA = Integer.toString(A);
        if (strA.length() <= 2) {
            return Integer.parseInt(strA);
        }
        String shuffledStr = Character.toString(strA.charAt(0)) +
                Character.toString(strA.charAt(strA.length() - 1)) +
                Integer.toString(shuffle(Integer.parseInt(strA.substring(1, strA.length() - 1))));
        return Integer.parseInt(shuffledStr);
    }

    public static int shuffle(int num) {

        String str = String.valueOf(num);
        if (str.length() <= 1) {
            return num;
        }

        char[] firstHalf = str.substring(0,str.length()/2).toCharArray();
        char[] secondHalf = new StringBuilder(str.substring(str.length()/2))
                                .reverse().toString().toCharArray();
        StringBuilder finalStr = new StringBuilder();
        for (int i=0;i<firstHalf.length;i++) {
            finalStr.append(firstHalf[i]);
            finalStr.append(secondHalf[i]);
        }
        // To handle for odd numbers length of array
        if (secondHalf.length > firstHalf.length) {
            finalStr.append(secondHalf[secondHalf.length - 1]);
        }

        return Integer.parseInt(finalStr.toString());
    }

}
