package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class sample {

    @Test
    public void main1() {
        String[] s = {"Hello","Alaska","Dad","Peace"};
        String[] s2 = findWords(s);
    }



    public static String[] findWords(String[] words) {
        boolean valid = false;
        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";
        ArrayList<String> st = new ArrayList<>();

        for(String s: words) {
            if(s1.indexOf(Character.toLowerCase(s.charAt(0)))!=-1) {
                for(char c: s.toCharArray()){
                    if(s1.indexOf(Character.toLowerCase(c))!=-1){
                        valid = true;
                    }else valid = false;
                }
            }else if(s2.indexOf(Character.toLowerCase(s.charAt(0)))!=-1){
                for(char c: s.toCharArray()){
                    if(s2.indexOf(Character.toLowerCase(c))!=-1){
                        valid = true;
                    }else valid = false;
                }
            }else if(s3.indexOf(Character.toLowerCase(s.charAt(0)))!=-1){
                for(char c: s.toCharArray()){
                    if(s3.indexOf(Character.toLowerCase(c))!=-1){
                        valid = true;
                    }else valid = false;
                }
            }
            if(valid){
                st.add(s);
            }
        }

        return st.toArray(new String[0]);
    }

    @Test
    public void ex1(){
        String s = "xyzzaz";
        subsstring(s);
    }

    private int subsstring(String s) {
            int i=0, right=0;
        HashMap<Character, Integer> map = new HashMap();
        int count=0;
        while( i<s.length()){
            while(i<3){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            }

            if(!map.containsValue(2) && map.size()==3){
                count++;
            }
//            while(i<s.length()){
//
//
//                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)-1);
//            }
        }

        return count;
    }

    @Test
    public void ex2(){
        String[] s = {"abc","car","ada","racecar","cool"};
        Assert.assertEquals(substringp(s), "ada");
    }

    /*
    base cond - check string <1
    1. get every word from string array
    2. compare the first and last char in a loop
        if condition pass then move to next char
        else return false
   3. return the passed word
     */



    private String substringp(String[] s) {
        boolean valid = false;
        String w="";
        for(String word : s){
            int left=0, right=word.length()-1;
            while(left<right){//0, 2  1 1
                if(word.charAt(left++)!=word.charAt(right--)) {//0 2
                    break;
                }else {
                    return word;
                }
            }
        }
        return w;
    }

    @Test
    public void ex3(){
        int[] s = {0,1,0,3,12};
       Assert.assertEquals(moveZeroes(s), new int[]{1,3,12,0,0});
    }

    public int[] moveZeroes(int[] nums) {

        int i=0, j=1, temp=0;
        while(i<nums.length-1 && j<nums.length){
            if(nums[i]==0 && nums[j]==0){
                j++;
            }else if(nums[i]==0 && nums[j]!=0){
                temp=nums[i];
                nums[i++]=nums[j];
                nums[j++]=temp;
            }else if(nums[i]!=0 && nums[j]==0){
                j++;
            }
        }
        System.out.println(String.valueOf(nums));
        return nums;
    }


}