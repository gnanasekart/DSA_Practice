package LeetCode_Daily_Practice.Two_Pointers_String;

import org.testng.annotations.Test;

public class P_I_Add_Space_to_Str {


    public static void main(String[] args) {
       String input = "HowAreYouSekar";
        String out = "How Are You Sekar.";
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
                output += " " + c;
            } else {
                output += c;
            }
        }
        System.out.println("Output: " + output.trim());
    }
}