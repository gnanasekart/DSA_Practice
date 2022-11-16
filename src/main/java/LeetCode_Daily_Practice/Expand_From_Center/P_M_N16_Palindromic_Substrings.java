package LeetCode_Daily_Practice.Expand_From_Center;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_M_N16_Palindromic_Substrings {
    /*
    Given a string s, return the number of palindromic substrings in it.
A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.
     */

    @Test
    public void example1(){
        String s = "abc";
        Assert.assertEquals(palSubstringCount(s), 3);
    }

    @Test
    public void example2(){
        String s = "aaa";
        Assert.assertEquals(palSubstringCount(s), 6);
    }

    @Test
    public void example3(){
        String s = "c";
        Assert.assertEquals(palSubstringCount(s), 1);
    }

    @Test
    public void example4(){
        String s = "asdfgggg";
        Assert.assertEquals(palSubstringCount(s), 3);
    }

//    private int palStringCount2p(String s){
//        if(s.length()<=1) return s.length();
//        int count=0;
//        for(int i=0; i<s.length(); i++){
//            for (int j = i+1; j <= s.length(); j++) {
//                if(ispal(s.substring(i,j))){
//                    System.out.println(s.substring(i,j));
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    /*
    1. start iterating from 0 to length
    2. pass the even and odd value for iterate from center
    3. identify the start and end points
    4. check the two points are valid palindrome
    5. get the valid palindrome count
    6. return count;
     */

//abc
    private int start, end;
    private int palSubstringCount(String s) {
        if(s.length()==1) return 1;
        int count=0;
        for(int i=0; i<s.length(); i++){
             count+=isplan(s, i, i);
             count+=isplan(s, i, i+1);
        }
        return count;
    }

    public int isplan(String s, int left, int right){
        int count=0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        if(end<right-left-1){
            start=left+1;
            end=right-left-1;
        }
        if(ispal(s.substring(start, start+end))){
            count=1;
        }
    return count;
    }


    public boolean ispal(String s){

        int n=s.length();
        if(n<1) return false;
        if(n==1) return true;
        int left=0, right=s.length()-1;
        while(left<right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
