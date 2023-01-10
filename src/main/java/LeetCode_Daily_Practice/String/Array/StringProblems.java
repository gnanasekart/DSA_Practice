package LeetCode_Daily_Practice.String.Array;

import org.testng.annotations.Test;

public class StringProblems {

    @Test
    public void StringOccurance(){
        //Count the occurrences of a given string in another given string
        String main_string = "abcd abc aabc baa aabcaa";
        String sub_string = "aa";

        if (main_string == null || sub_string == null) {
            throw new IllegalArgumentException("The given strings cannot be null");
        }

        int position = 0;
        int ctr = 0;
        int n = sub_string.length();
        while ((position = main_string.indexOf(sub_string, position)) != -1) {
            position = position + n;
            ctr++;
        }
        System.out.println(ctr);
    }

    @Test
    public boolean twiceOccurance(){

        String stng =  "fizzez";

        int i = stng.indexOf("z");
        if (i == -1) return false;
        if (i+1 >= stng.length()) return false;
        return stng.substring(i+1, i+2).equals("z");
    }

    @Test
    public void ShortestDistance(){
        String[] S = {"the", "quick", "brown", "fox", "quick"};
        String word1 ="the", word2 = "fox";
//        Output: 3
//        Explanation: Minimum distance between the words “the” and “fox” is 3
//        Input: S = {“geeks”, “for”, “geeks”, “contribute”,  “practice”}, word1 = “geeks”, word2 = “practice”
//        Output: 2
//        Explanation: Minimum distance between the words “geeks” and “practice” is 2
        int d1=0, d2=0, max=0;
        for(int i=0; i<S.length; i++){
            if(S[i]==word1){
                d1=i;
            }
            if(S[i]==word2){
                d2=i;
            }
            max = Integer.MAX_VALUE;

            max=Math.min(max, (d2-d1));
        }
        System.out.println(max);
    }
}
