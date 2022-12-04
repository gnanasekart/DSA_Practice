package Recursion;

import org.testng.Assert;
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

    @Test
    public void ex(){
        String[] s = {"h","e","l","l","o"};
        String[] out= {"o","l","l","e","h"};
        Assert.assertEquals(s, out);
    }

    public void reverseString(char[] s) {
        reversemethod(s, 0);
    }

    public void reversemethod(char[] s, int left){
        if(left>=s.length/2)
            return;

        int right=s.length;
        char temp= s[right-left-1];
        s[right-left-1]=s[left];
        s[left++]=temp;
        reversemethod(s, left);
    }
}
