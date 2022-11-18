package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P_C_E_LC_25_Shortest_Distance_To_Char {
    /*
    https://leetcode.com/problems/shortest-distance-to-a-character/
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
        Assert.assertEquals(shortestToChar(s, c), output);
    }

    @Test
    public void example2() {
        String s = "love";
        char c = 'e';
        int[] output = {3, 2, 1, 0};
        Assert.assertEquals(shortestChar(s, c), output);
    }

    //@Test
    public void example3() {
        String s = "mad";
        char c = 'e';
        int[] output = {3, 3, 3};
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

    @Test
    public void example6() {
        String s = "lovelett";
        char c = 'e';
        int[] output = {3, 2, 1, 0, 1, 0, 1, 2};
        Assert.assertEquals(shortestDisatanceBF(s, c), output);
    }

    @Test
    public void example7() {
        String s = "abaa";
        char c = 'b';
        int[] output = {1, 0, 1, 2};
        Assert.assertEquals(shortestChar(s, c), output);
    }


/*
1. create an empty array for storing the shortest distance
2. consider 3 iteration for assigning the value
    - First loop from 0 to len assign the c value if arr[i]==c as 0 and assign len =0
        if not match assigned higher value greater than arr length as ++len
    - second loop start from len to 0
        - assign arr[i]==c as 0, len=0
        - else assign the min value by comparing actual value in array and ++len
3. return the new array
*/

    //brute force approach
    private int[] shortestDisatanceBF(String s, char c) {

        int[] ans = new int[s.length()];
        int prev = s.length();
        for (int i = 0; i < s.length(); i++) {//13,14,15,0,1,0,0,1,2,3,4,0
        if (s.charAt(i) == c) {
                prev = 0;
                ans[i] = 0;
            } else {
                ans[i] = ++prev;
            }
        }
        prev = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = 0;
                ans[i] = Math.min(ans[i], 0);//13,14,15,0,1,0,0,1,2,3,4,0
            } else {
                ans[i] = Math.min(ans[i], ++prev);//3,2,1,0,1,0,0,1,2,2,1,0
            }
        }
        return ans;
    }

    //best approach
    public int[] shortestChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) != C)
                res[i] = n;
        }
        for (int i = 1; i < n; i++) {
            res[i] = Math.min(res[i], res[i - 1] + 1);
        }
        for (int i = n - 2; i >= 0; i--) {
            res[i] = Math.min(res[i], res[i + 1] + 1);
        }
        return res;
    }

    //time = O(1)+O(n)+O(n)+O(n)=O(3n) => O(n)
    //space = O(n) = additionally space created for answer array
    private int[] shortestChar1(String str, char c) {
        boolean ischpresent = false;
        if (str.length() == 0) return new int[]{};//O(1)

        int[] answer = new int[str.length()];
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) { //=> O(n)
            if (ch[i] == c) {
                answer[i] = 0;
                ischpresent = true;
            } else answer[i] = ch.length;
        }

        if (ischpresent) {
            int left = 0, right = 0;
            while (left < ch.length - 1 && right <= ch.length - 1) {//O(n)
                if (ch[right] != c) right++;
                else if (ch[right] == c) {
                    if (left < right) {
                        answer[left] = Math.abs(left - right);
                        left++;
                    } else {
                        left = right;
                        left++;
                        right++;
                    }
                }
            }
            right = right - 1;
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


    //devasena
    public int[] findshortestDistance(String s, char c) {
        int n = s.length();
        int[] output = new int[s.length()];
        int position = -n;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) position = i;
            output[i] = i - position;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) position = i;
            output[i] = Math.min(output[i], Math.abs(i - position));
        }
        return output;
    }

    //LC solution
    public int[] shortestToChar1(String s, char c) {
        int[] ans = new int[s.length()];

        for (int i = 0, j = 0; i < ans.length; i++) {
            if (i == 0) j = s.indexOf(c);
            if (i > j && s.indexOf(c, i) >= 0 &&
                    Math.abs(j - i) > Math.abs(s.indexOf(c, i) - i)) {
                j = s.indexOf(c, i);
            }
            ans[i] = Math.abs(j - i);
        }

        return ans;
    }

    public int[] shortestToChar(String s, char c) {
        List list = new ArrayList();
        list.add(-10000);
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == c) list.add(i);
        list.add(Integer.MAX_VALUE);
        int[] res = new int[s.length()];
        int p1 = (int) list.get(0);
        int p2 = (int) list.get(1);
        int k = 2;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) res[i] = Math.min(i - p1, p2 - i);
            else {
                p1 = p2;
                p2 = (int) list.get(k++);
            }
        }
        return res;
    }
}