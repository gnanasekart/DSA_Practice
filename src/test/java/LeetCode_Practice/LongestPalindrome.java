package LeetCode_Practice;

import org.testng.annotations.Test;

public class LongestPalindrome {

	//Given a string s, return the longest palindromic substring in s.

	@Test
	public void example() {
		String s = "ac";
		System.out.println(palindrome(s));
	}

	String result ="";
	private String palindrome(String s) {
		
		if (s == null || s.length()==0) return "";
		else if(s.length()==1) return s;
		
		StringBuffer sb = new StringBuffer();
		for (int L=0; L<s.length(); L++) {
			for(int R=L+1; R<s.length(); R++) {
				String sub = s.substring(L, R);
				String rev = sb.replace(0, sb.length(), "")
						.append(sub.substring(0, sub.length())).reverse().toString();
				
				if(sub.equals(rev) && sub.length()>=1) {
					System.out.println(sub);
				}
			}
		}
		return result;
	}
}