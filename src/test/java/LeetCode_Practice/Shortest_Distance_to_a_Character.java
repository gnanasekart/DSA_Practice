package LeetCode_Practice;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Shortest_Distance_to_a_Character {

	/*
	 * Given a string s and a character c that occurs in s, return an array of integers answer 
	 * where answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in s.

	The distance between two indices i and j is abs(i - j), where abs is the absolute value function.
		Example 1:

		Input: s = "loveleetcode", c = "e"
		Output: [3,2,1,0,1,0,0,1,2,2,1,0]
		Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
		The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
		The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
		For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, 
			but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
		The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.
	 
h  e  l  l  e 
5  5  5  5  5 --> array.fill

5  0  1  2  0 --> l to r

1  0  1  1  0 --> r to l
	 *
	 */

    @Test
    public void example1() {
        String s = "loveleetcode";
        char c = 'e';
        System.out.println(shortestDistance(s, c));
    }

    //@Test
    public void example2() {
        String s = "aaab";
        char c = 'b';
        System.out.println(shortestDistance(s, c));
    }

    @Test
    public void example3() {
        String s = "helle";
        char c = 'e';
        System.out.println(shortestDistance(s, c));
    }

	//time comp - O(3n) -> O(n)
	//space comp - O(n) creating an array
    private int[] shortestDistance(String s, char c) {
        char[] ch = s.toCharArray();
        int[] arr = new int[ch.length];
        Arrays.fill(arr, ch.length);//O(n)

        for (int i = 0; i < arr.length; i++) {//O(n)
            if (ch[i] == c) arr[i] = 0;
            else if (i > 0)
                arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }

        for (int i = arr.length - 1; i >= 0; i--) {//O(n)
            if (ch[i] == c) arr[i] = 0;
            else if (i < arr.length - 1) arr[i] = Math.min(arr[i], arr[i + 1] + 1);
        }
        return arr;
    }
}
