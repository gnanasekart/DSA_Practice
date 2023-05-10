package LeetCode_Daily_Practice.Two_Pointers_String;

import org.testng.annotations.Test;

public class P_I_Add_Space_to_Str {


    @Test
    public void ex1() {
       String input = "HowAreYouSekar";
        String out = "How Are You Sekar.";
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c))
                output += " " + c;
            else
                output += c;
        }
        System.out.println("Output: " + output.trim());
    }

    @Test
    public void ex2(){
        String str = "HowAreYouToday";
        //Expected output - How are you today.

        StringBuffer sb = new StringBuffer();
        int left=0, right=0;

        while(right<str.length() && left<str.length()){
            if(left==0 && right==0 || Character.isLowerCase(str.charAt(right))){
                right++;
            }else if( Character.isUpperCase(str.charAt(right))){
                sb.append(" ");
                String s = str.substring(left, right);
                sb.append(s);
                left=right;
                right++;
            }
        }
        sb.append(" ");
        String s = str.substring(left, right);
        sb.append(s);
        System.out.println(sb.toString().trim());
    }
}