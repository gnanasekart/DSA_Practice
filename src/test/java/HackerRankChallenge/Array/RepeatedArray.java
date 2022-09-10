package HackerRankChallenge.Array;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatedArray {
	public static void main(String[] args) throws IOException {
   //https://www.hackerrank.com/challenges/repeated-string/problem?h_r=profile
		String s = "aba";
		int count=0;
		int n=10, i=s.length(), j=0;	
		int num=n/s.length();
		int rem=n%s.length();
		
		for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k)=='a') {
                count += num;
                if (k < rem)
                    count++;
            }
        }
		System.out.println(count);
	}
}