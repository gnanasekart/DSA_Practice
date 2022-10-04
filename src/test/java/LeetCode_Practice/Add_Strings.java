package LeetCode_Practice;

import org.testng.annotations.Test;

public class Add_Strings {
    /*
    Given two non-negative integers, num1 and num2 represented as string,
    return the sum of num1 and num2 as a string.
    You must solve the problem without using any built-in library for handling large integers
     (such as BigInteger). You must also not convert the inputs to integers directly.
    Example 1:
    Input: num1 = "11", num2 = "123"
    Output: "134"
     */
    @Test
    public void example1(){
        String num1 = "11", num2 = "123";
        System.out.println(addStrings(num1, num2));
    }

    @Test
    public void example2(){
        String num1 = "456", num2 = "77";
        System.out.println(addStrings(num1, num2));
    }

    @Test
    public void example3(){
        String num1 = "0", num2 = "0";
        System.out.println(addStrings(num1, num2));
    }

    private String addStrings(String num1, String num2) {


        return "";
    }
}
