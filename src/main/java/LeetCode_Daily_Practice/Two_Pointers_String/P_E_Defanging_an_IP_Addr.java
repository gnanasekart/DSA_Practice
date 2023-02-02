package LeetCode_Daily_Practice.Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_Defanging_an_IP_Addr {
    /*
    leetcode.com/problems/defanging-an-ip-address/description/
Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".

Example 1:

Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"

Constraints:

The given address is a valid IPv4 address.
     */

    @Test
    public void ex() {
        Assert.assertEquals(validIpAddr("1.1.1.1"), "1[.]1[.]1[.]1");
    }

    private String validIpAddr1(String s) {
        char[] c = s.toCharArray();
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (c[i] == '.') {
                str+="[.]";
            }else str+=c[i];
        }
        return str.toString();
    }

    private String validIpAddr(String s) {
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (c[i] == '.') {
                sb.append('[').append(c[i]).append(']');
            }else sb.append(c[i]);
        }
        return sb.toString();
    }

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
    public String defangIPaddr1(String address) {
        return String.join("[.]", address.split("\\."));
    }
    public String defangIPaddr2(String address) {
        return address.replaceAll("\\.", "[.]");
    }
    public String defangIPaddr3(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            sb.append(c == '.' ? "[.]" : c);
        }
        return sb.toString();
    }
}
