package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class P_C_E_LC_25_Shortest_Distance_To_Char {
    /*

    Given a string s and a character c that occurs in s,
    return an array of integers answers where answer.length == s.length
    and answer[i] is the distance from index i to the closest occurrence of character c in s.

    The distance between two indices i and j is abs(i - j),
    where abs is the absolute value function.

Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]
Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5,
but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.

 */
    @Test
    public void example1() {
        String s = "loveleetcode";
        char c = 'e';
        int[] output = {3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0};
        Assert.assertEquals(shortestChar(s, c), output);
    }

    @Test
    public void example2() {
        String s = "love";
        char c = 'e';
        int[] output = {3, 2, 1, 0};
        Assert.assertEquals(shortestChar(s, c), output);
    }

    @Test
    public void example3() {
        String s = "mad";
        char c = 'e';
        int[] output = {3,3,3};
        Assert.assertEquals(shortestChar(s, c), output);
    }
    @Test
    public void example4() {
        String s = "";
        char c = 'e';
        int[] output = {};
        Assert.assertEquals(shortestChar(s, c), output);
    }

    @Test
    public void example5() {
        String s = "abaabaaabbaaaabbba";
        char c = 'b';
        int[] output = {1, 0, 1, 1, 0, 1, 2, 1, 0, 0, 1, 2, 2, 1, 0, 0, 0, 1};
        Assert.assertEquals(shortestChar(s, c), output);
    }

    //@Test
    public void example6() {
        String s = "madmadmadmademadmama";
        char c = 'e';
        int[] output = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 7};
        Assert.assertEquals(shortestChar(s, c), output);
    }

    @Test
    public void example7() {
        String s = "abaa";
        char c = 'b';
        int[] output = {1,0,1,2};
        Assert.assertEquals(shortestChar(s, c), output);
    }


/*
1. if array is empty return empty array
2. create new array with same string
2. consider two traversal from left to right and another one is right to left
2. first traversal
    -
6. then return the answer array
*/

    //time = O(1)+O(n)+O(n)+O(n)=O(3n) => O(n)
    //space = O(n) = additionally space created for answer array
    private int[] shortestChar(String str, char c) {
        boolean ischpresent=false;
        if (str.length() == 0) return new int[]{};//O(1)

        int[] answer = new int[str.length()];
        char[] ch = str.toCharArray();
        for(int i=0; i<ch.length; i++){ //=> O(n)
            if(ch[i]==c) {
                answer[i]=0;
                ischpresent=true;
            }else answer[i]=ch.length;
        }
    if(ischpresent) {
        int left = 0, right = 0;
        while (left < ch.length - 1) {//O(n)
            if (ch[right] != c) right++;
            else if (ch[right] == c) {
                if (left < right) {
                    answer[left] = Math.min(ch[left], Math.abs(left - right));
                    left++;
                } else {
                    left = right;
                    left++;
                    right++;
                }
            }
        }

        while (right >= 0) { //O(n)
            if (ch[right] != c) right--;
            else if (ch[right] == c) {
                if (right < left) {
                    answer[left] = Math.min(answer[left], Math.abs(left - right));
                    left--;
                } else {
                    left = right;
                    left--;
                    right--;
                }
            }
        }
    }
        return answer;
    }
    }
