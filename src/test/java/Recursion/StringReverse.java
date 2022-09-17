package Recursion;

import org.testng.annotations.Test;

public class StringReverse {

    String rev = "";

    @Test
    public void example1() {
        String s = "hello";
        //reverseString(s);
        System.out.println(StringReverseRecursion(s));
    }

    @Test
    public void example2() {
        String s = "Today is a beautiful day";
        System.out.println(StringReverseRecursion(s));
    }

    /*
     *  Input length ==> 0 return input
        call recursively -> 0 to n-1
        get the last char - append to string
        finally return appended.
     */
    private String StringReverseRecursion(String s) {
        if (s.length() == 0) return s;

        rev = rev + s.charAt(s.length() - 1);
        StringReverseRecursion(s.substring(0, s.length() - 1));
        return rev;
    }

    private void reverseString(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
