package LeetCode_Daily_Practice.Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class P_E_P_Longest_Common_Prefix {
    /*
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".


     */

    @Test
    public void ex1(){
        String[] strs = {"flower", "flow", "flight"};
        Assert.assertEquals(commonPrefixMethod(strs), "fl");
    }

    @Test
    public void ex2(){
        String[] strs = {"dog","racecar","car"};
        Assert.assertEquals(commonPrefixMethod(strs), "");
    }

    @Test
    public void ex3(){
        String[] strs = {"dog","ddd"};
        Assert.assertEquals(commonPrefixMethod(strs), "d");
    }

    @Test
    public void ex4(){
        String[] strs = {"", ""};
        Assert.assertEquals(commonPrefixMethod(strs), "");
    }

    @Test
    public void ex5(){
        String[] strs = {"ab", "a"};
        Assert.assertEquals(commonPrefixMethod(strs), "a");
    }

    private String commonPrefixMethodBF(String[] strs) {
        if(strs.length==0) return "";
        String prefix = "";
        String first = strs[0];
        for(int i=0; i<first.length(); i++){
            prefix=first.substring(0, i+1);
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].substring(0, prefix.length()).equals(prefix)){
                    continue;
                }else return strs[j].substring(0, i);
            }
        }
        return prefix;
    }

    private String commonPrefixMethod(String[] strs) {
        if(strs.length==0) return "";

        int start=0;
        int end = minLength(strs)-1;
        int mid=0;
        String prefix="";
        while(start<=end){
            mid = start+(end-start)/2;
            boolean flag = true;
            String temp=strs[0].substring(0, mid+1);

            for(String s: strs){
                if(!s.substring(0, mid+1).equals(temp)){
                    flag=false;
                    break;
                }
            }

            if(flag) {
                start= mid+1;
                prefix=temp;
            }
            else end = mid-1;
        }
     return prefix;
    }

    public int minLength(String[] strs){
        int len = strs[0].length();

        for(String s: strs){
            if(s.length()<len)
                len=s.length();
        }
        return len;
    }
}
