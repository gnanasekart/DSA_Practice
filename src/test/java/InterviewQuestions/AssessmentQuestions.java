package InterviewQuestions;

import org.testng.annotations.Test;

public class AssessmentQuestions {

    @Test
    public void charCount() {
        //String input = "aaabbccaad";
        //String input = "aaabbccaaa";
        String input = "abcdef";
        String output = "a3b2c2a2d1";

        int left = 0, right = 0;
        StringBuilder sb = new StringBuilder();
        while (right < input.length()) {
            if (input.charAt(left) == input.charAt(right)) {
                right++;
            } else {
                sb.append(input.charAt(left));
                sb.append(right - left);
                left = right;
                right++;
            }
        }
        if (left < right) {
            sb.append(input.charAt(left));
            sb.append(right - left);
        }
        System.out.println(sb.toString());
    }

    @Test
    public void MaxProduct3() {
        int[] input = {3, 5, 8, 1, 2, 0, 6, 4};
        int output[] = {5, 6, 8};
        // Return the 3 numbers which will give maximum product.
        // Can consist of negative numbers too


    }

    @Test
    public void maxProdSubArray() {
       /*
       Given an integer array nums, find the contiguous subarray (containing at least one number)
       which has the largest sum and return its sum.
    A subarray is a contiguous part of an array.
    Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
     Input: arr = [1,2,2,1,1,3]
    Output: true
        */
    }

    @Test
    public void uniqueCharInString() {
//    (return Unique Character in a string)
        String input = "this is my test string";
        char[] output = {'r', 'e', 'g', 'h', 'y', 'm', 'n' };
        int[] ch = new int[122];
        for (int i = 0; i < input.length(); i++) {
            int c = input.charAt(i);
            if (c >= 97 && c <= 122) {
                ch[c]++;
            }
        }

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 1)
                System.out.println((char) i);
        }
    }

    @Test
    public void maxProdSubArray2() {
        //Return the 3 numbers which will give maximum product. which has -ve/+ve numbers too
        // if -ve has highest value convert to positive and return it
        int input[] = {3, 5, 8, 1, 2, 0, -10, -20};//n = [3,5,-6,1,2,0,-8,4]
        int output[] = {20, 10, 8};

    }

    @Test
    public void FirstSubArrayPalindrome() {
        String a = "ABCDCDC";
        String output = "CDC";

        int k = output.length();
        int left = 0, right = k - 1;
        while (right < a.length()) {
            //right=k-1;
            left = right - k + 1;
            if (ispal(a, left, right)) {
                System.out.println(a.substring(left, right + 1));
                break;
            }
            right++;
        }
        //System.out.println("no thing");
    }

    public boolean ispal(String a, int left, int right) {
        while (a.charAt(left++) != a.charAt(right--)) {
            return false;
        }
        return true;
    }


    @Test
    public void countRepeatingSequennces() {

//        a. abbc - Output "1" - Only one repeating character of sequence b
//        b. aabbc - Output "2" - Two repeating characters a and b
//        c. aabbaa - Output "3" - Three repeating characters a, b and a
//        d. aaabbbccaaad - Output

        String input = "aaabbbccaaaa";

        int left = 0, right = 0, count = 0;
        StringBuilder sb = new StringBuilder();
        while (right < input.length()) {
            if (input.charAt(left) == input.charAt(right)) {
                right++;
            } else if (input.charAt(left) != input.charAt(right)) {

                if (right - left > 1) {
                    sb.append(input.charAt(left));
                    count++;
                }
                left = right;
            }
        }
        if (left < right) {
            if (right - left > 1) {
                sb.append(input.charAt(left));
                count++;
            }
        }
        System.out.println(count);
    }
}
